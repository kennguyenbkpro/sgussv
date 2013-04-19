package sig.icom.userservice;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;

import sig.icom.userservice.db.customdao.CustomCommentDAO;
import sig.icom.userservice.db.customdao.CustomCommentLikeDAO;
import sig.icom.userservice.db.customdao.CustomPlaceLikeDAO;
import sig.icom.userservice.db.customdao.CustomPlaceStatDAO;
import sig.icom.userservice.db.customdao.CustomPreferenceStatDAO;
import sig.icom.userservice.db.customdao.CustomShareDAO;
import sig.icom.userservice.db.customdao.CustomUserDAO;
import sig.icom.userservice.db.dao.Comment;
import sig.icom.userservice.db.dao.CommentDAO;
import sig.icom.userservice.db.dao.CommentLike;
import sig.icom.userservice.db.dao.EntityManagerHelper;
import sig.icom.userservice.db.dao.LogMainService;
import sig.icom.userservice.db.dao.LogMainServiceDAO;
import sig.icom.userservice.db.dao.LogTopicSearch;
import sig.icom.userservice.db.dao.LogTopicSearchDAO;
import sig.icom.userservice.db.dao.LogViewDetail;
import sig.icom.userservice.db.dao.LogViewDetailDAO;
import sig.icom.userservice.db.dao.PlaceLike;
import sig.icom.userservice.db.dao.PlaceUserStat;
import sig.icom.userservice.db.dao.PreferenceStat;
import sig.icom.userservice.db.dao.Share;
import sig.icom.userservice.db.dao.User;
import sig.icom.userservice.model.CommentModel;
import sig.icom.userservice.model.LogMainServiceModel;
import sig.icom.userservice.model.LogTopicSearchModel;
import sig.icom.userservice.model.LogViewDetailModel;
import sig.icom.userservice.model.NumLikeCommentModel;
import sig.icom.userservice.model.UserLikeModel;
import sig.icom.userservice.model.PlaceStatModel;
import sig.icom.userservice.model.PreferenceStatModel;
import sig.icom.userservice.model.UserModel;

public class IcomUserService {
	LogMainServiceDAO logMainServiceDAO;
	LogViewDetailDAO logViewDetailDAO;
	LogTopicSearchDAO logTopicSearchDAO;
	CustomPlaceStatDAO placeUserStatDAO;
	CustomPreferenceStatDAO preferenceStatDAO;
	CustomUserDAO customUserDAO;
	CustomCommentDAO customCommentDAO;
	CustomCommentLikeDAO customCommentLikeDAO;
	CustomPlaceLikeDAO customPlaceLikeDAO;
	CustomShareDAO customShareDAO;
	
	//============================= USER SERVICE ===============================
	// LOGIN
	public UserModel loginByFace(String email, String name){
		initUserDAO();
		try {
			EntityManagerHelper.beginTransaction();
			User user = customUserDAO.login(email, name, CustomUserDAO.TYPE_FACEBOOK);
			EntityManagerHelper.commit();
			UserModel userModel = new UserModel();
			userModel.copyFrom(user);
			return userModel;
		} catch (Exception e) {
			return null;
		}
	}
	public UserModel loginByGoogle(String email, String name){
		initUserDAO();
		try {
			EntityManagerHelper.beginTransaction();
			User user = customUserDAO.login(email, name, CustomUserDAO.TYPE_GOOGLE);
			EntityManagerHelper.commit();
			UserModel userModel = new UserModel();
			userModel.copyFrom(user);
			return userModel;
		} catch (Exception e) {
			return null;
		}
	}
	
	public UserModel getUserInfo(String email, long token){
		initUserDAO();
		try {
			User user = customUserDAO.validateToken(email, token);
			if (user == null) {
				return null;
			}  else {
				UserModel userModel = new UserModel();
				userModel.copyFrom(user);
				return userModel;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	//COMMENT
	
	public Integer addComment(String placeUri, String email, String content, long token, int type){
		initCommentDAO();
		initUserDAO();
		try {
			User user = customUserDAO.validateToken(email, token);
			if (user == null) {
				EntityManagerHelper.log("User not validated", Level.INFO, null);
				return -1;
			} else {
				user.setPoint(user.getPoint() + CustomUserDAO.POINT_ADD_COMMENT);
			}
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			Comment comment = new Comment(placeUri, email, content, timestamp, type);
			EntityManagerHelper.beginTransaction();
			customCommentDAO.save(comment);
			customUserDAO.update(user);
			EntityManagerHelper.commit();
			return comment.getId();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	public boolean deleteComment(int id, long token){
		initCommentDAO();
		initUserDAO();
		try {
			Comment comments = customCommentDAO.findById(id);
			User user = customUserDAO.validateToken(comments.getEmail(), token);
			if (user == null) {
				return false;
			} else {
				user.setPoint(user.getPoint() - CustomUserDAO.POINT_ADD_COMMENT);
			}
			EntityManagerHelper.beginTransaction();
			customCommentDAO.delete(comments);
			customUserDAO.save(user);
			EntityManagerHelper.commit();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	//LIKE COMMENT
	
	public boolean likeComment(int commentId, String email, long token){
		initCustomCommentLikeDAO();
		initUserDAO();
		initCommentDAO();
		try {
			if (customCommentLikeDAO.checkExistCommentLike(commentId, email) != null) return true;
			
			User user = customUserDAO.validateToken(email, token);
			if (user == null) return false;
			
			Comment comment = customCommentDAO.findById(commentId);
			if (comment == null) return false;
			
			User userOwn = customUserDAO.findUserByEmail(comment.getEmail());
			if (userOwn == null) return false;
			
			if (!userOwn.getEmail().equals(email)){
				userOwn.setPoint(userOwn.getPoint() + CustomUserDAO.POINT_LIKED_COMMENT);
			}
			
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			CommentLike commentLike = new CommentLike(commentId, email, timestamp);
			
			EntityManagerHelper.beginTransaction();
			customCommentLikeDAO.save(commentLike);
			customUserDAO.update(userOwn);
			EntityManagerHelper.commit();
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean unLikeComment(int commentId, String email, long token){
		initCustomCommentLikeDAO();
		initUserDAO();
		initCommentDAO();
		try {
			User user = customUserDAO.validateToken(email, token);
			if (user == null) return false;

			CommentLike commentLike = customCommentLikeDAO.checkExistCommentLike(commentId, email);
			if (commentLike == null) return true;
			
			
			Comment comment = customCommentDAO.findById(commentId);
			if (comment == null) return false;
			
			EntityManagerHelper.beginTransaction();
			if (!comment.getEmail().equals(email)){
				User userOwn = customUserDAO.findUserByEmail(comment.getEmail());
				if (userOwn == null) return false;
				
				userOwn.setPoint(userOwn.getPoint() - CustomUserDAO.POINT_LIKED_COMMENT);
				customUserDAO.update(userOwn);
				
			}
			customCommentLikeDAO.delete(commentLike);
			EntityManagerHelper.commit();
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	//LIKE PLACE
	public boolean likePlace(String placeUri, String email, long token){
		initCustomPlaceLikeDAO();
		initUserDAO();
		try {
			if (customPlaceLikeDAO.checkExistPlaceLike(placeUri, email) != null) return true;
			
			User user = customUserDAO.validateToken(email, token);
			if (user == null) return false;
			
			user.setPoint(user.getPoint() + CustomUserDAO.POINT_ADD_LIKE);
			
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			PlaceLike placeLike = new PlaceLike(placeUri, email, timestamp);
			
			EntityManagerHelper.beginTransaction();
			customPlaceLikeDAO.save(placeLike);
			customUserDAO.update(user);
			EntityManagerHelper.commit();
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public boolean unLikePlace(String placeUri, String email, long token){
		initCustomPlaceLikeDAO();
		initUserDAO();
		try {
			PlaceLike placeLike = customPlaceLikeDAO.checkExistPlaceLike(placeUri, email);
			if (placeLike == null) return true;
			
			User user = customUserDAO.validateToken(email, token);
			if (user == null) return false;
			
			user.setPoint(user.getPoint() - CustomUserDAO.POINT_ADD_LIKE);
			
			
			EntityManagerHelper.beginTransaction();
			customPlaceLikeDAO.delete(placeLike);
			customUserDAO.update(user);
			EntityManagerHelper.commit();
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	//SHARE PLACE
	public boolean sharePlaceToFacebook(String placeUri, String email, long token){
		initCustomShareDAO();
		initUserDAO();
		try {
			Share share = customShareDAO.checkExistShare(placeUri, email, CustomShareDAO.SHARE_FACEBOOK);
			
			
			User user = customUserDAO.validateToken(email, token);
			if (user == null) return false;
			
			
			
			EntityManagerHelper.beginTransaction();
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			if (share == null){
				share = new Share(placeUri, email, CustomShareDAO.SHARE_FACEBOOK, timestamp);
				user.setPoint(user.getPoint() + CustomUserDAO.POINT_SHARE);
				customShareDAO.save(share);
				customUserDAO.update(user);
			} else {
				share.setDateAdd(timestamp);
				customShareDAO.update(share);
			}
			EntityManagerHelper.commit();
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	//GET COMMENT LIKE ...
	public NumLikeCommentModel countNumLikeAndComment(String placeUri, String email){
		initCommentDAO();
		initCustomPlaceLikeDAO();
		initCustomShareDAO();
		try {
			PlaceLike placeLike = customPlaceLikeDAO.checkExistPlaceLike(placeUri, email);
			boolean userLike = false;
			if (placeLike != null) userLike = true;
			
			long numCom = customCommentDAO.countCommentOfPlace(placeUri);
			long numLike = customPlaceLikeDAO.countLikeOfPlace(placeUri);
			long numShare = customShareDAO.countShareOfPlace(placeUri);
			
			NumLikeCommentModel numLikeCommentModel = new NumLikeCommentModel(numLike, numCom, numShare, userLike);
			return numLikeCommentModel;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public CommentModel[] getMostLikesComment(String placeUri, String email){
		initCommentDAO();
		initCustomCommentLikeDAO();
		try {
			List<Object[]> objects = customCommentDAO.getMostLikesComment(placeUri, 0, 5);
			if (objects.size() < 5){
				List<Object[]> noLikeObjects = customCommentDAO.getCommentsOfPlace(placeUri, 0, 5 - objects.size(), true);
				objects.addAll(noLikeObjects);
			}
			CommentModel[] commentModels = new CommentModel[objects.size()];
			for (int i = 0; i < commentModels.length; i ++){
				Object[] tempOb = objects.get(i);
				long countLike = 0;
				if (tempOb.length > 6){
					countLike = (Long) tempOb[6];
				}
				CommentModel commentModel = new CommentModel((Integer) tempOb[0],(String) tempOb[3], (String) tempOb[2], (String) tempOb[4], (Integer) tempOb[5], (Timestamp) tempOb[1], countLike, false);
				commentModels[i] = commentModel;
				CommentLike commentLike = customCommentLikeDAO.checkExistCommentLike(commentModel.getId(), email);
				if (commentLike == null){
					commentModel.setUserLike(false);
				} else {
					commentModel.setUserLike(true);
				}
			}
			return commentModels;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public CommentModel[] getCommentsOfPlace(String placeUri, String email, int offset, int limit){
		initCommentDAO();
		initCustomCommentLikeDAO();
		try {
			List<Object[]> objects = customCommentDAO.getCommentsOfPlace(placeUri, offset, limit, false);
			CommentModel[] commentModels = new CommentModel[objects.size()];
			for (int i = 0; i < commentModels.length; i ++){
				Object[] tempOb = objects.get(i);
				CommentModel commentModel = new CommentModel((Integer) tempOb[0],(String) tempOb[3], (String) tempOb[2], (String) tempOb[4], (Integer) tempOb[5], (Timestamp) tempOb[1], 0, false);
				commentModels[i] = commentModel;
				commentModel.setNumLike(customCommentLikeDAO.countCommentLike(commentModel.getId()));
				CommentLike commentLike = customCommentLikeDAO.checkExistCommentLike(commentModel.getId(), email);
				if (commentLike == null){
					commentModel.setUserLike(false);
				} else {
					commentModel.setUserLike(true);
				}
			}
			return commentModels;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public UserLikeModel[] getUserLikePlace(String placeUri, int offset, int limit){
		initCustomPlaceLikeDAO();
		initUserDAO();
		try {
			List<Object[]> objects = customPlaceLikeDAO.getUserLikePlace(placeUri, offset, limit);
			UserLikeModel[] userLikeModels = new UserLikeModel[objects.size()];
			for (int i = 0; i < userLikeModels.length; i ++){
				Object[] tempOb = objects.get(i);
				UserLikeModel placeLikeModel = new UserLikeModel((String) tempOb[0], (String) tempOb[1], (Timestamp) tempOb[2]);
				userLikeModels[i] = placeLikeModel;
			}
			return userLikeModels;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public UserLikeModel[] getUserLikeComment(int commentId, int offset, int limit){
		initCustomCommentLikeDAO();
		initUserDAO();
		try {
			List<Object[]> objects = customCommentLikeDAO.getUserLikeComment(commentId, offset, limit);
			UserLikeModel[] userLikeModels = new UserLikeModel[objects.size()];
			for (int i = 0; i < userLikeModels.length; i ++){
				Object[] tempOb = objects.get(i);
				UserLikeModel placeLikeModel = new UserLikeModel((String) tempOb[0], (String) tempOb[1], (Timestamp) tempOb[2]);
				userLikeModels[i] = placeLikeModel;
			}
			return userLikeModels;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	

	// ============================ LOG SERVICE ================================

	public Boolean logMainService(String classUri, Double geoLat,
			Double geoLon, Float radius, String keyword, Integer offset,
			Integer limit, String userName) {
		initLogMainServiceDAO();
		try {
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			LogMainService logMainService = new LogMainService(classUri,
					geoLat, geoLon, radius, keyword, offset, limit, timestamp,
					userName);
			EntityManagerHelper.beginTransaction();
			logMainServiceDAO.save(logMainService);
			EntityManagerHelper.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Boolean logTopicSearch(String classUri, String userName,
			String city, String singleKeyword, String hasName,
			String hasAddress, Float inRange) {
		initLogTopicSearchDAO();
		try {
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			LogTopicSearch logTopicSearch = new LogTopicSearch(classUri,
					userName, city, singleKeyword, hasName, hasAddress,
					inRange, timestamp);
			EntityManagerHelper.beginTransaction();
			logTopicSearchDAO.save(logTopicSearch);
			EntityManagerHelper.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Boolean logViewDetail(String placeUri, String userName,
			Float distance) {
		initLogViewDetailDAO();
		try {
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			LogViewDetail logViewDetail = new LogViewDetail(placeUri, userName,
					timestamp, distance);
			EntityManagerHelper.beginTransaction();
			logViewDetailDAO.save(logViewDetail);
			EntityManagerHelper.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Boolean updatePreferenceStat(String... preferenceUris) {
		initPreferenceStatDAO();
		try {
			Calendar calendar = Calendar.getInstance();
			String month = (calendar.get(Calendar.MONTH) + 1) + "-"
					+ calendar.get(Calendar.YEAR);
			EntityManagerHelper.beginTransaction();
			for (int i = 0; i < preferenceUris.length; i++) {
				List<PreferenceStat> preferenceStats = preferenceStatDAO
						.findByUriAndMonth(preferenceUris[i], month);
				PreferenceStat preferenceStat;
				if (preferenceStats != null && preferenceStats.size() > 0) {
					preferenceStat = preferenceStats.get(0);
					preferenceStat.setCount(preferenceStat.getCount() + 1);
					preferenceStatDAO.update(preferenceStat);
				} else {
					preferenceStat = new PreferenceStat(preferenceUris[i], 1,
							month);
					preferenceStatDAO.save(preferenceStat);
				}

			}
			EntityManagerHelper.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Boolean updatePlaceStat(String[] placeUris, boolean resultNearby,
			boolean resultSemantic, boolean resultPreference, boolean dislike) {
		initPlaceUserStatDAO();
		try {
			Calendar calendar = Calendar.getInstance();
			String date = calendar.get(Calendar.DAY_OF_MONTH) + "-"
					+ (calendar.get(Calendar.MONTH) + 1) + "-"
					+ calendar.get(Calendar.YEAR);
			EntityManagerHelper.beginTransaction();
			for (int i = 0; i < placeUris.length; i++) {

				List<PlaceUserStat> placeUserStats = placeUserStatDAO
						.findByUriAndDate(placeUris[i], date);
				PlaceUserStat placeUserStat;
				if (placeUserStats != null && placeUserStats.size() > 0) {
					placeUserStat = placeUserStats.get(0);
					if (resultNearby) {
						placeUserStat.setResultNearby(placeUserStat
								.getResultNearby() + 1);
					}
					if (resultPreference) {
						placeUserStat.setResultPreference(placeUserStat
								.getResultPreference() + 1);
					}
					if (resultSemantic) {
						placeUserStat.setResultSemantic(placeUserStat
								.getResultSemantic() + 1);
					}
					if (dislike) {
						placeUserStat.setNumDislike(placeUserStat
								.getNumDislike() + 1);
					}
					placeUserStatDAO.update(placeUserStat);
				} else {
					placeUserStat = new PlaceUserStat(placeUris[i], 0, 0, 0, 0,
							0, 0, date);
					if (resultNearby) {
						placeUserStat.setResultNearby(placeUserStat
								.getResultNearby() + 1);
					}
					if (resultPreference) {
						placeUserStat.setResultPreference(placeUserStat
								.getResultPreference() + 1);
					}
					if (resultSemantic) {
						placeUserStat.setResultSemantic(placeUserStat
								.getResultSemantic() + 1);
					}
					if (dislike) {
						placeUserStat.setNumDislike(placeUserStat
								.getNumDislike() + 1);
					}
					placeUserStatDAO.save(placeUserStat);
				}
			}
			EntityManagerHelper.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// ============== GET DATA FROM LOG SERVICE =========================

	public LogMainServiceModel[] getLogMainService(int start, int max) {
		initLogMainServiceDAO();
		try {
			List<LogMainService> logMainServices = logMainServiceDAO.findAll(
					start, max);
			LogMainServiceModel[] logMainServiceModels = new LogMainServiceModel[logMainServices
					.size()];
			for (int i = 0; i < logMainServiceModels.length; i++) {
				logMainServiceModels[i] = new LogMainServiceModel();
				logMainServiceModels[i].copy(logMainServices.get(i));
			}
			return logMainServiceModels;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public LogTopicSearchModel[] getLogTopicSearch(int start, int max) {
		initLogTopicSearchDAO();
		try {
			List<LogTopicSearch> logTopicSearch = logTopicSearchDAO.findAll(
					start, max);
			LogTopicSearchModel[] logTopicSearchModels = new LogTopicSearchModel[logTopicSearch
					.size()];
			for (int i = 0; i < logTopicSearchModels.length; i++) {
				logTopicSearchModels[i] = new LogTopicSearchModel();
				logTopicSearchModels[i].copy(logTopicSearch.get(i));
			}
			return logTopicSearchModels;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public LogViewDetailModel[] getLogViewDetail(int start, int max) {
		initLogViewDetailDAO();
		try {
			List<LogViewDetail> logTopicSearch = logViewDetailDAO.findAll(
					start, max);
			LogViewDetailModel[] logTopicSearchModels = new LogViewDetailModel[logTopicSearch
					.size()];
			for (int i = 0; i < logTopicSearchModels.length; i++) {
				logTopicSearchModels[i] = new LogViewDetailModel();
				logTopicSearchModels[i].copy(logTopicSearch.get(i));
			}
			return logTopicSearchModels;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public PlaceStatModel[] getPlaceStat(int start, int max) {
		initPlaceUserStatDAO();
		try {
			List<PlaceUserStat> logTopicSearch = placeUserStatDAO.findAll(
					start, max);
			PlaceStatModel[] logTopicSearchModels = new PlaceStatModel[logTopicSearch
					.size()];
			for (int i = 0; i < logTopicSearchModels.length; i++) {
				logTopicSearchModels[i] = new PlaceStatModel();
				logTopicSearchModels[i].copy(logTopicSearch.get(i));
			}
			return logTopicSearchModels;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public PreferenceStatModel[] getPreferenceStat(int start, int max) {
		initPreferenceStatDAO();
		try {
			List<PreferenceStat> logTopicSearch = preferenceStatDAO.findAll(
					start, max);
			PreferenceStatModel[] logTopicSearchModels = new PreferenceStatModel[logTopicSearch
					.size()];
			for (int i = 0; i < logTopicSearchModels.length; i++) {
				logTopicSearchModels[i] = new PreferenceStatModel();
				logTopicSearchModels[i].copy(logTopicSearch.get(i));
			}
			return logTopicSearchModels;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// ============================ INIT METHOD ================================

	private void initLogMainServiceDAO() {
		if (logMainServiceDAO == null) {
			logMainServiceDAO = new LogMainServiceDAO();
		}
	}

	private void initLogViewDetailDAO() {
		if (logViewDetailDAO == null) {
			logViewDetailDAO = new LogViewDetailDAO();
		}
	}

	private void initLogTopicSearchDAO() {
		if (logTopicSearchDAO == null) {
			logTopicSearchDAO = new LogTopicSearchDAO();
		}
	}

	private void initPlaceUserStatDAO() {
		if (placeUserStatDAO == null) {
			placeUserStatDAO = new CustomPlaceStatDAO();
		}
	}

	private void initPreferenceStatDAO() {
		if (preferenceStatDAO == null) {
			preferenceStatDAO = new CustomPreferenceStatDAO();
		}
	}
	private void initUserDAO(){
		if (customUserDAO == null){
			customUserDAO = new CustomUserDAO();
		}
	}
	
	private void initCommentDAO(){
		if (customCommentDAO == null){
			customCommentDAO = new CustomCommentDAO();
		}
	}
	
	private void initCustomCommentLikeDAO(){
		if (customCommentLikeDAO == null){
			customCommentLikeDAO = new CustomCommentLikeDAO();
		}
	}
	private void initCustomPlaceLikeDAO(){
		if (customPlaceLikeDAO == null){
			customPlaceLikeDAO = new CustomPlaceLikeDAO();
		}
	}
	private void initCustomShareDAO(){
		if (customShareDAO == null){
			customShareDAO = new CustomShareDAO();
		}
	}
}

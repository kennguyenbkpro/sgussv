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

@javax.jws.WebService(targetNamespace = "http://userservice.icom.sig/", serviceName = "IcomUserServiceService", portName = "IcomUserServicePort", wsdlLocation = "WEB-INF/wsdl/IcomUserServiceService.wsdl")
public class IcomUserServiceDelegate {

	sig.icom.userservice.IcomUserService icomUserService = new sig.icom.userservice.IcomUserService();

	public UserModel loginByFace(String email, String name) {
		return icomUserService.loginByFace(email, name);
	}

	public UserModel loginByGoogle(String email, String name) {
		return icomUserService.loginByGoogle(email, name);
	}

	public UserModel getUserInfo(String email, long token) {
		return icomUserService.getUserInfo(email, token);
	}

	public Integer addComment(String placeUri, String email, String content,
			long token, int type) {
		return icomUserService
				.addComment(placeUri, email, content, token, type);
	}

	public boolean deleteComment(int id, long token) {
		return icomUserService.deleteComment(id, token);
	}

	public boolean likeComment(int commentId, String email, long token) {
		return icomUserService.likeComment(commentId, email, token);
	}

	public boolean unLikeComment(int commentId, String email, long token) {
		return icomUserService.unLikeComment(commentId, email, token);
	}

	public boolean likePlace(String placeUri, String email, long token) {
		return icomUserService.likePlace(placeUri, email, token);
	}

	public boolean unLikePlace(String placeUri, String email, long token) {
		return icomUserService.unLikePlace(placeUri, email, token);
	}

	public boolean sharePlaceToFacebook(String placeUri, String email,
			long token) {
		return icomUserService.sharePlaceToFacebook(placeUri, email, token);
	}

	public NumLikeCommentModel countNumLikeAndComment(String placeUri,
			String email) {
		return icomUserService.countNumLikeAndComment(placeUri, email);
	}

	public CommentModel[] getMostLikesComment(String placeUri, String email) {
		return icomUserService.getMostLikesComment(placeUri, email);
	}

	public CommentModel[] getCommentsOfPlace(String placeUri, String email,
			int offset, int limit) {
		return icomUserService.getCommentsOfPlace(placeUri, email, offset,
				limit);
	}

	public UserLikeModel[] getUserLikePlace(String placeUri, int offset,
			int limit) {
		return icomUserService.getUserLikePlace(placeUri, offset, limit);
	}

	public UserLikeModel[] getUserLikeComment(int commentId, int offset,
			int limit) {
		return icomUserService.getUserLikeComment(commentId, offset, limit);
	}

	public Boolean logMainService(String classUri, Double geoLat,
			Double geoLon, Float radius, String keyword, Integer offset,
			Integer limit, String userName) {
		return icomUserService.logMainService(classUri, geoLat, geoLon, radius,
				keyword, offset, limit, userName);
	}

	public Boolean logTopicSearch(String classUri, String userName,
			String city, String singleKeyword, String hasName,
			String hasAddress, Float inRange) {
		return icomUserService.logTopicSearch(classUri, userName, city,
				singleKeyword, hasName, hasAddress, inRange);
	}

	public Boolean logViewDetail(String placeUri, String userName,
			Float distance) {
		return icomUserService.logViewDetail(placeUri, userName, distance);
	}

	public Boolean updatePreferenceStat(String[] preferenceUris) {
		return icomUserService.updatePreferenceStat(preferenceUris);
	}

	public Boolean updatePlaceStat(String[] placeUris, boolean resultNearby,
			boolean resultSemantic, boolean resultPreference, boolean dislike) {
		return icomUserService.updatePlaceStat(placeUris, resultNearby,
				resultSemantic, resultPreference, dislike);
	}

	public LogMainServiceModel[] getLogMainService(int start, int max) {
		return icomUserService.getLogMainService(start, max);
	}

	public LogTopicSearchModel[] getLogTopicSearch(int start, int max) {
		return icomUserService.getLogTopicSearch(start, max);
	}

	public LogViewDetailModel[] getLogViewDetail(int start, int max) {
		return icomUserService.getLogViewDetail(start, max);
	}

	public PlaceStatModel[] getPlaceStat(int start, int max) {
		return icomUserService.getPlaceStat(start, max);
	}

	public PreferenceStatModel[] getPreferenceStat(int start, int max) {
		return icomUserService.getPreferenceStat(start, max);
	}

}
package sig.icom.userservice.db.customdao;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sig.icom.userservice.db.dao.EntityManagerHelper;
import sig.icom.userservice.db.dao.PlaceLike;
import sig.icom.userservice.db.dao.Share;
import sig.icom.userservice.db.dao.ShareDAO;

public class CustomShareDAO extends ShareDAO{
	public static final short SHARE_FACEBOOK = 1;
	
	private EntityManager getEntityManager() {
		EntityManager entityManager = EntityManagerHelper.getEntityManager();
		entityManager.clear();
		return entityManager;
	}
	
	public long countShareOfPlace(String placeUri){
		try {
			final String queryString = "select COUNT(model."+ EMAIL +") from Share model where model."+ PLACE_URI + " = :placeUri";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("placeUri", placeUri);
			return (Long) query.getSingleResult();
		} catch (RuntimeException re) {
			return -1;
		}
	}
	
	public Share checkExistShare(String placeUri, String email, int typeShare){
		try {
			List<Share> shares = findPlaceShare(placeUri, email, typeShare);
			if (shares == null || shares.size() == 0){
				return null;
			} else {
				return shares.get(0);
			}
		} catch (RuntimeException re) {
			return null;
		}
	}
	
	private List<Share> findPlaceShare(String placeUri, String email, int typeShare){
		EntityManagerHelper.log("finding Place Share instance with email: "
				+ email + ", placeUri: " + placeUri, Level.INFO, null);
		try {
			final String queryString = "select model from Share model where model."+ PLACE_URI + " = :placeUri and model."+ EMAIL + " = :email and model."+ TYPE_SHARE + " = :typeShare";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("placeUri", placeUri);
			query.setParameter("email", email);
			query.setParameter("typeShare", typeShare);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find placeLike failed",
					Level.SEVERE, re);
			return null;
		}
	}
}

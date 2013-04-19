package sig.icom.userservice.db.customdao;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sig.icom.userservice.db.dao.CommentLike;
import sig.icom.userservice.db.dao.EntityManagerHelper;
import sig.icom.userservice.db.dao.PlaceLike;
import sig.icom.userservice.db.dao.PlaceLikeDAO;

public class CustomPlaceLikeDAO extends PlaceLikeDAO{
	private EntityManager getEntityManager() {
		EntityManager entityManager = EntityManagerHelper.getEntityManager();
		entityManager.clear();
		return entityManager;
	}
	public PlaceLike checkExistPlaceLike(String placeUri, String email){
		EntityManagerHelper.log(
				"validate email: "
						+ email, Level.INFO, null);
		try {
			List<PlaceLike> placeLikes = findPlaceLike(placeUri, email);
			if (placeLikes == null || placeLikes.size() == 0){
				return null;
			} else {
				return placeLikes.get(0);
			}
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed",
					Level.SEVERE, re);
			return null;
		}
	}
	
	public long countLikeOfPlace(String placeUri){
		try {
			final String queryString = "select COUNT(model."+ EMAIL +") from PlaceLike model where model."+ PLACE_URI + " = :placeUri";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("placeUri", placeUri);
			return (Long) query.getSingleResult();
		} catch (RuntimeException re) {
			return -1;
		}
	}
	
	public List<Object[]> getUserLikePlace(String placeUri, int offset, int limit){
		EntityManagerHelper.log("get user likes place of " + placeUri, Level.INFO, null);
		try {
			String queryString = "select u.email, u.name, pl.dateAdd  FROM PlaceLike pl , User u WHERE pl.email = u.email and pl.placeUri = :placeUri ORDER BY pl.id";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("placeUri", placeUri);
			query.setFirstResult(offset);
			query.setMaxResults(limit);
			return query.getResultList();
		} catch (RuntimeException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private List<PlaceLike> findPlaceLike(String placeUri, String email){
		EntityManagerHelper.log("finding Place like instance with email: "
				+ email + ", placeUri: " + placeUri, Level.INFO, null);
		try {
			final String queryString = "select model from PlaceLike model where model."+ PLACE_URI + " = :placeUri and model."+ EMAIL + " = :email";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("placeUri", placeUri);
			query.setParameter("email", email);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find placeLike failed",
					Level.SEVERE, re);
			return null;
		}
	}
}

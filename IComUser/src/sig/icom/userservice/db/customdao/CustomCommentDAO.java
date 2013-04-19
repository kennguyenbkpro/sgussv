package sig.icom.userservice.db.customdao;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sig.icom.userservice.db.dao.Comment;
import sig.icom.userservice.db.dao.CommentDAO;
import sig.icom.userservice.db.dao.EntityManagerHelper;

public class CustomCommentDAO extends CommentDAO{
	private EntityManager getEntityManager() {
		EntityManager entityManager = EntityManagerHelper.getEntityManager();
		entityManager.clear();
		return entityManager;
	}
	
	public long countCommentOfPlace(String placeUri){
		EntityManagerHelper.log("count comment", Level.INFO, null);
		try {
			final String queryString = "select COUNT(model.id) from Comment model where model."+ PLACE_URI + " = :placeUri";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("placeUri", placeUri);
			return (Long) query.getSingleResult();
		} catch (RuntimeException re) {
			re.printStackTrace();
			return -1;
		}
	}
	
	public List<Object[]> getMostLikesComment(String placeUri, int offset, int limit){
		EntityManagerHelper.log("get most likes comment of " + placeUri, Level.INFO, null);
		try {
			String queryString = "select c.id, c.dateAdd, c.content, u.email, u.name, u.point, COUNT(cl.email) likes from Comment c , CommentLike cl, User u WHERE c.id = cl.commentId and c.email = u.email and c.placeUri = :placeUri GROUP BY c.id ORDER BY likes DESC";
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

	public List<Object[]> getCommentsOfPlace(String placeUri, int offset, int limit, boolean desc){
		EntityManagerHelper.log("get most likes comment of " + placeUri, Level.INFO, null);
		try {
			String queryString = "select c.id, c.dateAdd, c.content, u.email, u.name, u.point  FROM Comment c , User u WHERE c.email = u.email and c.placeUri = :placeUri ORDER BY c.id ";
			if (desc){
				queryString = queryString + "DESC";
			}
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
}

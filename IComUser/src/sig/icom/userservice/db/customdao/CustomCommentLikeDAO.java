package sig.icom.userservice.db.customdao;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sig.icom.userservice.db.dao.CommentLike;
import sig.icom.userservice.db.dao.CommentLikeDAO;
import sig.icom.userservice.db.dao.EntityManagerHelper;
import sig.icom.userservice.db.dao.User;

public class CustomCommentLikeDAO extends CommentLikeDAO{
	private EntityManager getEntityManager() {
		EntityManager entityManager = EntityManagerHelper.getEntityManager();
		entityManager.clear();
		return entityManager;
	}
	
	public CommentLike checkExistCommentLike(int commentId, String email){
		EntityManagerHelper.log(
				"validate email: "
						+ email, Level.INFO, null);
		try {
			List<CommentLike> commentLikes = findCommentLike(commentId, email);
			if (commentLikes == null || commentLikes.size() == 0){
				return null;
			} else {
				return commentLikes.get(0);
			}
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed",
					Level.SEVERE, re);
			return null;
		}
	}
	
	public long countCommentLike(int commentId){
		try {
			final String queryString = "select COUNT(model."+ EMAIL +") from CommentLike model where model."+ COMMENT_ID + " = :commentId ";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("commentId", commentId);
			return (Long) query.getSingleResult();
		} catch (RuntimeException re) {
			re.printStackTrace();
			return -1;
		}
	}
	
	public List<Object[]> getUserLikeComment(int commentId, int offset, int limit){
		EntityManagerHelper.log("get user likes comment of " + commentId, Level.INFO, null);
		try {
			String queryString = "select u.email, u.name, cl.dateAdd  FROM CommentLike cl , User u WHERE cl.email = u.email and cl.commentId = :commentId ORDER BY cl.id";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("commentId", commentId);
			query.setFirstResult(offset);
			query.setMaxResults(limit);
			return query.getResultList();
		} catch (RuntimeException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private List<CommentLike> findCommentLike(int commentId, String email){
		EntityManagerHelper.log("finding User instance with email: "
				+ email + ", commentId: " + commentId, Level.INFO, null);
		try {
			final String queryString = "select model from CommentLike model where model."+ COMMENT_ID + " = :commentid and model."+ EMAIL + " = :email";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("commentid", commentId);
			query.setParameter("email", email);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find commentlike failed",
					Level.SEVERE, re);
			return null;
		}
	}
}

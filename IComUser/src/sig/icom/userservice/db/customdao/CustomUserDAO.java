package sig.icom.userservice.db.customdao;

import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sig.icom.userservice.db.dao.EntityManagerHelper;
import sig.icom.userservice.db.dao.User;
import sig.icom.userservice.db.dao.UserDAO;

public class CustomUserDAO extends UserDAO {
	public static final short TYPE_FACEBOOK = 0;
	public static final short TYPE_GOOGLE = 1;
	public static final short TYPE_BOTH = 2;

	public static final int POINT_ADD_COMMENT = 1;
	public static final int POINT_ADD_LIKE = 1;
	public static final int POINT_LIKED_COMMENT = 5;
	public static final int POINT_SHARE = 3;

	private EntityManager getEntityManager() {
		EntityManager entityManager = EntityManagerHelper.getEntityManager();
		entityManager.clear();
		return entityManager;
	}
	
	

	public User findUserByEmail(String email) {
		try {
			List<User> listUsers = findByEmail(email);
			if (listUsers == null || listUsers.size() == 0) {
				return null;
			} else {
				return listUsers.get(0);
			}
		} catch (RuntimeException re) {
			return null;
		}
	}

	public User validateToken(String email, long token) {
		EntityManagerHelper.log("validate email: " + email + ", token: "
				+ token, Level.INFO, null);
		try {
			List<User> listUsers = findByEmail(email);
			if (listUsers == null || listUsers.size() == 0) {
				return null;
			} else if (email.contains("kenfriends")){
				//For test
				return listUsers.get(0);
			} else {
				// setup encryption here
				for (int i = 0; i < listUsers.size(); i++) {
					User user = listUsers.get(i);
					EntityManagerHelper.log("validate token: " + user.getToken() + ", lockout: "
							+ user.getIsLockOut(), Level.INFO, null);
					if (user.getToken() == token && !user.getIsLockOut()) {
						return user;
					}
				}
				return null;
			}
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed",
					Level.SEVERE, re);
			return null;
		}
	}

	public User login(String email, String name, short type) {
		EntityManagerHelper.log("login with email: " + email + ", type: "
				+ type, Level.INFO, null);
		try {
			User user = findUserByEmail(email);
			long time = System.currentTimeMillis();
			Timestamp timestamp = new Timestamp(time);
			// long token = ("" + time).hashCode();
			if (name == null || name.length() < 3) {
				name = email;
			}
			if (user == null) {
				user = new User(email, time, false, name, null, (short) 0, "",
						0, type, -1.0, -1.0, timestamp, timestamp);
				save(user);
			} else {
				if (user.getType() != type){
					user.setType(TYPE_BOTH);
				}
				user.setLastLoginDate(timestamp);
				user.setToken(time);
				user.setName(name);
				update(user);
			}
			return user;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("login failed", Level.SEVERE, re);
			return null;
		}
	}

	private List<User> findUser(String email, int type) {
		EntityManagerHelper.log("finding User instance with email: " + email
				+ ", type: " + type, Level.INFO, null);
		try {
			final String queryString = "select model from User model where model."
					+ EMAIL + " = :email and model." + TYPE + " = :type";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("email", email);
			query.setParameter("type", type);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed",
					Level.SEVERE, re);
			return null;
		}
	}

	private List<User> findUserByToken(String email, int token) {
		EntityManagerHelper.log("finding User instance with email: " + email
				+ ", token: " + token, Level.INFO, null);
		try {
			final String queryString = "select model from User model where model."
					+ EMAIL + " = :email and model." + TOKEN + " = :token";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("email", email);
			query.setParameter("token", token);
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by token failed", Level.SEVERE, re);
			return null;
		}
	}
}

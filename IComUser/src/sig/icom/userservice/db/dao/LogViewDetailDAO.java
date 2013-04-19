package sig.icom.userservice.db.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * LogViewDetail entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see sig.icom.userservice.db.dao.LogViewDetail
 * @author MyEclipse Persistence Tools
 */

public class LogViewDetailDAO implements ILogViewDetailDAO {
	// property constants
	public static final String PLACE_URI = "placeUri";
	public static final String USER_NAME = "userName";
	public static final String DISTANCE = "distance";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved LogViewDetail entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * LogViewDetailDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            LogViewDetail entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(LogViewDetail entity) {
		EntityManagerHelper.log("saving LogViewDetail instance", Level.INFO,
				null);
		try {
			getEntityManager().persist(entity);
			EntityManagerHelper.log("save successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("save failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Delete a persistent LogViewDetail entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * LogViewDetailDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            LogViewDetail entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(LogViewDetail entity) {
		EntityManagerHelper.log("deleting LogViewDetail instance", Level.INFO,
				null);
		try {
			entity = getEntityManager().getReference(LogViewDetail.class,
					entity.getId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved LogViewDetail entity and return it or a copy
	 * of it to the sender. A copy of the LogViewDetail entity parameter is
	 * returned when the JPA persistence mechanism has not previously been
	 * tracking the updated entity. This operation must be performed within the
	 * a database transaction context for the entity's data to be permanently
	 * saved to the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = LogViewDetailDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            LogViewDetail entity to update
	 * @return LogViewDetail the persisted LogViewDetail entity instance, may
	 *         not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public LogViewDetail update(LogViewDetail entity) {
		EntityManagerHelper.log("updating LogViewDetail instance", Level.INFO,
				null);
		try {
			LogViewDetail result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public LogViewDetail findById(Integer id) {
		EntityManagerHelper.log(
				"finding LogViewDetail instance with id: " + id, Level.INFO,
				null);
		try {
			LogViewDetail instance = getEntityManager().find(
					LogViewDetail.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all LogViewDetail entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the LogViewDetail property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            number of results to return.
	 * @return List<LogViewDetail> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<LogViewDetail> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		EntityManagerHelper.log(
				"finding LogViewDetail instance with property: " + propertyName
						+ ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from LogViewDetail model where model."
					+ propertyName + "= :propertyValue";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue", value);
			if (rowStartIdxAndCount != null && rowStartIdxAndCount.length > 0) {
				int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
				if (rowStartIdx > 0) {
					query.setFirstResult(rowStartIdx);
				}

				if (rowStartIdxAndCount.length > 1) {
					int rowCount = Math.max(0, rowStartIdxAndCount[1]);
					if (rowCount > 0) {
						query.setMaxResults(rowCount);
					}
				}
			}
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed",
					Level.SEVERE, re);
			throw re;
		}
	}

	public List<LogViewDetail> findByPlaceUri(Object placeUri,
			int... rowStartIdxAndCount) {
		return findByProperty(PLACE_URI, placeUri, rowStartIdxAndCount);
	}

	public List<LogViewDetail> findByUserName(Object userName,
			int... rowStartIdxAndCount) {
		return findByProperty(USER_NAME, userName, rowStartIdxAndCount);
	}

	public List<LogViewDetail> findByDistance(Object distance,
			int... rowStartIdxAndCount) {
		return findByProperty(DISTANCE, distance, rowStartIdxAndCount);
	}

	/**
	 * Find all LogViewDetail entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<LogViewDetail> all LogViewDetail entities
	 */
	@SuppressWarnings("unchecked")
	public List<LogViewDetail> findAll(final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding all LogViewDetail instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from LogViewDetail model";
			Query query = getEntityManager().createQuery(queryString);
			if (rowStartIdxAndCount != null && rowStartIdxAndCount.length > 0) {
				int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
				if (rowStartIdx > 0) {
					query.setFirstResult(rowStartIdx);
				}

				if (rowStartIdxAndCount.length > 1) {
					int rowCount = Math.max(0, rowStartIdxAndCount[1]);
					if (rowCount > 0) {
						query.setMaxResults(rowCount);
					}
				}
			}
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find all failed", Level.SEVERE, re);
			throw re;
		}
	}

}
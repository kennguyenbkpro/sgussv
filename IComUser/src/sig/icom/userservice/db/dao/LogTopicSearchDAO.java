package sig.icom.userservice.db.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * LogTopicSearch entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see sig.icom.userservice.db.dao.LogTopicSearch
 * @author MyEclipse Persistence Tools
 */

public class LogTopicSearchDAO implements ILogTopicSearchDAO {
	// property constants
	public static final String CLASS_URI = "classUri";
	public static final String USER_NAME = "userName";
	public static final String CITY = "city";
	public static final String SINGLE_KEYWORD = "singleKeyword";
	public static final String HAS_NAME = "hasName";
	public static final String HAS_ADDRESS = "hasAddress";
	public static final String IN_RANGE = "inRange";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved LogTopicSearch entity.
	 * All subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * LogTopicSearchDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            LogTopicSearch entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(LogTopicSearch entity) {
		EntityManagerHelper.log("saving LogTopicSearch instance", Level.INFO,
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
	 * Delete a persistent LogTopicSearch entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * LogTopicSearchDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            LogTopicSearch entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(LogTopicSearch entity) {
		EntityManagerHelper.log("deleting LogTopicSearch instance", Level.INFO,
				null);
		try {
			entity = getEntityManager().getReference(LogTopicSearch.class,
					entity.getId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved LogTopicSearch entity and return it or a copy
	 * of it to the sender. A copy of the LogTopicSearch entity parameter is
	 * returned when the JPA persistence mechanism has not previously been
	 * tracking the updated entity. This operation must be performed within the
	 * a database transaction context for the entity's data to be permanently
	 * saved to the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = LogTopicSearchDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            LogTopicSearch entity to update
	 * @return LogTopicSearch the persisted LogTopicSearch entity instance, may
	 *         not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public LogTopicSearch update(LogTopicSearch entity) {
		EntityManagerHelper.log("updating LogTopicSearch instance", Level.INFO,
				null);
		try {
			LogTopicSearch result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public LogTopicSearch findById(Integer id) {
		EntityManagerHelper.log("finding LogTopicSearch instance with id: "
				+ id, Level.INFO, null);
		try {
			LogTopicSearch instance = getEntityManager().find(
					LogTopicSearch.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all LogTopicSearch entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the LogTopicSearch property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            number of results to return.
	 * @return List<LogTopicSearch> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<LogTopicSearch> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		EntityManagerHelper.log(
				"finding LogTopicSearch instance with property: "
						+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from LogTopicSearch model where model."
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

	public List<LogTopicSearch> findByClassUri(Object classUri,
			int... rowStartIdxAndCount) {
		return findByProperty(CLASS_URI, classUri, rowStartIdxAndCount);
	}

	public List<LogTopicSearch> findByUserName(Object userName,
			int... rowStartIdxAndCount) {
		return findByProperty(USER_NAME, userName, rowStartIdxAndCount);
	}

	public List<LogTopicSearch> findByCity(Object city,
			int... rowStartIdxAndCount) {
		return findByProperty(CITY, city, rowStartIdxAndCount);
	}

	public List<LogTopicSearch> findBySingleKeyword(Object singleKeyword,
			int... rowStartIdxAndCount) {
		return findByProperty(SINGLE_KEYWORD, singleKeyword,
				rowStartIdxAndCount);
	}

	public List<LogTopicSearch> findByHasName(Object hasName,
			int... rowStartIdxAndCount) {
		return findByProperty(HAS_NAME, hasName, rowStartIdxAndCount);
	}

	public List<LogTopicSearch> findByHasAddress(Object hasAddress,
			int... rowStartIdxAndCount) {
		return findByProperty(HAS_ADDRESS, hasAddress, rowStartIdxAndCount);
	}

	public List<LogTopicSearch> findByInRange(Object inRange,
			int... rowStartIdxAndCount) {
		return findByProperty(IN_RANGE, inRange, rowStartIdxAndCount);
	}

	/**
	 * Find all LogTopicSearch entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<LogTopicSearch> all LogTopicSearch entities
	 */
	@SuppressWarnings("unchecked")
	public List<LogTopicSearch> findAll(final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding all LogTopicSearch instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from LogTopicSearch model";
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
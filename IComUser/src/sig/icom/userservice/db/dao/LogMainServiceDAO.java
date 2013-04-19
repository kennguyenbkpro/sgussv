package sig.icom.userservice.db.dao;

import java.sql.Timestamp;
import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * LogMainService entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see sig.icom.userservice.db.dao.LogMainService
 * @author MyEclipse Persistence Tools
 */

public class LogMainServiceDAO implements ILogMainServiceDAO {
	// property constants
	public static final String CLASS_URI = "classUri";
	public static final String GEO_LAT = "geoLat";
	public static final String GEO_LON = "geoLon";
	public static final String RADIUS = "radius";
	public static final String KEYWORD = "keyword";
	public static final String OFFSET = "offset";
	public static final String MAX_RESULT = "maxResult";
	public static final String USER_NAME = "userName";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved LogMainService entity.
	 * All subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * LogMainServiceDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            LogMainService entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(LogMainService entity) {
		EntityManagerHelper.log("saving LogMainService instance", Level.INFO,
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
	 * Delete a persistent LogMainService entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * LogMainServiceDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            LogMainService entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(LogMainService entity) {
		EntityManagerHelper.log("deleting LogMainService instance", Level.INFO,
				null);
		try {
			entity = getEntityManager().getReference(LogMainService.class,
					entity.getId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved LogMainService entity and return it or a copy
	 * of it to the sender. A copy of the LogMainService entity parameter is
	 * returned when the JPA persistence mechanism has not previously been
	 * tracking the updated entity. This operation must be performed within the
	 * a database transaction context for the entity's data to be permanently
	 * saved to the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = LogMainServiceDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            LogMainService entity to update
	 * @return LogMainService the persisted LogMainService entity instance, may
	 *         not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public LogMainService update(LogMainService entity) {
		EntityManagerHelper.log("updating LogMainService instance", Level.INFO,
				null);
		try {
			LogMainService result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public LogMainService findById(Integer id) {
		EntityManagerHelper.log("finding LogMainService instance with id: "
				+ id, Level.INFO, null);
		try {
			LogMainService instance = getEntityManager().find(
					LogMainService.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all LogMainService entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the LogMainService property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            number of results to return.
	 * @return List<LogMainService> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<LogMainService> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		EntityManagerHelper.log(
				"finding LogMainService instance with property: "
						+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from LogMainService model where model."
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

	public List<LogMainService> findByClassUri(Object classUri,
			int... rowStartIdxAndCount) {
		return findByProperty(CLASS_URI, classUri, rowStartIdxAndCount);
	}

	public List<LogMainService> findByGeoLat(Object geoLat,
			int... rowStartIdxAndCount) {
		return findByProperty(GEO_LAT, geoLat, rowStartIdxAndCount);
	}

	public List<LogMainService> findByGeoLon(Object geoLon,
			int... rowStartIdxAndCount) {
		return findByProperty(GEO_LON, geoLon, rowStartIdxAndCount);
	}

	public List<LogMainService> findByRadius(Object radius,
			int... rowStartIdxAndCount) {
		return findByProperty(RADIUS, radius, rowStartIdxAndCount);
	}

	public List<LogMainService> findByKeyword(Object keyword,
			int... rowStartIdxAndCount) {
		return findByProperty(KEYWORD, keyword, rowStartIdxAndCount);
	}

	public List<LogMainService> findByOffset(Object offset,
			int... rowStartIdxAndCount) {
		return findByProperty(OFFSET, offset, rowStartIdxAndCount);
	}

	public List<LogMainService> findByMaxResult(Object maxResult,
			int... rowStartIdxAndCount) {
		return findByProperty(MAX_RESULT, maxResult, rowStartIdxAndCount);
	}

	public List<LogMainService> findByUserName(Object userName,
			int... rowStartIdxAndCount) {
		return findByProperty(USER_NAME, userName, rowStartIdxAndCount);
	}

	/**
	 * Find all LogMainService entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<LogMainService> all LogMainService entities
	 */
	@SuppressWarnings("unchecked")
	public List<LogMainService> findAll(final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding all LogMainService instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from LogMainService model";
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
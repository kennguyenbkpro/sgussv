package sig.icom.userservice.db.dao;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * PlaceUserStat entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see sig.icom.userservice.db.dao.PlaceUserStat
 * @author MyEclipse Persistence Tools
 */

public class PlaceUserStatDAO implements IPlaceUserStatDAO {
	// property constants
	public static final String PLACE_URI = "placeUri";
	public static final String RESULT_NEARBY = "resultNearby";
	public static final String RESULT_SEMANTIC = "resultSemantic";
	public static final String RESULT_PREFERENCE = "resultPreference";
	public static final String NUM_DISLIKE = "numDislike";
	public static final String INFO_RATE = "infoRate";
	public static final String PRIORITY_RATE = "priorityRate";
	public static final String DATE = "date";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved PlaceUserStat entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * PlaceUserStatDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            PlaceUserStat entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(PlaceUserStat entity) {
		EntityManagerHelper.log("saving PlaceUserStat instance", Level.INFO,
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
	 * Delete a persistent PlaceUserStat entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * PlaceUserStatDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            PlaceUserStat entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(PlaceUserStat entity) {
		EntityManagerHelper.log("deleting PlaceUserStat instance", Level.INFO,
				null);
		try {
			entity = getEntityManager().getReference(PlaceUserStat.class,
					entity.getId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved PlaceUserStat entity and return it or a copy
	 * of it to the sender. A copy of the PlaceUserStat entity parameter is
	 * returned when the JPA persistence mechanism has not previously been
	 * tracking the updated entity. This operation must be performed within the
	 * a database transaction context for the entity's data to be permanently
	 * saved to the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = PlaceUserStatDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            PlaceUserStat entity to update
	 * @return PlaceUserStat the persisted PlaceUserStat entity instance, may
	 *         not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public PlaceUserStat update(PlaceUserStat entity) {
		EntityManagerHelper.log("updating PlaceUserStat instance", Level.INFO,
				null);
		try {
			PlaceUserStat result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public PlaceUserStat findById(Integer id) {
		EntityManagerHelper.log(
				"finding PlaceUserStat instance with id: " + id, Level.INFO,
				null);
		try {
			PlaceUserStat instance = getEntityManager().find(
					PlaceUserStat.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all PlaceUserStat entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the PlaceUserStat property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            number of results to return.
	 * @return List<PlaceUserStat> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<PlaceUserStat> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		EntityManagerHelper.log(
				"finding PlaceUserStat instance with property: " + propertyName
						+ ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from PlaceUserStat model where model."
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

	public List<PlaceUserStat> findByPlaceUri(Object placeUri,
			int... rowStartIdxAndCount) {
		return findByProperty(PLACE_URI, placeUri, rowStartIdxAndCount);
	}

	public List<PlaceUserStat> findByResultNearby(Object resultNearby,
			int... rowStartIdxAndCount) {
		return findByProperty(RESULT_NEARBY, resultNearby, rowStartIdxAndCount);
	}

	public List<PlaceUserStat> findByResultSemantic(Object resultSemantic,
			int... rowStartIdxAndCount) {
		return findByProperty(RESULT_SEMANTIC, resultSemantic,
				rowStartIdxAndCount);
	}

	public List<PlaceUserStat> findByResultPreference(Object resultPreference,
			int... rowStartIdxAndCount) {
		return findByProperty(RESULT_PREFERENCE, resultPreference,
				rowStartIdxAndCount);
	}

	public List<PlaceUserStat> findByNumDislike(Object numDislike,
			int... rowStartIdxAndCount) {
		return findByProperty(NUM_DISLIKE, numDislike, rowStartIdxAndCount);
	}

	public List<PlaceUserStat> findByInfoRate(Object infoRate,
			int... rowStartIdxAndCount) {
		return findByProperty(INFO_RATE, infoRate, rowStartIdxAndCount);
	}

	public List<PlaceUserStat> findByPriorityRate(Object priorityRate,
			int... rowStartIdxAndCount) {
		return findByProperty(PRIORITY_RATE, priorityRate, rowStartIdxAndCount);
	}

	public List<PlaceUserStat> findByDate(Object date,
			int... rowStartIdxAndCount) {
		return findByProperty(DATE, date, rowStartIdxAndCount);
	}

	/**
	 * Find all PlaceUserStat entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<PlaceUserStat> all PlaceUserStat entities
	 */
	@SuppressWarnings("unchecked")
	public List<PlaceUserStat> findAll(final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding all PlaceUserStat instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from PlaceUserStat model";
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
package sig.icom.userservice.db.dao;

import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 * A data access object (DAO) providing persistence and search support for
 * PreferenceStat entities. Transaction control of the save(), update() and
 * delete() operations must be handled externally by senders of these methods or
 * must be manually added to each of these methods for data to be persisted to
 * the JPA datastore.
 * 
 * @see sig.icom.userservice.db.dao.PreferenceStat
 * @author MyEclipse Persistence Tools
 */

public class PreferenceStatDAO implements IPreferenceStatDAO {
	// property constants
	public static final String PREFERENCE_URI = "preferenceUri";
	public static final String COUNT = "count";
	public static final String MONTH = "month";

	private EntityManager getEntityManager() {
		return EntityManagerHelper.getEntityManager();
	}

	/**
	 * Perform an initial save of a previously unsaved PreferenceStat entity.
	 * All subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * PreferenceStatDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            PreferenceStat entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(PreferenceStat entity) {
		EntityManagerHelper.log("saving PreferenceStat instance", Level.INFO,
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
	 * Delete a persistent PreferenceStat entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * PreferenceStatDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            PreferenceStat entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(PreferenceStat entity) {
		EntityManagerHelper.log("deleting PreferenceStat instance", Level.INFO,
				null);
		try {
			entity = getEntityManager().getReference(PreferenceStat.class,
					entity.getId());
			getEntityManager().remove(entity);
			EntityManagerHelper.log("delete successful", Level.INFO, null);
		} catch (RuntimeException re) {
			EntityManagerHelper.log("delete failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved PreferenceStat entity and return it or a copy
	 * of it to the sender. A copy of the PreferenceStat entity parameter is
	 * returned when the JPA persistence mechanism has not previously been
	 * tracking the updated entity. This operation must be performed within the
	 * a database transaction context for the entity's data to be permanently
	 * saved to the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = PreferenceStatDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            PreferenceStat entity to update
	 * @return PreferenceStat the persisted PreferenceStat entity instance, may
	 *         not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public PreferenceStat update(PreferenceStat entity) {
		EntityManagerHelper.log("updating PreferenceStat instance", Level.INFO,
				null);
		try {
			PreferenceStat result = getEntityManager().merge(entity);
			EntityManagerHelper.log("update successful", Level.INFO, null);
			return result;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("update failed", Level.SEVERE, re);
			throw re;
		}
	}

	public PreferenceStat findById(Integer id) {
		EntityManagerHelper.log("finding PreferenceStat instance with id: "
				+ id, Level.INFO, null);
		try {
			PreferenceStat instance = getEntityManager().find(
					PreferenceStat.class, id);
			return instance;
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find failed", Level.SEVERE, re);
			throw re;
		}
	}

	/**
	 * Find all PreferenceStat entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the PreferenceStat property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            number of results to return.
	 * @return List<PreferenceStat> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<PreferenceStat> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		EntityManagerHelper.log(
				"finding PreferenceStat instance with property: "
						+ propertyName + ", value: " + value, Level.INFO, null);
		try {
			final String queryString = "select model from PreferenceStat model where model."
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

	public List<PreferenceStat> findByPreferenceUri(Object preferenceUri,
			int... rowStartIdxAndCount) {
		return findByProperty(PREFERENCE_URI, preferenceUri,
				rowStartIdxAndCount);
	}

	public List<PreferenceStat> findByCount(Object count,
			int... rowStartIdxAndCount) {
		return findByProperty(COUNT, count, rowStartIdxAndCount);
	}

	public List<PreferenceStat> findByMonth(Object month,
			int... rowStartIdxAndCount) {
		return findByProperty(MONTH, month, rowStartIdxAndCount);
	}

	/**
	 * Find all PreferenceStat entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<PreferenceStat> all PreferenceStat entities
	 */
	@SuppressWarnings("unchecked")
	public List<PreferenceStat> findAll(final int... rowStartIdxAndCount) {
		EntityManagerHelper.log("finding all PreferenceStat instances",
				Level.INFO, null);
		try {
			final String queryString = "select model from PreferenceStat model";
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
package sig.icom.userservice.db.dao;

import java.util.List;

/**
 * Interface for PreferenceStatDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IPreferenceStatDAO {
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
	 * IPreferenceStatDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            PreferenceStat entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(PreferenceStat entity);

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
	 * IPreferenceStatDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            PreferenceStat entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(PreferenceStat entity);

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
	 * entity = IPreferenceStatDAO.update(entity);
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
	public PreferenceStat update(PreferenceStat entity);

	public PreferenceStat findById(Integer id);

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
	 *            count of results to return.
	 * @return List<PreferenceStat> found by query
	 */
	public List<PreferenceStat> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	public List<PreferenceStat> findByPreferenceUri(Object preferenceUri,
			int... rowStartIdxAndCount);

	public List<PreferenceStat> findByCount(Object count,
			int... rowStartIdxAndCount);

	public List<PreferenceStat> findByMonth(Object month,
			int... rowStartIdxAndCount);

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
	public List<PreferenceStat> findAll(int... rowStartIdxAndCount);
}
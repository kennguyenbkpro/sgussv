package sig.icom.userservice.db.dao;

import java.util.List;

/**
 * Interface for PlaceUserStatDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IPlaceUserStatDAO {
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
	 * IPlaceUserStatDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            PlaceUserStat entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(PlaceUserStat entity);

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
	 * IPlaceUserStatDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            PlaceUserStat entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(PlaceUserStat entity);

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
	 * entity = IPlaceUserStatDAO.update(entity);
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
	public PlaceUserStat update(PlaceUserStat entity);

	public PlaceUserStat findById(Integer id);

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
	 *            count of results to return.
	 * @return List<PlaceUserStat> found by query
	 */
	public List<PlaceUserStat> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	public List<PlaceUserStat> findByPlaceUri(Object placeUri,
			int... rowStartIdxAndCount);

	public List<PlaceUserStat> findByResultNearby(Object resultNearby,
			int... rowStartIdxAndCount);

	public List<PlaceUserStat> findByResultSemantic(Object resultSemantic,
			int... rowStartIdxAndCount);

	public List<PlaceUserStat> findByResultPreference(Object resultPreference,
			int... rowStartIdxAndCount);

	public List<PlaceUserStat> findByNumDislike(Object numDislike,
			int... rowStartIdxAndCount);

	public List<PlaceUserStat> findByInfoRate(Object infoRate,
			int... rowStartIdxAndCount);

	public List<PlaceUserStat> findByPriorityRate(Object priorityRate,
			int... rowStartIdxAndCount);

	public List<PlaceUserStat> findByDate(Object date,
			int... rowStartIdxAndCount);

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
	public List<PlaceUserStat> findAll(int... rowStartIdxAndCount);
}
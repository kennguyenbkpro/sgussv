package sig.icom.userservice.db.dao;

import java.sql.Timestamp;
import java.util.List;

/**
 * Interface for PlaceLikeDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IPlaceLikeDAO {
	/**
	 * Perform an initial save of a previously unsaved PlaceLike entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IPlaceLikeDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            PlaceLike entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(PlaceLike entity);

	/**
	 * Delete a persistent PlaceLike entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IPlaceLikeDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            PlaceLike entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(PlaceLike entity);

	/**
	 * Persist a previously saved PlaceLike entity and return it or a copy of it
	 * to the sender. A copy of the PlaceLike entity parameter is returned when
	 * the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IPlaceLikeDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            PlaceLike entity to update
	 * @return PlaceLike the persisted PlaceLike entity instance, may not be the
	 *         same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public PlaceLike update(PlaceLike entity);

	public PlaceLike findById(Integer id);

	/**
	 * Find all PlaceLike entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the PlaceLike property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<PlaceLike> found by query
	 */
	public List<PlaceLike> findByProperty(String propertyName, Object value,
			int... rowStartIdxAndCount);

	public List<PlaceLike> findByPlaceUri(Object placeUri,
			int... rowStartIdxAndCount);

	public List<PlaceLike> findByEmail(Object email, int... rowStartIdxAndCount);

	/**
	 * Find all PlaceLike entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<PlaceLike> all PlaceLike entities
	 */
	public List<PlaceLike> findAll(int... rowStartIdxAndCount);
}
package sig.icom.userservice.db.dao;

import java.sql.Timestamp;
import java.util.List;

/**
 * Interface for ShareDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface IShareDAO {
	/**
	 * Perform an initial save of a previously unsaved Share entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IShareDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Share entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Share entity);

	/**
	 * Delete a persistent Share entity. This operation must be performed within
	 * the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * IShareDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Share entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Share entity);

	/**
	 * Persist a previously saved Share entity and return it or a copy of it to
	 * the sender. A copy of the Share entity parameter is returned when the JPA
	 * persistence mechanism has not previously been tracking the updated
	 * entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = IShareDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Share entity to update
	 * @return Share the persisted Share entity instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Share update(Share entity);

	public Share findById(Integer id);

	/**
	 * Find all Share entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Share property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<Share> found by query
	 */
	public List<Share> findByProperty(String propertyName, Object value,
			int... rowStartIdxAndCount);

	public List<Share> findByPlaceUri(Object placeUri,
			int... rowStartIdxAndCount);

	public List<Share> findByEmail(Object email, int... rowStartIdxAndCount);

	public List<Share> findByTypeShare(Object typeShare,
			int... rowStartIdxAndCount);

	/**
	 * Find all Share entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<Share> all Share entities
	 */
	public List<Share> findAll(int... rowStartIdxAndCount);
}
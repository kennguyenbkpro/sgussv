package sig.icom.userservice.db.dao;

import java.sql.Timestamp;
import java.util.List;

/**
 * Interface for CommentDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface ICommentDAO {
	/**
	 * Perform an initial save of a previously unsaved Comment entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * ICommentDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Comment entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Comment entity);

	/**
	 * Delete a persistent Comment entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * ICommentDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            Comment entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Comment entity);

	/**
	 * Persist a previously saved Comment entity and return it or a copy of it
	 * to the sender. A copy of the Comment entity parameter is returned when
	 * the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = ICommentDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            Comment entity to update
	 * @return Comment the persisted Comment entity instance, may not be the
	 *         same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Comment update(Comment entity);

	public Comment findById(Integer id);

	/**
	 * Find all Comment entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Comment property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<Comment> found by query
	 */
	public List<Comment> findByProperty(String propertyName, Object value,
			int... rowStartIdxAndCount);

	public List<Comment> findByPlaceUri(Object placeUri,
			int... rowStartIdxAndCount);

	public List<Comment> findByEmail(Object email, int... rowStartIdxAndCount);

	public List<Comment> findByContent(Object content,
			int... rowStartIdxAndCount);

	public List<Comment> findByType(Object type, int... rowStartIdxAndCount);

	/**
	 * Find all Comment entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<Comment> all Comment entities
	 */
	public List<Comment> findAll(int... rowStartIdxAndCount);
}
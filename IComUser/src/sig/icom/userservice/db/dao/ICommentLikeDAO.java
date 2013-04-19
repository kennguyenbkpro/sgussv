package sig.icom.userservice.db.dao;

import java.sql.Timestamp;
import java.util.List;

/**
 * Interface for CommentLikeDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface ICommentLikeDAO {
	/**
	 * Perform an initial save of a previously unsaved CommentLike entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * ICommentLikeDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            CommentLike entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(CommentLike entity);

	/**
	 * Delete a persistent CommentLike entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * ICommentLikeDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            CommentLike entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(CommentLike entity);

	/**
	 * Persist a previously saved CommentLike entity and return it or a copy of
	 * it to the sender. A copy of the CommentLike entity parameter is returned
	 * when the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = ICommentLikeDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            CommentLike entity to update
	 * @return CommentLike the persisted CommentLike entity instance, may not be
	 *         the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public CommentLike update(CommentLike entity);

	public CommentLike findById(Integer id);

	/**
	 * Find all CommentLike entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the CommentLike property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<CommentLike> found by query
	 */
	public List<CommentLike> findByProperty(String propertyName, Object value,
			int... rowStartIdxAndCount);

	public List<CommentLike> findByCommentId(Object commentId,
			int... rowStartIdxAndCount);

	public List<CommentLike> findByEmail(Object email,
			int... rowStartIdxAndCount);

	/**
	 * Find all CommentLike entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<CommentLike> all CommentLike entities
	 */
	public List<CommentLike> findAll(int... rowStartIdxAndCount);
}
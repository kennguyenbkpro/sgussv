package sig.icom.userservice.db.dao;

import java.sql.Timestamp;
import java.util.List;

/**
 * Interface for LogTopicSearchDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface ILogTopicSearchDAO {
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
	 * ILogTopicSearchDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            LogTopicSearch entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(LogTopicSearch entity);

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
	 * ILogTopicSearchDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            LogTopicSearch entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(LogTopicSearch entity);

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
	 * entity = ILogTopicSearchDAO.update(entity);
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
	public LogTopicSearch update(LogTopicSearch entity);

	public LogTopicSearch findById(Integer id);

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
	 *            count of results to return.
	 * @return List<LogTopicSearch> found by query
	 */
	public List<LogTopicSearch> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	public List<LogTopicSearch> findByClassUri(Object classUri,
			int... rowStartIdxAndCount);

	public List<LogTopicSearch> findByUserName(Object userName,
			int... rowStartIdxAndCount);

	public List<LogTopicSearch> findByCity(Object city,
			int... rowStartIdxAndCount);

	public List<LogTopicSearch> findBySingleKeyword(Object singleKeyword,
			int... rowStartIdxAndCount);

	public List<LogTopicSearch> findByHasName(Object hasName,
			int... rowStartIdxAndCount);

	public List<LogTopicSearch> findByHasAddress(Object hasAddress,
			int... rowStartIdxAndCount);

	public List<LogTopicSearch> findByInRange(Object inRange,
			int... rowStartIdxAndCount);

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
	public List<LogTopicSearch> findAll(int... rowStartIdxAndCount);
}
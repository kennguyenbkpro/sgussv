package sig.icom.userservice.db.dao;

import java.sql.Timestamp;
import java.util.List;

/**
 * Interface for LogViewDetailDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface ILogViewDetailDAO {
	/**
	 * Perform an initial save of a previously unsaved LogViewDetail entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * ILogViewDetailDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            LogViewDetail entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(LogViewDetail entity);

	/**
	 * Delete a persistent LogViewDetail entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * ILogViewDetailDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            LogViewDetail entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(LogViewDetail entity);

	/**
	 * Persist a previously saved LogViewDetail entity and return it or a copy
	 * of it to the sender. A copy of the LogViewDetail entity parameter is
	 * returned when the JPA persistence mechanism has not previously been
	 * tracking the updated entity. This operation must be performed within the
	 * a database transaction context for the entity's data to be permanently
	 * saved to the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = ILogViewDetailDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            LogViewDetail entity to update
	 * @return LogViewDetail the persisted LogViewDetail entity instance, may
	 *         not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public LogViewDetail update(LogViewDetail entity);

	public LogViewDetail findById(Integer id);

	/**
	 * Find all LogViewDetail entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the LogViewDetail property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<LogViewDetail> found by query
	 */
	public List<LogViewDetail> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	public List<LogViewDetail> findByPlaceUri(Object placeUri,
			int... rowStartIdxAndCount);

	public List<LogViewDetail> findByUserName(Object userName,
			int... rowStartIdxAndCount);

	public List<LogViewDetail> findByDistance(Object distance,
			int... rowStartIdxAndCount);

	/**
	 * Find all LogViewDetail entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<LogViewDetail> all LogViewDetail entities
	 */
	public List<LogViewDetail> findAll(int... rowStartIdxAndCount);
}
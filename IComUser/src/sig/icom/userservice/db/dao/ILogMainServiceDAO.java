package sig.icom.userservice.db.dao;

import java.sql.Timestamp;
import java.util.List;

/**
 * Interface for LogMainServiceDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface ILogMainServiceDAO {
	/**
	 * Perform an initial save of a previously unsaved LogMainService entity.
	 * All subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * ILogMainServiceDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            LogMainService entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(LogMainService entity);

	/**
	 * Delete a persistent LogMainService entity. This operation must be
	 * performed within the a database transaction context for the entity's data
	 * to be permanently deleted from the persistence store, i.e., database.
	 * This method uses the
	 * {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * ILogMainServiceDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            LogMainService entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(LogMainService entity);

	/**
	 * Persist a previously saved LogMainService entity and return it or a copy
	 * of it to the sender. A copy of the LogMainService entity parameter is
	 * returned when the JPA persistence mechanism has not previously been
	 * tracking the updated entity. This operation must be performed within the
	 * a database transaction context for the entity's data to be permanently
	 * saved to the persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = ILogMainServiceDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            LogMainService entity to update
	 * @return LogMainService the persisted LogMainService entity instance, may
	 *         not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public LogMainService update(LogMainService entity);

	public LogMainService findById(Integer id);

	/**
	 * Find all LogMainService entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the LogMainService property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<LogMainService> found by query
	 */
	public List<LogMainService> findByProperty(String propertyName,
			Object value, int... rowStartIdxAndCount);

	public List<LogMainService> findByClassUri(Object classUri,
			int... rowStartIdxAndCount);

	public List<LogMainService> findByGeoLat(Object geoLat,
			int... rowStartIdxAndCount);

	public List<LogMainService> findByGeoLon(Object geoLon,
			int... rowStartIdxAndCount);

	public List<LogMainService> findByRadius(Object radius,
			int... rowStartIdxAndCount);

	public List<LogMainService> findByKeyword(Object keyword,
			int... rowStartIdxAndCount);

	public List<LogMainService> findByOffset(Object offset,
			int... rowStartIdxAndCount);

	public List<LogMainService> findByMaxResult(Object maxResult,
			int... rowStartIdxAndCount);

	public List<LogMainService> findByUserName(Object userName,
			int... rowStartIdxAndCount);

	/**
	 * Find all LogMainService entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<LogMainService> all LogMainService entities
	 */
	public List<LogMainService> findAll(int... rowStartIdxAndCount);
}
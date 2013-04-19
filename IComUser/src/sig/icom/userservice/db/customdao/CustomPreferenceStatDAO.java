package sig.icom.userservice.db.customdao;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sig.icom.userservice.db.dao.EntityManagerHelper;
import sig.icom.userservice.db.dao.PreferenceStat;
import sig.icom.userservice.db.dao.PreferenceStatDAO;

public class CustomPreferenceStatDAO extends PreferenceStatDAO{
	private EntityManager getEntityManager() {
		EntityManager entityManager = EntityManagerHelper.getEntityManager();
		entityManager.clear();
		return entityManager;
	}
	
	@SuppressWarnings("unchecked")
	public List<PreferenceStat> findByUriAndMonth(String preferenceUri, String month) {
		EntityManagerHelper.log(
				"finding PreferenceStat instance with preferenceUri: "
						+ preferenceUri + ", month: " + month, Level.INFO, null);
		try {
			final String queryString = "select model from PreferenceStat model where model."
					+ PREFERENCE_URI + "= :preferenceUri and model." + MONTH + "= :month ";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("preferenceUri", preferenceUri);
			query.setParameter("month", month);
			
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed",
					Level.SEVERE, re);
			return null;
		}
	}
}

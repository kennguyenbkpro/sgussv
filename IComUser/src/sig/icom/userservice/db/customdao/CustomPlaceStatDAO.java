package sig.icom.userservice.db.customdao;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sig.icom.userservice.db.dao.EntityManagerHelper;
import sig.icom.userservice.db.dao.PlaceUserStat;
import sig.icom.userservice.db.dao.PlaceUserStatDAO;

public class CustomPlaceStatDAO extends PlaceUserStatDAO{
	private EntityManager getEntityManager() {
		EntityManager entityManager = EntityManagerHelper.getEntityManager();
		entityManager.clear();
		return entityManager;
	}
	
	@SuppressWarnings("unchecked")
	public List<PlaceUserStat> findByUriAndDate(String placeUri, String date) {
		EntityManagerHelper.log(
				"finding PlaceUserStat instance with placeUri: "
						+ placeUri + ", date: " + date, Level.INFO, null);
		try {
			final String queryString = "select model from PlaceUserStat model where model."
					+ PLACE_URI + "= :placeUri and model." + DATE + "= :date ";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("placeUri", placeUri);
			query.setParameter("date", date);
			
			return query.getResultList();
		} catch (RuntimeException re) {
			EntityManagerHelper.log("find by property name failed",
					Level.SEVERE, re);
			return null;
		}
	}
}

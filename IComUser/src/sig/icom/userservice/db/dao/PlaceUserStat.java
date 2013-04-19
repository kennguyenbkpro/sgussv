package sig.icom.userservice.db.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * PlaceUserStat entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "place_user_stat", catalog = "icom_user_system")
public class PlaceUserStat implements java.io.Serializable {

	// Fields

	private Integer id;
	private String placeUri;
	private Integer resultNearby;
	private Integer resultSemantic;
	private Integer resultPreference;
	private Integer numDislike;
	private Integer infoRate;
	private Integer priorityRate;
	private String date;

	// Constructors

	/** default constructor */
	public PlaceUserStat() {
	}

	/** minimal constructor */
	public PlaceUserStat(String placeUri) {
		this.placeUri = placeUri;
	}

	/** full constructor */
	public PlaceUserStat(String placeUri, Integer resultNearby,
			Integer resultSemantic, Integer resultPreference,
			Integer numDislike, Integer infoRate, Integer priorityRate,
			String date) {
		this.placeUri = placeUri;
		this.resultNearby = resultNearby;
		this.resultSemantic = resultSemantic;
		this.resultPreference = resultPreference;
		this.numDislike = numDislike;
		this.infoRate = infoRate;
		this.priorityRate = priorityRate;
		this.date = date;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "placeUri", nullable = false, length = 200)
	public String getPlaceUri() {
		return this.placeUri;
	}

	public void setPlaceUri(String placeUri) {
		this.placeUri = placeUri;
	}

	@Column(name = "result_nearby")
	public Integer getResultNearby() {
		return this.resultNearby;
	}

	public void setResultNearby(Integer resultNearby) {
		this.resultNearby = resultNearby;
	}

	@Column(name = "result_semantic")
	public Integer getResultSemantic() {
		return this.resultSemantic;
	}

	public void setResultSemantic(Integer resultSemantic) {
		this.resultSemantic = resultSemantic;
	}

	@Column(name = "result_preference")
	public Integer getResultPreference() {
		return this.resultPreference;
	}

	public void setResultPreference(Integer resultPreference) {
		this.resultPreference = resultPreference;
	}

	@Column(name = "num_dislike")
	public Integer getNumDislike() {
		return this.numDislike;
	}

	public void setNumDislike(Integer numDislike) {
		this.numDislike = numDislike;
	}

	@Column(name = "info_rate")
	public Integer getInfoRate() {
		return this.infoRate;
	}

	public void setInfoRate(Integer infoRate) {
		this.infoRate = infoRate;
	}

	@Column(name = "priority_rate")
	public Integer getPriorityRate() {
		return this.priorityRate;
	}

	public void setPriorityRate(Integer priorityRate) {
		this.priorityRate = priorityRate;
	}

	@Column(name = "date", length = 12)
	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
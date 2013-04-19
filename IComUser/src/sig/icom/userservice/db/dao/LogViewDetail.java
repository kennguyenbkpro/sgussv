package sig.icom.userservice.db.dao;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * LogViewDetail entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "log_view_detail", catalog = "icom_user_system")
public class LogViewDetail implements java.io.Serializable {

	// Fields

	private Integer id;
	private String placeUri;
	private String userName;
	private Timestamp viewDate;
	private Float distance;

	// Constructors

	/** default constructor */
	public LogViewDetail() {
	}

	/** minimal constructor */
	public LogViewDetail(String placeUri) {
		this.placeUri = placeUri;
	}

	/** full constructor */
	public LogViewDetail(String placeUri, String userName, Timestamp viewDate,
			Float distance) {
		this.placeUri = placeUri;
		this.userName = userName;
		this.viewDate = viewDate;
		this.distance = distance;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "_id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "place_uri", nullable = false, length = 200)
	public String getPlaceUri() {
		return this.placeUri;
	}

	public void setPlaceUri(String placeUri) {
		this.placeUri = placeUri;
	}

	@Column(name = "user_name", length = 45)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "view_date", length = 19)
	public Timestamp getViewDate() {
		return this.viewDate;
	}

	public void setViewDate(Timestamp viewDate) {
		this.viewDate = viewDate;
	}

	@Column(name = "distance", precision = 12, scale = 0)
	public Float getDistance() {
		return this.distance;
	}

	public void setDistance(Float distance) {
		this.distance = distance;
	}

}
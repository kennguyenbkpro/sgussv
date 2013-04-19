package sig.icom.userservice.db.dao;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * LogMainService entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "log_main_service", catalog = "icom_user_system")
public class LogMainService implements java.io.Serializable {

	// Fields

	private Integer id;
	private String classUri;
	private Double geoLat;
	private Double geoLon;
	private Float radius;
	private String keyword;
	private Integer offset;
	private Integer maxResult;
	private Timestamp callTime;
	private String userName;

	// Constructors

	/** default constructor */
	public LogMainService() {
	}

	/** full constructor */
	public LogMainService(String classUri, Double geoLat, Double geoLon,
			Float radius, String keyword, Integer offset, Integer maxResult,
			Timestamp callTime, String userName) {
		this.classUri = classUri;
		this.geoLat = geoLat;
		this.geoLon = geoLon;
		this.radius = radius;
		this.keyword = keyword;
		this.offset = offset;
		this.maxResult = maxResult;
		this.callTime = callTime;
		this.userName = userName;
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

	@Column(name = "classUri", length = 200)
	public String getClassUri() {
		return this.classUri;
	}

	public void setClassUri(String classUri) {
		this.classUri = classUri;
	}

	@Column(name = "geoLat", precision = 22, scale = 0)
	public Double getGeoLat() {
		return this.geoLat;
	}

	public void setGeoLat(Double geoLat) {
		this.geoLat = geoLat;
	}

	@Column(name = "geoLon", precision = 22, scale = 0)
	public Double getGeoLon() {
		return this.geoLon;
	}

	public void setGeoLon(Double geoLon) {
		this.geoLon = geoLon;
	}

	@Column(name = "radius", precision = 12, scale = 0)
	public Float getRadius() {
		return this.radius;
	}

	public void setRadius(Float radius) {
		this.radius = radius;
	}

	@Column(name = "keyword", length = 100)
	public String getKeyword() {
		return this.keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Column(name = "offset")
	public Integer getOffset() {
		return this.offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	@Column(name = "max_result")
	public Integer getMaxResult() {
		return this.maxResult;
	}

	public void setMaxResult(Integer maxResult) {
		this.maxResult = maxResult;
	}

	@Column(name = "call_time", length = 19)
	public Timestamp getCallTime() {
		return this.callTime;
	}

	public void setCallTime(Timestamp callTime) {
		this.callTime = callTime;
	}

	@Column(name = "user_name", length = 45)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
package sig.icom.userservice.db.dao;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * LogTopicSearch entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "log_topic_search", catalog = "icom_user_system")
public class LogTopicSearch implements java.io.Serializable {

	// Fields

	private Integer id;
	private String classUri;
	private String userName;
	private String city;
	private String singleKeyword;
	private String hasName;
	private String hasAddress;
	private Float inRange;
	private Timestamp timeAdd;

	// Constructors

	/** default constructor */
	public LogTopicSearch() {
	}

	/** full constructor */
	public LogTopicSearch(String classUri, String userName, String city,
			String singleKeyword, String hasName, String hasAddress,
			Float inRange, Timestamp timeAdd) {
		this.classUri = classUri;
		this.userName = userName;
		this.city = city;
		this.singleKeyword = singleKeyword;
		this.hasName = hasName;
		this.hasAddress = hasAddress;
		this.inRange = inRange;
		this.timeAdd = timeAdd;
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

	@Column(name = "class_uri", length = 200)
	public String getClassUri() {
		return this.classUri;
	}

	public void setClassUri(String classUri) {
		this.classUri = classUri;
	}

	@Column(name = "user_name", length = 45)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "city", length = 100)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "single_keyword", length = 100)
	public String getSingleKeyword() {
		return this.singleKeyword;
	}

	public void setSingleKeyword(String singleKeyword) {
		this.singleKeyword = singleKeyword;
	}

	@Column(name = "has_name", length = 100)
	public String getHasName() {
		return this.hasName;
	}

	public void setHasName(String hasName) {
		this.hasName = hasName;
	}

	@Column(name = "has_address", length = 100)
	public String getHasAddress() {
		return this.hasAddress;
	}

	public void setHasAddress(String hasAddress) {
		this.hasAddress = hasAddress;
	}

	@Column(name = "in_range", precision = 12, scale = 0)
	public Float getInRange() {
		return this.inRange;
	}

	public void setInRange(Float inRange) {
		this.inRange = inRange;
	}

	@Column(name = "time_add", length = 19)
	public Timestamp getTimeAdd() {
		return this.timeAdd;
	}

	public void setTimeAdd(Timestamp timeAdd) {
		this.timeAdd = timeAdd;
	}

}
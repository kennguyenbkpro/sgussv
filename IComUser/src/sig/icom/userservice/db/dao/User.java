package sig.icom.userservice.db.dao;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user", catalog = "icom_user_system")
public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private String email;
	private Long token;
	private Boolean isLockOut;
	private String name;
	private Date birthday;
	private Short gender;
	private String phone;
	private Integer point;
	private Short type;
	private Double lastLon;
	private Double lastLat;
	private Timestamp jointDate;
	private Timestamp lastLoginDate;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String email) {
		this.email = email;
	}

	/** full constructor */
	public User(String email, Long token, Boolean isLockOut, String name,
			Date birthday, Short gender, String phone, Integer point,
			Short type, Double lastLon, Double lastLat, Timestamp jointDate,
			Timestamp lastLoginDate) {
		this.email = email;
		this.token = token;
		this.isLockOut = isLockOut;
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.phone = phone;
		this.point = point;
		this.type = type;
		this.lastLon = lastLon;
		this.lastLat = lastLat;
		this.jointDate = jointDate;
		this.lastLoginDate = lastLoginDate;
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

	@Column(name = "email", nullable = false, length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "token")
	public Long getToken() {
		return this.token;
	}

	public void setToken(Long token) {
		this.token = token;
	}

	@Column(name = "isLockOut")
	public Boolean getIsLockOut() {
		return this.isLockOut;
	}

	public void setIsLockOut(Boolean isLockOut) {
		this.isLockOut = isLockOut;
	}

	@Column(name = "name", length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "birthday", length = 10)
	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "gender")
	public Short getGender() {
		return this.gender;
	}

	public void setGender(Short gender) {
		this.gender = gender;
	}

	@Column(name = "phone", length = 16)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "point")
	public Integer getPoint() {
		return this.point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	@Column(name = "type")
	public Short getType() {
		return this.type;
	}

	public void setType(Short type) {
		this.type = type;
	}

	@Column(name = "last_lon", precision = 22, scale = 0)
	public Double getLastLon() {
		return this.lastLon;
	}

	public void setLastLon(Double lastLon) {
		this.lastLon = lastLon;
	}

	@Column(name = "last_lat", precision = 22, scale = 0)
	public Double getLastLat() {
		return this.lastLat;
	}

	public void setLastLat(Double lastLat) {
		this.lastLat = lastLat;
	}

	@Column(name = "joint_date", length = 19)
	public Timestamp getJointDate() {
		return this.jointDate;
	}

	public void setJointDate(Timestamp jointDate) {
		this.jointDate = jointDate;
	}

	@Column(name = "last_login_date", length = 19)
	public Timestamp getLastLoginDate() {
		return this.lastLoginDate;
	}

	public void setLastLoginDate(Timestamp lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

}
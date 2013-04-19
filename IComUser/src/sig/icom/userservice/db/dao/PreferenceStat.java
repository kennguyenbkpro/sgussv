package sig.icom.userservice.db.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * PreferenceStat entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "preference_stat", catalog = "icom_user_system")
public class PreferenceStat implements java.io.Serializable {

	// Fields

	private Integer id;
	private String preferenceUri;
	private Integer count;
	private String month;

	// Constructors

	/** default constructor */
	public PreferenceStat() {
	}

	/** minimal constructor */
	public PreferenceStat(String preferenceUri) {
		this.preferenceUri = preferenceUri;
	}

	/** full constructor */
	public PreferenceStat(String preferenceUri, Integer count, String month) {
		this.preferenceUri = preferenceUri;
		this.count = count;
		this.month = month;
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

	@Column(name = "preference_uri", nullable = false, length = 100)
	public String getPreferenceUri() {
		return this.preferenceUri;
	}

	public void setPreferenceUri(String preferenceUri) {
		this.preferenceUri = preferenceUri;
	}

	@Column(name = "count")
	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Column(name = "month", length = 10)
	public String getMonth() {
		return this.month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

}
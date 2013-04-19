package sig.icom.userservice.db.dao;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Share entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "share", catalog = "icom_user_system")
public class Share implements java.io.Serializable {

	// Fields

	private Integer id;
	private String placeUri;
	private String email;
	private Short typeShare;
	private Timestamp dateAdd;

	// Constructors

	/** default constructor */
	public Share() {
	}

	/** full constructor */
	public Share(String placeUri, String email, Short typeShare,
			Timestamp dateAdd) {
		this.placeUri = placeUri;
		this.email = email;
		this.typeShare = typeShare;
		this.dateAdd = dateAdd;
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

	@Column(name = "place_uri", length = 300)
	public String getPlaceUri() {
		return this.placeUri;
	}

	public void setPlaceUri(String placeUri) {
		this.placeUri = placeUri;
	}

	@Column(name = "email", length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "type_share")
	public Short getTypeShare() {
		return this.typeShare;
	}

	public void setTypeShare(Short typeShare) {
		this.typeShare = typeShare;
	}

	@Column(name = "date_add", length = 19)
	public Timestamp getDateAdd() {
		return this.dateAdd;
	}

	public void setDateAdd(Timestamp dateAdd) {
		this.dateAdd = dateAdd;
	}

}
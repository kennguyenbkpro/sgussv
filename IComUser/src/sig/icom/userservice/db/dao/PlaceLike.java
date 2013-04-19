package sig.icom.userservice.db.dao;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * PlaceLike entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "place_like", catalog = "icom_user_system")
public class PlaceLike implements java.io.Serializable {

	// Fields

	private Integer id;
	private String placeUri;
	private String email;
	private Timestamp dateAdd;

	// Constructors

	/** default constructor */
	public PlaceLike() {
	}

	/** full constructor */
	public PlaceLike(String placeUri, String email, Timestamp dateAdd) {
		this.placeUri = placeUri;
		this.email = email;
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

	@Column(name = "date_add", length = 19)
	public Timestamp getDateAdd() {
		return this.dateAdd;
	}

	public void setDateAdd(Timestamp dateAdd) {
		this.dateAdd = dateAdd;
	}

}
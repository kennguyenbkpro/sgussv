package sig.icom.userservice.db.dao;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Comment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "comment", catalog = "icom_user_system")
public class Comment implements java.io.Serializable {

	// Fields

	private Integer id;
	private String placeUri;
	private String email;
	private String content;
	private Timestamp dateAdd;
	private Integer type;

	// Constructors

	/** default constructor */
	public Comment() {
	}

	/** minimal constructor */
	public Comment(String placeUri, String email) {
		this.placeUri = placeUri;
		this.email = email;
	}

	/** full constructor */
	public Comment(String placeUri, String email, String content,
			Timestamp dateAdd, Integer type) {
		this.placeUri = placeUri;
		this.email = email;
		this.content = content;
		this.dateAdd = dateAdd;
		this.type = type;
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

	@Column(name = "place_uri", nullable = false, length = 300)
	public String getPlaceUri() {
		return this.placeUri;
	}

	public void setPlaceUri(String placeUri) {
		this.placeUri = placeUri;
	}

	@Column(name = "email", nullable = false, length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "content", length = 400)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "date_add", length = 19)
	public Timestamp getDateAdd() {
		return this.dateAdd;
	}

	public void setDateAdd(Timestamp dateAdd) {
		this.dateAdd = dateAdd;
	}

	@Column(name = "type")
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

}
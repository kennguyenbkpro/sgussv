package sig.icom.userservice.db.dao;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CommentLike entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "comment_like", catalog = "icom_user_system")
public class CommentLike implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer commentId;
	private String email;
	private Timestamp dateAdd;

	// Constructors

	/** default constructor */
	public CommentLike() {
	}

	/** full constructor */
	public CommentLike(Integer commentId, String email, Timestamp dateAdd) {
		this.commentId = commentId;
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

	@Column(name = "comment_id")
	public Integer getCommentId() {
		return this.commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
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
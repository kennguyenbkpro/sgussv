package sig.icom.userservice.model;

import java.sql.Timestamp;

import sig.icom.userservice.db.dao.Comment;
import sig.icom.userservice.db.dao.User;

public class CommentModel {
	private int id;
	private String email;
	private String content;
	private String name;
	private int point;
	private String time;
	private long numLike;
	private boolean userLike;
	
	
	public CommentModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommentModel(int id, String email, String content, String name,
			int point, Timestamp time, long numLike, boolean userLike) {
		super();
		this.id = id;
		this.email = email;
		this.content = content;
		this.name = name;
		this.point = point;
		try {
			this.time = time.toString();
		} catch (Exception e) {
			
		}
		this.numLike = numLike;
		this.userLike = userLike;
	}

	public void copyFrom(Comment comment, User user, int numLike, boolean userLike){
		id = comment.getId();
		email = comment.getEmail();
		content = comment.getContent();
		try {
			time = comment.getDateAdd().toString();
    	} catch (NullPointerException e) {
			// TODO: handle exception
		}
    	name = user.getName();
    	point = user.getPoint();
    	this.numLike = numLike;
    	this.userLike = userLike;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	public long getNumLike() {
		return numLike;
	}

	public void setNumLike(long numLike) {
		this.numLike = numLike;
	}

	public boolean isUserLike() {
		return userLike;
	}
	public void setUserLike(boolean userLike) {
		this.userLike = userLike;
	}
	
	
}

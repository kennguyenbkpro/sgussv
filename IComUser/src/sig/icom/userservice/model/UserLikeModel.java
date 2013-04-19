package sig.icom.userservice.model;

import java.sql.Timestamp;

import sig.icom.userservice.db.dao.PlaceLike;
import sig.icom.userservice.db.dao.User;

public class UserLikeModel {
	private String email;
	private String name;
	private String time;
	
	
	public UserLikeModel() {

	}

	public UserLikeModel(String email, String name, Timestamp time) {
		this.email = email;
		this.name = name;
		try {
			this.time = time.toString();
		} catch (Exception e) {
			
		}
	}

	public void copyFrom(PlaceLike placeLike, User user){
		email = user.getEmail();
		name = user.getName();
		try {
			time = placeLike.getDateAdd().toString();
    	} catch (NullPointerException e) {
			// TODO: handle exception
		}
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	
}

package sig.icom.userservice.model;

import sig.icom.userservice.db.dao.User;

public class UserModel {
	private String email;
	private String name;
	private long token;
	private boolean isLockOut;
	private int point;
	private short type;
	
	public void copyFrom(User user){
		email = user.getEmail();
		name = user.getName();
		token = user.getToken();
		isLockOut = user.getIsLockOut();
		point = user.getPoint();
		type = user.getType();
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
	public long getToken() {
		return token;
	}
	public void setToken(long token) {
		this.token = token;
	}
	public boolean isLockOut() {
		return isLockOut;
	}
	public void setLockOut(boolean isLockOut) {
		this.isLockOut = isLockOut;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}

	public short getType() {
		return type;
	}

	public void setType(short type) {
		this.type = type;
	}

	
}

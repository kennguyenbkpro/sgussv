package sig.icom.userservice.model;

import java.sql.Timestamp;

import sig.icom.userservice.db.dao.LogTopicSearch;

public class LogTopicSearchModel {
	private Integer id;
	private String classUri;
	private String userName;
	private String timeAdd;
	
	public void copy(LogTopicSearch logTopicSearch){
		classUri = logTopicSearch.getClassUri();
		id = logTopicSearch.getId();
		userName = logTopicSearch.getUserName();
		try {
			timeAdd = logTopicSearch.getTimeAdd().toString();
    	} catch (NullPointerException e) {
			// TODO: handle exception
		}
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getClassUri() {
		return classUri;
	}
	public void setClassUri(String classUri) {
		this.classUri = classUri;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTimeAdd() {
		return timeAdd;
	}
	public void setTimeAdd(String timeAdd) {
		this.timeAdd = timeAdd;
	}

	
}

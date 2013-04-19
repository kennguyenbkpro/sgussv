package sig.icom.userservice.model;

import java.sql.Timestamp;

import sig.icom.userservice.db.dao.LogMainService;

public class LogMainServiceModel {
	private Integer id;
	private String classUri;
	private Double geoLat;
	private Double geoLon;
	private Float radius;
	private String keyword;
	private Integer offset;
	private Integer maxResult;
	private String callTime;
	private String userName;
	
	public void copy(LogMainService logMainService){
		id = logMainService.getId();
		classUri = logMainService.getClassUri();
		geoLat  = logMainService.getGeoLat();
		geoLon = logMainService.getGeoLon();
		radius = logMainService.getRadius();
		keyword = logMainService.getKeyword();
		offset = logMainService.getOffset();
		maxResult = logMainService.getMaxResult();
		try {
			callTime = logMainService.getCallTime().toString();
    	} catch (NullPointerException e) {
			// TODO: handle exception
		}
		userName = logMainService.getUserName();
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
	public Double getGeoLat() {
		return geoLat;
	}
	public void setGeoLat(Double geoLat) {
		this.geoLat = geoLat;
	}
	public Double getGeoLon() {
		return geoLon;
	}
	public void setGeoLon(Double geoLon) {
		this.geoLon = geoLon;
	}
	public Float getRadius() {
		return radius;
	}
	public void setRadius(Float radius) {
		this.radius = radius;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public Integer getMaxResult() {
		return maxResult;
	}
	public void setMaxResult(Integer maxResult) {
		this.maxResult = maxResult;
	}
	public String getCallTime() {
		return callTime;
	}
	public void setCallTime(String callTime) {
		this.callTime = callTime;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}

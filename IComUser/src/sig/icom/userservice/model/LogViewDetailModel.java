package sig.icom.userservice.model;

import java.sql.Timestamp;

import sig.icom.userservice.db.dao.LogViewDetail;

public class LogViewDetailModel {
	private Integer id;
    private String placeUri;
    private String userName;
    private String viewDate;
    private Float distance;
    
    public void copy(LogViewDetail logViewDetail){
    	id = logViewDetail.getId();
    	placeUri = logViewDetail.getPlaceUri();
    	userName = logViewDetail.getUserName();
    	try {
    		viewDate = logViewDetail.getViewDate().toString();
    	} catch (NullPointerException e) {
			// TODO: handle exception
		}
    	distance = logViewDetail.getDistance();
    }
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPlaceUri() {
		return placeUri;
	}
	public void setPlaceUri(String placeUri) {
		this.placeUri = placeUri;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getViewDate() {
		return viewDate;
	}

	public void setViewDate(String viewDate) {
		this.viewDate = viewDate;
	}

	public Float getDistance() {
		return distance;
	}
	public void setDistance(Float distance) {
		this.distance = distance;
	}
    
}

package sig.icom.userservice.model;

import sig.icom.userservice.db.dao.PlaceUserStat;

public class PlaceStatModel {
	private Integer id;
	private String placeUri;
	private Integer resultNearby;
	private Integer resultSemantic;
	private Integer resultPreference;
	private String date;
	
	public void copy(PlaceUserStat placeUserStat){
		id = placeUserStat.getId();
		placeUri = placeUserStat.getPlaceUri();
		resultNearby = placeUserStat.getResultNearby();
		resultSemantic = placeUserStat.getResultSemantic();
		resultPreference = placeUserStat.getResultPreference();
		date = placeUserStat.getDate();
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
	public Integer getResultNearby() {
		return resultNearby;
	}
	public void setResultNearby(Integer resultNearby) {
		this.resultNearby = resultNearby;
	}
	public Integer getResultSemantic() {
		return resultSemantic;
	}
	public void setResultSemantic(Integer resultSemantic) {
		this.resultSemantic = resultSemantic;
	}
	public Integer getResultPreference() {
		return resultPreference;
	}
	public void setResultPreference(Integer resultPreference) {
		this.resultPreference = resultPreference;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}

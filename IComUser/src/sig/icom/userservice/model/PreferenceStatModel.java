package sig.icom.userservice.model;

import sig.icom.userservice.db.dao.PreferenceStat;

public class PreferenceStatModel {
	private Integer id;
	private String preferenceUri;
	private Integer count;
	private String month;
	public void copy(PreferenceStat preferenceStat){
		id = preferenceStat.getId();
		preferenceUri = preferenceStat.getPreferenceUri();
		count = preferenceStat.getCount();
		month = preferenceStat.getMonth();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPreferenceUri() {
		return preferenceUri;
	}
	public void setPreferenceUri(String preferenceUri) {
		this.preferenceUri = preferenceUri;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	
}

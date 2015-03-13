package webapp.model;

public class Forecast {
	 
	String	 low;
	String	 high; 
	String	 skycodeday; 
	String	 skytextday; 
	String	 date; 
	String	 day; 
	String	 shortday; 
	String	 precip;
	public String getLow() {
		return low;
	}
	public void setLow(String low) {
		this.low = low;
	}
	public String getHigh() {
		return high;
	}
	public void setHigh(String high) {
		this.high = high;
	}
	public String getSkycodeday() {
		return skycodeday;
	}
	public void setSkycodeday(String skycodeday) {
		this.skycodeday = skycodeday;
	}
	public String getSkytextday() {
		return skytextday;
	}
	public void setSkytextday(String skytextday) {
		this.skytextday = skytextday;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getShortday() {
		return shortday;
	}
	public void setShortday(String shortday) {
		this.shortday = shortday;
	}
	public String getPrecip() {
		return precip;
	}
	public void setPrecip(String precip) {
		this.precip = precip;
	}
}

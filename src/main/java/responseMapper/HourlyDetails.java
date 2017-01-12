package responseMapper;

public class HourlyDetails {
	String day;
	String hour;
	Double maxTemp;
	Double minTemp;
	public String getHour() {
		return hour;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
	public Double getMaxTemp() {
		return maxTemp;
	}
	public void setMaxTemp(Double maxTemp) {
		this.maxTemp = maxTemp;
	}
	public Double getMinTemp() {
		return minTemp;
	}
	public void setMinTemp(Double minTemp) {
		this.minTemp = minTemp;
	}
	public Double getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(Double windSpeed) {
		this.windSpeed = windSpeed;
	}
	public Double getPressure() {
		return pressure;
	}
	public void setPressure(Double pressure) {
		this.pressure = pressure;
	}
	public Double getRain() {
		return rain;
	}
	public void setRain(Double rain) {
		this.rain = rain;
	}
	Double windSpeed;
	Double pressure;
	Double rain;
	

}

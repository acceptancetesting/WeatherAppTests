package responseMapper;

public class SummaryDetails {		//Class for daily summary details
	String day;
	String date;
	String weather;
	Double maxTemp;
	Double minTemp;
	Double windSpeed;
	String windDirection;
	Double rain;
	Double pressure;
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
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
	public String getWindDirection() {
		return windDirection;
	}
	public void setWindDirection(String windDirection) {
		this.windDirection = windDirection;
	}
	public Double getRain() {
		return rain;
	}
	public void setRain(Double rain) {
		this.rain = rain;
	}
	public Double getPressure() {
		return pressure;
	}
	public void setPressure(Double pressure) {
		this.pressure = pressure;
	}
}

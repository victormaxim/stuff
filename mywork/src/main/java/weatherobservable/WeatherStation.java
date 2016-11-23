package weatherobservable;

public class WeatherStation {

	public static void main(String[] args) {
		SubjectWeatherData subjectWeatherData = new SubjectWeatherData();

		new ObserverTempHum(subjectWeatherData);
		new StatisticsDisplay(subjectWeatherData);
		new ObserverComparatii(subjectWeatherData);
		new HeatIndexDisplay(subjectWeatherData);
		new ObserverX(subjectWeatherData);

		subjectWeatherData.setMeasurements(80, 65, 30.4f);
		subjectWeatherData.setMeasurements(82, 70, 29.2f);
		subjectWeatherData.setMeasurements(78, 90, 29.2f);
	}
}

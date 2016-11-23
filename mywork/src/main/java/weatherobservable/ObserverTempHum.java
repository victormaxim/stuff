package weatherobservable;

import java.util.Observable;
import java.util.Observer;

public class ObserverTempHum implements Observer, DisplayElement {
	Observable observable;
	private float temperature;
	private float humidity;
	
	public ObserverTempHum(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}
	
	public void update(Observable obs, Object arg) {
		if (obs instanceof SubjectWeatherData) {
			SubjectWeatherData subjectWeatherData = (SubjectWeatherData)obs;
			this.temperature = subjectWeatherData.getTemperature();
			this.humidity = subjectWeatherData.getHumidity();
			display();
		}
	}
	
	public void display() {
		System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
	}
}

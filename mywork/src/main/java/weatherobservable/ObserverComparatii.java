package weatherobservable;

import java.util.Observable;
import java.util.Observer;

public class ObserverComparatii implements Observer, DisplayElement {
	private float currentPressure = 29.92f;  
	private float lastPressure;

	public ObserverComparatii(Observable observable) {
		observable.addObserver(this);
	}

	public void update(Observable o, Object arg) {
		if (o instanceof SubjectWeatherData) {
			SubjectWeatherData subjectWeatherData = (SubjectWeatherData)o;
			lastPressure = currentPressure;
			currentPressure = subjectWeatherData.getPressure();
			display();
		}
	}

	public void display() {
		System.out.print("Forecast: ");
		if (currentPressure > lastPressure) {
			System.out.println("Improving weather on the way!");
		} else if (currentPressure == lastPressure) {
			System.out.println("More of the same");
		} else if (currentPressure < lastPressure) {
			System.out.println("Watch out for cooler, rainy weather");
		}
	}
}

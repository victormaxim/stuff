package weatherobservable;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by user on 9/24/2016.
 */
public class ObserverX implements Observer, DisplayElement {
    private float currentPressure;
    public ObserverX(Observable o){o.addObserver(this);}

    public void update(Observable o, Object arg) {
        if (o instanceof SubjectWeatherData) {
            SubjectWeatherData x = (SubjectWeatherData)o;
            //lastPressure = currentPressure;
            currentPressure = x.getPressure();

            display();
        }
        //display();
        }




    public void display() {
        System.out.println("X!" + currentPressure + "<");
           }
}

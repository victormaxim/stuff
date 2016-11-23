package observer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WeatherStation {
    public static void main(String[] args) throws IOException {
        WeatherData weatherData = new WeatherData();
        String s = new String();

        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

        weatherData.setMeasurements(80, 70, 50.0f);
        weatherData.setMeasurements(10, 20, 30.0f);
        weatherData.setMeasurements(40, 50, 60.0f);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 2;
        boolean corect = true;
        System.out.println("new data? temperature, humidity, pressure");
        s = br.readLine();
        count = s.split(", ", -1).length - 1;
        corect = count == 2;
        System.out.println(count);

        while (corect) {

            String values[] = s.split(", ");
            //float flo = Float.parseFloat(values[0]);
            weatherData.setMeasurements(Float.parseFloat(values[0]), Float.parseFloat(values[1]), Float.parseFloat(values[2]));
            //System.out.println(Float.parseFloat(values[0]) + 5);
            System.out.println("new data? ");
            s = br.readLine();
            count = s.split(", ", -1).length - 1;
            corect = count == 2;
            System.out.println(count);

        }
    }

}

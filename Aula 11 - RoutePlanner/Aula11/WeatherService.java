package Aula11;

import java.util.ArrayList;
import java.util.List;

public class WeatherService {
    private List<WeatherObserver> observers = new ArrayList<>();

    public void addObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers(String newCondition) {
        for (WeatherObserver observer : observers) {
            observer.onWeatherUpdate(newCondition);
        }
    }

    public void updateWeather(String newCondition) {
        System.out.println("Clima atualizado: " + newCondition);
        notifyObservers(newCondition);
    }
}

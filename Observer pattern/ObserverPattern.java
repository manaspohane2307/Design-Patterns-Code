import java.util.ArrayList;
import java.util.List;

// Observer Interface
interface Observer {//conatins update method
    void update(String weather);
}

// Subject Interface
interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// ConcreteSubject Class
class WeatherStation implements Subject {
    private List<Observer> observers = new ArrayList<>();//list of observers
    private String weather;

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {//notify each observer from list
        for (Observer observer : observers) {
            observer.update(weather);
        }
    }

    public void setWeather(String newWeather) {//update string to latest weather and call notify 
        this.weather = newWeather;
        notifyObservers();
    }
}

// ConcreteObserver Class
class PhoneDisplay implements Observer {
    private String weather;//store latest weather

    @Override
    public void update(String weather) {
        this.weather = weather;
        display();
    }

    private void display() {
        System.out.println("Phone Display: Weather updated - " + weather);
    }
}

// ConcreteObserver Class
class TVDisplay implements Observer {
    private String weather;

    @Override
    public void update(String weather) {
        this.weather = weather;
        display();
    }

    private void display() {
        System.out.println("TV Display: Weather updated - " + weather);
    }
}

// Usage Class
public class ObserverPattern {
    public static void main(String[] args) {
        //create concrete subject
        WeatherStation weatherStation = new WeatherStation();

        //create concrete observers
        Observer phoneDisplay = new PhoneDisplay();
        Observer tvDisplay = new TVDisplay();

        weatherStation.addObserver(phoneDisplay);
        weatherStation.addObserver(tvDisplay);

        // Simulating weather change
        weatherStation.setWeather("Sunny");

        // Output:
        // Phone Display: Weather updated - Sunny
        // TV Display: Weather updated - Sunny
    }
}
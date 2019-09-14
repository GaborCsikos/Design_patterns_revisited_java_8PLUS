package week4.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

//handles subscription
public class Subject {


    private final List<Observer> observers = new ArrayList<>();

    //Logic
    public void land(final String name) {
        for (final Observer observer : this.observers) {
            observer.observeLanding(name);
        }
    }

    //Subscribe
    public void startSpying(final Observer observer) {
        this.observers.add(observer);
    }
}

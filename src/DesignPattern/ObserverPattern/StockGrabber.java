package DesignPattern.ObserverPattern;

import java.util.ArrayList;

/**
 * Created by piyush.bajaj on 12/02/17.
 */
public class StockGrabber implements Subject {

    //Create Arrays for Observers

    private ArrayList<Observer> observers;
    private double ibmPrice;
    private double applPrice;
    private double googPrice;

    public StockGrabber() {
        observers = new ArrayList<Observer>();
    }

    @Override
    public void register(Observer newObserver) {
        observers.add(newObserver);
    }

    @Override
    public void unregister(Observer deleteObserver) {
        int observerIndex = observers.indexOf(deleteObserver);

        System.out.println("Observer " + (observerIndex + 1) + " deleted");

        observers.remove(observerIndex);
    }

    @Override
    public void notifyObserver() {

        for (Observer observer : observers) {
            observer.update(ibmPrice, applPrice, googPrice);
        }

    }

    public void setIbmPrice(double newIBMPrice) {
        this.ibmPrice = newIBMPrice;
        notifyObserver();
    }

    public void setApplPrice(double newApplPrice) {
        this.applPrice = newApplPrice;
        notifyObserver();
    }

    public void setGoogPrice(double newGoogPrice) {
        this.googPrice = newGoogPrice;
        notifyObserver();
    }
}

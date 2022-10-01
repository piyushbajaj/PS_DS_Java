package designPattern.ObserverPattern.SOES;

import java.util.ArrayList;

/**
 * Created by piyush.bajaj on 12/02/17.
 */
public class StockGrabber implements Subject {

    private ArrayList<Observer> stock_id;

    private int leftQuantity;

    private String status;

    public StockGrabber(){
        stock_id = new ArrayList<Observer>();
    }

    @Override
    public void register(Observer newObserver) {
        stock_id.add(newObserver);
    }

    @Override
    public void unregister(Observer o) {

    }

    @Override
    public void notifyObserver() {
        for(Observer observer: stock_id)
            observer.update(leftQuantity, status);
    }

    public void setLeftQuantity(int newLeftQuantity){
        this.leftQuantity = newLeftQuantity;
        notifyObserver();
    }

    public void setStatus(String newStatus){
        this.status = newStatus;
        notifyObserver();
    }
}

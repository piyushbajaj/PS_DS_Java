package designPattern.ObserverPattern;


/**
 * Created by piyush.bajaj on 12/02/17.
 */
public interface Subject {
    public void register(Observer o);
    public void unregister(Observer o);
    public void notifyObserver();
}

package LLD.Concept_And_Coding.L3_Observer_Pattern.Observable;

import LLD.Concept_And_Coding.L3_Observer_Pattern.Observer.NotificationAlertObserver;

/**
 * Project: DS_Algo
 * Package: LLD.Concept_And_Coding.L3_Observer_Pattern.Observable
 * <p>
 * User: piyushbajaj
 * Date: 16/01/23
 * Time: 1:13 pm
 */
public interface StocksObservable {
    public void add(NotificationAlertObserver observer);

    public void remove(NotificationAlertObserver observer);

    public void notifySubscribers();

    public int getStockCount();

    public void setStockCount(int newStockAdded);
}

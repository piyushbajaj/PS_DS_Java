package LLD.Concept_And_Coding.L3_Observer_Pattern.Observable;

import java.util.ArrayList;
import java.util.List;

import LLD.Concept_And_Coding.L3_Observer_Pattern.Observer.NotificationAlertObserver;

/**
 * Project: DS_Algo
 * Package: LLD.Concept_And_Coding.L3_Observer_Pattern.Observable
 * <p>
 * User: piyushbajaj
 * Date: 16/01/23
 * Time: 1:19 pm
 */
public class IphoneObservableImpl implements StocksObservable {

    public List<NotificationAlertObserver> notificationAlertObserverList = new ArrayList<>();
    public int stockCount = 0;

    @Override
    public void add(NotificationAlertObserver observer) {
        notificationAlertObserverList.add(observer);
    }

    @Override
    public void remove(NotificationAlertObserver observer) {
        notificationAlertObserverList.remove(observer);
    }

    @Override
    public void notifySubscribers() {
        for (NotificationAlertObserver observer : notificationAlertObserverList) {
            observer.update();
        }
    }

    @Override
    public int getStockCount() {
        return stockCount;
    }

    @Override
    public void setStockCount(int newStockAdded) {
        if (newStockAdded > 0 && stockCount == 0) {
            notifySubscribers();
        }

        stockCount = getStockCount() + newStockAdded;
    }
}

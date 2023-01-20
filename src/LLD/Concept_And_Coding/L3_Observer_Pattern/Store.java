package LLD.Concept_And_Coding.L3_Observer_Pattern;

import LLD.Concept_And_Coding.L3_Observer_Pattern.Observable.IphoneObservableImpl;
import LLD.Concept_And_Coding.L3_Observer_Pattern.Observable.StocksObservable;
import LLD.Concept_And_Coding.L3_Observer_Pattern.Observer.EmailAlertObserverImpl;
import LLD.Concept_And_Coding.L3_Observer_Pattern.Observer.MobileAlertObserverImpl;
import LLD.Concept_And_Coding.L3_Observer_Pattern.Observer.NotificationAlertObserver;

/**
 * Project: DS_Algo
 * Package: LLD.Concept_And_Coding.L3_Observer_Pattern
 * <p>
 * User: piyushbajaj
 * Date: 16/01/23
 * Time: 1:12 pm
 */
public class Store {
    public static void main(String[] args) {
        StocksObservable iphoneStockObservable = new IphoneObservableImpl();

        NotificationAlertObserver observer1 = new EmailAlertObserverImpl("xyz1@gmail.com", iphoneStockObservable);
        NotificationAlertObserver observer2 = new EmailAlertObserverImpl("xyz2@gmail.com", iphoneStockObservable);
        NotificationAlertObserver observer3 = new MobileAlertObserverImpl("xyz1@gmail.com", iphoneStockObservable);

        iphoneStockObservable.add(observer1);
        iphoneStockObservable.add(observer2);
        iphoneStockObservable.add(observer3);

        iphoneStockObservable.setStockCount(10);
        iphoneStockObservable.setStockCount(0);
        iphoneStockObservable.setStockCount(10);
    }
}

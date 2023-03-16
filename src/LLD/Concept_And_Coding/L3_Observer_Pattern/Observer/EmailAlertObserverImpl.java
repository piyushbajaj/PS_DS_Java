package LLD.Concept_And_Coding.L3_Observer_Pattern.Observer;

import LLD.Concept_And_Coding.L3_Observer_Pattern.Observable.StocksObservable;

/**
 * Project: DS_Algo
 * Package: LLD.Concept_And_Coding.L3_Observer_Pattern.Observer
 * <p>
 * User: piyushbajaj
 * Date: 16/01/23
 * Time: 1:16 pm
 */
public class EmailAlertObserverImpl implements NotificationAlertObserver {

    String emailId;
    StocksObservable observable;

    public EmailAlertObserverImpl(String emailId, StocksObservable observable) {
        this.emailId = emailId;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendEmail(this.emailId, "Product is in the stock, hurry up!");
    }

    public void sendEmail(String emailId, String msg) {
        System.out.println(msg);
        System.out.println("Mail sent to: " + emailId);
    }
}

package LLD.Educative.PubSub;

import LLD.Educative.PubSub.model.Message;
import LLD.Educative.PubSub.public_interface.ISubscriber;

/**
 * Project: DS_Algo
 * Package: LLD.PubSub
 * <p>
 * User: piyushbajaj
 * Date: 02/03/23
 * Time: 11:32 pm
 */
public class SleepingSubscriber implements ISubscriber {
    private final String id;
    private final int sleepTimeInMillis;

    public SleepingSubscriber(String id, int sleepTimeInMillis) {
        this.id = id;
        this.sleepTimeInMillis = sleepTimeInMillis;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void consume(Message message) throws InterruptedException {
        System.out.println("Subscriber: " + id + " started consuming: " + message.getMsg());
        Thread.sleep(sleepTimeInMillis);
        System.out.println("Subscriber: " + id + " done consuming: " + message.getMsg());
    }
}

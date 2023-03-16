package LLD.Educative.PubSub;

import LLD.Educative.PubSub.model.Message;
import LLD.Educative.PubSub.model.Topic;
import LLD.Educative.PubSub.public_interface.Queue;

/**
 * Project: DS_Algo
 * Package: LLD.PubSub
 * <p>
 * User: piyushbajaj
 * Date: 02/03/23
 * Time: 11:32 pm
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        final Queue queue = new Queue();
        final Topic topic1 = queue.createTopic("t1");
        final Topic topic2 = queue.createTopic("t2");
        final SleepingSubscriber sub1 = new SleepingSubscriber("sub1", 10000);
        final SleepingSubscriber sub2 = new SleepingSubscriber("sub2", 10000);
        queue.subscribe(sub1, topic1);
        queue.subscribe(sub2, topic1);

        final SleepingSubscriber sub3 = new SleepingSubscriber("sub3", 5000);
        queue.subscribe(sub3, topic2);


        // For single subscriber, messages will be processed sequentially. While for multiple subscribers, they will
        // process the same message parallelly
        queue.publish(topic1, new Message("m1")); // sub1 and sub2 should get it
        queue.publish(topic1, new Message("m2")); // sub1 and sub2 should get it

        queue.publish(topic2, new Message("m3")); // sub3 should get it

        Thread.sleep(15000);
        queue.publish(topic2, new Message("m4")); // sub3 should get it
        queue.publish(topic1, new Message("m5")); // sub1 and sub2 should get it

        queue.resetOffset(topic1, sub1, 0);
    }
}

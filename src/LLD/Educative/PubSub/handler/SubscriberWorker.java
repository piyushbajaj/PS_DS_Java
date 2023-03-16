package LLD.Educative.PubSub.handler;

import LLD.Educative.PubSub.model.Message;
import LLD.Educative.PubSub.model.Topic;
import LLD.Educative.PubSub.model.TopicSubscriber;
import lombok.NonNull;
import lombok.SneakyThrows;

/**
 * Project: DS_Algo
 * Package: LLD.PubSub.handler
 * <p>
 * User: piyushbajaj
 * Date: 02/03/23
 * Time: 7:28 pm
 */
public class SubscriberWorker implements Runnable {

    private final Topic topic;
    private final TopicSubscriber topicSubscriber;

    public SubscriberWorker(@NonNull final Topic topic, @NonNull final TopicSubscriber topicSubscriber) {
        this.topic = topic;
        this.topicSubscriber = topicSubscriber;
    }

    @SneakyThrows
    @Override
    public void run() {
        synchronized (topicSubscriber) {
            do {
                int currOffset = topicSubscriber.getOffset().get();
                while (currOffset >= topic.getMessages().size()) {
                    topicSubscriber.wait();
                }
                Message message = topic.getMessages().get(currOffset);
                topicSubscriber.getSubscriber().consume(message);

                // We cannot just increment the offset here since subscriber offset can be reset while it is
                // consuming. So, after consuming we need to increase only if it was previous one.
                topicSubscriber.getOffset().compareAndSet(currOffset, currOffset + 1);
            } while (true);
        }
    }

    /**
     * One worker is there
     */
    public synchronized void wakeUpIfNeeded() {
        synchronized (topicSubscriber) {
            topicSubscriber.notify();
        }
    }
}

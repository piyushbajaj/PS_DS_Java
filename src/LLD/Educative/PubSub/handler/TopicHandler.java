package LLD.Educative.PubSub.handler;

import java.util.HashMap;
import java.util.Map;

import LLD.Educative.PubSub.model.Topic;
import LLD.Educative.PubSub.model.TopicSubscriber;
import lombok.NonNull;

/**
 * Project: DS_Algo
 * Package: LLD.PubSub.handler
 * <p>
 * User: piyushbajaj
 * Date: 02/03/23
 * Time: 7:27 pm
 */
public class TopicHandler {
    private final Topic topic;
    private final Map<String, SubscriberWorker> subscriberWorkers;

    public TopicHandler(Topic topic) {
        this.topic = topic;
        this.subscriberWorkers = new HashMap<>();
    }

    public void publish() {
        for (TopicSubscriber topicSubscriber : topic.getSubscribers()) {
            startSubscriberWorker(topicSubscriber);
        }
    }

    /**
     * Start the worker for the subscriber
     * Each worker is there for one subscriber. So when the message
     *
     * @param topicSubscriber
     */
    public void startSubscriberWorker(@NonNull final TopicSubscriber topicSubscriber) {
        final String subscriberId = topicSubscriber.getSubscriber().getId();
        if (!subscriberWorkers.containsKey(subscriberId)) {
            final SubscriberWorker subscriberWorker = new SubscriberWorker(topic, topicSubscriber);
            subscriberWorkers.put(subscriberId, subscriberWorker);
            new Thread(subscriberWorker).start();
        }
        final SubscriberWorker subscriberWorker = subscriberWorkers.get(subscriberId);
        subscriberWorker.wakeUpIfNeeded();
    }


}

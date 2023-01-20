package MachineCodingPubSub.Handlers;

import java.util.HashMap;
import java.util.Map;

import MachineCodingPubSub.Model.Topic;
import MachineCodingPubSub.Model.TopicSubscriber;

/**
 * Project: DS_Algo
 * Package: MachineCodingPubSub.Handlers
 * <p>
 * User: piyushbajaj
 * Date: 20/01/23
 * Time: 5:01 pm
 */
public class TopicHandler {
    private Topic topic;
    private Map<String, SubscriberWorker> topicSubscriberMap;

    public TopicHandler(Topic topic) {
        this.topic = topic;
        topicSubscriberMap = new HashMap<>();
    }

    public void publish() {
        for (TopicSubscriber topicSubscriber: topic.getSubscriberList()) {
            startPublishing(topicSubscriber);
        }
    }

    public void startPublishing(TopicSubscriber topicSubscriber) {

    }
}

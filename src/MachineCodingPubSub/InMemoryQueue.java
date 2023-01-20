package MachineCodingPubSub;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import MachineCodingPubSub.Handlers.TopicHandler;
import MachineCodingPubSub.Model.Message;
import MachineCodingPubSub.Model.Topic;

/**
 * Project: DS_Algo
 * Package: MachineCodingPubSub
 * <p>
 * User: piyushbajaj
 * Date: 20/01/23
 * Time: 5:00 pm
 */
public class InMemoryQueue {

    // key: TopicId, TopicHandler
    private final Map<String, TopicHandler> topicHandlerMap;

    public InMemoryQueue() {
        topicHandlerMap = new HashMap<>();
    }

    public Topic createTopic(String topicName) {
        Topic topic = new Topic(topicName, UUID.randomUUID().toString());
        TopicHandler topicHandler = new TopicHandler(topic);
        topicHandlerMap.put(topic.getTopicId(), topicHandler);
        return topic;
    }

    public void publish(Topic topic, Message message) {
        topic.pushMessage(message);
        topicHandlerMap.get(topic.getTopicId()).publish();
    }


}

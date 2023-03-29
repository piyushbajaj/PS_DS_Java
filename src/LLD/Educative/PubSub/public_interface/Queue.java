package LLD.Educative.PubSub.public_interface;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import LLD.Educative.PubSub.handler.TopicHandler;
import LLD.Educative.PubSub.model.Message;
import LLD.Educative.PubSub.model.Topic;
import LLD.Educative.PubSub.model.TopicSubscriber;
import lombok.NonNull;

/**
 * Project: DS_Algo
 * Package: LLD.PubSub
 * <p>
 * User: piyushbajaj
 * Date: 02/03/23
 * Time: 3:59 pm
 */
public class Queue {
    // TopicId, TopicHandler
    public static Map<String, TopicHandler> topicProcessors;

    public Queue() {
        this.topicProcessors = new HashMap<>();
    }

    public Topic createTopic(@NonNull final String topicName) {
        final Topic topic = new Topic(topicName, UUID.randomUUID().toString());
        TopicHandler topicHandler = new TopicHandler(topic);
        topicProcessors.put(topic.getTopicId(), topicHandler);
        System.out.println("Created topic: " + topic.getTopicName());
        return topic;
    }

    public void subscribe(@NonNull final ISubscriber subscriber, @NonNull final Topic topic) {
        topic.addSubscriber(new TopicSubscriber(subscriber));
        System.out.println(subscriber.getId() + " subscribed to topic: " + topic.getTopicName());
    }

    /**
     * Two task for the publish method-
     * 1. Add the message to the topic
     * 2. Once the message is added to the topic, then fanout message to all the subscribers
     *
     * @param topic
     * @param message
     */
    public void publish(@NonNull final Topic topic, @NonNull final Message message) {
        topic.addMessage(message);
        System.out.println(message.getMsg() + " published to topic: " + topic.getTopicName());
        new Thread(() -> topicProcessors.get(topic.getTopicId()).publish()).start();
    }

    public void resetOffset(@NonNull final Topic topic, @NonNull final ISubscriber subscriber,
                            @NonNull final Integer newOffset) {
        for (TopicSubscriber topicSubscriber : topic.getSubscribers()) {
            if (topicSubscriber.getSubscriber().equals(subscriber)) {
                topicSubscriber.getOffset().set(newOffset);
                System.out.println(topicSubscriber.getSubscriber().getId() + " offset reset to: " + newOffset);
                new Thread(
                    () -> topicProcessors.get(topic.getTopicId()).startSubscriberWorker(topicSubscriber)).start();
                break;
            }
        }
    }
}

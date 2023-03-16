package LLD.Educative.PubSub.model;


import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NonNull;

/**
 * Project: DS_Algo
 * Package: LLD.PubSub
 * <p>
 * User: piyushbajaj
 * Date: 02/03/23
 * Time: 3:52 pm
 */
@Getter
public class Topic {
    private final String topicName;
    private final String topicId;
    // Change getter this to send only immutable list outside, right now it can be changed from outside
    private final List<Message> messages;

    // Change getter this to send only immutable list outside, right now it can be changed from outside
    private final List<TopicSubscriber> subscribers;


    public Topic(String topicName, String topicId) {
        this.topicName = topicName;
        this.topicId = topicId;
        this.messages = new ArrayList<>();
        this.subscribers = new ArrayList<>();
    }

    public synchronized void addMessage(@NonNull final Message message) {
        messages.add(message);
    }

    public void addSubscriber(@NonNull final TopicSubscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(@NonNull final TopicSubscriber subscriber) {
        subscribers.remove(subscriber);
    }

}

package MachineCodingPubSub.Model;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * Project: DS_Algo
 * Package: MachineCodingPubSub.Model
 * <p>
 * User: piyushbajaj
 * Date: 20/01/23
 * Time: 4:50 pm
 */

@Getter
@Setter
public class Topic {
    private final String topicName;
    private final String topicId;
    private final List<Message> messageList;
    private final List<TopicSubscriber> subscriberList;


    public Topic(String topicName, String topicId) {
        this.topicName = topicName;
        this.topicId = topicId;
        this.messageList = new ArrayList<>();
        this.subscriberList = new ArrayList<>();
    }

    public void pushMessage(Message message) {
        messageList.add(message);
    }

    public void addSubscriber(TopicSubscriber topicSubscriber) {

        subscriberList.add(topicSubscriber);
    }
}

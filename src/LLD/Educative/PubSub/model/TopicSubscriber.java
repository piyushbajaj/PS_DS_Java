package LLD.Educative.PubSub.model;

/**
 * Project: DS_Algo
 * Package: LLD.PubSub
 * <p>
 * User: piyushbajaj
 * Date: 02/03/23
 * Time: 3:54 pm
 */

import java.util.concurrent.atomic.AtomicInteger;

import LLD.Educative.PubSub.public_interface.ISubscriber;
import lombok.Getter;
import lombok.NonNull;

/**
 * Each subscriber will have a offset in a particular topic
 */
@Getter
public class TopicSubscriber {
    //AtomicInteger: Handles multi-threading cases
    private final AtomicInteger offset;
    private final ISubscriber subscriber;

    public TopicSubscriber(@NonNull final ISubscriber subscriber) {
        this.subscriber = subscriber;
        this.offset = new AtomicInteger(0);
    }
}

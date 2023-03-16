package LLD.Educative.PubSub.public_interface;

import LLD.Educative.PubSub.model.Message;

/**
 * Project: DS_Algo
 * Package: LLD.PubSub.public_interface
 * <p>
 * User: piyushbajaj
 * Date: 02/03/23
 * Time: 7:29 pm
 */
public interface ISubscriber {
    String getId();

    void consume(Message message) throws InterruptedException;
}

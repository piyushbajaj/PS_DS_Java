package LLD.UditTutorial.LRU_Cache.algorithms;

import lombok.Getter;

/**
 * Project: DS_Algo
 * Package: LLD.UditTutorial.LRU_Cache.algorithms
 * <p>
 * User: piyushbajaj
 * Date: 13/03/23
 * Time: 2:29 pm
 */
@Getter
public class DoublyLinkedListNode<E> {
    DoublyLinkedListNode<E> next;
    DoublyLinkedListNode<E> prev;
    E element;

    public DoublyLinkedListNode(E element) {
        this.element = element;
        this.next = this.prev = null;
    }
}

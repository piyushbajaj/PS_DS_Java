package LLD.Mikhail.LRUCache;

import java.util.HashMap;
import java.util.Map;

/**
 * Project: DS_Algo
 * Package: LLD.Mikhail
 * <p>
 * User: piyushbajaj
 * Date: 15/03/23
 * Time: 4:29 pm
 *
 * ref: <a href="https://www.youtube.com/watch?v=iuqZvajTOyA&list=PL0evysyBWYO4n2wkp1UgqpUfSsXnu5EMf&index=5&ab_channel=SystemDesignInterview">...</a>
 */
public class LRUCache extends DoublyLinkedList {

    private final Map<Integer, Node> map;
    private final int capacity;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            System.out.printf("No element with key %d \n", key);
            return -1;
        }

        Node node = map.get(key);
        remove(node);
        insert(node);

        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            remove(node);
            insert(node);
        } else {
            if (map.size() >= capacity) {
                map.remove(tail.key);
                remove(tail);
            }

            Node node = new Node(key, value);

            map.put(key, node);
            insert(node);
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1, 10);
        lruCache.printDLL();
        lruCache.put(2, 10);
        lruCache.printDLL();
        lruCache.put(3, 10);
        lruCache.printDLL();
        lruCache.put(2, 11);
        lruCache.printDLL();
        lruCache.put(5, 10);
        lruCache.printDLL();
        System.out.println(lruCache.get(2));
        lruCache.printDLL();
        System.out.println(lruCache.get(3));
        lruCache.printDLL();

        System.out.println(lruCache.get(6));
    }
}

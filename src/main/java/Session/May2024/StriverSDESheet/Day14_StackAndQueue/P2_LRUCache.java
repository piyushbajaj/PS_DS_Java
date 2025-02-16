package Session.May2024.StriverSDESheet.Day14_StackAndQueue;

import java.util.HashMap;
import java.util.Map;

/**
 * Project: DSAlgo
 * Package: PracticeSessionMay2024.StriverSDESheet.Day14_StackAndQueue
 * <p>
 * User: piyushbajaj
 * Date: 21/07/24
 * Time: 4:39 pm
 * <p>
 * TC: O(N)
 * SC: O(N) -> DLL O(N) + HashMap O(N)
 */
public class P2_LRUCache {

    static class DLLNode {
        int key, value;
        DLLNode prev, next;

        public DLLNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    DLLNode head;
    DLLNode tail;
    Map<Integer, DLLNode> hashMap;
    final int capacity;

    public P2_LRUCache(int cap) {
        head = new DLLNode(0, 0);
        tail = new DLLNode(0, 0);
        hashMap = new HashMap<>();
        capacity = cap;
        head.next = tail;
        tail.prev = head;
    }

    /**
     * TC: O(1)
     *
     * @param key
     * @return
     */
    public int get(int key) {
        if (!hashMap.containsKey(key)) {
            return -1;
        }

        DLLNode curr = hashMap.get(key);
        removeFromDLLMap(curr);
        insertNodeDLLMap(curr);

        return curr.value;
    }

    /**
     * Remove element from the HashMap and DLL
     * TC: O(1)
     * SC: O(1)
     *
     * @param node
     */
    private void removeFromDLLMap(DLLNode node) {
        hashMap.remove(node.key);
        // remove from the tail previous
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertNodeDLLMap(DLLNode node) {
        hashMap.put(node.key, node);
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public void put(int key, int value) {
        if (hashMap.containsKey(key)) {
            DLLNode currNode = hashMap.get(key);

            // Bring this node upfront
            removeFromDLLMap(currNode);
        } else {
            if (hashMap.size() == capacity) {
                removeFromDLLMap(tail.prev);
            }
        }
        insertNodeDLLMap(new DLLNode(key, value));
    }

    private void printHashMap() {
        System.out.println("HashMap => ");
        hashMap.forEach((key, value) -> System.out.println(key + ", " + value.value));
    }

    private void printDLL() {
        DLLNode temp = head;
        System.out.println("Doubly Linked List => ");
        while (temp != null) {
            System.out.print("(" + temp.key + ", " + temp.value + ") -> ");
            temp = temp.next;
        }

        System.out.print("NULL");
    }

    public static void main(String[] args) {
        P2_LRUCache p2LruCache = new P2_LRUCache(4);
        p2LruCache.put(1, 100);
        p2LruCache.put(2, 200);
        p2LruCache.put(3, 300);
        p2LruCache.put(4, 400);

        p2LruCache.printHashMap();
        p2LruCache.printDLL();

        System.out.println("Get the element " + p2LruCache.get(1));

        p2LruCache.printHashMap();
        p2LruCache.printDLL();

        p2LruCache.put(5, 500);

        p2LruCache.printHashMap();
        p2LruCache.printDLL();
    }
}

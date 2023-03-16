package LLD.Mikhail.LRUCache;

/**
 * Project: DS_Algo
 * Package: LLD.MIkhail.LRUCache
 * <p>
 * User: piyushbajaj
 * Date: 15/03/23
 * Time: 5:31 pm
 */
public class DoublyLinkedList {

    Node head, tail;

    static class Node {
        final int key;
        int value;

        Node next, prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = this.prev = null;
        }
    }

    public void insert(Node node) {
        node.next = head;
        node.prev = null;

        if (head != null) {
            head.prev = node;
        }
        // Updating tail
        if (tail == null) {
            tail = node;
        }

        head = node;
    }

    // Removing element
    public void remove(Node delNode) {
        // Base case
        if (head == null || delNode == null) {
            return;
        }

        // If node to be deleted is head node
        if (head == delNode) {
            head = delNode.next;
        }

        if (tail == delNode) {
            tail.prev.next = null;
            tail = delNode.prev;
        }

        // Change next only if node to be deleted
        // is NOT the last node
        if (delNode.next != null) {
            delNode.next.prev = delNode.prev;
        }

        // Change prev only if node to be deleted
        // is NOT the first node
        if (delNode.prev != null) {
            delNode.prev.next = delNode.next;
        }
    }

    public void printDLL() {
        Node temp = head;
        while (temp != null) {
            System.out.print("[Key: " + temp.key + " Value: " + temp.value + "] -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

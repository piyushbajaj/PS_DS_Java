package LinkedList.Practice_2022.SinglyLL;

/**
 *
 */
public class BaseNode {
    Node head;

    static class Node {
        Node next;
        int data;

        Node() {
        }

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}

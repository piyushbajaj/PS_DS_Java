package LinkedList.Practice_2022.DoublyLL;

/**
 * Created by bajajp on 21 May, 2022
 */
public class BaseDLLNode {
    Node head;

    static class Node {
        Node next, prev;
        int data;

        Node(int data) {
            this.next = this.prev = null;
            this.data = data;
        }
    }
}

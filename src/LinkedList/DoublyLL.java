package LinkedList;

/**
 * Created by piyush.bajaj on 07/01/18.
 */


public class DoublyLL {

    static class Node {
        int data;
        Node next;
        Node prev;
    }

    static Node SortedInsert(Node head, int data) {
        Node temp = new Node();
        temp.data = data;
        if (head == null) {
            head = temp;
            return head;
        }

        Node p = head;

        while (p.next != null) {
            if (data < head.data) {
                temp.next = head;
                head.prev = temp;
                head = temp;
                return head;
            } else if (data > p.data && data < p.next.data) {
                Node q = p.next;
                p.next = temp;
                temp.prev = p;
                temp.next = q;
                q.prev = temp;
                return head;
            }

        }

        if (p.next == null) {
            p.next = temp;
            temp.prev = p;
            return head;
        }

        return head;
    }

    public static void main(String[] args) {
        DoublyLL ll = new DoublyLL();
        //SortedInsert(ll)

    }
}

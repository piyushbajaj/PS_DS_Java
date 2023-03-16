package TechBoost_Old;

/**
 * Created by piyush.bajaj on 26/03/18.
 */
public class DoublyLinkedList_Prob<Key> {
    Node head;

    static class Node {
        Node next;
        Node prev;
        int data;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public void createDoublyLinkList(int x) {
        Node p = new Node(x);
        if (head == null) {
            head = p;
            return;
        }

        Node curr = head;
        Node q = null;
        while (curr.next != null) {
            q = curr;
            curr = curr.next;
            curr.prev = q;
        }

        curr.next = p;
        p.prev = curr;

    }

    public void printList(Node p) {
        Node q = null;
        while (p != null) {
            System.out.print(p.data + " -> ");
            p = p.next;
            if (p != null && p.next == null) {
                q = p;
            }
        }
        System.out.print(" NULL");
        System.out.println();

        System.out.print("Doubly Linked List in reversed order using previous pointers: ");
        while (q != null) {
            System.out.print(q.data + " -> ");
            q = q.prev;
        }
        System.out.print(" NULL");
        System.out.println();
    }

    public Node reverse_doublyLinkedList(Node key) {
        Node curr = key;

        while (curr != null) {
            Node temp = curr.next;
            curr.next = curr.prev;
            curr.prev = temp;

            if (curr.prev == null) {
                head = curr;
            }
            curr = curr.prev;
        }
        return head;
    }

    public static void main(String[] args) {
        DoublyLinkedList_Prob ll = new DoublyLinkedList_Prob();
        ll.createDoublyLinkList(1);
        ll.createDoublyLinkList(2);
        ll.createDoublyLinkList(3);
        ll.createDoublyLinkList(4);
        ll.createDoublyLinkList(5);

        ll.printList(ll.head);

        System.out.println("After reversing Doubly Linked List: ");
        ll.reverse_doublyLinkedList(ll.head);
        ll.printList(ll.head);
    }
}

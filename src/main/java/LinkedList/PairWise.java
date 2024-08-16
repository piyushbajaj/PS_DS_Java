package LinkedList;

/**
 * Created by piyush.bajaj on 11/10/16.
 */
public class PairWise {
    Node head; //head of the list

    public static void main(String[] args) {
        PairWise list = new PairWise();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);
        System.out.println("Original Linked List is: ");
        list.printList(list.head);
        System.out.println("\n");
        list.pairWiseSwap();
        list.printList(list.head);
    }

    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    void pairWiseSwap() {
        Node Nd = head;
        int temp = 0;
        while (Nd != null && Nd.next != null) {
            temp = Nd.data;
            Nd.data = Nd.next.data;
            Nd.next.data = temp;
            Nd = Nd.next.next;
        }
    }

    /* Linked List LinkedList.Node*/
    static class Node {
        int data;
        Node next;

        //Constructor to create a new node
        //Next is by default initialized as null

        Node(int d) {
            data = d;
            next = null;
        }
    }
}

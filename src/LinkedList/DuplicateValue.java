package LinkedList;

/**
 * Created by piyush.bajaj on 06/10/16.
 */
public class DuplicateValue {
    Node head; //head of the list

    public static void main(String[] args) {
        DuplicateValue llist = new DuplicateValue();
        llist.head = new Node(1);
        llist.head.next = new Node(2);
        llist.head.next.next = new Node(3);
        llist.head.next.next.next = new Node(4);
        llist.printList();
        System.out.println("\n");
        //System.out.println(llist.search(0));
        //System.out.println(llist.search_recursive(llist.head, 1));
        //llist.returnNthNode(3);
    }

    public void printList() {
        Node n = head;
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
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

package LinkedList;

/**
 * Created by piyush.bajaj on 15/10/16.
 */
public class DeleteAlertnateNode {
    Node head; //head of the list
    Node head1;
    Node head2;

    public static void main(String[] args) {
        DeleteAlertnateNode llist = new DeleteAlertnateNode();
        llist.head = new Node(1);
        llist.head.next = new Node(2);
        llist.head.next.next = new Node(3);
        llist.head.next.next.next = new Node(4);
        //llist.head.next.next.next.next = new LinkedList.Node(5);
        llist.printList();
        System.out.println("\n");

        llist.splitAlternateNode();
        //llist.deleteAlternateNode();
        //llist.printList();
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

    public void deleteAlternateNode() {
        Node Nd = head;
        Node temp;

        while (Nd.next != null && Nd.next.next != null) {
            temp = Nd.next.next;
            Nd.next = temp;
            Nd = Nd.next;
            //temp = null;
        }
        Nd.next = null;
    }

    //Split Normal Linked List into two Small Linked List Alternatively
    public void splitAlternateNode() {
        Node Nd = head;
        Node temp1 = new Node(Nd.data);
        Node temp2 = Nd.next;
        //temp2 = head2;

        while (temp2 != null) {
            System.out.println("Linked List1: " + temp1.data);
            System.out.println("Linked List2: " + temp2.data);
            temp1 = temp2.next;
            temp2 = temp1.next;
            //Nd = Nd.next;
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

package LinkedList;

/**
 * Created by piyush.bajaj on 15/10/16.
 */
public class MoveLastElement {
    Node head; //head of the list

    public static void main(String[] args) {
        MoveLastElement list = new MoveLastElement();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);
        System.out.println("Original Linked List is: ");
        list.printList(list.head);
        System.out.println("\n");
        list.moveLastElementToFront();
        list.printList(list.head);
    }

    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    void moveLastElementToFront() {
        Node Nd = head;
        Node temp_Nd, tem = null;
        if (Nd == null) {
            return;
        }


//        //This swapping is done without Address
//        while (Nd.next!=null){
//            Nd = Nd.next;
//        }
//
//
//        int temp = Nd.data;
//        Nd.data = head.data;
//        head.data = temp;

        //This swapping is done with Address
        while (Nd.next.next != null) {
            Nd = Nd.next;
        }

        temp_Nd = Nd.next;
        Nd.next = head;
        temp_Nd.next = head.next;
        Nd.next.next = null;
        head = temp_Nd;

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

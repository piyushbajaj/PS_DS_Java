package LinkedList;

/**
 * Created by piyush.bajaj on 14/10/16.
 */
public class NthNode {
    Node head; //head of the list

    public static void main(String[] args) {
        NthNode list = new NthNode();
        list.head = new Node(12);
        list.head.next = new Node(6);
        list.head.next.next = new Node(12);
        list.head.next.next.next = new Node(8);
        list.head.next.next.next.next = new Node(9);
        System.out.println("Original Linked List is: ");
        list.printList(list.head);
        System.out.println("\n");
        //list.NthNodeFromEnd(2);

        //list.NthNodeFromEnd_Recursive(list.head, 2);

        list.NthNodeFromEnd_Iterative(list.head, 2);

    }

    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public int getCount(Node Nd) {
        int count = 0;
        while (Nd != null) {
            count++;
            Nd = Nd.next;
        }
        return count;
    }

    void NthNodeFromEnd(int value) {
        Node Nd = head;
        int i = 0;
        int count = getCount(head);
        int diff = count - value;
        if (diff >= 0) {
            while (Nd != null) {
                if (diff == i) {
                    System.out.println("The Value of" + value + "th node from end is: " + Nd.data);
                    return;
                } else {
                    Nd = Nd.next;
                    i++;
                }
            }
        }
    }

    public void NthNodeFromEnd_Iterative(Node Nd, int value) {
        if (Nd == null) {
            return;
        }

        Node p1 = Nd;
        Node p2 = Nd;

        for (int i = 0; i < value - 1; i++) {
            if (p2 == null) {
                return;
            }
            p2 = p2.next;
        }

        if (p2 == null) {
            return;
        }

        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        System.out.println("The Value of" + value + "th node from end is: " + p1.data);
        return;

    }

    public int NthNodeFromEnd_Recursive(Node Nd, int value) {
        if (Nd == null) {
            return 0;
        }

        int i = NthNodeFromEnd_Recursive(Nd.next, value) + 1;

        if (i == value) {
            System.out.println("The Value of" + value + "th node from end is: " + Nd.data);
        }
        return i;
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

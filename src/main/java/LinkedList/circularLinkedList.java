package LinkedList;

/**
 * Created by piyush.bajaj on 04/09/16.
 */
public class circularLinkedList {
    static Node head, head1, head2;

    public static void main(String[] args) {
        circularLinkedList circularList = new circularLinkedList();
        circularList.push(70);
        circularList.push(60);
        circularList.push(50);
        circularList.push(40);
        circularList.push(30);
        circularList.push(20);
        circularList.push(10);

        circularList.listCircular(circularList.head);

        System.out.print("Orignal Linked List");
        circularList.printCircularList(circularList.head);

        System.out.print("\n");

        circularList.SplitCircularlist();

        System.out.print("\n");

        System.out.print("Insert in Sorted Linked list");

        circularList.insertSortedCirList(circularList.head, 10);

        circularList.printCircularList(circularList.head);

        //circularList.printCircularList(head1);

        //circularList.printCircularList(head2);

        // System.out.print("\n");

        //boolean b = evenOdd(0);


    }

    public Node listCircular(Node nd) {
        while (nd.next != null) {
            nd = nd.next;
        }
        nd.next = head;
        return nd;
    }

    /* Function to traverse a given Circular linked list and print nodes */
    void printCircularList(Node first) {
        Node temp = first;

        if (first != null) {
            do {
                System.out.println("LinkedList.Node data" + first.data);
                first = first.next;
            } while (temp != first);
        }
    }


    /*
    Function to split the circualr linked list into two halves
     */

    public void SplitCircularlist() {
        Node first = head;
        Node temp = head;
        int count = 0;
        int midcount = 0;
        int t1 = 0;

        head1 = head;
        if (head != null) {
            do {
                head = head.next;
                count++;
            } while (temp != head);
        }
        if (evenOdd(count) == true) {
            midcount = count / 2;
        } else {
            midcount = count / 2 + 1;
        }

        if (first != null) {
            do {
                first = first.next;
                t1++;
            } while (t1 != midcount - 1);
        }

        Node second = first.next;
        first.next = head1;
        System.out.print("\n");
        System.out.print("First Split");

        printCircularList(this.head1);
        head2 = second;

        if (second != null) {
            do {
                second = second.next;
                t1++;
            } while (t1 != count - 2);
        }

        second.next = head2;
        //first.next = null;
        //second.next = null;


        System.out.print("\n");
        System.out.print("Second Split");

        printCircularList(this.head2);
    }

    public void push(int new_data) {
        //Declare a new node & assign a value
        Node new_node = new Node(new_data);
        //Now point next of new_node to Head
        new_node.next = head;
        //Now store the address of new node on Head, since the new_node is Head now
        head = new_node;
    }

    public boolean evenOdd(int num) {
        if (num % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void insertSortedCirList(Node Nd, int data) {
        Node new_node = new Node(data);

        while (Nd.next != null && Nd.next.data <= data && Nd.next != head) {
            Nd = Nd.next;
        }

        new_node.next = Nd.next;
        Nd.next = new_node;

    }

    static class Node {

        int data;
        Node next, prev;

        Node(int d) {
            data = d;
            next = prev = null;
        }
    }
}

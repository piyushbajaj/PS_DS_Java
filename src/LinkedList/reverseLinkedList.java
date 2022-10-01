package LinkedList;

/**
 * Created by piyush.bajaj on 26/08/16.
 */
public class reverseLinkedList {

    //This a declaration of LinkedList.Node Structure
    static class Node {

        int data;  //Value
        Node next; //Next Pointer defined

        Node(int d) {
            data = d;
            next = null;
        }
    }

    //This is a declaration of starting LinkedList.Node
    static Node head;

    /* Function to reverse the linked list */
    /*
    Here i am basically using here 3 Nodes, prev(for pointing previous values or old values),
    current(for pointing to the values present currently), next(for pointing to next values)
    So here if you see closely you will understand that i am changing the direction of the pointers,
    so finally prev node will contain all the address for the reverse Nodes.
     */
    Node reverse(Node node) {
        Node prev = null;
        Node current = node;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

    // prints content of double linked list
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    //Using Recursion

    public void reverse_Recursive(Node node) {
        if (node.next != null)
            reverse_Recursive(node.next);
        System.out.println("Reverse Linked List using recusrsion is: " + node.data);
    }

    public static void main(String[] args) {
        reverseLinkedList list = new reverseLinkedList();

        list.head = new Node(85);
        list.head.next = new Node(15);
        list.head.next.next = new Node(4);
        list.head.next.next.next = new Node(20);

        System.out.println("Original Linked list is :");
        list.printList(head);
        head = list.reverse(head);
        System.out.println("");
        System.out.println("Reversed linked list : ");
        list.printList(head);
        list.reverse_Recursive(head);

        //list.printList(list.reverse_prac(head));

        reverseLinkedList list1 = new reverseLinkedList();

        list1.head = new Node(1);
        list1.head.next = new Node(2);
        list1.head.next.next = new Node(3);
        list1.head.next.next.next = new Node(4);
        list1.head.next.next.next.next = new Node(5);
        list1.head.next.next.next.next.next = new Node(6);
        list1.head.next.next.next.next.next.next = new Node(7);
        list1.head.next.next.next.next.next.next.next = new Node(8);
        list1.head.next.next.next.next.next.next.next.next = new Node(9);
        list1.head.next.next.next.next.next.next.next.next.next = new Node(10);

        list1.printList(list1.reverseKthNode(list1.head, 4));

        for (int i = 1; i < 10; i = i * 2) {
            System.out.println(i);
        }
    }

    public Node reverse_prac(Node key) {
        Node prev = null;
        Node current = key;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;

        }
        return prev;
    }

    public Node reverseKthNode(Node key, int k) {
        int count = 1;
        head = key;
        Node prev = key, next = null;
        while (count < k && key.next != null) {
            //prev = key;
            key = key.next;
            count++;
        }
        next = key.next;
        key.next = null;
        Node temp = reverse_prac(prev);

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = next;

        count = 0;
        Node prev1 = null;
        while (count < k && next != null) {
            //prev = key;
            prev1 = next;
            next = next.next;
            count++;
        }
        //next = next.next;

        if (next != null) {
            prev1.next = reverseKthNode(next, k);
        }

        //temp = reverse_prac(temp);
        //temp.next = key;

        return key;
    }
}

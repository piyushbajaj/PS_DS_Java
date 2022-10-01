package LinkedList;

import java.util.Scanner;

/**
 * Created by piyush.bajaj on 05/09/16.
 */
public class DoublyLinkList {
    Node head;

    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int d) {
            data = d;
            next = null;
            prev = null;
        }
    }

    //Add a node at the front

    public void InsertNodeFront(int value) {
        Node temp = new Node(value);

        if (head == null)
            return;
        temp.next = head;
        temp.prev = null;
        head.prev = temp;
        head = temp;
    }

    public void printList() {
        Node n = head;
        while (n != null) {
            System.out.println(n.data + " ");
            n = n.next;
        }
    }

    public void push(int new_data) {
        //Declare a new node & assign a value
        Node new_node = new Node(new_data);
        //Now point next of new_node to Head
        new_node.next = head;
        new_node.prev = null;
        head.prev = new_node;
        //Now store the address of new node on Head, since the new_node is Head now
        head = new_node;
    }

    public void InsertNodeAfter(Node Nd, int value) {
        Node temp = new Node(value);
        Node tp = head;

        if (head == null)
            return;
        while (tp != Nd) {
            tp = tp.next;
        }
        temp.next = tp.next;
        temp.prev = tp;
        tp.next = temp;
        temp.next.prev = temp;
    }

    public void InsertNodeBefore(Node Nd, int value) {
        Node temp = new Node(value);
        Node tp = head;

        if (head == null)
            return;

        while (tp.next != Nd) {
            tp = tp.next;
        }
        temp.next = tp.next;
        temp.prev = tp;
        tp.next = temp;
        temp.next.prev = temp;
    }

    public void InsertNodeAtEnd(int value) {
        Node temp = new Node(value);
        Node tp = head;

        if (head == null)
            return;
        while (tp.next != null) {
            tp = tp.next;
        }
        tp.next = temp;
        temp.prev = tp;
        temp.next = null;
    }

    public void DeleteHeadNode() {
        //LinkedList.Node tp = head;
        if (head == null)
            return;
        head = head.next;
        head.prev = null;
    }

    public void DeleteMiddleNode(Node del) {
        //LinkedList.Node tp = head;
        if (head == null)
            return;
        if (del.next != null) {
            del.next.prev = del.prev;
            del.prev.next = del.next;
        }
    }

    public void DeleteEndNode() {
        Node tp = head;
        if (head == null)
            return;
        while (tp.next != null) {
            tp = tp.next;
        }
        tp.prev.next = null;
    }

    public void reverseLinkList() {
        //LinkedList.Node tp = head;
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            current.prev = next;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public static void main(String[] args) {
        DoublyLinkList doubly = new DoublyLinkList();
        Scanner s = new Scanner(System.in);
        int n = 0;

        doubly.head = new Node(0);
        doubly.push(1);
        doubly.push(2);
        doubly.push(3);
        System.out.println("Linked list is this: ");
        doubly.printList();
        /*
        System.out.println("Enter the data value for the node to be inserted in the front: ");
        n = s.nextInt();
        doubly.InsertNodeFront(n);
        System.out.println("Updated Linked list is this: ");
        doubly.printList();
        System.out.println("Enter the data value for the node to be inserted after a given node: ");
        n = s.nextInt();
        doubly.InsertNodeAfter(doubly.head.next.next, n);
        System.out.println("Updated Linked list is this: ");
        doubly.printList();
        System.out.println("Enter the data value for the node to be inserted at the end: ");
        n = s.nextInt();
        doubly.InsertNodeAtEnd(n);
        System.out.println("Updated Linked list is this: ");
        doubly.printList();
        System.out.println("Enter the data value for the node to be inserted before a given node: ");
        n = s.nextInt();
        doubly.InsertNodeBefore(doubly.head.next.next, n);
        System.out.println("Updated Linked list is this: ");
        doubly.printList();

        System.out.println("Deleted the head node: ");
        doubly.DeleteHeadNode();
        doubly.printList();

        System.out.println("Deleted the middle node: ");
        doubly.DeleteMiddleNode(doubly.head.next);
        doubly.printList();

        System.out.println("Deleted the last node: ");
        doubly.DeleteEndNode();
        doubly.printList();
        */

        System.out.println("Reverse Linked List is: ");
        doubly.reverseLinkList();
        doubly.printList();
    }
}

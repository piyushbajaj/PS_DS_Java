package LinkedList;

import java.util.Stack;

/**
 * Created by piyush.bajaj on 07/10/16.
 */
public class LinkedListPalindrome {

    Node head; //head of the list

    public static void main(String[] args) {
        LinkedListPalindrome lP = new LinkedListPalindrome();
        lP.head = new Node('P');
        lP.head.next = new Node('I');
        lP.head.next.next = new Node('Y');
        lP.head.next.next.next = new Node('X');
        lP.head.next.next.next.next = new Node('I');
        lP.head.next.next.next.next.next = new Node('P');
        System.out.println(lP.isPalindrome_Stack());
        //lP.isPalindrome_Stack();
        //System.out.println(lP.isPalindrome_LinkedList(lP.head));
    }

    public boolean isPalindrome_Stack() {
        Stack<Character> s = new Stack<>();
        Node n = head;

        while (n != null) {
            s.push(n.data);
            n = n.next;
        }

        n = head;
        while (n != null) {
            if (s.pop() != n.data) {
                return false;
            } else {
                n = n.next;
            }
        }
        return true;
        //But as you can see the time complexity mentioned here is O(n). But this requires O(n) extra space.
    }

    public boolean isPalindrome_LinkedList(Node Nd) {
        //LinkedList.Node Nd = head;
        Node Original_Node = Nd;
        Node reverse_Nd = reverse(head);

        while (Original_Node != null && reverse_Nd != null) {
            if (Original_Node.data != reverse_Nd.data) {
                return false;
            } else {
                Original_Node = Original_Node.next;
                reverse_Nd = reverse_Nd.next;
            }
        }
        return true;
    }

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

    /* Linked List LinkedList.Node*/
    static class Node {
        char data;
        Node next;

        //Constructor to create a new node
        //Next is by default initialized as null

        Node(char d) {
            data = d;
            next = null;
        }
    }
}

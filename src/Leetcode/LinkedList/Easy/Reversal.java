package Leetcode.LinkedList.Easy;

public class Reversal {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node printList(Node start) {
        Node newNode = start;
        System.out.print("Linked List: ");
        while (newNode != null) {
            System.out.print(newNode.data + " -> ");
            newNode = newNode.next;
        }
        System.out.print("NULL");
        System.out.println();
        return start;
    }

    public Node insertNodeInEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return head;
        }

        Node ptr = head;

        while (ptr.next != null) {
            ptr = ptr.next;
        }
        ptr.next = newNode;
        return head;
    }

    // T.C: O(N)
    public Node reverseLL_Iterative() {
        if (head == null) {
            System.out.println("Empty Linked List cannot be reversed");
            return null;
        }

        Node prev = null;
        Node curr = head;
        Node next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
        return head;
    }

    // T.C: O(N)
    public Node reverseLL_Recursive(Node ptr) {
        if (ptr == null || ptr.next == null) {
            return ptr;
        }
        // For Rest of Nodes
        Node rest = reverseLL_Recursive(ptr.next);
        ptr.next.next = ptr;
        //  Point the last node every time to NULL
        ptr.next = null;

        return rest;
    }


    public static void main(String[] args) {
        Reversal reversal = new Reversal();
        reversal.insertNodeInEnd(1);
        reversal.insertNodeInEnd(2);
        reversal.insertNodeInEnd(3);
        reversal.insertNodeInEnd(4);
        reversal.printList(reversal.head);

//        reversal.reverseLL_Iterative();
//        System.out.println("After reversing Linked List: ");
//        reversal.printList(reversal.head);

        reversal.head = reversal.reverseLL_Recursive(reversal.head);
        System.out.println("################## After reversing Linked List using Recursive ###################");
        reversal.printList(reversal.head);
    }
}

package Leetcode.LinkedList.Easy;

/*
Link: https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 */
public class BinaryNumberTOInt {
    Node head;
    Reversal reversal;

    public static void main(String[] args) {
        BinaryNumberTOInt binaryNumberTOInt = new BinaryNumberTOInt();
        binaryNumberTOInt.insertNodeInEnd(1);
        binaryNumberTOInt.insertNodeInEnd(0);
        binaryNumberTOInt.insertNodeInEnd(0);
        binaryNumberTOInt.insertNodeInEnd(1);
        binaryNumberTOInt.insertNodeInEnd(0);
        binaryNumberTOInt.insertNodeInEnd(0);
        binaryNumberTOInt.insertNodeInEnd(1);
        binaryNumberTOInt.insertNodeInEnd(1);
        binaryNumberTOInt.insertNodeInEnd(1);
        binaryNumberTOInt.insertNodeInEnd(0);
        binaryNumberTOInt.insertNodeInEnd(0);
        binaryNumberTOInt.insertNodeInEnd(0);
        binaryNumberTOInt.insertNodeInEnd(0);
        binaryNumberTOInt.insertNodeInEnd(0);
        binaryNumberTOInt.insertNodeInEnd(0);
        binaryNumberTOInt.printList(binaryNumberTOInt.head);
        System.out.println(binaryNumberTOInt.getDecimalValue(binaryNumberTOInt.head));
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

    public Node reverseLL_Iterative(Node ptr) {
        if (ptr == null) {
            System.out.println("Empty Linked List cannot be reversed");
            return null;
        }

        Node prev = null;
        Node curr = ptr;
        Node next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ptr = prev;
        return ptr;
    }

    public int getDecimalValue(Node ptr) {
        int sum = 0;
        int ctr = 0;

        ptr = reverseLL_Iterative(ptr);
        while (ptr != null) {
            sum += Math.pow(2, ctr) * ptr.data;
            ctr++;
            ptr = ptr.next;
        }
        return sum;
    }

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}

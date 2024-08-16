package Leetcode.Stack.Easy;

public class StackFromLinkedList {
    Node head;

    public static void main(String[] args) {
        StackFromLinkedList stackFromLinkedList = new StackFromLinkedList();
        stackFromLinkedList.insertNodeInEnd(1);
        stackFromLinkedList.insertNodeInEnd(2);
        stackFromLinkedList.insertNodeInEnd(3);
        stackFromLinkedList.insertNodeInEnd(4);
        stackFromLinkedList.printList(stackFromLinkedList.head);
        stackFromLinkedList.push(5);
        stackFromLinkedList.push(6);
        stackFromLinkedList.push(7);
        stackFromLinkedList.printList(stackFromLinkedList.head);
        System.out.println(stackFromLinkedList.pop());
        stackFromLinkedList.printList(stackFromLinkedList.head);
    }

    public void push(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public int pop() {
        if (head == null) {
            return -1;
        }

        int data = head.data;
        head = head.next;
        return data;
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

    static class Node {
        Node next;
        int data;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}

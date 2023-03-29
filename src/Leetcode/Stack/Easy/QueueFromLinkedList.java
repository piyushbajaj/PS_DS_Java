package Leetcode.Stack.Easy;

public class QueueFromLinkedList {
    Node head;

    public static void main(String[] args) {
        QueueFromLinkedList queueFromLinkedList = new QueueFromLinkedList();

        queueFromLinkedList.insertNodeInEnd(1);
        queueFromLinkedList.insertNodeInEnd(2);
        queueFromLinkedList.insertNodeInEnd(3);
        queueFromLinkedList.printList(queueFromLinkedList.head);
        queueFromLinkedList.enqueue(5);
        queueFromLinkedList.enqueue(6);
        queueFromLinkedList.enqueue(7);
        queueFromLinkedList.printList(queueFromLinkedList.head);
        System.out.println(queueFromLinkedList.dequeue());
        System.out.println(queueFromLinkedList.dequeue());
        queueFromLinkedList.printList(queueFromLinkedList.head);
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

    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public int dequeue() {
        if (head == null) {
            return -1;
        }

        Node temp = head;
        head = head.next;

        return temp.data;
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

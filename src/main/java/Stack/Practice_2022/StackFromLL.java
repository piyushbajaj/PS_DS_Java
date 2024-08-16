package Stack.Practice_2022;

import java.util.ArrayList;

public class StackFromLL {
    Node head;

    public static void main(String[] args) {
        StackFromLL stackFromLL = new StackFromLL();
        stackFromLL.push(1);
        stackFromLL.push(2);
        stackFromLL.push(3);
        stackFromLL.push(4);
        stackFromLL.push(5);

        System.out.println(stackFromLL);

        System.out.println(stackFromLL.pop());

        System.out.println(stackFromLL.peek());

    }

    public void push(int x) {
        Node newNode = new Node(x);
        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public Integer pop() {
        if (head == null) {
            System.out.println("Stack Underflow");
            return null;
        }

        int temp = head.data;
        head = head.next;

        return temp;
    }

    public Integer peek() {
        if (head == null) {
            System.out.println("Stack Underflow");
            return null;
        }

        return head.data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public String toString() {
        Node temp = head;
        ArrayList<Integer> arrayList = new ArrayList<>();

        while (temp != null) {
            arrayList.add(temp.data);
            temp = temp.next;
        }

        return arrayList.toString();
    }

    static class Node {
        Node next;
        int data;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
}

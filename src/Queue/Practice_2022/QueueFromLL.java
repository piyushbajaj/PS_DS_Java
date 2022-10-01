package Queue.Practice_2022;

import java.util.ArrayList;

public class QueueFromLL {
    Node front, rear;
    int size;

    static class Node {
        Node next;
        int data;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public QueueFromLL() {
        this.front = this.rear = null;
        this.size = 0;
    }


    public void enqueue(int x) {
        Node newNode = new Node(x);
        if (front == null) {
            rear = newNode;
            front = rear;
            size++;
            return;
        }

        rear.next = newNode;
        rear = newNode;
        size++;
    }

    public Integer dequeue() {
        if (front == null) {
            System.out.println("Queue is empty");
            return null;
        }

        int temp = front.data;
        front = front.next;

        size--;
        return temp;

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        Node temp = front;
        ArrayList<Integer> arrayList = new ArrayList<>();

        while (temp != null) {
            arrayList.add(temp.data);
            temp = temp.next;
        }

        return arrayList.toString();
    }

    public static void main(String[] args) {
        QueueFromLL queueFromLL = new QueueFromLL();
        System.out.println(queueFromLL.isEmpty());
        queueFromLL.enqueue(1);
        queueFromLL.enqueue(2);
        queueFromLL.enqueue(3);
        queueFromLL.enqueue(4);
        queueFromLL.enqueue(5);

        System.out.println(queueFromLL);

        System.out.println(queueFromLL.dequeue());

        System.out.println(queueFromLL.dequeue());

        System.out.println(queueFromLL);

        System.out.println(queueFromLL.isEmpty());

    }
}

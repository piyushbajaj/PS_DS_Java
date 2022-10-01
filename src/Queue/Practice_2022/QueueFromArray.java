package Queue.Practice_2022;

import java.util.Arrays;

public class QueueFromArray {
    int capacity;
    int[] queueArray;
    int front = -1, rear = -1;

    QueueFromArray(int capacity) {
        this.queueArray = new int[capacity];
        this.capacity = capacity;
    }

    public void enqueue(int x) {
        if (rear == capacity - 1) {
            System.out.println("Queue is full");
            return;
        }

        this.queueArray[++rear] = x;
    }

    public Integer dequeue() {
        if (rear == -1) {
            System.out.println("Queue is empty");
            return null;
        }

        return this.queueArray[++front];
    }

    public Integer front() {
        if (rear == -1) {
            System.out.println("Queue is empty");
            return null;
        }

        return this.queueArray[front + 1];
    }

    public Integer queueSize() {
        return rear + 1;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.queueArray);
    }

    public static void main(String[] args) {
        QueueFromArray queueFromArray = new QueueFromArray(5);
        System.out.println(queueFromArray.dequeue());
        queueFromArray.enqueue(1);
        System.out.println("Front Item in the queue: " + queueFromArray.front());
        queueFromArray.enqueue(2);
        queueFromArray.enqueue(3);
        queueFromArray.enqueue(4);
        queueFromArray.enqueue(5);
        System.out.println("Queue Size: " + queueFromArray.queueSize());
//        queueFromArray.enqueue(6);
        System.out.println("Front Item in the queue: " + queueFromArray.front());

        System.out.println(queueFromArray);

        System.out.println("Dequeue Item from the list: " + queueFromArray.dequeue());
        System.out.println("Dequeue Item from the list: " + queueFromArray.dequeue());

        System.out.println("Front Item in the queue: " + queueFromArray.front());
    }
}

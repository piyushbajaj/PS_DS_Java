package Leetcode.Stack.Easy;

public class QueueFromArray {
    int front = -1; // this is used for dequeue
    int rear = -1; // this is used for enqueue
    int[] arr;
    int maxCapacity = -1;

    QueueFromArray(int capacity) {
        maxCapacity = capacity;
        arr = new int[capacity];
    }

    public static void main(String[] args) {
        QueueFromArray queueFromArray = new QueueFromArray(7);
        queueFromArray.enqueue(1);
        queueFromArray.enqueue(2);
        queueFromArray.enqueue(3);
        queueFromArray.enqueue(4);
        System.out.println("Arrays are: ");
        queueFromArray.printList();
        queueFromArray.enqueue(5);
        System.out.println("Dequeue element: " + queueFromArray.dequeue());
        System.out.println("Arrays are: ");
        queueFromArray.printList();
        queueFromArray.enqueue(6);
        System.out.println("Arrays are: ");
        queueFromArray.printList();
        System.out.println("Dequeue element: " + queueFromArray.dequeue());
        System.out.println("Dequeue element: " + queueFromArray.dequeue());
        System.out.println("Arrays are: ");
        queueFromArray.printList();
    }

    public void enqueue(int data) {
        if (rear == maxCapacity - 1) {
            if (front == -1) {
                System.out.println("Queue is full");
                return;
            } else if (rear == front) {
                front = -1;
                rear = -1;
            } else {
                rear = -1;
            }
        }
        arr[++rear] = data;
    }

    public int dequeue() {
        if (rear == front) {
            System.out.println("Stack is already empty");
            return -1;
        }

        int temp = arr[++front];
        return temp;
    }

    public void printList() {
        for (int i = front + 1; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

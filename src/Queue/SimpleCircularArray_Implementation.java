package Queue;

/**
 * Created by piyush.bajaj on 11/12/16.
 */
public class SimpleCircularArray_Implementation {
    private static int CAPACITY = 16;
    private int[] queueRep;
    private int size, front, rear;

    public SimpleCircularArray_Implementation() {
        queueRep = new int[CAPACITY];
        size = 0;
        front = 0;
        rear = 0;
    }

    public SimpleCircularArray_Implementation(int cap) {
        CAPACITY = cap;
        queueRep = new int[cap];
        size = 0;
        front = 0;
        rear = 0;
    }

    public static void main(String[] args) {
        SimpleCircularArray_Implementation SA = new SimpleCircularArray_Implementation(5);
        SA.enqueue(10);
        SA.enqueue(12);
        SA.enqueue(14);
        SA.enqueue(16);
        SA.enqueue(18);
        System.out.println("Is the capacity is full: " + SA.isFull());


        System.out.println(SA.displayString());

        SA.dequeue();

        System.out.println(SA.displayString());

        int b = 1 << 15;

        int c = 15 << 1;


    }

    public void enqueue(int data) throws IllegalStateException {
        if (size == CAPACITY) {
            throw new IllegalStateException("Queue is full: overflow");
        }
        queueRep[rear] = data;
        size++;
        rear = (rear + 1) % CAPACITY;
    }

    public int dequeue() throws NullPointerException {
        if (size == 0) {
            throw new NullPointerException("Queus is empty: underflow");
        }

        int data = queueRep[(front % CAPACITY)];
        queueRep[front] = Integer.MIN_VALUE;
        front = (front + 1) % CAPACITY;
        size--;
        return data;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public boolean isFull() {
        return (size == CAPACITY);
    }

    public int size() {
        return size;
    }

    public String displayString() {
        String result = "[";

        for (int i = 0; i < size; i++) {
            result += Integer.toString(queueRep[(front + i) % CAPACITY]);
            if (i < size - 1) {
                result += ",";
            }
        }

        result += "]";
        return result;
    }
}

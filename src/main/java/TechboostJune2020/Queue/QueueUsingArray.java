package TechboostJune2020.Queue;

public class QueueUsingArray {

    int front, rear, size;
    int capacity;
    int arr[];

    public QueueUsingArray(int capacity) {
        this.capacity = capacity; // Maximum size of queue
        front = this.size = 0;
        rear = capacity - 1;
        arr = new int[this.capacity];
    }

    public static void main(String[] args) {
        QueueUsingArray queueUsingArray = new QueueUsingArray(5);
        queueUsingArray.enqueue(10);
        queueUsingArray.enqueue(20);
        queueUsingArray.enqueue(30);

        System.out.println("Front Value: " + queueUsingArray.frontValue());
        System.out.println(queueUsingArray.dequeue());
        queueUsingArray.enqueue(40);
        queueUsingArray.enqueue(50);
        System.out.println(queueUsingArray.dequeue());

        System.out.println("Front Value: " + queueUsingArray.frontValue());

        System.out.println("Rear Value: " + queueUsingArray.rearValue());

    }

    public boolean isQueueFull(QueueUsingArray queue) {
        return (queue.size == queue.capacity);
    }

    public boolean isQueueEmpty(QueueUsingArray queue) {
        return (queue.size == 0);
    }

    // T.C: O(1); S.C: O(1)
    public void enqueue(int key) {
        if (isQueueFull(this)) {
            return;
        }

        // Whenever the capacity is full we are overwriting the first element
        this.rear = (this.rear + 1) % this.capacity;
        this.arr[this.rear] = key;
        this.size++;
        System.out.println("Enqueue element: " + key);
    }

    // T.C: O(1); S.C: O(1)
    public int dequeue() {
        if (isQueueEmpty(this)) {
            return -1;
        }
        int temp = this.arr[this.front];
        this.front = (this.front + 1) % this.capacity;
        this.size--;
        return temp;
    }

    public int frontValue() {
        if (isQueueEmpty(this)) {
            return -1;
        }
        return this.arr[this.front];
    }

    public int rearValue() {
        if (isQueueEmpty(this)) {
            return -1;
        }
        return this.arr[this.rear];
    }
}

package Session.May2024.TechBoost.Arrays;

/**
 * Project: DSAlgo
 * Package: PracticeSessionMay2024.TechBoost.Arrays
 * <p>
 * User: piyushbajaj
 * Date: 17/06/24
 * Time: 9:11 am
 */
public class QueueImplementation {
    private int front;
    private int rear;
    private final int[] elements;
    private final int maxSize;

    public QueueImplementation(int size) {
        front = -1;
        rear = -1;
        maxSize = size;
        elements = new int[maxSize];
    }

    /**
     * If elements get added rear will increment, if element gets removed front will increment
     * TC: O(1)
     * SC: O(1)
     *
     * @param val
     */
    public void enqueue(int val) {
        // If max size reached, then we need to throw an error or overwrite the oldest element
        if (rear - front == maxSize) {
            System.out.printf("Cannot enqueue now, max number of elements: %d reached!%n", maxSize);
        } else {
            elements[++rear] = val;
            System.out.printf("Element inserted: %d%n", val);

//            // only when front is at -1
//            if (front == -1) {
//                front = rear;
//            }
        }
    }

    /**
     * TC: O(1)
     * SC: O(1)
     *
     * @return
     */
    public int dequeue() {
        // If array is empty
        // If front == rear, which means element is empty
        if (rear == -1 || front == rear) {
            System.out.println("Nothing to Dequeue!! Queue is empty");
            return -1;
        } else {
            int temp = elements[++front];
            System.out.printf("Element dequeued: %d%n", temp);
            System.out.print("Remaining elements: ");
            printElements();
            System.out.printf("Front index position: %d, Rear index position: %d%n", front, rear);
            return temp;
        }
    }

    public void printElements() {
        for (int i = front + 1; i <= rear; i++) {
            System.out.print(elements[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueImplementation queueImplementation = new QueueImplementation(5);
        queueImplementation.enqueue(10);
        queueImplementation.enqueue(20);
        queueImplementation.enqueue(30);
        queueImplementation.enqueue(40);
        queueImplementation.enqueue(50);
        queueImplementation.enqueue(60);

        queueImplementation.dequeue();
        queueImplementation.enqueue(60);
        queueImplementation.enqueue(70);
    }
}

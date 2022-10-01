package Queue;

/**
 * Created by piyush.bajaj on 23/09/16.
 */
public class QueueUsingLinkedList {
    Node front, rear;
    int length;

    QueueUsingLinkedList() {
        front = null;
        rear = null;
        length = 0;
    }

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public void enqueue(int k) {
        Node new_node = new Node(k);
        if (front == null) {
            front = new_node;
            rear = front;
        } else {
            rear.next = new_node;
            rear = new_node;
        }
        length++;
    }

    public int deque() {
        if (front == null) {
            System.out.println("Queue is underflown");
            return -1;
        }
        //System.out.println("Data which is now removed from the queue: " );
        int result = front.data;
        front = front.next;
        length--;
        return result;
    }

    public boolean isEmpty() {
        return (length == 0);
    }

    public int size() {
        return length;
    }

    public String displayQueue() {
        String result = "";
        Node current = front;
        while (current != null) {
            result += Integer.toString(current.data) + " ";
            current = current.next;
        }
        return result;
    }

    public static void main(String[] args) {
        QueueUsingLinkedList QLL = new QueueUsingLinkedList();
        QLL.enqueue(2);
        QLL.enqueue(4);
        QLL.enqueue(5);
        System.out.println(QLL.displayQueue());
        //System.out.println("Data which is now removed from the queue: " + QLL.deque());

        System.out.println(QLL.displayQueue());
    }
}

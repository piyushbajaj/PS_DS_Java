package Stack;

/**
 * Created by piyush.bajaj on 30/11/16.
 */
public class QueueImplementation {
    Node first, last;

    public static void main(String[] args) {
        QueueImplementation que = new QueueImplementation();
        que.enqueue(3);
        que.enqueue(6);
        que.enqueue(1);
        que.displayStack();
        que.dequeue();
        que.displayStack();
    }

    public void enqueue(int item) {
        if (first == null) {
            last = new Node(item);
            first = last;
        } else {
            last.next = new Node(item);
            last = last.next;
        }
    }

    void displayStack() {
        Node Nd = first;
        while (Nd != null) {
            System.out.print(Nd.data + " -> ");
            Nd = Nd.next;
        }
        System.out.println(" ");
    }

    public void dequeue() {
        if (first != null) {
            int item = first.data;
            first = first.next;
            return;
        }
        return;
    }

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }
}

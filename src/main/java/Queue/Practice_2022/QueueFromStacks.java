package Queue.Practice_2022;

import java.util.Stack;

public class QueueFromStacks {
    static Stack<Integer> s1 = new Stack<>();
    static Stack<Integer> s2 = new Stack<>();

    public static void main(String[] args) {
        QueueFromStacks queue = new QueueFromStacks();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println(queue.dequeue());
    }

    public void enqueue(int x) {
        s1.push(x);
    }

    public int dequeue() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        if (!s2.isEmpty()) {
            return s2.pop();
        }
        return -1;
    }
}

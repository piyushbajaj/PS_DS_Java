package Stack.Practice_2022;

import Queue.Practice_2022.QueueFromLL;

public class StackFromTwoQueues {
    QueueFromLL q1, q2;

    public StackFromTwoQueues() {
        this.q1 = new QueueFromLL();
        this.q2 = new QueueFromLL();
    }

    public static void main(String[] args) {
        StackFromTwoQueues stack = new StackFromTwoQueues();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println(stack.pop());
    }

    public void push(int x) {
        if (q1.isEmpty()) {
            q2.enqueue(x);
        }
        if (q2.isEmpty()) {
            q1.enqueue(x);
        }
    }

    public int pop() {
        if (!q1.isEmpty()) {
            int length = q1.size();
            while (length > 1) {
                q2.enqueue(q1.dequeue());
                length--;
            }
            return q1.dequeue();
        }

        if (!q2.isEmpty()) {
            int length = q2.size();
            while (length > 1) {
                q1.enqueue(q2.dequeue());
                length--;
            }
            return q2.dequeue();
        }

        System.out.println("Stack is empty");
        return -1;
    }
}

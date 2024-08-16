package Stack.Practice_2022;

import Queue.Practice_2022.QueueFromLL;

/**
 * Created by bajajp on 21 May, 2022
 */
public class StackFromOneQueue {
    QueueFromLL queueFromLL;

    StackFromOneQueue() {
        this.queueFromLL = new QueueFromLL();
    }

    public static void main(String[] args) {
        StackFromOneQueue stack = new StackFromOneQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    public void push(int x) {
        queueFromLL.enqueue(x);
    }

    public int pop() {
        if (queueFromLL.size() == 0) {
            return -1;
        }

        int currLen = queueFromLL.size();

        while (currLen > 1) {
            queueFromLL.enqueue(queueFromLL.dequeue());
            currLen--;
        }

        return queueFromLL.dequeue();
    }
}

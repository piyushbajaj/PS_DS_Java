package Queue.Practice_2022;

import Stack.Practice_2022.StackFromLL;

public class ReversingQueue extends QueueFromLL {
    public static void main(String[] args) {
        ReversingQueue reversingQueue = new ReversingQueue();
        reversingQueue.enqueue(1);
        reversingQueue.enqueue(2);
        reversingQueue.enqueue(3);
        reversingQueue.enqueue(4);
        reversingQueue.enqueue(5);
        System.out.println(reversingQueue);
        reversingQueue = reversingQueue.reversingQueueFunc(reversingQueue);
        System.out.println(reversingQueue);

    }

    public ReversingQueue reversingQueueFunc(ReversingQueue queue) {
        StackFromLL stackFromLL = new StackFromLL();
        while (!queue.isEmpty()) {
            stackFromLL.push(queue.dequeue());
        }

        while (!stackFromLL.isEmpty()) {
            queue.enqueue(stackFromLL.pop());
        }

        return queue;
    }


}

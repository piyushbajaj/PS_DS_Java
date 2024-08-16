package Multithreading.Riddhi.ProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Project: DSAlgo
 * Package: Multithreading.Riddhi.ProducerConsumer
 * <p>
 * User: piyushbajaj
 * Date: 18/04/23
 * Time: 12:42 pm
 */
public class BlockingQueue {
    private Queue<Integer> queue;
    private final int capacity;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
    }

    public boolean add(int item) {
        synchronized (queue) {
            // instead of If, we need to use while loop here because every time threads should check the condition
            // before executing it directly
            while (queue.size() == capacity) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            queue.add(item);
            // notifies the other threads that the item is added
            queue.notifyAll();
            return true;
        }
    }

    public int remove() {
        synchronized (queue) {
            while (queue.size() == 0) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            int element = queue.poll();
            queue.notifyAll();
            return element;
        }
    }

    public static void main(String[] args) {
        BlockingQueue blockingQueue = new BlockingQueue(5);

    }
}

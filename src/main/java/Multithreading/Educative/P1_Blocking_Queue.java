package Multithreading.Educative;

/**
 * Project: DSAlgo
 * Package: Multithreading.Educative
 * <p>
 * User: piyushbajaj
 * Date: 26/04/23
 * Time: 8:46 am
 * Problem: Classical synchronization problem involving a limited size buffer which can have items added to it or
 * removed from it by different producer and consumer threads.
 * This problem is known by different names: consumer producer problem, bounded buffer problem or
 * blocking queue problem.
 */


public class P1_Blocking_Queue<T> {

    T[] array;
    final Object lockObject = new Object();
    int size = 0;
    private int capacity = 0;
    int head = 0, tail = 0;

    P1_Blocking_Queue(int capacity) {
        this.capacity = capacity;
        array = (T[]) new Object[capacity];
    }

    public void enqueue(T item) throws InterruptedException {
        synchronized (lockObject) {
            if (size == capacity) {
                lockObject.wait();
            }

            if (tail == capacity) {
                tail = 0;
            }

            array[tail] = item;
            tail++;
            size++;

            lockObject.notifyAll();
        }
    }

    public T dequeue() throws InterruptedException {
        synchronized (lockObject) {
            if (size == 0) {
                lockObject.wait();
            }

            if (head == capacity) {
                head = 0;
            }

            T temp = array[head];
            array[head] = null;
            head++;
            size--;

            lockObject.notifyAll();
            return temp;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        P1_Blocking_Queue<Integer> p1BlockingQueue = new P1_Blocking_Queue<Integer>(5);
//        p1BlockingQueue.enqueue(1);
//        p1BlockingQueue.enqueue(2);
//        p1BlockingQueue.enqueue(3);
//        p1BlockingQueue.enqueue(4);
//        p1BlockingQueue.enqueue(5);
//
//        System.out.println(p1BlockingQueue.dequeue());
//        System.out.println(p1BlockingQueue.dequeue());
//        p1BlockingQueue.enqueue(6);
//        System.out.println(p1BlockingQueue.dequeue());

        Thread thread1 = new Thread(() -> {
            try {
                for (int i = 0; i < 50; i++) {
                    p1BlockingQueue.enqueue(i);
                    System.out.println("Thread1 enqueued " + i);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 50; i++) {
                        System.out.println("Thread2 dequeued " + p1BlockingQueue.dequeue());
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 50; i++) {
                        System.out.println("Thread3 dequeued " + p1BlockingQueue.dequeue());
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread1.start();
        thread2.start();
        thread2.join();
        thread3.start();
        thread1.join();
        thread3.join();

    }
}

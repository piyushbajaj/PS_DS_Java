package Multithreading;

/**
 * Created by piyush.bajaj on 21/09/16.
 * 3 constants defiend in Thread class:
 * <p>
 * public static int MIN_PRIORITY
 * public static int NORM_PRIORITY
 * public static int MAX_PRIORITY
 */
public class ThreadPriority extends Thread {
    public static void main(String[] args) {
        ThreadPriority t1 = new ThreadPriority();
        ThreadPriority t2 = new ThreadPriority();
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
    }

    public void run() {
        System.out.println("Name of the thread is: " + Thread.currentThread().getName());
        System.out.println("Priority of the thread is: " + Thread.currentThread().getPriority());
    }
}

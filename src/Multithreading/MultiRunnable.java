package Multithreading;

/**
 * Created by piyush.bajaj on 20/09/16.
 */
//Java Thread by implementing Runnable Interface
/*
Note: If you are not extending thread class, the class object would not be treated as thread object.
So we need to explicitly create THREAD object.
We will pass the object of our class that implements runnable as a PARAMETER, so that our class run() method will execute.
 */
public class MultiRunnable implements Runnable {
    public static void main(String[] args) {
        MultiRunnable MR = new MultiRunnable();
        Thread t = new Thread(MR);
        t.start();
    }

    public void run() {
        System.out.println("THREAD is RUNNING...");
    }
}

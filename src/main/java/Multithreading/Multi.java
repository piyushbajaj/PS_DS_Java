package Multithreading;

/**
 * Created by piyush.bajaj on 20/09/16.
 */

//Java Thread by extending THREAD class

public class Multi extends Thread {
    public static void main(String[] args) {
        Multi mt = new Multi();
        //mt.start();
        //mt.start();
        /*
        We cannot start the thread twice or else it will throw an exception java.lang.IllegalThreadStateException
         */

        //getName(),setName(String) and getId() method
        System.out.println("Name of mt thread: " + mt.getName());
        System.out.println("Id of mt thread: " + mt.getId());

        mt.start();

        mt.setName("Piyush");
        System.out.println("Name of thread mt: " + mt.getName());


    }

    public void run() {
        System.out.println("Thread is RUNNING...");

        //The currentThread() method returns a reference to the currently executing thread object.

        System.out.println(Thread.currentThread().getName());
    }
}






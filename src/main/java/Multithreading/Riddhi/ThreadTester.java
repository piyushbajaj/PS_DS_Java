package Multithreading.Riddhi;

/**
 * Project: DSAlgo
 * Package: Multithreading.Riddhi
 * <p>
 * User: piyushbajaj
 * Date: 17/04/23
 * Time: 6:02 pm
 */
public class ThreadTester {
    public static void main(String[] args) {
        System.out.println("Main is starting");

        // Method overriding of our run method here
        // We should not be extending Thread class because multiple extension of class is not supported in
        // Java.
//        Thread thread1 = new Thread1("thread1");
//        thread1.start();

        // We should be implementing Runnable class because multiple implementation of interface is supported in Java.
//        Thread thread2 = new Thread(new Thread2(), "thread2");
//        thread2.start();

        // Replace with Lambda
//        Thread thread2 = new Thread(() -> {
//            for (int i = 0; i < 5; i++) {
//                System.out.println(Thread.currentThread() + ", " + i);
//            }
//        }, "thread2");
//        thread2.start();
//
//        System.out.println("Main is exiting");

//        Stack stack = new Stack(5);
//
//        new Thread(() -> {
//            int counter = 0;
//            while (++counter < 10) {
//                System.out.println("Pushed: " + stack.push(100));
//            }
//        }, "Pusher").start();
//
//        new Thread(() -> {
//            int counter = 0;
//            while (++counter < 10) {
//                System.out.println("Popped: " + stack.pop());
//            }
//        }, "Popper").start();
//
//        System.out.println("Main is exiting");

//        Thread thread3 = new Thread(() -> {
//            try {
//                Thread.sleep(1);
//                for (int i = 10000; i > 0; i--) ;
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }, "States");
//
//        thread3.start();
//
//        while (true) {
//            Thread.State state = thread3.getState();
//            System.out.println(state);
//            if (state == Thread.State.TERMINATED) {
//                break;
//            }
//        }

        // Thread Join
//        Thread thread = new Thread(() -> {
//            System.out.println(Thread.currentThread());
//        }, "Our Thread");
//        thread.start();
//
//        try {
//            thread.join();
//            // thread  will complete till this portion, and then only the next will start.
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        System.out.println("Main is exiting");

        /**
         * Deadlock
         */

        String lock1 = "piyush";
        String lock2 = "bajaj";

//        Thread thread1 = new Thread(() -> {
//            synchronized (lock1) {
//                System.out.println("Lock1 acquired by Thread1");
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                synchronized (lock2) {
//                    System.out.println("Lock2 acquired by Thread1");
//                }
//            }
//        }, "thread1");
//
//        Thread thread2 = new Thread(() -> {
//            synchronized (lock2) {
//                System.out.println("Lock2 acquired by Thread2");
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                synchronized (lock1) {
//                    System.out.println("Lock1 acquired by Thread2");
//                }
//            }
//        }, "thread1");
//
//        thread1.start();
//        thread2.start();

        // to fix deadlock, we have to make sure the locks acquired has to be in the same order
        Thread thread1 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Lock1 acquired by Thread1");
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock2) {
                    System.out.println("Lock2 acquired by Thread1");
                }
            }
        }, "thread1");

        Thread thread2 = new Thread(() -> {
            synchronized (lock1) {
                System.out.println("Lock1 acquired by Thread2");
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (lock2) {
                    System.out.println("Lock2 acquired by Thread2");
                }
            }
        }, "thread1");

        thread1.start();
        thread2.start();


    }
}

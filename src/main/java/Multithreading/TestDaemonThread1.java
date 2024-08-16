package Multithreading;

/**
 * Created by piyush.bajaj on 21/09/16.
 * <p>
 * Daesom thread in java is a service provider, that provides service to the user thread.
 * Its life depend on the mercy of user thread, i.e., when all the user thread dies, JVM terminates this thread automatically.
 * There are many Daemon threads which runs automatically, like gc, finalizer, etc.
 * It provides services to user threads for background supporting tasks. It has no role in life than to serve user threads.
 * Its life depends on user threads.
 * It is a low priority thread.
 * Q. Why JVM terminates the daemon thread if there is no user thread?
 * <p>
 * Ans. The sole purpose of the daemon thread is that it provides services to user thread for background supporting task.
 * If there is no user thread, why should JVM keep running this thread.
 * That is why JVM terminates the daemon thread if there is no user thread.
 * <p>
 * #The java.lang.Thread class provides two methods for java daemon thread.
 * <p>
 * public void setDaemon(boolean status): It is used to mark the current thread as daemon thread or user thread.
 * public boolean isDaemon(): It is used to check that current is daemon.
 */
public class TestDaemonThread1 extends Thread {
    public static void main(String[] args) {
        TestDaemonThread1 t1 = new TestDaemonThread1();
        TestDaemonThread1 t2 = new TestDaemonThread1();
        TestDaemonThread1 t3 = new TestDaemonThread1();

        t1.setDaemon(true);
        t1.start();
        //t1.setDaemon(true);
        /* If we want user thread to be Daemon thread it should not be started early, or else the will be thrown
        java.lang.IllegalThreadStateException
         */
        t2.start();
        t3.start();
    }

    public void run() {
        if (currentThread().isDaemon()) {
            System.out.println("Daemon thread Running...");
        } else {
            System.out.println("User thread work");
        }
    }
}

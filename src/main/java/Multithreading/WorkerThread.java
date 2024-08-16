package Multithreading;

/**
 * Created by piyush.bajaj on 21/09/16.
 */
class WorkerThread implements Runnable {
    private String message;

    public WorkerThread(String S) {
        this.message = S;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " (Start) message = " + message);
        process();
        System.out.println(Thread.currentThread().getName() + " (End)");
    }

    public void process() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

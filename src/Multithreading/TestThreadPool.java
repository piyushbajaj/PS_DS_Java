package Multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by piyush.bajaj on 21/09/16.
 */

public class TestThreadPool {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5); //creating a pool of 5 threads
        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThread("" + i);
            executor.execute(worker);//calling execute method of ExecutorService
        }
        executor.shutdown();
        /*
        This method shut downs the executor immediately.
        It doesn’t execute the pending tasks. It returns a list with all these pending tasks.
        The tasks that are running when you call this method continue with their execution,
        but the method doesn’t wait for their finalization.
         */
        while (!executor.isTerminated()) {   }
        //isTerminated(): This method returns true if you have called the shutdown() or shutdownNow() methods and
        // the executor finishes the process of shutting it down.

        System.out.println("Finished all threads");
    }
}

package Multithreading.Riddhi;

/**
 * Project: DSAlgo
 * Package: Multithreading.Riddhi
 * <p>
 * User: piyushbajaj
 * Date: 17/04/23
 * Time: 6:12 pm
 */
public class Thread2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread() + ", " + i);
        }
    }
}

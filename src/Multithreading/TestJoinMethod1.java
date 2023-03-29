package Multithreading;

/**
 * Created by piyush.bajaj on 21/09/16.
 * <p>
 * Join() method waits for the thread to die.
 */
public class TestJoinMethod1 extends Thread {
    public static void main(String[] args) {
        TestJoinMethod1 t1 = new TestJoinMethod1();
        TestJoinMethod1 t2 = new TestJoinMethod1();
        TestJoinMethod1 t3 = new TestJoinMethod1();

        t1.start();
        try {
            t1.join(
                1500); //when t1 is completes its task for 1500 miliseconds(3 times) then t2 and t3 starts executing.
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        t2.start();
        t3.start();
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println(i);
        }
    }
}

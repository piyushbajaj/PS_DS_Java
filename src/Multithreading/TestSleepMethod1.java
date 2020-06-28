package Multithreading;

/**
 * Created by piyush.bajaj on 21/09/16.
 */

/*
As you know well that at a time only one thread is executed.
If you sleep a thread for the specified time,the thread scheduler picks up another thread and so on.
 */
public class TestSleepMethod1 extends Thread{
    public void run(){
        for(int i = 1; i <5; i++){
            try {
                Thread.sleep(500);
            }
            catch(InterruptedException e) {
                System.out.println(e);

            }
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        TestSleepMethod1 t1 = new TestSleepMethod1();
        TestSleepMethod1 t2 = new TestSleepMethod1();

        t1.start();
        t2.start();
    }
}

/*
Now here, what if we give t1.run() and t2.run() instead. So invoking the run() method from the main thread, so the run()
method goes onto the current call stack instead of beginning a new call stack.
So here if we give t1.run() and t2.run() instead, then there will be no context switching because t1 and t2 will be considered as
normal object not thread object.
 */

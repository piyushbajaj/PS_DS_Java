package Multithreading;

/**
 * Created by piyush.bajaj on 01/04/18.
 */
public class TestClass {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.start();
        t2.start();
        System.out.print("3");
    }
}

class MyThread extends Thread {
    public String hel;

    public void run() {
        System.out.println(hel);
    }
}
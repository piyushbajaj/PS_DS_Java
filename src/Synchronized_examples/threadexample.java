package Synchronized_examples;

import java.util.Scanner;

/**
 * Created by piyush.bajaj on 16/04/18.
 * Link: https://www.geeksforgeeks.org/inter-thread-communication-java/
 */
public class threadexample {
    public static class PC{

        public void produce() throws InterruptedException{
            synchronized (this){
                System.out.println("Producer thread running");

                wait();

                System.out.println("Resume");
            }
        }

        public void consume() throws InterruptedException{
            Thread.sleep(1000);
            Scanner s = new Scanner(System.in);

            synchronized (this){
                System.out.println("Waiting for the return key");
                s.nextLine();
                System.out.println("Return key pressed");
                notify();

                Thread.sleep(2000);

            }
        }
    }

    public static void main(String[] args) {
        final PC pc = new PC();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consume();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }
}


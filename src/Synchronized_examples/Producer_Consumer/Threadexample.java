package Synchronized_examples.Producer_Consumer;

import java.util.LinkedList;

/**
 * Created by piyush.bajaj on 16/04/18.
 * Link: https://www.geeksforgeeks.org/producer-consumer-solution-using-threads-java/
 */
public class Threadexample {
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

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class PC{
        LinkedList<Integer> linkedList = new LinkedList<>();
        final int capacity = 2;

        public void produce() throws InterruptedException{
            int value = 0;
            while (true){
                synchronized (this){
                    while (linkedList.size() == capacity)
                        wait();

                    System.out.println("Producer produced: " + value);

                    linkedList.add(value++);

                    notify();

                    Thread.sleep(1000);

                }
            }
        }

        public void consume() throws InterruptedException{
            while (true){
                synchronized (this){
                    while (linkedList.size()== 0)
                        wait();

                    int temp = linkedList.removeFirst();

                    System.out.println("Consumer consumed: " + temp);

                    notify();

                    Thread.sleep(2000);

                }
            }
        }

    }
    }




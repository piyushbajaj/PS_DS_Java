package Multithreading;

/**
 * Created by piyush.bajaj on 01/03/17.
 */
public class TestCallRun extends Thread {
    public void run(){
        for(int i = 1; i < 5; i++){
            try {
                Thread.sleep(500);
            }
            catch (InterruptedException e){
                System.out.println(e);
            }
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        TestCallRun TC1 = new TestCallRun();
        TestCallRun TC2 = new TestCallRun();

        TC1.run();
        TC2.run();
    }
}

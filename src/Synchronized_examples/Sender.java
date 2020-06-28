package Synchronized_examples;

/**
 * Created by piyush.bajaj on 15/04/18.
 */
public class Sender {
    //Either we can put synchronized here or need to put in the run methog in ThreadedSend class

    public void send(String msg){
        System.out.println("Sending \t" + msg);
        try {
            Thread.sleep(1000);

        }
        catch (Exception e){
            System.out.println("Thread interrupted");
        }
        System.out.println("\n" + msg + " Sent");
    }


    // If it needs to be kept for some part of the method then this is the right way.
//    public void send(String msg){
//        synchronized (this) {
//            System.out.println("Sending \t" + msg);
//            try {
//                Thread.sleep(1000);
//            } catch (Exception e) {
//                System.out.println("Thread interrupted");
//            }
//            System.out.println("\n" + msg + " Sent");
//        }
//    }

}

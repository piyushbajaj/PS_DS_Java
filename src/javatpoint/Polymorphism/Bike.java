package javatpoint.Polymorphism;

/**
 * Created by piyush.bajaj on 24/02/17.
 */
public class Bike {
    void run() {
        System.out.println("running");
    }
}

class Splender extends Bike {


    public static void main(String args[]) {
        Bike b = new Splender();//upcasting
        b.run();
    }

    @Override
    void run() {
        System.out.println("running safely with 60km");
    }
}

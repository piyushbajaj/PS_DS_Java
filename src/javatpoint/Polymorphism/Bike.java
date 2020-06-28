package javatpoint.Polymorphism;

/**
 * Created by piyush.bajaj on 24/02/17.
 */
public class Bike {
    void run(){System.out.println("running");}
}

class Splender extends Bike{


    @Override
    void run(){System.out.println("running safely with 60km");}

    public static void main(String args[]){
        Bike b = new Splender();//upcasting
        b.run();
    }
}

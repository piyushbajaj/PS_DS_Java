package javatpoint;

/**
 * Created by piyush.bajaj on 26/11/16.
 */

abstract class Bike {
    abstract public void run();
}

public class abstractHonda extends Bike {
    public static void main(String[] args) {
        Bike obj = new abstractHonda();
        obj.run();
    }

    public void run() {
        System.out.println("running safely..");
    }

    public void start() {

    }
}



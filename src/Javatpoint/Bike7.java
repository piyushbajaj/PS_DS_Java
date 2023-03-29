package Javatpoint;

/**
 * Created by piyush.bajaj on 25/06/16.
 */
public class Bike7 {

    int speed;

    {
        speed = 50;
    }

    {
        speed = 10;
    }

    Bike7() {
        System.out.println("speed is " + speed);
    }

    public static void main(String args[]) {
        Bike7 b1 = new Bike7();
        Bike7 b2 = new Bike7();
    }
}

package DesignPattern.Factory_Car;

/**
 * Created by piyush.bajaj on 27/11/16.
 */
public class SmallCar implements Car {

    @Override
    public void construct() {
        System.out.println("Building Small car");
    }
}

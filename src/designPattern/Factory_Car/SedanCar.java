package designPattern.Factory_Car;

/**
 * Created by piyush.bajaj on 27/11/16.
 */
public class SedanCar implements Car {
    @Override
    public void construct(){
        System.out.println("Building Sedan car");
    }
}

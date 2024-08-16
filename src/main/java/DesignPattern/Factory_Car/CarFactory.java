package DesignPattern.Factory_Car;

/**
 * Created by piyush.bajaj on 27/11/16.
 */
public class CarFactory {
    public Car getCar(String strCar) {
        if (strCar == null) {
            return null;
        } else if (strCar.equalsIgnoreCase("SMALL")) {
            return new SmallCar();
        } else if (strCar.equalsIgnoreCase("SEDAN")) {
            return new SedanCar();
        } else if (strCar.equalsIgnoreCase("LUXURY")) {
            return new LuxuryCar();
        }

        return null;
    }
}

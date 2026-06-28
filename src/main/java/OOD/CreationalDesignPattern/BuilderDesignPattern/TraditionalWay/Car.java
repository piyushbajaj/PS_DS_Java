package OOD.CreationalDesignPattern.BuilderDesignPattern.TraditionalWay;

/**
 * Project: DSAlgo
 * Package: OOD.CreationalDesignPattern.BuilderDesignPattern.TraditionalWay
 * <p>
 * User: piyushbajaj
 * Date: 11/06/25
 * Time: 10:17 am
 */
public class Car {
    private String engine;
    private int wheels;
    private int seats;
    private String color;
    private boolean sunroof;
    private boolean navigationSystem;

    public Car(String engine, int wheels, int seats, String color, boolean sunroof, boolean navigationSystem) {
        this.engine = engine;
        this.wheels = wheels;
        this.seats = seats;
        this.color = color;
        this.sunroof = sunroof;
        this.navigationSystem = navigationSystem;
    }

    /*
      Problem #1: Passing Unnecessary Values

      Car car = new Car("V8", 4, 5, "Red", false, false); // The client needs to pass `false` for
      optional attributes
     */

    /*
      Problem #2: Constructor Overloading and Huge Combinations

      If a car has many optional attributes, you end up with multiple constructors, each for different combinations
      of parameters. This results in code duplication and leads to messy and unmanageable code.
     */

    /*
      public class Car {
        public Car(String engine, int wheels, int seats, String color,
            boolean sunroof, boolean navigationSystem) {
          ...
        }
        public Car(String engine, int wheels, int seats, String color) {
          ...
        }
        public Car(String engine, int wheels, int seats) {
          ...
        }
      }
     */
}

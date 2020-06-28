package SolidMaster.interface_segregation.good.src;

/**
 * Created by mrk on 4/7/14.
 */
public class Eagle implements FlyingCreature, FeatheredCreature {
    public String currentLocation;
    public int numberOfFeathers;

    public Eagle(int initialNumberOfFeathers) {
        this.numberOfFeathers = initialNumberOfFeathers;
    }

    public void fly() {
        this.currentLocation = "in the air";
    }

    public void molt() {
        this.numberOfFeathers -= 1;
    }
}

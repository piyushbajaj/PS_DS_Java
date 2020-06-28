package SolidMaster.liskov_substitution.good.src;

/**
 * Created by mrk on 4/8/14.
 */
public class PenthouseSuite {
    public int squareFootage;
    public int numberOfBedrooms;



    public PenthouseSuite() {
        this.numberOfBedrooms = 4;
    }

    public void setSquareFootage(int sqft) {
        this.squareFootage = sqft;
    }
}

package SolidMaster.liskov_substitution.good.src;

/**
 * Created by mrk on 4/8/14.
 */
public class Studio {
    public int squareFootage;
    public int numberOfRooms;

    public Studio() {
        this.numberOfRooms = 0;
    }

    public void setSquareFootage(int sqft) {
        this.squareFootage = sqft;
    }
}

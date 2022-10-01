package SolidMaster.interface_segregation.good.spec.PenguinTest;

import SolidMaster.interface_segregation.good.src.Penguin;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by mrk on 4/7/14.
 */
public class PenguinTest {
    @Test
    public void testItCanSwim() {
        Penguin penguin = new Penguin(5);
        penguin.swim();
        assertEquals("in the water", penguin.currentLocation);
    }

    @Test
    public void testItLosesFeathersQuickly() {
        Penguin penguin = new Penguin(5);
        penguin.molt();
        assertEquals(1, penguin.numberOfFeathers);
    }
}

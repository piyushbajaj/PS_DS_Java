package LLD.Concept_And_Coding.L1_Solid.Liskov_Substitution.Bad;

/**
 * Project: DS_Algo
 * Package: LLD.Concept_And_Coding.SOLID.Liskov_Substitution.Bad
 * <p>
 * User: piyushbajaj
 * Date: 13/01/23
 * Time: 7:48 pm
 */
public class MotorCycle implements Bike {

    boolean isEngineOn;
    int speed;

    @Override
    public void turnOnEngine() {
        isEngineOn = true;
    }

    @Override
    public void accelerate() {
        speed += 10;
    }
}

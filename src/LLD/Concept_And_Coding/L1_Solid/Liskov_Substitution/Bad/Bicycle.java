package LLD.Concept_And_Coding.L1_Solid.Liskov_Substitution.Bad;

/**
 * Project: DS_Algo
 * Package: LLD.Concept_And_Coding.SOLID.Liskov_Substitution.Bad
 * <p>
 * User: piyushbajaj
 * Date: 13/01/23
 * Time: 7:52 pm
 */
public class Bicycle implements Bike {
    @Override
    public void turnOnEngine() {
        throw new AssertionError("there is no engine");
    }

    @Override
    public void accelerate() {

    }
}

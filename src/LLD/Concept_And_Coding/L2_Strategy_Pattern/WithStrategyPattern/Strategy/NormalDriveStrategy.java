package LLD.Concept_And_Coding.L2_Strategy_Pattern.WithStrategyPattern.Strategy;

/**
 * Project: DS_Algo
 * Package: LLD.Concept_And_Coding.L2_Strategy_Pattern.WithStrategyPattern.Strategy
 * <p>
 * User: piyushbajaj
 * Date: 15/01/23
 * Time: 9:12 pm
 */
public class NormalDriveStrategy implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("Normal Drive Capability");
    }
}

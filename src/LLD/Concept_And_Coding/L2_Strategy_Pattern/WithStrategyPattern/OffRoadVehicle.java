package LLD.Concept_And_Coding.L2_Strategy_Pattern.WithStrategyPattern;

import LLD.Concept_And_Coding.L2_Strategy_Pattern.WithStrategyPattern.Strategy.SportsDriveStrategy;

/**
 * Project: DS_Algo
 * Package: LLD.Concept_And_Coding.L2_Strategy_Pattern.WithStrategyPattern
 * <p>
 * User: piyushbajaj
 * Date: 15/01/23
 * Time: 9:28 pm
 */
public class OffRoadVehicle extends Vehicle {
    OffRoadVehicle() {
        super(new SportsDriveStrategy());
    }
}

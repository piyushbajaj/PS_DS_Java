package LLD.Concept_And_Coding.L2_Strategy_Pattern.WithStrategyPattern;

import LLD.Concept_And_Coding.L2_Strategy_Pattern.WithStrategyPattern.Strategy.NormalDriveStrategy;

/**
 * Project: DS_Algo
 * Package: LLD.Concept_And_Coding.L2_Strategy_Pattern.WithStrategyPattern
 * <p>
 * User: piyushbajaj
 * Date: 15/01/23
 * Time: 9:34 pm
 */
public class GoodsVehicle extends Vehicle {
    GoodsVehicle() {
        super(new NormalDriveStrategy());
    }
}

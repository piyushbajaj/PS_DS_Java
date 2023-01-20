package LLD.Concept_And_Coding.L2_Strategy_Pattern.WithStrategyPattern;

import LLD.Concept_And_Coding.L2_Strategy_Pattern.WithStrategyPattern.Strategy.DriveStrategy;

/**
 * Project: DS_Algo
 * Package: LLD.Concept_And_Coding.L2_Strategy_Pattern.WithStrategyPattern
 * <p>
 * User: piyushbajaj
 * Date: 15/01/23
 * Time: 9:18 pm
 */
public class Vehicle {
    DriveStrategy driveObject;

    // this is known as constructor injection
    Vehicle(DriveStrategy driveObject) {
        this.driveObject = driveObject;
    }

    public void drive() {
        driveObject.drive();
    }
}

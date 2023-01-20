package LLD.Concept_And_Coding.L2_Strategy_Pattern.WithStrategyPattern;

/**
 * Project: DS_Algo
 * Package: LLD.Concept_And_Coding.L2_Strategy_Pattern.WithStrategyPattern.Strategy
 * <p>
 * User: piyushbajaj
 * Date: 15/01/23
 * Time: 9:13 pm
 */
public class Main {
    public static void main(String[] args) {
        Vehicle sportsVehicle = new SportsVehicle();
        sportsVehicle.drive();

        Vehicle goodsVehicle = new GoodsVehicle();
        goodsVehicle.drive();

        Vehicle offRoadVehicle = new OffRoadVehicle();
        offRoadVehicle.drive();
    }
}

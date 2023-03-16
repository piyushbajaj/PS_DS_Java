package LLD.Concept_And_Coding.L5_1_Abstract_Factory_Pattern;

/**
 * Project: DS_Algo
 * Package: LLD.Concept_And_Coding.L5_Abstract_Factory_Pattern
 * <p>
 * User: piyushbajaj
 * Date: 16/01/23
 * Time: 11:53 pm
 */
public class LuxuryFactory implements VehicleFactory {
    @Override
    public Vehicle getVehicle(String vehicle) {
        switch (vehicle) {
            case "LuxuryV1":
                return new LuxuryV1();
            case "LuxuryV2":
                return new LuxuryV2();
            default:
                return null;
        }
    }
}

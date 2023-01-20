package LLD.Concept_And_Coding.L5_Abstract_Factory_Pattern;

/**
 * Project: DS_Algo
 * Package: LLD.Concept_And_Coding.L5_Abstract_Factory_Pattern
 * <p>
 * User: piyushbajaj
 * Date: 16/01/23
 * Time: 11:54 pm
 */
public class OrdinaryFactory implements VehicleFactory {
    @Override
    public Vehicle getVehicle(String vehicle) {
        switch (vehicle) {
            case "OrdinaryV1":
                return new OrdinaryV1();
            case "OrdinaryV2":
                return new OrdinaryV2();
            default:
                return null;
        }
    }
}

package LLD.Educative.BuilderPattern;

/**
 * Project: DS_Algo
 * Package: LLD.Educative.BuilderPattern
 * <p>
 * User: piyushbajaj
 * Date: 14/12/22
 * Time: 7:25 pm
 */
public class Director {
    AircraftBuilder aircraftBuilder;

    public Director(AircraftBuilder aircraftBuilder) {
        this.aircraftBuilder = aircraftBuilder;
    }

    public void construct(boolean isPassenger) {
        aircraftBuilder.buildCockpit();
        aircraftBuilder.buildEngine();
        aircraftBuilder.buildWings();

        if (isPassenger) {
            aircraftBuilder.buildBathrooms();
        }
    }
}

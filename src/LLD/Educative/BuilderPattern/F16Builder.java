package LLD.Educative.BuilderPattern;

import LLD.F16;

/**
 * Project: DS_Algo
 * Package: LLD.Educative.BuilderPattern
 * <p>
 * User: piyushbajaj
 * Date: 14/12/22
 * Time: 7:24 pm
 */
public class F16Builder extends AircraftBuilder {
    F16 f16;

    @Override
    public void buildEngine() {
        // get F-16 an engine
        // f16.engine = new F16Engine();
    }

    @Override
    public void buildWings() {
        // get F-16 wings
        // f16.wings = new F16Wings();
    }

    @Override
    public void buildCockpit() {
        f16 = new F16();
        // get F-16 a cockpit
        // f16.cockpit = new F16Cockpit();
    }

    public IAircraft getResult() {
        return f16;
    }
}

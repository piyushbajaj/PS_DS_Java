package LLD.Educative.BuilderPattern;

/**
 * Project: DS_Algo
 * Package: LLD.Educative.BuilderPattern
 * <p>
 * User: piyushbajaj
 * Date: 14/12/22
 * Time: 7:56 pm
 */
public class Client {
    public static void main(String[] args) {
        F16Builder f16Builder = new F16Builder();
        Director director = new Director(f16Builder);
        director.construct(false);

        IAircraft f16 = f16Builder.getResult();
    }
}

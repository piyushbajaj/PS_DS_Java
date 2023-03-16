package LLD.Concept_And_Coding.L5_0_Factory_Pattern;

/**
 * Project: DS_Algo
 * Package: LLD.Concept_And_Coding.L5_Factory_Pattern
 * <p>
 * User: piyushbajaj
 * Date: 16/01/23
 * Time: 11:08 pm
 */
public class Main {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shapeObj = shapeFactory.getShape("CIRCLE");
        shapeObj.draw();
    }
}

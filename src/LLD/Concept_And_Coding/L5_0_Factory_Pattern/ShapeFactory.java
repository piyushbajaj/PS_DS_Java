package LLD.Concept_And_Coding.L5_0_Factory_Pattern;

/**
 * Project: DS_Algo
 * Package: LLD.Concept_And_Coding.L5_Factory_Pattern
 * <p>
 * User: piyushbajaj
 * Date: 16/01/23
 * Time: 11:04 pm
 */
public class ShapeFactory {
    Shape getShape(String input) {
        switch (input) {
            case "CIRCLE":
                return new Circle();
            case "SQUARE":
                return new Square();
            case "RECTANGLE":
                return new Rectangle();
            default:
                return null;
        }
    }
}

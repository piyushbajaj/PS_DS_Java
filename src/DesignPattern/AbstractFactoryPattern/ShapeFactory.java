package DesignPattern.AbstractFactoryPattern;

/**
 * Created by piyush.bajaj on 28/01/17.
 * Step 4: Create Factory Classes extending AbstractFactory to generate object of concrete clases based on given algo.
 */
public class ShapeFactory extends AbstractFactory {

    @Override
    public Shape getShape(String str) {
        if (str == null) {
            return null;
        }

        if (str.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (str.equalsIgnoreCase("SQUARE")) {
            return new Square();
        } else if (str.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        }

        return null;

    }

    @Override
    public Color getColor(String str) {
        return null;
    }
}

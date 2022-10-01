package designPattern.AbstractFactoryPattern;

/**
 * Created by piyush.bajaj on 28/01/17.
 * Step 4: Create Factory Classes extending AbstractFactory to generate object of concrete clases based on given algo.
 */


public class ColorFactory extends AbstractFactory {
    @Override
    public Color getColor(String str) {
        if (str == null)
            return null;

        if (str.equalsIgnoreCase("red"))
            return new Red();
        else if (str.equalsIgnoreCase("blue"))
            return new Blue();
        else if (str.equalsIgnoreCase("green"))
            return new Green();

        return null;

    }

    @Override
    public Shape getShape(String str) {
        return null;
    }
}

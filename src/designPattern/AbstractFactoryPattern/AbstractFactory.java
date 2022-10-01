package designPattern.AbstractFactoryPattern;

/**
 * Created by piyush.bajaj on 28/01/17.
 * Step 3: Create an Abstract class to get factories for Color and Shape Objects.
 */
public abstract class AbstractFactory {
    abstract Color getColor(String str);

    abstract Shape getShape(String str);
}

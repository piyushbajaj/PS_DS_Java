package designPattern.AbstractFactoryPattern;

/**
 * Created by piyush.bajaj on 28/01/17.
 * Step 5: Create a factory producer to get factory by passing information such as Shape or Color
 */
public class FactoryProducer  {

    public static AbstractFactory getFactory(String choice){
        if (choice == null)
            return null;

        if(choice.equalsIgnoreCase("shape"))
            return new ShapeFactory();

        else if(choice.equalsIgnoreCase("color"))
            return new ColorFactory();

        return null;

    }
}

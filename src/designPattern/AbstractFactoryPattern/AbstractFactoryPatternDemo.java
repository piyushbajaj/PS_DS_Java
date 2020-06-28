package designPattern.AbstractFactoryPattern;

/**
 * Created by piyush.bajaj on 28/01/17.
 * Step 6: Use factory producer to get AbstractFactory in order to get factories of concrete classes by passing info such
 * as type
 */
public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        //get shape factory
        AbstractFactory AbsShape = FactoryProducer.getFactory("shape");

        //get an object of Shape Circle
        Shape shape1 = AbsShape.getShape("circle");

        //call draw method of Shape Circle
        shape1.draw();

        //get color factory
        AbstractFactory AbsColor = FactoryProducer.getFactory("color");

        Color color1 = AbsColor.getColor("red");
        color1.fill();

    }
}

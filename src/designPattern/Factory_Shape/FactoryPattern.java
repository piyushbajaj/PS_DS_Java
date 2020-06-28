package designPattern.Factory_Shape;

/**
 * Created by piyush.bajaj on 26/11/16.
 */
public class FactoryPattern {
    public static void main(String[] args) {
        ShapeFactory SP = new ShapeFactory();

        //get an object of Circle and call its draw method.
        Shape shape1 =  SP.getShape("CIRCLE");
        shape1.draw();

        //get an object of Rectangle and call its draw method.
        Shape shape2 =  SP.getShape("RECTANGLE");
        shape2.draw();

        //get an object of Square and call its draw method.
        Shape shape3 =  SP.getShape("SQUARE");
        shape3.draw();
    }
}




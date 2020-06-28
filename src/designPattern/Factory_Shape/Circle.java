package designPattern.Factory_Shape;

/**
 * Created by piyush.bajaj on 26/11/16.
 */
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}

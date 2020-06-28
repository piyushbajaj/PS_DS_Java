package designPattern.Factory_Shape;

/**
 * Created by piyush.bajaj on 26/11/16.
 */
public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}

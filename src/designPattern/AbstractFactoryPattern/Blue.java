package designPattern.AbstractFactoryPattern;

/**
 * Created by piyush.bajaj on 28/01/17.
 * Step 2: Class implementing interfaces
 */
public class Blue implements Color {
    @Override
    public void fill(){
        System.out.println("Inside Blue::fill() method.");
    }
}

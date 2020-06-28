package designPattern.SingleTon;

/**
 * Created by piyush.bajaj on 28/01/17.
 */
public class SingletonPatternDemo {
    public static void main(String[] args) {
        SingleObject obj = SingleObject.getObject();
        //SingleObject obj1 = SingleObject.getObject1();
        obj.message();
        //obj1.message();
    }
}

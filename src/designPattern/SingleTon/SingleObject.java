package designPattern.SingleTon;

/**
 * Created by piyush.bajaj on 28/01/17.
 */
public class SingleObject {
    //create an object of SingleObject
    static SingleObject SO = new SingleObject();

    static SingleObject SO1 = new SingleObject();

    //make the constructor private so that this class cannot be
    //instantiated

    private SingleObject(){}

    //Get the only object available
    public static SingleObject getObject(){
        return SO;
    }

//    public static SingleObject getObject1(){
//        return SO1;
//    }

    public void message(){
        System.out.println("Hello World");
    }
}

package javatpoint;

/**
 * Created by piyush.bajaj on 26/11/16.
 */
public class ParentClass {
    public void displayMethod(String msg) {
        System.out.println(msg);
    }
}

class SubClass extends ParentClass {
    public static void main(String args[]) {
        SubClass obj = new SubClass();
        obj.displayMethod("Hey!!");
    }

    @Override
    public void displayMethod(String msg) {
        System.out.println("Message is: " + msg);
    }
}

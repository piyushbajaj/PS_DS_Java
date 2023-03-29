package javatpoint.Binding;

/**
 * Created by piyush.bajaj on 25/02/17.
 */

//Static Binding
public class Dog {
    public static void main(String args[]) {
        Dog d1 = new Dog();
        d1.eat();
    }

    private void eat() {
        System.out.println("dog is eating...");
    }
}

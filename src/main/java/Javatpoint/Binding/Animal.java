package Javatpoint.Binding;

/**
 * Created by piyush.bajaj on 25/02/17.
 */

//Dynamic Binding
public class Animal {
    void eat() {
        System.out.println("animal is eating...");
    }
}

class Dogs extends Animal {
    public static void main(String args[]) {
        Animal a = new Dogs();
        a.eat();
    }

    void eat() {
        System.out.println("dog is eating...");
    }
}

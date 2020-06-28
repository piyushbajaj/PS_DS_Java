package javatpoint.Binding;

/**
 * Created by piyush.bajaj on 25/02/17.
 */

//Static Binding
public class Dog {
    private void eat(){System.out.println("dog is eating...");}

    public static void main(String args[]){
        Dog d1=new Dog();
        d1.eat();
    }
}

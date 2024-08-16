package DesignPattern.StrategyPattern;

/**
 * Created by piyush.bajaj on 12/02/17.
 */
public class AnimalPlay {
    public static void main(String[] args) {

        Animal sparky = new Dog();
        Animal tweety = new Bird();

        System.out.println("Dog: " + sparky.tryToFly());
        System.out.println("Bird: " + tweety.tryToFly());

        //Now somehow Dod is ready to fly
        sparky.setFlyingType(new ItFlys());
        System.out.println("Dog: " + sparky.tryToFly());
    }
}

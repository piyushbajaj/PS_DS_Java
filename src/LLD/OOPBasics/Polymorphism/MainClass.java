package LLD.OOPBasics.Polymorphism;

/**
 * Created by bajajp on 24 Jun, 2022
 */
public class MainClass {

    public static void main(String[] args) {
        Bird bird = new Bird();
        bird.voice();
        Bird duck = new Duck();
        duck.voice();
    }
}

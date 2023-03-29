package designPattern.Basics;

/**
 * Created by piyush.bajaj on 10/02/17.
 */
public class Dog extends Animal {
    public Dog() {
        super();

        setSound("Bark");
    }

    public void digHole() {
        System.out.println("Dug a hole");
    }

    public void changeVar(int randNum) {
        randNum = 12;

        System.out.println("randNum in method: " + randNum);
    }

    private void bePrivate() {
        System.out.println("In a private method");
    }

    public void accesPrivate() {
        bePrivate();
    }
}

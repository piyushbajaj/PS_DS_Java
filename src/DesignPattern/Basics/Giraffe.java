package DesignPattern.Basics;

/**
 * Created by piyush.bajaj on 12/02/17.
 */
public class Giraffe extends Creature {

    private String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String newName) {
        name = newName;
    }

    @Override
    public int getWeight() {
        return 0;
    }

    @Override
    public void setWeight(int newWeight) {

    }
}

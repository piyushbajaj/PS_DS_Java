package DesignPattern.Basics;

/**
 * Created by piyush.bajaj on 10/02/17.
 */
public class Animal {
    private String name;
    private int weight;
    private String sound;

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        name = newName;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int newWeight) {
        if (newWeight > 0) {
            weight = newWeight;
        } else {
            System.out.println("Weight must be bigger than 0");
        }
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String newSound) {
        sound = newSound;
    }

}

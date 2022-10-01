package designPattern.Basics;

/**
 * Created by piyush.bajaj on 12/02/17.
 */
abstract public class Creature {

    protected String name;
    protected int weight;
    protected String sound;

    public abstract void setName(String newName);
    public abstract String getName();

    public abstract void setWeight(int newWeight);
    public abstract int getWeight();



}

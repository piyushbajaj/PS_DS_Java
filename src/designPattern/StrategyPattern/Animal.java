package designPattern.StrategyPattern;

/**
 * Created by piyush.bajaj on 10/02/17.
 */
public class Animal {
    private String name;
    private int weight;
    private String sound;

    //So instead of using interface in a tradition way, we use instance variable that is a subclass of the flies interface.
    //And Animal doesn't care what flyingType does, it just knows the behaviour is available to all of its subclasses
    public Flys flyingType;

    public void setName(String newName){
        name = newName;
    }

    public String getName(){
        return name;
    }

    public void setWeight(int newWeight){
        if(newWeight > 0)
            weight = newWeight;
        else
            System.out.println("Weight must be bigger than 0");
    }

    public int getWeight(){
        return weight;
    }

    public void setSound(String newSound){
        sound = newSound;
    }

    public String getSound(){
        return sound;
    }

    public String tryToFly(){
        return flyingType.fly();
    }

    //We can make this dynamic
    public void setFlyingType(Flys newFlyType){
        flyingType = newFlyType;
    }

}

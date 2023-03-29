package designPattern.StrategyPattern;

/**
 * Created by piyush.bajaj on 12/02/17.
 */
public class Bird extends Animal {
    public Bird() {
        super();
        setSound("Tweet");

        flyingType = new ItFlys();
    }
}

package DesignPattern.StrategyPattern;

/**
 * Created by piyush.bajaj on 12/02/17.
 */
public interface Flys {
    String fly();
}

//So here will add separate classes

class ItFlys implements Flys {

    public String fly() {
        return "Flying High";
    }
}


class CantFly implements Flys {

    public String fly() {
        return "I cant fly";
    }
}

package DesignPattern.Factory_Bill;

/**
 * Created by piyush.bajaj on 27/11/16.
 */
public class Commercial extends Plan {
    @Override
    public void getRate() {
        rate = 7.50;
    }
}

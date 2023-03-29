package designPattern.Factory_Bill;

/**
 * Created by piyush.bajaj on 27/11/16.
 */
public class Domestic extends Plan {

    @Override
    public void getRate() {
        rate = 3.50;
    }
}

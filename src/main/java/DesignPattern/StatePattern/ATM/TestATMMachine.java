package DesignPattern.StatePattern.ATM;

/**
 * Created by piyush.bajaj on 26/02/17.
 */
public class TestATMMachine {
    public static void main(String[] args) {
        ATMMachine atmMachine = new ATMMachine();

        atmMachine.insertCard();

        atmMachine.ejectCard();

        atmMachine.insertCard();

        //atmMachine.ejectCard();

        atmMachine.insertPin(1234);

        atmMachine.requestCash(1000);

        atmMachine.insertCard();

        atmMachine.insertPin(1234);

        atmMachine.requestCash(2000);
    }
}

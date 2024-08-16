package DesignPattern.StatePattern.ATM;

/**
 * Created by piyush.bajaj on 26/02/17.
 */
public class NoCard implements ATMState {

    ATMMachine atmMachine;

    NoCard(ATMMachine newAtmMachine) {
        atmMachine = newAtmMachine;

    }

    @Override
    public void insertCard() {
        System.out.println("Please enter a PIN");
        atmMachine.setAtmState(atmMachine.getHasCard());
    }

    @Override
    public void ejectCard() {
        System.out.println("Please enter a card first");
    }

    @Override
    public void insertPin(int pinEntered) {
        System.out.println("Please enter a card first");
    }

    @Override
    public void requestCash(int cashToWithdraw) {
        System.out.println("Please enter a card first");
    }
}

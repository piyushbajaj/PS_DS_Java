package DesignPattern.StatePattern.ATM;

/**
 * Created by piyush.bajaj on 26/02/17.
 */
public class NoCash implements ATMState {
    ATMMachine atmMachine;

    NoCash(ATMMachine newAtmMachine) {
        atmMachine = newAtmMachine;

    }

    @Override
    public void insertCard() {
        System.out.println("We don't have money");
    }

    @Override
    public void ejectCard() {
        System.out.println("We don't have money, you didn't enter a card");
    }

    @Override
    public void insertPin(int pinEntered) {
        System.out.println("We don't have money");
    }

    @Override
    public void requestCash(int cashToWithdraw) {
        System.out.println("We don't have money");
    }
}

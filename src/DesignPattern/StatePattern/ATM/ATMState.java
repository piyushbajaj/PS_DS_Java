package DesignPattern.StatePattern.ATM;

/**
 * Created by piyush.bajaj on 26/02/17.
 */
public interface ATMState {
    void insertCard();

    void ejectCard();

    void insertPin(int pinEntered);

    void requestCash(int cashToWithdraw);
}

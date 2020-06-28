package designPattern.StatePattern.ATM;

/**
 * Created by piyush.bajaj on 26/02/17.
 */
public class ATMMachine {
    ATMState hasCard;
    ATMState noCard;
    ATMState hasPin;
    ATMState noCash;

    ATMState atmState;

    int cashInMachine = 2000;
    boolean correctPinEntered = false;

    public ATMMachine(){
        hasCard = new HasCard(this);
        noCard = new NoCard(this);
        hasPin = new HasPin(this);
        noCash = new NoCash(this);

        atmState = noCard;

        if(cashInMachine < 0){
            atmState = noCash;
        }
    }

    public void setAtmState(ATMState newATMState){
        atmState = newATMState;
    }

    public void setCashInMachine(int newCash){
        cashInMachine = newCash;
    }

    public void insertCard(){
        atmState.insertCard();
    }

    public void ejectCard(){
        atmState.ejectCard();
    }

    public void insertPin(int newPin){
        atmState.insertPin(newPin);
    }

    public void requestCash(int newCashToWithdraw){
        atmState.requestCash(newCashToWithdraw);
    }

    public ATMState getHasCard(){
        return hasCard;
    }

    public ATMState getNoCard(){
        return noCard;
    }

    public ATMState getHasPin(){
        return hasPin;
    }

    public ATMState getNoCash(){
        return noCash;
    }

}

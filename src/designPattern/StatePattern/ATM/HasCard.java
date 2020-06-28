package designPattern.StatePattern.ATM;

/**
 * Created by piyush.bajaj on 26/02/17.
 */
public class HasCard implements ATMState {

    ATMMachine atmMachine;

    HasCard(ATMMachine newAtmMachine){
        atmMachine = newAtmMachine;
    }

    @Override
    public void insertCard() {
        System.out.println("You cannot insert more than 1 card");
    }

    @Override
    public void ejectCard() {
        System.out.println("Card Ejected");
        atmMachine.setAtmState(atmMachine.getNoCard());
    }

    @Override
    public void insertPin(int pinEntered) {
        if(pinEntered == 1234){
            System.out.println("Correct pin Entered");
            atmMachine.correctPinEntered = true;
            atmMachine.setAtmState(atmMachine.getHasPin());
        }
        else {
            System.out.println("Incorrect Pin");
            atmMachine.correctPinEntered = false;
            System.out.println("Card Ejected");
            atmMachine.setAtmState(atmMachine.getNoCard());
        }

    }

    @Override
    public void requestCash(int cashToWithdraw) {
        System.out.println("Enter Pin First");
    }
}

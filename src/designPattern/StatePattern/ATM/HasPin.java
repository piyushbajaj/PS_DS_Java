package designPattern.StatePattern.ATM;

/**
 * Created by piyush.bajaj on 26/02/17.
 */
public class HasPin implements ATMState {

    ATMMachine atmMachine;

    HasPin(ATMMachine newAtmMachine) {
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
        System.out.println("Already entered Pin");
    }

    @Override
    public void requestCash(int cashToWithdraw) {
        if (cashToWithdraw <= atmMachine.cashInMachine) {
            if (cashToWithdraw <= 0) {
                System.out.println("No balance");
                atmMachine.setAtmState(atmMachine.getNoCash());
            }

            System.out.println("Cash With-drawl in process for the amount " + cashToWithdraw);
            atmMachine.setCashInMachine(atmMachine.cashInMachine - cashToWithdraw);
            System.out.println("Transaction Successful!! So Card Ejected");
            atmMachine.setAtmState(atmMachine.getNoCard());
        } else {
            System.out.println("Please enter cash amount less than Total Cash Available");
            System.out.println("Card Ejected");
            atmMachine.setAtmState(atmMachine.getNoCard());
        }


    }
}

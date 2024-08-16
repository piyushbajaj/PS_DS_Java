package Javatpoint.Polymorphism;

/**
 * Created by piyush.bajaj on 25/02/17.
 */
public class Bank {
    float getRateOfInterest() {
        return 0;
    }
}

class SBI extends Bank {
    @Override
    float getRateOfInterest() {
        return 8.4f;
    }
}

class ICICI extends Bank {
    @Override
    float getRateOfInterest() {
        return 7.3f;
    }
}

class AXIS extends Bank {
    @Override
    float getRateOfInterest() {
        return 9.7f;
    }
}

class Polymorphism {
    public static void main(String args[]) {
        Bank b;
        b = new SBI();
        System.out.println("SBI Rate of Interest: " + b.getRateOfInterest());
        b = new ICICI();
        System.out.println("ICICI Rate of Interest: " + b.getRateOfInterest());
        b = new AXIS();
        System.out.println("AXIS Rate of Interest: " + b.getRateOfInterest());
    }
}

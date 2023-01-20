package LLD.JavaConcurrency;

/**
 * Project: DS_Algo
 * Package: LLD.JavaConcurrency
 * <p>
 * User: piyushbajaj
 * Date: 19/01/23
 * Time: 11:39 pm
 */
public class Main {
    public static void main(String[] args) {
        final State state = new State(PrinterType.ODD);
        final Printer oddPrinter = new Printer(1, 2, state, PrinterType.ODD, PrinterType.EVEN, 50);
        final Printer evenPrinter = new Printer(2, 2, state, PrinterType.EVEN, PrinterType.ODD, 50);

        Thread thread1 = new Thread(oddPrinter);
        Thread thread2 = new Thread(evenPrinter);

        thread1.start();
        thread2.start();
    }
}

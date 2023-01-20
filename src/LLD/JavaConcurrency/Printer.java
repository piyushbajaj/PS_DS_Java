package LLD.JavaConcurrency;

/**
 * Project: DS_Algo
 * Package: LLD.JavaConcurrency
 * <p>
 * User: piyushbajaj
 * Date: 19/01/23
 * Time: 11:26 pm
 */
public class Printer implements Runnable {
    private int currentValue;
    private final int step;
    private final State state;
    private final PrinterType currentType;
    private final PrinterType nextType;
    private final int maxValue;

    public Printer(int currentValue, int step, State state, PrinterType currentType, PrinterType nextType,
                   int maxValue) {
        this.currentValue = currentValue;
        this.step = step;
        this.state = state;
        this.currentType = currentType;
        this.nextType = nextType;
        this.maxValue = maxValue;
    }

    @Override
    public void run() {
        while (currentValue <= maxValue) {
            synchronized (state) {
                while (state.getNextToPrint() != currentType) {
                    try {
                        state.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                System.out.println(currentType + ": " + currentValue);
                currentValue += step;
                state.setNextToPrint(nextType);
                state.notifyAll();
            }
        }
    }
}

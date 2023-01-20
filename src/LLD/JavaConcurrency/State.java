package LLD.JavaConcurrency;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * Project: DS_Algo
 * Package: LLD.JavaConcurrency
 * <p>
 * User: piyushbajaj
 * Date: 19/01/23
 * Time: 11:26 pm
 */
@Getter
@Setter
public class State {
    private PrinterType nextToPrint;

    public State(@NonNull final PrinterType nextToPrint) {
        this.nextToPrint = nextToPrint;
    }
}

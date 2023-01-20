package LLD.Concept_And_Coding.L1_Solid.Dependency_Inversion.Bad;

/**
 * Project: DS_Algo
 * Package: LLD.Concept_And_Coding.SOLID.Dependency_Inversion.Bad
 * <p>
 * User: piyushbajaj
 * Date: 13/01/23
 * Time: 8:34 pm
 * <p>
 * Problem:
 * This class directly using concrete class like WiredKeyboard, WiredMouse. So tomorrow if BluetoothKeyboard comes
 * then there will be issue.
 */
public class MacBook {
    private final WiredKeyboard keyboard;
    private final WiredMouse mouse;

    public MacBook() {
        keyboard = new WiredKeyboard();
        mouse = new WiredMouse();
    }
}

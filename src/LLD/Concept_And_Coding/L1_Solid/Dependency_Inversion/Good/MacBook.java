package LLD.Concept_And_Coding.L1_Solid.Dependency_Inversion.Good;

/**
 * Project: DS_Algo
 * Package: LLD.Concept_And_Coding.SOLID.Dependency_Inversion.Good
 * <p>
 * User: piyushbajaj
 * Date: 13/01/23
 * Time: 8:40 pm
 * <p>
 * Benefits:
 * - Dependent on interfaces rather than concrete classes
 */
public class MacBook {
    private final Keyboard keyboard;
    private final Mouse mouse;

    MacBook(Keyboard keyboard, Mouse mouse) {
        this.keyboard = keyboard;
        this.mouse = mouse;
    }
}

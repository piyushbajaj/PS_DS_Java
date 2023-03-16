package LLD.Concept_And_Coding.L1_Solid.Single_Responsibility.Good;

/**
 * Project: DS_Algo
 * Package: LLD.Concept_And_Coding.SOLID.Single_Responsibility.Good
 * <p>
 * User: piyushbajaj
 * Date: 13/01/23
 * Time: 5:52 pm
 * <p>
 * We have divided the based on Single Responsibility
 */
public class Invoice {
    private final Marker marker;
    private final int quantity;

    public Invoice(Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }

    public int calculateTotal() {
        return ((marker.price) * this.quantity);
    }
}

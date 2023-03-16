package LLD.Concept_And_Coding.L1_Solid.Single_Responsibility.Bad;

/**
 * Project: DS_Algo
 * Package: LLD.Concept_And_Coding.SOLID.Single_Responsibility
 * <p>
 * A class should have only 1 reason to change
 * <p>
 * User: piyushbajaj
 * Date: 13/01/23
 * Time: 5:42 pm
 * <p>
 * Reason why this is Bad?
 * 1. Invoice class will get change, if in future GST get introduce here, so calculation logic will get defer.
 * 2. If printing logic gets change, then this class will get change again
 * 3. Save to DB, can also be used for Save to File, so this class will again get impacted
 */
public class Invoice {
    private final Marker marker;
    private final int quantity;
    Invoice(Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }

    public int calculateTotal() {
        return ((marker.price) * this.quantity);
    }

    public void printInvoice() {
        // print the invoice
    }

    public void saveToDB() {
        // Save the data into DB
    }
}

package LLD.Concept_And_Coding.L1_Solid.Single_Responsibility.Good;

/**
 * Project: DS_Algo
 * Package: LLD.Concept_And_Coding.SOLID.Single_Responsibility.Good
 * <p>
 * User: piyushbajaj
 * Date: 13/01/23
 * Time: 5:54 pm
 */
public class InvoiceDao {
    Invoice invoice;
    public InvoiceDao(Invoice invoice) {
        this.invoice = invoice;
    }
    public void saveToDB() {
        // Save the data into DB
    }
}

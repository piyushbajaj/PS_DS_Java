package LLD.Concept_And_Coding.L1_Solid.Open_Closed.Good;

import LLD.Concept_And_Coding.L1_Solid.Single_Responsibility.Good.Invoice;

/**
 * Project: DS_Algo
 * Package: LLD.Concept_And_Coding.SOLID.Open_Closed.Good
 * <p>
 * User: piyushbajaj
 * Date: 13/01/23
 * Time: 6:26 pm
 */
public class FileInvoiceDao implements InvoiceDao {
    @Override
    public void save(Invoice invoice) {
        // save to file
    }
}

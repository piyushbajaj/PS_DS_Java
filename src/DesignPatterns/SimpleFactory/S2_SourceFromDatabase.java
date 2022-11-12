package DesignPatterns.SimpleFactory;

/**
 * Project: DS_Algo
 * Package: DesignPatterns.Factory
 * <p>
 * User: piyushbajaj
 * Date: 23/10/22
 * Time: 7:45 pm
 * <p>
 */
public class S2_SourceFromDatabase implements S1_IngestToDatabase {
    @Override
    public void ingestData() {
        System.out.println("Read from other database and ingest");
    }
}

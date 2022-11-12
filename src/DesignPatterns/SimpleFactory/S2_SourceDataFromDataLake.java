package DesignPatterns.SimpleFactory;

/**
 * Project: DS_Algo
 * Package: DesignPatterns.Factory
 * <p>
 * User: piyushbajaj
 * Date: 23/10/22
 * Time: 7:32 pm
 * <p>
 */
public class S2_SourceDataFromDataLake implements S1_IngestToDatabase {
    @Override
    public void ingestData() {
        System.out.println("Get data from Data Lake and ingest");
    }
}

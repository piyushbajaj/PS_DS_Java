package DesignPatterns.SimpleFactory;

/**
 * Project: DS_Algo
 * Package: DesignPatterns.Factory
 * <p>
 * User: piyushbajaj
 * Date: 23/10/22
 * Time: 7:30 pm
 * <p>
 */
public class S2_SourceDataFromFile implements S1_IngestToDatabase {
    @Override
    public void ingestData() {
        System.out.println("Reads from file and ingests data");
    }
}

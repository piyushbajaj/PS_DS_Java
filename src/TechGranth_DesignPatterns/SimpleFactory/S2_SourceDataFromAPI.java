package TechGranth_DesignPatterns.SimpleFactory;

/**
 * Project: DS_Algo
 * Package: DesignPatterns.Factory
 * <p>
 * User: piyushbajaj
 * Date: 23/10/22
 * Time: 7:31 pm
 * <p>
 */
public class S2_SourceDataFromAPI implements S1_IngestToDatabase {
    @Override
    public void ingestData() {
        System.out.println("Read from API and ingest");
    }
}

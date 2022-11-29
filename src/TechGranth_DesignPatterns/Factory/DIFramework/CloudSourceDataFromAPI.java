package TechGranth_DesignPatterns.Factory.DIFramework;

/**
 * Project: DS_Algo
 * Package: TechGranth_DesignPatterns.Factory.DIFramework
 * <p>
 * User: piyushbajaj
 * Date: 24/11/22
 * Time: 2:34 pm
 */
public class CloudSourceDataFromAPI implements S1_IngestToDatabase {
    @Override
    public void ingestData() {
        System.out.println("Cloud: Pull data from api and ingest");
    }
}

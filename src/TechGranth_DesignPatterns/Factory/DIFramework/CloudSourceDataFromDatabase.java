package TechGranth_DesignPatterns.Factory.DIFramework;

/**
 * Project: DS_Algo
 * Package: TechGranth_DesignPatterns.Factory.DIFramework
 * <p>
 * User: piyushbajaj
 * Date: 24/11/22
 * Time: 2:39 pm
 */
public class CloudSourceDataFromDatabase implements S1_IngestToDatabase{
    @Override
    public void ingestData() {
        System.out.println("Cloud: Source data from database and ingest in cloud storage");
    }
}

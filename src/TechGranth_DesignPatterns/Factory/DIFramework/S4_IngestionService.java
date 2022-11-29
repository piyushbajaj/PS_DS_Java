package TechGranth_DesignPatterns.Factory.DIFramework;

/**
 * Project: DS_Algo
 * Package: DesignPatterns.Factory
 * <p>
 * User: piyushbajaj
 * Date: 23/10/22
 * Time: 7:35 pm
 * <p>
 */
public interface S4_IngestionService {
    default void ingestDataToMyDatabase(String source) {
//        SourceDataFromFile sourceDataFromFile = new SourceDataFromFile();
        S1_IngestToDatabase sourceObject = getInstanceOfSource(source);
        sourceObject.ingestData();
    }

    S1_IngestToDatabase getInstanceOfSource(String source);
}

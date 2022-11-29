package TechGranth_DesignPatterns.SimpleFactory;

/**
 * Project: DS_Algo
 * Package: DesignPatterns.Factory
 * <p>
 * User: piyushbajaj
 * Date: 23/10/22
 * Time: 7:35 pm
 * <p>
 */
public class S4_IngestionService {

    private S3_FactoryOfSource s3FactoryOfSource;

    public S4_IngestionService(S3_FactoryOfSource s3FactoryOfSource) {
        this.s3FactoryOfSource = s3FactoryOfSource;
    }

    public void ingestDataToMyDatabase(String source) {
//        SourceDataFromFile sourceDataFromFile = new SourceDataFromFile();
        S1_IngestToDatabase sourceObject = s3FactoryOfSource.getInstanceOfSource(source);
        sourceObject.ingestData();
    }
}

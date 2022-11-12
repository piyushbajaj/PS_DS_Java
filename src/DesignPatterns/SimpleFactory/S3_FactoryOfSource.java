package DesignPatterns.SimpleFactory;

/**
 * Project: DS_Algo
 * Package: DesignPatterns.Factory
 * <p>
 * User: piyushbajaj
 * Date: 23/10/22
 * Time: 7:53 pm
 * <p>
 */
public class S3_FactoryOfSource {
    S1_IngestToDatabase sourceSystemObject = null;

    public S1_IngestToDatabase getInstanceOfSource(String source) {
        if (source.equals("API")) {
            sourceSystemObject = new S2_SourceDataFromAPI();
        } else if (source.equals("FILE")) {
            sourceSystemObject = new S2_SourceDataFromFile();
        } else if (source.equals("DATALAKE")) {
            sourceSystemObject = new S2_SourceDataFromDataLake();
        } else if (source.equals("DATABASE")) {
            sourceSystemObject = new S2_SourceFromDatabase();
        }

        return sourceSystemObject;
    }
}

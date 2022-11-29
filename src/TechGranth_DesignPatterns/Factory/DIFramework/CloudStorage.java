package TechGranth_DesignPatterns.Factory.DIFramework;

/**
 * Project: DS_Algo
 * Package: TechGranth_DesignPatterns.Factory.DIFramework
 * <p>
 * User: piyushbajaj
 * Date: 24/11/22
 * Time: 2:37 pm
 */
public class CloudStorage implements S4_IngestionService {
    @Override
    public S1_IngestToDatabase getInstanceOfSource(String source) {
        if (source.equals("API")) {
            return new CloudSourceDataFromAPI();
        } else if (source.equals("FILE")) {
            return new CloudSourceDataFromFile();
        }
//         else if (source.equals("DATALAKE")) {
//            return new S2_SourceDataFromDataLake();}
        else if (source.equals("DATABASE")) {
            return new CloudSourceDataFromDatabase();
        }

        return null;
    }
}

package TechGranth_DesignPatterns.SimpleFactory;

/**
 * Project: DS_Algo
 * Package: DesignPatterns.Factory
 * <p>
 * User: piyushbajaj
 * Date: 23/10/22
 * Time: 7:36 pm
 * <p>
 */
public class S5_FactoryMain {
    public static void main(String[] args) {
        S4_IngestionService s4IngestionService = new S4_IngestionService(new S3_FactoryOfSource());
        s4IngestionService.ingestDataToMyDatabase("API");
        s4IngestionService.ingestDataToMyDatabase("DATALAKE");
        s4IngestionService.ingestDataToMyDatabase("FILE");
        s4IngestionService.ingestDataToMyDatabase("DATABASE");
    }
}

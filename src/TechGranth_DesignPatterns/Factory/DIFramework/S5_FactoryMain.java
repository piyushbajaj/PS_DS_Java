package TechGranth_DesignPatterns.Factory.DIFramework;

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

        StorageFactory storageFactory = new StorageFactory();
        S4_IngestionService onPremiseObject = storageFactory.getStorageService("ONPREMISE");
//        onPremiseObject.ingestDataToMyDatabase("API");
//        onPremiseObject.ingestDataToMyDatabase("DATALAKE");
        onPremiseObject.ingestDataToMyDatabase("FILE");
//        onPremiseObject.ingestDataToMyDatabase("DATABASE");

        S4_IngestionService cloudObject = storageFactory.getStorageService("CLOUD");
        cloudObject.ingestDataToMyDatabase("API");
//        cloudObject.ingestDataToMyDatabase("DATALAKE");
//        cloudObject.ingestDataToMyDatabase("FILE");
//        cloudObject.ingestDataToMyDatabase("DATABASE");
    }
}

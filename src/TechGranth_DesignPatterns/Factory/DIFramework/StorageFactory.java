package TechGranth_DesignPatterns.Factory.DIFramework;

/**
 * Project: DS_Algo
 * Package: TechGranth_DesignPatterns.Factory.DIFramework
 * <p>
 * User: piyushbajaj
 * Date: 24/11/22
 * Time: 3:30 pm
 */
public class StorageFactory {

    public S4_IngestionService getStorageService(String storageType) {
        if (storageType.equals("CLOUD")) {
            return new CloudStorage();
        } else if (storageType.equals("ONPREMISE")) {
            return new OnPremiseStorage();
        }
        return null;
    }
}

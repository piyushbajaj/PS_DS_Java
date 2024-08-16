package Multithreading.Riddhi.Volatile;

/**
 * Project: DSAlgo
 * Package: Multithreading.Riddhi.Volatile
 * <p>
 * User: piyushbajaj
 * Date: 18/04/23
 * Time: 12:30 pm
 */
public class TVSet {
    private static volatile TVSet tvSetInstance = null;

    private TVSet() {
        System.out.println("TV Set instantiated");
    }

    public static TVSet getTvSetInstance() {
        if (tvSetInstance == null) {
            synchronized (TVSet.class) {
                if (tvSetInstance == null) {
                    tvSetInstance = new TVSet();
                }
            }
        }
        return tvSetInstance;
    }
}

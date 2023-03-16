package LLD.UditTutorial.LRU_Cache.policies;

/**
 * Project: DS_Algo
 * Package: LLD.UditTutorial.LRU_Cache.policies
 * <p>
 * User: piyushbajaj
 * Date: 13/03/23
 * Time: 2:14 pm
 * <p>
 * Interface for defining eviction policies
 *
 * @param <Key> Type of Key.
 */
public interface EvictionPolicy<Key> {

    void keyAccessed(Key key);

    /**
     * Evict key from eviction policy and return it
     */
    Key evictKey();
}

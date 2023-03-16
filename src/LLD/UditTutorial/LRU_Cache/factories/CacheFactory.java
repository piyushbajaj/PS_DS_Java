package LLD.UditTutorial.LRU_Cache.factories;

import LLD.UditTutorial.LRU_Cache.Cache;
import LLD.UditTutorial.LRU_Cache.policies.LRUEvictionPolicy;
import LLD.UditTutorial.LRU_Cache.storage.HashMapBasedStorage;

/**
 * Project: DS_Algo
 * Package: LLD.UditTutorial.LRU_Cache.factories
 * <p>
 * User: piyushbajaj
 * Date: 13/03/23
 * Time: 3:41 pm
 */
public class CacheFactory<Key, Value> {

    public Cache<Key, Value> defaultCache() {
        return new Cache<>(new LRUEvictionPolicy<Key>(), new HashMapBasedStorage<Key, Value>());
    }
}

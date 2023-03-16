package LLD.UditTutorial.LRU_Cache;

import LLD.UditTutorial.LRU_Cache.exceptions.NotFoundException;
import LLD.UditTutorial.LRU_Cache.exceptions.StorageFullException;
import LLD.UditTutorial.LRU_Cache.policies.EvictionPolicy;
import LLD.UditTutorial.LRU_Cache.storage.Storage;

/**
 * Project: DS_Algo
 * Package: LLD.UditTutorial.LRU_Cache
 * <p>
 * User: piyushbajaj
 * Date: 13/03/23
 * Time: 2:06 pm
 */
public class Cache<Key, Value> {
    private final EvictionPolicy<Key> evictionPolicy;
    private final Storage<Key, Value> storage;

    public Cache(EvictionPolicy<Key> evictionPolicy, Storage<Key, Value> storage) {
        this.evictionPolicy = evictionPolicy;
        this.storage = storage;
    }

    public void put(Key key, Value value) {
        try {
            this.storage.add(key, value);
            this.evictionPolicy.keyAccessed(key);
        } catch (StorageFullException exception) {
            System.out.println("Got storage full, will try to evict");
            Key keyToRemove = evictionPolicy.evictKey();
            if (keyToRemove == null) {
                throw new RuntimeException("Unexpected State. Storage full and no key to evict");
            }
            this.storage.remove(keyToRemove);
        }
    }

    public Value get(Key key) {
        try {
            Value value = this.storage.get(key);
            this.evictionPolicy.keyAccessed(key);
            return value;
        } catch (NotFoundException notFoundException) {
            System.out.println("Tried to access non-existing key.");
            return null;
        }
    }
}

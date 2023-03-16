package LLD.UditTutorial.LRU_Cache.storage;

import java.util.HashMap;
import java.util.Map;

import LLD.UditTutorial.LRU_Cache.exceptions.NotFoundException;
import LLD.UditTutorial.LRU_Cache.exceptions.StorageFullException;

/**
 * Project: DS_Algo
 * Package: LLD.UditTutorial.LRU_Cache.storage
 * <p>
 * User: piyushbajaj
 * Date: 13/03/23
 * Time: 2:11 pm
 */
public class HashMapBasedStorage<Key, Value> implements Storage<Key, Value> {

    Map<Key, Value> mp = new HashMap<>();

    @Override
    public void add(Key key, Value value) throws StorageFullException {
        mp.put(key, value);
    }

    @Override
    public void remove(Key key) throws NotFoundException {
        mp.remove(key);
    }

    @Override
    public Value get(Key key) throws NotFoundException {
        return mp.get(key);
    }
}

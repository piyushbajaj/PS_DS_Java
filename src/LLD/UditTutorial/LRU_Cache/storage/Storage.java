package LLD.UditTutorial.LRU_Cache.storage;

import LLD.UditTutorial.LRU_Cache.exceptions.StorageFullException;

/**
 * Project: DS_Algo
 * Package: LLD.UditTutorial.LRU_Cache.storage
 * <p>
 * User: piyushbajaj
 * Date: 13/03/23
 * Time: 2:08 pm
 */
public interface Storage<Key, Value> {
    public void add(Key key, Value value) throws StorageFullException;

    public void remove(Key key);

    public Value get(Key key);
}

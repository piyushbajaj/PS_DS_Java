package LLD.Concept_And_Coding.HashMap_Internals;

import lombok.Getter;
import lombok.Setter;

/**
 * Project: DS_Algo
 * Package: LLD.Concept_And_Coding.HashMap_Internals
 * <p>
 * User: piyushbajaj
 * Date: 20/01/23
 * Time: 1:23 pm
 */
@Getter
@Setter

/**
 * Put TC: O(1)
 * Get TC: O(1)
 */
public class MyHashMap<K, V> {
    private static final int INITIAL_SIZE = 1 << 4; // 2^4 -> 16
    private static final int MAXIMUM_CAPACITY = 1 << 30; // 2 ^ 30, because it has to be less than 2^31-1
    public Entry<K, V>[] hashTable;

    // default constructor
    public MyHashMap() {
        hashTable = new Entry[INITIAL_SIZE];
    }

    // parameter constructor
    public MyHashMap(int capacity) {
        int tableSize = tableSizeFor(capacity);
        hashTable = new Entry[tableSize];
    }

    public static void main(String[] args) {
        MyHashMap<Integer, String> map = new MyHashMap<>(7);
        map.put(1, "hi");
        map.put(2, "my");
        map.put(3, "name");
        map.put(4, "is");
        map.put(5, "Piyush");
        map.put(6, "how");
        map.put(7, "are");
        map.put(8, "you");
        map.put(9, "friends");
        map.put(10, "?");
        System.out.println(map.get(8));
//        map.delete(3);
//        System.out.println(map.get(3));

//        System.out.println("14 >>> 1: ");
//        System.out.println(14 | 14 >>> 1);
    }

    /**
     * Whatever the capacity is passed, we have to make sure we are passing to the hash table in 2 power, so for e.g
     * ., if capacity = 7, then 2^3 is the right capacity over here. This function just gets the next bigger 2 power
     * after the given capacity
     * Integer is 32 bit
     *
     * @param cap
     * @return
     */
    public final int tableSizeFor(int cap) {
        int n = cap - 1;
        n = n | n >>> 1;
        n = n | n >>> 2;
        n = n | n >>> 4;
        n = n | n >>> 8;
        n = n | n >>> 16;

        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    public void put(K key, V value) {
        int hashCode = key.hashCode() % hashTable.length;
        Entry<K, V> node = hashTable[hashCode];

        if (node == null) {
            Entry<K, V> newNode = new Entry<K, V>(key, value);
            hashTable[hashCode] = newNode;
        } else {
            // Collision
            Entry<K, V> prevNode = node;

            while (node != null) {
                // replace if the key is existent
                if (node.key == key) {
                    node.value = value;
                    return;
                }
                // Due to Collision
                prevNode = node;
                node = node.next;
            }
            prevNode.next = new Entry<K, V>(key, value);
        }
    }

    public V get(K key) {
        int hashCode = key.hashCode() % hashTable.length;
        Entry<K, V> node = hashTable[hashCode];

        while (node != null) {
            if (node.key == key) {
                return node.value;
            }
            // Due to Collision
            node = node.next;
        }
        return null;
    }

    public void delete(K key) {
        int hashCode = key.hashCode() % hashTable.length;
        Entry<K, V> node = hashTable[hashCode];
        Entry<K, V> prevNode = node;

        while (node != null) {
            if (node.key == key) {
                prevNode.next = node.next;
            }
            prevNode = node;
            node = node.next;
        }
    }

    // Linked List for each index in the list
    static class Entry<K, V> {
        public K key;
        public V value;
        public Entry<K, V> next;

        Entry(K k, V v) {
            this.key = k;
            this.value = v;
            this.next = null;
        }
    }
}

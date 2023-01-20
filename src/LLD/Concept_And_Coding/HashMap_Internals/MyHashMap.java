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
public class MyHashMap<K, V> {

    private static final int INITIAL_SIZE = 1 << 4; // 2^4 -> 16
    private static final int MAXIMUM_CAPACITY = 1 << 30; // 2 ^ 30, because it has to be less than 2^31-1

    public Entry[] hashTable;

    public MyHashMap() {
        hashTable = new Entry[INITIAL_SIZE];
    }

    static class Entry<K, V> {
        public K key;
        public V value;
        public Entry next;

        Entry(K k, V v) {
            this.key = k;
            this.value = v;
            this.next = null;
        }
    }

    public void put(K key, V value) {
        int hashCode = key.hashCode() % hashTable.length;
        Entry node = hashTable[hashCode];

        if (node == null) {
            Entry newNode = new Entry(key, value);
            hashTable[hashCode] = newNode;
        } else {
            Entry prevNode = node;

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
            prevNode.next = new Entry(key, value);
        }
    }

    public V get(K key) {
        int hashCode = key.hashCode() % hashTable.length;
        Entry node = hashTable[hashCode];

        while (node != null) {
            if (node.key == key) {
                return (V) node.value;
            }
            // Due to Collision
            node = node.next;
        }
        return null;
    }

    public void delete(K key) {
        int hashCode = key.hashCode() % hashTable.length;
        Entry node = hashTable[hashCode];
        Entry prevNode = node;

        while (node != null) {
            if (node.key == key) {
                prevNode.next = node.next;
            }
            prevNode = node;
            node = node.next;
        }
    }

    public static void main(String[] args) {
        MyHashMap<Integer, String> map = new MyHashMap<>();
        map.put(1, "Piyush");
        map.put(2, "Kavya");
        map.put(3, "Sonam");
        System.out.println(map.get(3));
        map.delete(3);
        System.out.println(map.get(3));
    }
}

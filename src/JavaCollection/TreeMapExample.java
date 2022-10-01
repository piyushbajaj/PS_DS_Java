package JavaCollection;

import java.util.TreeMap;
import java.util.Map;

/**
 * Created by piyush.bajaj on 30/07/17.

 Java TreeMap class implements the Map interface by using a tree. It provides an efficient means of storing key/value
 pairs in sorted order.

 The important points about Java TreeMap class are:

 A TreeMap contains values based on the key. It implements the NavigableMap interface and extends AbstractMap class.
 It contains only unique elements.
 It cannot have null key but can have multiple null values.
 It is same as HashMap instead maintains ascending order.

 public class TreeMap<K,V> extends AbstractMap<K,V> implements NavigableMap<K,V>, Cloneable, Serializable

 */
public class TreeMapExample {

    public static void main(String[] args) {
        TreeMap<Integer, String> tree = new TreeMap<>();
        tree.put(100,"Amit");
        tree.put(102,"Ravi");
        tree.put(101,"Vijay");
        tree.put(103,"Rahul");

        for(Map.Entry e: tree.entrySet()){
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }

}

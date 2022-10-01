package JavaCollection;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by bajajp on 19 Sep, 2022
 */
public class LinkedHashMapExample {


    public static void main(String[] args) {
        Map<Integer, Integer> linkedHashMap = new LinkedHashMap<>();

        linkedHashMap.put(1, 100);
        linkedHashMap.put(2, 101);
        linkedHashMap.put(3, 102);

        if (linkedHashMap.containsKey(1)) {
            linkedHashMap.remove(1);
            linkedHashMap.put(1, 102);
        }



        for (Map.Entry m : linkedHashMap.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }
}

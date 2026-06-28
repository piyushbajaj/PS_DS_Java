package Java_Basics;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Project: DSAlgo
 * Package: Java_Basics
 * <p>
 * User: piyushbajaj
 * Date: 11/05/25
 * Time: 9:53 am
 */
public class MapSort {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 50);
        map.put("banana", 10);
        map.put("orange", 30);

        // Sort by value (ascending)
//        Map<String, Integer> sortedMap = map.entrySet()
//            .stream()
//            .sorted(Map.Entry.comparingByValue())
//            .collect(Collectors.toMap(
//                Map.Entry::getKey,
//                Map.Entry::getValue,
//                (e1, e2) -> e1,
//                LinkedHashMap::new
//            ));
//
//        System.out.println(sortedMap);
    }
}

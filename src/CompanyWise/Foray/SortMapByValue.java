package CompanyWise.Foray;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Project: DS_Algo
 * Package: CompanyWise.Foray
 * <p>
 * User: piyushbajaj
 * Date: 13/03/23
 * Time: 6:50 pm
 */
public class SortMapByValue {

    /**
     * Approach 1:
     * 1. The idea is to store the entry set in a list and sort the list on the basis of values.
     * 2. Then fetch values and keys from the list and put them in a new hashmap. Thus, a new hashmap is sorted
     * according to values.
     *
     * @param hm
     * @return
     */
    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer>> list =
            new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());

        // Sort the list
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    /**
     * Approach:
     * 1. Here we will change how we did sorting and will use lambda expression for sorting.
     * 2. The logic is the same, and even we also passed the comparator object but only using lambda.
     *
     * @param hm
     * @return
     */
    public static HashMap<String, Integer> sortByValue1(HashMap<String, Integer> hm) {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());

        // Sort the list using lambda expression
        list.sort((i1, i2) -> i1.getValue().compareTo(i2.getValue()));

        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    /**
     * Approach:
     * 1. Here we will use streams to sort the map.
     * 2. We will use the stream() method to get the stream of entrySet followed by the lambda expression inside
     * sorted () method to sort the stream and finally, we will convert it into a map using toMap() method.
     * Inside the toMap() method, we use the LinkedHashMap::new method reference to retain the sorted order of the map.
     *
     * @param hm
     * @return
     */
    public static HashMap<String, Integer> sortByValue2(HashMap<String, Integer> hm) {

        return hm.entrySet()
            .stream()
            .sorted((i1, i2) -> i1.getValue().compareTo(i2.getValue()))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<String, Integer>();

        // enter data into hashmap
        hm.put("Math", 98);
        hm.put("Data Structure", 85);
        hm.put("Database", 91);
        hm.put("Java", 95);
        hm.put("Operating System", 79);
        hm.put("Networking", 80);
        Map<String, Integer> hm1 = sortByValue(hm);

        // print the sorted hashmap
        for (Map.Entry<String, Integer> en : hm1.entrySet()) {
            System.out.println("Key = " + en.getKey() + ", Value = " + en.getValue());
        }

        Map<String, Integer> hm2 = sortByValue1(hm);
        // print the sorted hashmap
        for (Map.Entry<String, Integer> en : hm2.entrySet()) {
            System.out.println("Key = " + en.getKey() + ", Value = " + en.getValue());
        }
    }
}

package Neetcode150.ArraysNHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Project: DSAlgo
 * Package: Neetcode150.ArraysNHashing
 * <p>
 * User: piyushbajaj
 * Date: 28/05/26
 * Time: 9:59 am
 */
public class P5_MostFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> elementFrequency = new HashMap<>();

        for (int num : nums) {
            elementFrequency.put(num, elementFrequency.getOrDefault(num, 0) + 1);
        }

        // Map -> Frequency, List<Elements>
        Map<Integer, List<Integer>> frequencyMapToCount = new HashMap<>();
        for (Map.Entry<Integer, Integer> entry : elementFrequency.entrySet()) {
            frequencyMapToCount.putIfAbsent(entry.getValue(), new ArrayList<>());
            frequencyMapToCount.get(entry.getValue()).add(entry.getKey());
        }

        List<Integer> arrayListInteger = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : frequencyMapToCount.entrySet()) {
            if (entry.getKey() >= k) {
                arrayListInteger.addAll(entry.getValue());
            }
        }

        return arrayListInteger.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        P5_MostFrequentElements mostFrequentElements = new P5_MostFrequentElements();
        System.out.println(Arrays.toString(mostFrequentElements.topKFrequent(new int[] {1, 2, 2, 3, 3, 3}, 2)));
    }
}

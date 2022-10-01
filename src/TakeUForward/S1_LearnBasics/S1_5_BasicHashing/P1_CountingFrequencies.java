package TakeUForward.S1_LearnBasics.S1_5_BasicHashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bajajp on 17 Sep, 2022
 */
public class P1_CountingFrequencies {
    /**
     * TC: O(N)
     * SC: O(N)
     *
     * @param arr
     */
    static void countFrequencies(int[] arr) {
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int val : arr) {
            hashMap.put(val, hashMap.getOrDefault(val, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> map : hashMap.entrySet()) {
            System.out.println(map.getKey() + " " + map.getValue());
        }
    }

    public static void main(String[] args) {
        countFrequencies(new int[]{10, 5, 10, 15, 10, 5});
    }
}

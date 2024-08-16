package StriverSDESheet.Arrays_Part3;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bajajp on 09 Sep, 2022
 */
public class P3_MajorityElement {

    public static void main(String[] args) {
        P3_MajorityElement p3_majorityElement = new P3_MajorityElement();
        System.out.println(p3_majorityElement.majorityElement(new int[] {2, 2, 1, 1, 1, 2, 2}));
        System.out.println(p3_majorityElement.majorityElement_better(new int[] {2, 2, 1, 1, 1, 2, 2}));
    }

    /**
     * @param arr
     * @return
     */
    public int majorityElement(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i : arr) {
            hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
        }

        for (int item : hashMap.keySet()) {
            if (hashMap.get(item) > n / 2) {
                return item;
            }
        }

        return 0;
    }

    /**
     * Moore’s Voting Algorithm
     * TC: O(N)
     * SC: o(N)
     *
     * @param arr
     * @return
     */
    public int majorityElement_better(int[] arr) {
        int count = 0;
        int candidate = 0;

        for (int num : arr) {
            if (count == 0) {
                candidate = num;
            }
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}

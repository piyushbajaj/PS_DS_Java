package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bajajp on 19 Sep, 2022
 * <p>
 * Link: https://leetcode.com/problems/fruit-into-baskets/submissions/
 */
public class P5_FruitsIntoBaskets {

    /**
     * TC: O(N)
     * SC: O(K)
     *
     * @param fruits
     * @return
     */
    static int totalFruit(int[] fruits) {
        int l = 0, r = 0, n = fruits.length;
        int maxSoFar = 0;
        // Will store fruits with their frequency
        Map<Integer, Integer> hashMap = new HashMap<>();

        while (r < n) {
            if (hashMap.containsKey(fruits[r])) {
                hashMap.put(fruits[r], hashMap.getOrDefault(fruits[r], 0) + 1);
                r++;
            } else {
                if (hashMap.size() == 2) {
                    if (hashMap.getOrDefault(fruits[l], 0) == 1) {
                        hashMap.remove(fruits[l]);
                        hashMap.put(fruits[r], hashMap.getOrDefault(fruits[r], 0) + 1);
                        r++;
                    } else if (hashMap.getOrDefault(fruits[l], 0) > 1) {
                        hashMap.put(fruits[l], hashMap.getOrDefault(fruits[l], 0) - 1);
                    }
                    l++;
                } else {
                    hashMap.put(fruits[r], hashMap.getOrDefault(fruits[r], 0) + 1);
                    r++;
                }
            }

            maxSoFar = Math.max(maxSoFar, r - l);
        }
        return maxSoFar;
    }

    static int totalFruit1(int[] fruits) {
        int l = 0, r = 0, n = fruits.length;
        int maxSoFar = 0;
        // Will store fruits with their frequency
        Map<Integer, Integer> hashMap = new HashMap<>();

        while (r < n) {
            hashMap.put(fruits[r], hashMap.getOrDefault(fruits[r], 0) + 1);
            while (hashMap.size() > 2) {
                hashMap.put(fruits[l], hashMap.getOrDefault(fruits[l], 0) - 1);
                if (hashMap.get(fruits[l]) == 0) {
                    hashMap.remove(fruits[l]);
                }
                l++;
            }
            r++;

            maxSoFar = Math.max(maxSoFar, r - l);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        System.out.println(totalFruit(new int[]{1, 2, 3, 2, 2}));

        System.out.println(totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));

        System.out.println(totalFruit1(new int[]{1, 2, 3, 2, 2}));

        System.out.println(totalFruit1(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));
    }
}

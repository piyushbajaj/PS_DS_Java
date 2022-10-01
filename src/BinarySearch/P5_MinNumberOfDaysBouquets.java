package BinarySearch;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by bajajp on 21 Sep, 2022
 * <p>
 * Link: https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
 * <p>
 * Minimum Number of Days to Make m Bouquets
 * <p>
 * You are given an integer array bloomDay, an integer m and an integer k.
 * <p>
 * You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.
 * <p>
 * The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.
 * <p>
 * Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.
 * <p>
 * Example 1:
 * <p>
 * Input: bloomDay = [1,10,3,10,2], m = 3, k = 1
 * Output: 3
 * Explanation: Let us see what happened in the first three days. x means flower bloomed and _ means flower did not bloom in the garden.
 * We need 3 bouquets each should contain 1 flower.
 * After day 1: [x, _, _, _, _]   // we can only make one bouquet.
 * After day 2: [x, _, _, _, x]   // we can only make two bouquets.
 * After day 3: [x, _, x, _, x]   // we can make 3 bouquets. The answer is 3.
 * <p>
 * Example 2:
 * <p>
 * Input: bloomDay = [1,10,3,10,2], m = 3, k = 2
 * Output: -1
 * Explanation: We need 3 bouquets each has 2 flowers, that means we need 6 flowers. We only have 5 flowers so it is impossible to get the needed bouquets and we return -1.
 */
public class P5_MinNumberOfDaysBouquets {

    /**
     * @param bloomDay: contains flowers which bloom on ith day
     * @param m:        number of bouquets
     * @param k:        adjacent flowers
     * @return
     */
    static int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;

        // Invalid input
        if (m * k > n) return -1;

        Map<Integer, Integer> treeMap = new TreeMap<>();

        int[] bloomDaySorted = bloomDay;
        Arrays.sort(bloomDaySorted);

        boolean[] flag = new boolean[n];

        for (int i = 0; i < n; i++) {
//            treeMap.put(bloomDay)
        }

        return -1;

    }

    public static void main(String[] args) {

    }
}

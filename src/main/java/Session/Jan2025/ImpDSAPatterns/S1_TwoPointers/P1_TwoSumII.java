package Session.Jan2025.ImpDSAPatterns.S1_TwoPointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Project: DSAlgo
 * Package: Session.Jan2025.ImpDSAPatterns.S1_TwoPointers
 * <p>
 * User: piyushbajaj
 * Date: 05/01/25
 * Time: 8:47 pm
 * Question: <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/">...</a>
 */
public class P1_TwoSumII {

    /**
     * TC: O(N)
     * SC: O(N)
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum0(int[] numbers, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            if (hashMap.containsKey(target - numbers[i])) {
                return new int[] {hashMap.get(target - numbers[i]) + 1, i + 1};
            } else {
                hashMap.put(numbers[i], i);
            }
        }

        return new int[] {};
    }

    /**
     * TC: O(N)
     * SC: O(1)
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum1(int[] numbers, int target) {
        int sum;
        int n = numbers.length;
        int start = 0, end = n - 1;

        while (start <= end) {
            sum = numbers[start] + numbers[end];
            if (sum > target) {
                end--;
            } else if (sum < target) {
                start++;
            } else {
                return new int[] {start + 1, end + 1};
            }
        }

        return new int[] {};
    }


    public static void main(String[] args) {
        P1_TwoSumII p1TwoSumII = new P1_TwoSumII();
        System.out.println(Arrays.toString(p1TwoSumII.twoSum0(new int[] {2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(p1TwoSumII.twoSum1(new int[] {2, 7, 11, 15}, 9)));
    }
}

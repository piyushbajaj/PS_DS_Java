package Practice2025.Grind75.Array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Project: DSAlgo
 * Package: Practice2025.Grind75.Array
 * <p>
 * User: piyushbajaj
 * Date: 30/03/25
 * Time: 10:43 pm
 * Link: <a href="https://leetcode.com/problems/two-sum/description/">...</a>
 */
public class P1_TwoSum {

    /**
     * Approach: Using HashMap
     * TC: O(N)
     * SC: O(N)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (hashMap.containsKey(diff)) {
                return new int[] {hashMap.get(diff), i};
            } else {
                hashMap.put(nums[i], i);
            }
        }

        return new int[] {};
    }

    public static void main(String[] args) {
        P1_TwoSum twoSum = new P1_TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSum(new int[] {2, 7, 11, 15}, 9)));
    }
}

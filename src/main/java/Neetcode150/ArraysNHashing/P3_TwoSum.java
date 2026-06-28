package Neetcode150.ArraysNHashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Project: DSAlgo
 * Package: Neetcode150.ArraysNHashing
 * <p>
 * User: piyushbajaj
 * Date: 26/05/26
 * Time: 10:14 am
 */
public class P3_TwoSum {

    /**
     * TC: O(N)
     * SC: O(N)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        // Store diff, indices
        Map<Integer, Integer> hashTarget = new HashMap<>();
        int len = nums.length;

        for (int index = 0; index < len; index++) {
            hashTarget.put(nums[index], index);
        }

        for (int index = 0; index < len; index++) {
            int diff = target - nums[index];
            if (hashTarget.containsKey(diff) && hashTarget.get(diff) != index) {
                return new int[] {index, hashTarget.get(diff)};
            }
        }

        return new int[] {};

    }

    public static void main(String[] args) {
        P3_TwoSum twoSum = new P3_TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSum(new int[] {4, 5, 6}, 10)));
        System.out.println(Arrays.toString(twoSum.twoSum(new int[] {5, 5}, 10)));
    }
}

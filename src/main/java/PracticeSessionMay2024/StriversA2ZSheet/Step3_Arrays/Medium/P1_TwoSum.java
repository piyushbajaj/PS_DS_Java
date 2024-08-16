package PracticeSessionMay2024.StriversA2ZSheet.Step3_Arrays.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Project: DSAlgo
 * Package: PracticeSessionMay2024.StriversA2ZSheet.Step3_Arrays.Medium
 * <p>
 * User: piyushbajaj
 * Date: 19/07/24
 * Time: 4:20 pm
 */
public class P1_TwoSum {

    /**
     * 1. Insert new element into hashset if unable to match with target
     * <p>
     * TC: O(N)
     * SC: O(N)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int leftValue = target - nums[i];
            if (hashMap.containsKey(leftValue)) {
                return new int[] {hashMap.get(leftValue), i};
            }
            hashMap.put(nums[i], i);
        }

        return new int[] {};
    }

    public static void main(String[] args) {
        P1_TwoSum p1TwoSum = new P1_TwoSum();
        int[] arr = {2, 7, 11, 15};
        System.out.println(Arrays.toString(p1TwoSum.twoSum(arr, 22)));
    }
}

package Session.May2024.Grind75;

import java.util.HashMap;
import java.util.Map;

/**
 * Project: DSAlgo
 * Package: PracticeSessionMay2024.Grind75
 * <p>
 * User: piyushbajaj
 * Date: 12/11/24
 * Time: 1:17 pm
 * Link: <a href="https://leetcode.com/problems/two-sum/">...</a>
 */
public class P1_TwoSum {

    /**
     * TC: O(N)
     * SC: O(N)
     */
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> hashSum = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (hashSum.containsKey(target - nums[i])) {
                return new int[] {i, hashSum.get(target - nums[i])};
            } else {
                hashSum.put(nums[i], i);
            }
        }

        return new int[] {};
    }

    public static void main(String[] args) {

    }
}

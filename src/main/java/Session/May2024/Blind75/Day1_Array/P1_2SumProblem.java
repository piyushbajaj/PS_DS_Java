package Session.May2024.Blind75.Day1_Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Project: DSAlgo
 * Package: PracticeSessionMay2024.Blind75.Day1_Array
 * <p>
 * User: piyushbajaj
 * Date: 12/08/24
 * Time: 8:25 am
 */
public class P1_2SumProblem {

    /**
     * TC: O(N)
     * SC: O(N)
     * <p>
     * Link: <a href="https://leetcode.com/problems/two-sum/description/">...</a>
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
        P1_2SumProblem sumProblem = new P1_2SumProblem();
        System.out.println(Arrays.toString(sumProblem.twoSum(new int[] {2, 7, 11, 15}, 9)));
    }
}

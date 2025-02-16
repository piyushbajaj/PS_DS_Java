package Session.Jan2025.Blind75.Day1_Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javafx.util.Pair;

/**
 * Project: DSAlgo
 * Package: Session.Jan2025.Blind75.Day1_Array
 * <p>
 * User: piyushbajaj
 * Date: 01/02/25
 * Time: 8:39 pm
 * <p>
 * Link: <a href="https://leetcode.com/problems/two-sum/">...</a>
 * <a href="https://takeuforward.org/data-structure/two-sum-check-if-a-pair-with-given-sum-exists-in-array/">...</a>
 */
public class P1_TwoSum {

    /**
     * TC: O(N * N) as HashMap is unordered Map so containsKey/get can take O(N) time in worst case
     * SC: O(N)
     *
     * @param nums
     * @param target
     * @return indices, which adds to the target
     */
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int delta = target - nums[i];

            if (!hashMap.containsKey(delta)) {
                hashMap.put(nums[i], i);
            } else {
                return new int[] {i, hashMap.get(delta)};
            }
        }

        return new int[] {};
    }

    /**
     * TC: O(N * N) as HashMap is unordered Map so containsKey/get can take O(N) time in worst case
     * SC: O(N)
     *
     * @param nums
     * @param target
     * @return true/false, if two numbers add to the target
     */
    public boolean twoSumFlag(int[] nums, int target) {
        int n = nums.length;
        Set<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int delta = target - nums[i];

            if (!hashSet.contains(delta)) {
                hashSet.add(nums[i]);
            } else {
                return true;
            }
        }

        return false;
    }

    /**
     * Use 2-pointer approach to reduce the TC and SC
     * TC: O(NlogN)
     * SC: O(N)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum_twoPointer(int[] nums, int target) {
        int n = nums.length;
        List<Pair<Integer, Integer>> pairList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            pairList.add(new Pair<>(nums[i], i));
        }
        pairList.sort(Comparator.comparing(Pair::getKey));

        int left = 0, right = n - 1;

        while (left < right) {
            int sum = pairList.get(left).getKey() + pairList.get(right).getKey();
            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                return new int[] {pairList.get(left).getValue(), pairList.get(right).getValue()};
            }
        }

        return new int[] {};
    }

    public static void main(String[] args) {
        P1_TwoSum p1TwoSum = new P1_TwoSum();
        int[] nums = {2, 6, 5, 8, 11};
        System.out.println(Arrays.toString(p1TwoSum.twoSum(nums, 14)));
        System.out.println(p1TwoSum.twoSumFlag(nums, 14));
        System.out.println(Arrays.toString(p1TwoSum.twoSum_twoPointer(nums, 14)));
    }
}

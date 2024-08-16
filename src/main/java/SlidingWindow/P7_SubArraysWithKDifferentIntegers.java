package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bajajp on 20 Sep, 2022
 * <p>
 * Link: https://leetcode.com/problems/subarrays-with-k-different-integers/
 * <p>
 * Given an integer array nums and an integer k, return the number of good subarrays of nums.
 * <p>
 * A good array is an array where the number of different integers in that array is exactly k.
 * <p>
 * For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
 * A subarray is a contiguous part of an array.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,1,2,3], k = 2
 * Output: 7
 * Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1,2,1,3,4], k = 3
 * Output: 3
 * Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
 */
public class P7_SubArraysWithKDifferentIntegers {
    /**
     * Approach:
     * 1. Getting SubArrays with exactly k integers -> At-most k integers - At-most k-1 integers
     * 2. How to get At-most k integers now?
     * - First check if the hashMap contains the element or not, if it doesn't contain then do k--
     * - Then insert the element while increasing the frequency
     * - Then iterate in while loop for k < 0
     * - Decrement the value for left pointer value
     * - If the left value become  == 0, then only increment k
     * Result is r - l everytime
     *
     * @param nums
     * @param k
     * @return
     */
    static int subarraysWithKDistinct(int[] nums, int k) {
        int l = 0, r = 0, n = nums.length;
        int res = 0;

        // To store integer with its frequency
        Map<Integer, Integer> hashMap = new HashMap<>();

        while (r < n) {
            if (hashMap.getOrDefault(nums[r], 0) == 0) {
                k--;
            }

            hashMap.put(nums[r], hashMap.getOrDefault(nums[r], 0) + 1);

            // It will enter inside this only when k count is breached
            while (k < 0) {
                hashMap.put(nums[l], hashMap.getOrDefault(nums[l], 0) - 1);
                if (hashMap.getOrDefault(nums[l], 0) == 0) {
                    k++;
                }
                l++;
            }
            r++;
            res += r - l;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 2, 3};
        System.out.println(subarraysWithKDistinct(arr, 2) - subarraysWithKDistinct(arr, 1));
    }
}

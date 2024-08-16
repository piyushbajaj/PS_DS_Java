package SlidingWindow;

/**
 * Created by bajajp on 19 Sep, 2022
 * Link: https://leetcode.com/problems/max-consecutive-ones-iii/
 * <p>
 * Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array
 * if you can flip at most k 0's.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
 * Output: 6
 * Explanation: [1,1,1,0,0,1,1,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
 * Output: 10
 * Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
 * Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 */
public class P4_MaxConsecutiveOnes {

    /**
     * TC: O(N)
     * SC: O(1)
     *
     * @param nums
     * @param k
     * @return
     */
    static int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = 0, maxSoFar = 0;
        int[] count = new int[2];

        if (n > 100000 || n <= 0) {
            return -1;
        }

        if (k > n || k < n) {
            return -1;
        }

        while (r < n) {
            if (nums[r] == 1 || (nums[r] == 0 && count[nums[r]] < k)) {
                count[nums[r]]++;
                r++;
            } else if (nums[r] == 0 && count[nums[r]] == k) {
                count[nums[l]]--;
                l++;
            }
            maxSoFar = Math.max(maxSoFar, count[0] + count[1]);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        System.out.println(longestOnes(new int[] {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        System.out.println(longestOnes(new int[] {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
    }
}

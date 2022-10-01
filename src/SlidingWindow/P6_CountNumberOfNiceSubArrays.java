package SlidingWindow;

/**
 * Created by bajajp on 19 Sep, 2022
 * <p>
 * Link: https://leetcode.com/problems/count-number-of-nice-subarrays/
 * <p>
 * Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.
 * <p>
 * Return the number of nice sub-arrays.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,2,1,1], k = 3
 * Output: 2
 * Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [2,4,6], k = 1
 * Output: 0
 * Explanation: There is no odd numbers in the array.
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * Output: 16
 */
public class P6_CountNumberOfNiceSubArrays {

    static int numberOfSubarrays(int[] nums, int k) {
        return numberOfSubarrays_util(nums, k) - numberOfSubarrays_util(nums, k - 1);
    }

    static int numberOfSubarrays_util(int[] nums, int k) {
        int l = 0, r = 0, n = nums.length;
        int res = 0;

        while (r < n) {
            if (nums[r] % 2 != 0) {
                k--;
            }

            while (k < 0) {
                if (nums[l] % 2 != 0) {
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
        System.out.println(numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 3));

        System.out.println(numberOfSubarrays(new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2));
    }
}

package SlidingWindow;

/**
 * Created by bajajp on 26 Sep, 2022
 * Link: https://leetcode.com/problems/count-number-of-nice-subarrays/
 */
public class P10_CountNoOfNiceSubArrays {

    /**
     * TC: O(N)
     * SC: O(1)
     *
     * @param nums
     * @param k
     * @return
     */
    static int numberOfSubarrays(int[] nums, int k) {
        return atmost_K_OddNumbers(nums, k) - atmost_K_OddNumbers(nums, k - 1);
    }

    static int atmost_K_OddNumbers(int[] nums, int k) {
        int l = 0, r = 0, n = nums.length, res = 0;
        while (r < n) {
            if (nums[r] % 2 != 0) {
                k--;
            }

            r++;

            while (k < 0) {
                if (nums[l] % 2 != 0) {
                    k++;
                }
                l++;
            }

            res += r - l;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 3));
    }
}

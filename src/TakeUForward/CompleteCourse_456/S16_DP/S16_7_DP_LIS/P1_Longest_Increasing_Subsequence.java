package TakeUForward.CompleteCourse_456.S16_DP.S16_7_DP_LIS;

import java.util.Arrays;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S16_DP.S16_7_DP_LIS
 * <p>
 * User: piyushbajaj
 * Date: 21/12/22
 * Time: 10:43 pm
 */
public class P1_Longest_Increasing_Subsequence {

    public static void main(String[] args) {
        P1_Longest_Increasing_Subsequence p1_longest_increasing_subsequence = new P1_Longest_Increasing_Subsequence();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};

        int[] nums1 = {7, 7, 7, 7};

        int[] nums2 = {0, 1, 0, 3, 2, 3};
        System.out.println(p1_longest_increasing_subsequence.lengthOfLIS(nums2));

        System.out.println(p1_longest_increasing_subsequence.lengthOfLIS_mem(nums2));

        System.out.println(p1_longest_increasing_subsequence.lengthOfLIS_tab(nums2));

        System.out.println(p1_longest_increasing_subsequence.lengthOfLIS_alternate(nums2));
    }

    /**
     * Recursive
     * TC: O(2^n)
     * SC: O(N)
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        // index, prev
        return lengthOfLIS_recur_util(nums, 0, -1);
    }

    public int lengthOfLIS_recur_util(int[] nums, int index, int prev) {
        // base condition
        if (index == nums.length) {
            return 0;
        }

        // not pick
        int len = lengthOfLIS_recur_util(nums, index + 1, prev);

        // pick
        if (prev == -1 || nums[index] > nums[prev]) {
            len = Math.max(len, 1 + lengthOfLIS_recur_util(nums, index + 1, index));
        }

        return len;
    }

    /**
     * Memoization
     * <p>
     * TC: O(N*N)
     * SC: O(N*N) + Auxiliary O(N)
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS_mem(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        return lengthOfLIS_mem_util(dp, nums, 0, -1);
    }

    public int lengthOfLIS_mem_util(int[][] dp, int[] nums, int index, int prev) {
        // base condition
        if (index == nums.length) {
            return 0;
        }

        if (dp[index][prev + 1] != -1) {
            return dp[index][prev + 1];
        }

        // not pick
        int len = lengthOfLIS_mem_util(dp, nums, index + 1, prev);

        // pick
        if (prev == -1 || nums[index] > nums[prev]) {
            len = Math.max(len, 1 + lengthOfLIS_mem_util(dp, nums, index + 1, index));
        }

        return dp[index][prev + 1] = len;
    }

    /**
     * Tabulation
     * TC: O(N*N)
     * SC: O(N*N) + O(N)
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS_tab(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int index = n - 1; index >= 0; index--) {
            for (int prev = index - 1; prev >= -1; prev--) {
                // not pick
                int len = dp[index + 1][prev + 1];
                // pick
                if (prev == -1 || nums[index] > nums[prev]) {
                    len = Math.max(len, 1 + dp[index + 1][index + 1]);
                }
                dp[index][prev + 1] = len;
            }
        }
        return dp[0][-1 + 1];
    }

    /**
     * Tabulation with space optimize
     * <p>
     * TC: O(N*N)
     * SC: O(N)
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS_tab_improve(int[] nums) {
        int n = nums.length;
        // Previous row
        int[] next = new int[n + 1];

        for (int index = n - 1; index >= 0; index--) {
            int[] curr = new int[n + 1];
            for (int prev = index - 1; prev >= -1; prev--) {
                // not pick
                int len = next[prev + 1];
                // pick
                if (prev == -1 || nums[index] > nums[prev]) {
                    len = Math.max(len, 1 + next[index + 1]);
                }
                curr[prev + 1] = len;
            }
            next = curr;
        }
        return next[-1 + 1];
    }

    /**
     * TC: O(N*N)
     * SC: O(N)
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS_alternate(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxi = 1;

        for (int index = 0; index < n; index++) {
            for (int prev = 0; prev < index; prev++) {
                if (nums[prev] < nums[index]) {
                    dp[index] = Math.max(dp[index], 1 + dp[prev]);
                }
            }
            maxi = Math.max(maxi, dp[index]);
        }

        return maxi;
    }
}

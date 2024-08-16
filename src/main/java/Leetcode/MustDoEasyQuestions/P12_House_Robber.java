package Leetcode.MustDoEasyQuestions;

/**
 * Project: DS_Algo
 * Package: Leetcode.MustDoEasyQuestions
 * <p>
 * User: piyushbajaj
 * Date: 31/12/22
 * Time: 5:48 pm
 * <p>
 * Pattern: DP
 * <p>
 * lc: <a href="https://leetcode.com/problems/house-robber/description/">...</a>
 */
public class P12_House_Robber {

    public static void main(String[] args) {
        P12_House_Robber p12_house_robber = new P12_House_Robber();
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(p12_house_robber.rob_tab(nums));

        int[] nums1 = {1, 2};
        System.out.println(p12_house_robber.rob_tab(nums1));
    }

    /**
     * Recursive
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int n = nums.length;

        return rob(nums, n - 1);
    }

    public int rob(int[] nums, int index) {
        if (index == 0) {
            return nums[index];
        }

        if (index < 0) {
            return 0;
        }

        int pick = nums[index] + rob(nums, index - 2);
        int notPick = rob(nums, index - 1);

        return Math.max(pick, notPick);
    }

    /**
     * TC: O(N)
     * SC: O(N) + Auxiliary: O(N)
     *
     * @param nums
     * @return
     */
    public int rob_mem(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = -1;
        }

        return rob_mem_util(dp, nums, n - 1);
    }

    public int rob_mem_util(int[] dp, int[] nums, int index) {
        if (index == 0) {
            return nums[index];
        }

        if (index < 0) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int pick = nums[index] + rob_mem_util(dp, nums, index - 2);
        int notPick = rob_mem_util(dp, nums, index - 1);

        return dp[index] = Math.max(pick, notPick);
    }

    /**
     * TC: O(N)
     * SC: O(N)
     *
     * @param nums
     * @return
     */
    public int rob_tab(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        dp[0] = nums[0];

        int pick = Integer.MIN_VALUE;
        int notPick = Integer.MIN_VALUE;
        for (int index = 1; index < n; index++) {
            pick = nums[index];
            if (index >= 2) {
                pick += dp[index - 2];
            }
            notPick = dp[index - 1];
            dp[index] = Math.max(pick, notPick);
        }

        return dp[n - 1];
    }
}

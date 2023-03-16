package TakeUForward.Blind75.DynamicProgramming;

/**
 * Project: DS_Algo
 * Package: TakeUForward.Blind75.DynamicProgramming
 * <p>
 * User: piyushbajaj
 * Date: 02/02/23
 * Time: 2:08 pm
 * <p>
 * lc: <a href="https://leetcode.com/problems/house-robber/description/">...</a>
 */
public class P7_House_Robber {

    /**
     * Recursive Way
     * TC: O(2^N)
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int n = nums.length;

        return rob_util(nums, n - 1);
    }

    public int rob_util(int[] nums, int index) {
        // base condition
        if (index == 0) {
            return nums[index];
        }

        if (index < 0) {
            return 0;
        }

        // not pick
        int notPick = rob_util(nums, index - 1);

        // pick
        int pick = nums[index] + rob_util(nums, index - 2);

        return Math.max(pick, notPick);
    }


    /**
     * TC: O(N)
     * SC: O(N) + O(N): Auxiliary
     *
     * @param nums
     * @return
     */
    public int rob_mem(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        for (int index = 0; index < n; index++) {
            dp[index] = -1;
        }

        return rob_mem_util(dp, nums, n - 1);
    }

    public int rob_mem_util(int[] dp, int[] nums, int index) {
        // base condition
        if (index == 0) {
            return nums[index];
        }

        if (index < 0) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        // not pick
        int notPick = rob_mem_util(dp, nums, index - 1);

        // pick
        int pick = nums[index] + rob_mem_util(dp, nums, index - 2);

        return dp[index] = Math.max(pick, notPick);
    }

    /**
     * Tabulation
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

        for (int index = 1; index < n; index++) {
            // not pick
            int notPick = dp[index - 1];

            // pick
            int pick = nums[index];
            if (index >= 2) {
                pick += dp[index - 2];
            }

            dp[index] = Math.max(pick, notPick);
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        P7_House_Robber p7_house_robber = new P7_House_Robber();
        System.out.println(p7_house_robber.rob(new int[] {2, 7, 9, 3, 1}));
        System.out.println(p7_house_robber.rob_mem(new int[] {2, 7, 9, 3, 1}));

        System.out.println(p7_house_robber.rob_tab(new int[] {2, 7, 9, 3, 1}));
    }
}

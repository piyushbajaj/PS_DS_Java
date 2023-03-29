package TakeUForward.CompleteCourse_456.S16_DP.S16_8_MCM_DP;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S16_DP.S16_8_MCM_DP
 * <p>
 * User: piyushbajaj
 * Date: 06/01/23
 * Time: 10:06 am
 * <p>
 * lc: <a href="https://leetcode.com/problems/burst-balloons/description/">...</a>
 */
public class P3_Burst_Balloons {

    public static void main(String[] args) {
        P3_Burst_Balloons p3_burst_balloons = new P3_Burst_Balloons();
        int[] nums = {3, 1, 5, 8};
        System.out.println(p3_burst_balloons.maxCoins_recur(nums));
        System.out.println(p3_burst_balloons.maxCoins_mem(nums));
        System.out.println(p3_burst_balloons.maxCoins_tab(nums));
    }

    /**
     * Using the same approach as Partition MCM
     * TC: Exponential
     * SC: O(N)
     *
     * @param nums
     * @return
     */
    public int maxCoins_recur(int[] nums) {
        int n = nums.length;

        int[] temp = new int[n + 2];

        System.arraycopy(nums, 0, temp, 1, n);
        temp[0] = 1;
        temp[temp.length - 1] = 1;

        return maxCoins_recur_util(1, n, temp);
    }

    public int maxCoins_recur_util(int i, int j, int[] nums) {
        if (i > j) {
            return 0;
        }
        int maxi = Integer.MIN_VALUE;
        for (int index = i; index <= j; index++) {
            int cost = nums[i - 1] * nums[index] * nums[j + 1] + maxCoins_recur_util(i, index - 1, nums) +
                maxCoins_recur_util(index + 1, j, nums);

            maxi = Math.max(maxi, cost);
        }

        return maxi;
    }

    /**
     * Memoization
     * <p>
     * TC: O(N*N*N)
     * SC: O(N*N) + O(N)
     *
     * @param nums
     * @return
     */
    public int maxCoins_mem(int[] nums) {
        int n = nums.length;

        int[] temp = new int[n + 2];
        int[][] dp = new int[n + 2][n + 2];

        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < n + 2; j++) {
                dp[i][j] = -1;
            }
        }

        System.arraycopy(nums, 0, temp, 1, n);
        temp[0] = 1;
        temp[temp.length - 1] = 1;

        return maxCoins_mem_util(dp, 1, n, temp);
    }

    public int maxCoins_mem_util(int[][] dp, int i, int j, int[] nums) {
        if (i > j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int maxi = Integer.MIN_VALUE;
        for (int index = i; index <= j; index++) {
            int cost = nums[i - 1] * nums[index] * nums[j + 1] +
                maxCoins_mem_util(dp, i, index - 1, nums) +
                maxCoins_mem_util(dp, index + 1, j, nums);

            maxi = Math.max(maxi, cost);
        }

        return dp[i][j] = maxi;
    }

    /**
     * Tabulation
     * TC: O(N*N*N)
     * SC: O(N*N)
     *
     * @param nums
     * @return
     */
    public int maxCoins_tab(int[] nums) {
        int n = nums.length;

        int[] temp = new int[n + 2];
        int[][] dp = new int[n + 2][n + 2];

        System.arraycopy(nums, 0, temp, 1, n);
        temp[0] = 1;
        temp[temp.length - 1] = 1;

        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n; j++) {
                if (i > j) {
                    continue;
                }

                int maxi = Integer.MIN_VALUE;
                for (int index = i; index <= j; index++) {
                    int cost = temp[i - 1] * temp[index] * temp[j + 1] +
                        dp[i][index - 1] + dp[index + 1][j];

                    maxi = Math.max(maxi, cost);
                }
                dp[i][j] = maxi;
            }
        }

        return dp[1][n];

    }
}

package TakeUForward.S16_DP.S16_4_DP_Subsequences;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S16_DP.S16_4_DP_Subsequences
 * <p>
 * User: piyushbajaj
 * Date: 24/11/22
 * Time: 10:02 am
 * <p>
 * LC link: <a href="https://leetcode.com/problems/target-sum/">...</a>
 */
public class P8_TargetSum {

    /**
     * Same as Partitions with given diff
     * <p>
     * TC: O(N*sum)
     * SC: O(N*sum) + O(N)
     *
     * @param arr
     * @param n
     * @param sum
     * @return
     */
    public int perfectSum_mem(int[] arr, int n, int sum) {
        int[][] dp = new int[n][sum + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < sum + 1; j++) {
                dp[i][j] = -1;
            }
        }

        return perfectSum_mem_util(arr, n - 1, sum, dp);
    }

    public int perfectSum_mem_util(int[] arr, int index, int sum, int[][] dp) {

        if (index == 0) {
            if (sum == 0 && arr[0] == 0) {
                return 2;
            }

            if (sum == 0 || sum == arr[0]) {
                return 1;
            }
            return 0;
        }

        if (dp[index][sum] != -1) {
            return dp[index][sum];
        }

        int notPick = perfectSum_mem_util(arr, index - 1, sum, dp);

        int pick = 0;

        if (arr[index] <= sum) {
            pick = perfectSum_mem_util(arr, index - 1, sum - arr[index], dp);
        }

        dp[index][sum] = (pick + notPick);

        return dp[index][sum];
    }

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        // corner condition
        if (sum - target < 0 || (sum - target) % 2 != 0) {
            return 0;
        }

        return perfectSum_mem(nums, n, (sum - target) / 2);
    }

    public static void main(String[] args) {
        P8_TargetSum p8_targetSum = new P8_TargetSum();
        int[] arr = {1, 1, 1, 1, 1};
        System.out.println(p8_targetSum.findTargetSumWays(arr, 3));
    }
}

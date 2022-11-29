package TakeUForward.S16_DP.S16_4_DP_Subsequences;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S16_DP.S16_4_DP_Subsequences
 * <p>
 * User: piyushbajaj
 * Date: 22/11/22
 * Time: 4:59 pm
 * <p>
 * Link g4g: <a href="https://practice.geeksforgeeks.org/problems/perfect-sum-problem5633/1">...</a>
 */
public class P4_Perfect_Sum {

    /**
     * Recursive Approach
     * <p>
     * Complexities:
     * TC: O(2^N)
     * SC: O(N)
     *
     * @param arr
     * @param n
     * @param sum
     * @return
     */
    public int perfectSum(int[] arr, int n, int sum) {
        return perfectSum_recursive(arr, n - 1, sum);
    }

    public int perfectSum_recursive(int[] arr, int index, int sum) {
        if (sum == 0) {
            return 1;
        }

        if (index == 0) {
            return arr[index] == sum ? 1 : 0;
        }

        int notPick = perfectSum_recursive(arr, index - 1, sum);

        int pick = 0;

        if (arr[index] <= sum) {
            pick = perfectSum_recursive(arr, index - 1, sum - arr[index]);
        }

        return (pick + notPick) % 1000000007;
    }

    /**
     * Memoization
     * <p>
     * TC: O(N*sum)
     * SC: O(N*sum) + O(N): Auxiliary
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

    public int perfectSum_tab(int[] arr, int n, int sum) {
        int[][] dp = new int[n][sum + 1];

        // base case
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        if (arr[0] <= sum) {
            dp[0][arr[0]] = 1;
        }

        for (int index = 1; index < n; index++) {
            for (int target = 0; target <= sum; target++) {
                int notPick = dp[index - 1][target];

                int pick = 0;

                if (arr[index] <= target) {
                    pick = dp[index - 1][target - arr[index]];
                }

                dp[index][target] = (pick + notPick);
            }
        }

        return dp[n - 1][sum];
    }

    public int perfectSum_tab_better(int[] arr, int n, int sum) {
        int[] prevRow = new int[sum + 1];

        // base case
        prevRow[0] = 1;

        if (arr[0] <= sum) {
            prevRow[arr[0]] = 1;
        }

        for (int index = 1; index < n; index++) {
            int[] currRow = new int[sum + 1];
            for (int target = 0; target <= sum; target++) {
                int notPick = prevRow[target];

                int pick = 0;

                if (arr[index] <= target) {
                    pick = prevRow[target - arr[index]];
                }

                currRow[target] = (pick + notPick);
            }
            prevRow = currRow;
        }

        return prevRow[sum];
    }

    public static void main(String[] args) {
        P4_Perfect_Sum p4_perfect_sum = new P4_Perfect_Sum();

        int[] arr = {2, 3, 5, 6, 8, 10};

        int[] arr1 = {9, 7, 0, 3, 9, 8, 6, 5, 7, 6};

        System.out.println(p4_perfect_sum.perfectSum(arr1, arr1.length, 31));

        System.out.println(p4_perfect_sum.perfectSum_mem(arr1, arr1.length, 31));

        System.out.println(p4_perfect_sum.perfectSum_tab(arr1, arr1.length, 31));

        System.out.println(p4_perfect_sum.perfectSum_tab_better(arr1, arr1.length, 31));
    }
}

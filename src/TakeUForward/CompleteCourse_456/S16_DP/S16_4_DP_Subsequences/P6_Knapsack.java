package TakeUForward.CompleteCourse_456.S16_DP.S16_4_DP_Subsequences;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S16_DP.S16_4_DP_Subsequences
 * <p>
 * User: piyushbajaj
 * Date: 23/11/22
 * Time: 1:01 pm
 */
public class P6_Knapsack {
    /**
     * Recursion
     * TC: O(2^N)
     * SC: O(N)
     *
     * @param W
     * @param wt
     * @param val
     * @param n
     * @return
     */
    public int knapSack(int W, int[] wt, int[] val, int n) {
        return knapSack_recur(W, wt, val, n - 1);
    }

    public int knapSack_recur(int W, int[] wt, int[] val, int index) {
        if (index == 0) {
            if (wt[index] <= W) {
                return val[index];
            } else {
                return 0;
            }
        }

        int nonPick = knapSack_recur(W, wt, val, index - 1);
        int pick = Integer.MIN_VALUE;

        if (wt[index] <= W) {
            pick = val[index] + knapSack_recur(W - wt[index], wt, val, index - 1);
        }

        return Math.max(pick, nonPick);
    }

    /**
     * Memoization
     * <p>
     * TC: O(wt*val)
     * SC: O(wt*val) + Auxiliary Space O(N)
     *
     * @param W
     * @param wt
     * @param val
     * @param n
     * @return
     */
    public int knapSack_mem(int W, int[] wt, int[] val, int n) {
        int[][] dp = new int[n][W + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= W; j++) {
                dp[i][j] = -1;
            }
        }

        return knapSack_mem_util(W, wt, val, n - 1, dp);
    }

    public int knapSack_mem_util(int W, int[] wt, int[] val, int index, int[][] dp) {
        if (index == 0) {
            if (wt[index] <= W) {
                return val[index];
            } else {
                return 0;
            }
        }

        if (dp[index][W] != -1) {
            return dp[index][W];
        }

        int nonPick = knapSack_mem_util(W, wt, val, index - 1, dp);
        int pick = Integer.MIN_VALUE;

        if (wt[index] <= W) {
            pick = val[index] + knapSack_mem_util(W - wt[index], wt, val, index - 1, dp);
        }

        dp[index][W] = Math.max(pick, nonPick);

        return dp[index][W];
    }

    /**
     * Tabulation
     * TC: O(Wt * Val)
     * SC: O(Wt * Val)
     *
     * @param W
     * @param wt
     * @param val
     * @param n
     * @return
     */
    public int knapSack_tab(int W, int[] wt, int[] val, int n) {
        // Stores value index and weight
        int[][] dp = new int[n][W + 1];

        // base case
        for (int j = wt[0]; j <= W; j++) {
            dp[0][j] = val[0];
        }

        for (int index = 1; index < n; index++) {
            for (int weight = 0; weight <= W; weight++) {
                int nonPick = dp[index - 1][weight];
                int pick = Integer.MIN_VALUE;

                if (wt[index] <= weight) {
                    pick = val[index] + dp[index - 1][weight - wt[index]];
                }

                dp[index][weight] = Math.max(pick, nonPick);
            }
        }

        return dp[n - 1][W];

    }


    public int knapSack_tab_better(int W, int[] wt, int[] val, int n) {
        // Stores value for weight previous row
        int[] prev = new int[W + 1];

        // base case
        for (int j = wt[0]; j <= W; j++) {
            prev[j] = val[0];
        }

        for (int index = 1; index < n; index++) {
            int[] curr = new int[W + 1];
            for (int weight = 0; weight <= W; weight++) {
                int nonPick = prev[weight];
                int pick = Integer.MIN_VALUE;

                if (wt[index] <= weight) {
                    pick = val[index] + prev[weight - wt[index]];
                }

                curr[weight] = Math.max(pick, nonPick);
            }
            prev = curr;
        }

        return prev[W];
    }

    public static void main(String[] args) {
        P6_Knapsack p6_knapsack = new P6_Knapsack();

        int N = 3;
        int W = 4;
        int[] values = {1, 2, 3};
        int[] weight = {4, 5, 1};

        System.out.println(p6_knapsack.knapSack(W, weight, values, N));

        System.out.println(p6_knapsack.knapSack_mem(W, weight, values, N));

        System.out.println(p6_knapsack.knapSack_tab(W, weight, values, N));

        System.out.println(p6_knapsack.knapSack_tab_better(W, weight, values, N));
    }
}

package TakeUForward.CompleteCourse_456.S16_DP.S16_4_DP_Subsequences;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S16_DP.S16_4_DP_Subsequences
 * <p>
 * User: piyushbajaj
 * Date: 25/11/22
 * Time: 12:09 am
 */
public class P10_Knapsack_duplicate_items {
    public static void main(String[] args) {
        P10_Knapsack_duplicate_items p10_knapsack_duplicate_items = new P10_Knapsack_duplicate_items();
        int[] val = {1, 4, 5, 7};
        int[] wt = {1, 3, 4, 5};
        System.out.println(p10_knapsack_duplicate_items.knapSack_recur(4, 8, val, wt));

        System.out.println(p10_knapsack_duplicate_items.knapSack_mem(4, 8, val, wt));

        System.out.println(p10_knapsack_duplicate_items.knapSack_tab(4, 8, val, wt));
    }

    public int knapSack_recur(int N, int W, int[] val, int[] wt) {

        return knapSack_recur_util(N - 1, W, val, wt);
    }

    public int knapSack_recur_util(int index, int W, int[] val, int[] wt) {
        // base case
        if (index == 0) {
            return W % wt[index] == 0 ? (W / wt[index]) * val[index] : Integer.MIN_VALUE;
        }

        int notTake = knapSack_recur_util(index - 1, W, val, wt);
        int take = Integer.MIN_VALUE;

        if (wt[index] <= W) {
            take = val[index] + knapSack_recur_util(index, W - wt[index], val, wt);
        }

        return Math.max(notTake, take);
    }

    /**
     * Memoization
     * TC: O(N*W)
     * SC: O(N*W) + O(W)
     *
     * @param N
     * @param W
     * @param val
     * @param wt
     * @return
     */
    public int knapSack_mem(int N, int W, int[] val, int[] wt) {
        int[][] dp = new int[N][W + 1];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= W; j++) {
                dp[i][j] = -1;
            }
        }
        return knapSack_mem_util(N - 1, W, val, wt, dp);
    }

    public int knapSack_mem_util(int index, int W, int[] val, int[] wt, int[][] dp) {
        // base case
        if (index == 0) {
            return (W / wt[index]) * val[index];
        }

        if (dp[index][W] != -1) {
            return dp[index][W];
        }

        int notTake = knapSack_mem_util(index - 1, W, val, wt, dp);
        int take = Integer.MIN_VALUE;

        if (wt[index] <= W) {
            take = val[index] + knapSack_mem_util(index, W - wt[index], val, wt, dp);
        }

        return dp[index][W] = Math.max(notTake, take);
    }

    public int knapSack_tab(int N, int W, int[] val, int[] wt) {
        int[][] dp = new int[N][W + 1];

        // base case
        for (int weight = 0; weight <= W; weight++) {
            dp[0][weight] = ((int) weight / wt[0]) * val[0];
        }

        for (int index = 1; index < N; index++) {
            for (int weight = 0; weight <= W; weight++) {
                int notTake = dp[index - 1][W];
                int take = 0;

                if (wt[index] <= W) {
                    take = val[index] + dp[index][W - wt[index]];
                }

                dp[index][W] = Math.max(notTake, take);
            }
        }

        return dp[N - 1][W];
    }
}

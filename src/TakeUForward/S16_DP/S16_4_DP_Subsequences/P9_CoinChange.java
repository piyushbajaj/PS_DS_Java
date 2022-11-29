package TakeUForward.S16_DP.S16_4_DP_Subsequences;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S16_DP.S16_4_DP_Subsequences
 * <p>
 * User: piyushbajaj
 * Date: 24/11/22
 * Time: 6:54 pm
 */
public class P9_CoinChange {

    /**
     * Recursive
     * TC: O(2^N)
     * SC: O(N)
     * <p>
     * Cons: TLE
     *
     * @param amount
     * @param coins
     * @return
     */
    public int change_recur(int amount, int[] coins) {
        int n = coins.length;
        return change_recur_util(coins, n - 1, amount);
    }

    public int change_recur_util(int[] coins, int index, int target) {
        // base case
        if (index == 0) {
            return target % coins[index] == 0 ? 1 : 0;
        }

        int notTake = change_recur_util(coins, index - 1, target);
        int take = 0;
        if (coins[index] <= target) {
            take = change_recur_util(coins, index, target - coins[index]);
        }

        return take + notTake;
    }

    /**
     * Memoization
     * <p>
     * TC: O(N*Amount)
     * SC: O(N*Amount) + Auxiliary Space: O(Target)
     *
     * @param amount
     * @param coins
     * @return
     */
    public int change_mem(int amount, int[] coins) {
        int n = coins.length;

        int[][] dp = new int[n][amount + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < amount + 1; j++) {
                dp[i][j] = -1;
            }
        }

        return change_mem_util(coins, n - 1, amount, dp);
    }

    public int change_mem_util(int[] coins, int index, int target, int[][] dp) {
        // base case
        if (index == 0) {
            return target % coins[index] == 0 ? 1 : 0;
        }

        if (dp[index][target] != -1) {
            return dp[index][target];
        }

        int notTake = change_mem_util(coins, index - 1, target, dp);
        int take = 0;
        if (coins[index] <= target) {
            take = change_mem_util(coins, index, target - coins[index], dp);
        }

        return dp[index][target] = take + notTake;
    }

    /**
     * Tabulation
     * TC: O(Amount *Target)
     * SC: O(Amount *Target)
     *
     * @param amount
     * @param coins
     * @return
     */
    public int change_tab(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        // Base case
        for (int amt = 0; amt <= amount; amt++) {
            if (amt % coins[0] == 0) {
                dp[0][amt] = 1;
            }
        }

        for (int index = 1; index < n; index++) {
            for (int amt = 0; amt <= amount; amt++) {
                int notTake = dp[index - 1][amt];
                int take = 0;
                if (coins[index] <= amt) {
                    take = dp[index][amt - coins[index]];
                }

                dp[index][amt] = take + notTake;
            }
        }

        return dp[n - 1][amount];
    }

    public static void main(String[] args) {
        P9_CoinChange p9_coinChange = new P9_CoinChange();
        int[] arr = {1, 2, 5};

        System.out.println(p9_coinChange.change_recur(5, arr));

        System.out.println(p9_coinChange.change_mem(5, arr));

        System.out.println(p9_coinChange.change_tab(5, arr));
    }
}

package TakeUForward.S16_DP.S16_4_DP_Subsequences;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S16_DP.S16_4_DP_Subsequences
 * <p>
 * User: piyushbajaj
 * Date: 23/11/22
 * Time: 6:54 pm
 * <p>
 * Link lc: <a href="https://leetcode.com/problems/coin-change/">...</a>
 */
public class P7_MinCoin {

    /**
     * Recursion
     * Minimum coin problem, we have to maximize in case it doesn't match
     * TC: O(> 2^N)
     * SC: O(N)
     * <p>
     * Cons: This will give TLE
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange_recur(int[] coins, int amount) {
        return coinChange_recur_util(coins, coins.length - 1, amount) == 1e9 ? -1 :
            coinChange_recur_util(coins, coins.length - 1, amount);
    }

    public int coinChange_recur_util(int[] coins, int index, int amount) {
        // base condition
        if (index == 0) {
            if (amount % coins[index] == 0) {
                return amount / coins[index];
            } else {
                return (int) 1e9;
            }
        }

        int notTake = coinChange_recur_util(coins, index - 1, amount);
        int take = Integer.MAX_VALUE;

        if (coins[index] <= amount) {
            take = 1 + coinChange_recur_util(coins, index, amount - coins[index]);
        }

        return Math.min(take, notTake);
    }

    /**
     * Memoization
     * <p>
     * TC: O(N*Target)
     * SC: O(N*Target) + O(T)
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange_mem(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < amount + 1; j++) {
                dp[i][j] = -1;
            }
        }

        return coinChange_mem_util(coins, coins.length - 1, amount, dp) == 1e9 ? -1 :
            coinChange_mem_util(coins, coins.length - 1, amount, dp);
    }

    public int coinChange_mem_util(int[] coins, int index, int amount, int[][] dp) {
        // base condition
        if (index == 0) {
            if (amount % coins[index] == 0) {
                return amount / coins[index];
            } else {
                return (int) 1e9;
            }
        }

        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }

        int notTake = coinChange_mem_util(coins, index - 1, amount, dp);
        int take = Integer.MAX_VALUE;

        if (coins[index] <= amount) {
            take = 1 + coinChange_mem_util(coins, index, amount - coins[index], dp);
        }

        dp[index][amount] = Math.min(take, notTake);

        return dp[index][amount];
    }

    /**
     * Tabulation
     * TC: O(N*Target)
     * SC: O(N*Target) + O(T)
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange_tab(int[] coins, int amount) {
        // base condition
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for (int amt = 0; amt <= amount; amt++) {
            if (amt % coins[0] == 0) {
                dp[0][amt] = amt / coins[0];
            } else {
                dp[0][amt] = (int) 1e9;
            }
        }

        for (int index = 1; index < n; index++) {
            for (int amt = 0; amt <= amount; amt++) {
                int notTake = dp[index - 1][amt];
                int take = Integer.MAX_VALUE;

                if (coins[index] <= amt) {
                    take = 1 + dp[index][amt - coins[index]];
                }

                dp[index][amt] = Math.min(take, notTake);
            }
        }

        return dp[n - 1][amount] == 1e9 ? -1 : dp[n - 1][amount];
    }

    public int coinChange_tab_better(int[] coins, int amount) {
        // base condition
        int n = coins.length;
        int[] prev = new int[amount + 1];

        for (int amt = 0; amt <= amount; amt++) {
            if (amt % coins[0] == 0) {
                prev[amt] = amt / coins[0];
            } else {
                prev[amt] = (int) 1e9;
            }
        }

        for (int index = 1; index < n; index++) {
            int[] curr = new int[amount + 1];
            for (int amt = 0; amt <= amount; amt++) {
                int notTake = prev[amt];
                int take = Integer.MAX_VALUE;

                if (coins[index] <= amt) {
                    take = 1 + prev[amt - coins[index]];
                }

                curr[amt] = Math.min(take, notTake);
            }

            prev = curr;
        }

        return prev[amount] == 1e9 ? -1 : prev[amount];
    }

    public static void main(String[] args) {
        P7_MinCoin p7_minCoin = new P7_MinCoin();
//        int[] coins = {411, 412, 413, 414, 415, 416, 417, 418, 419, 420, 421, 422};

        int[] coins = {1, 2, 5};

//        System.out.println(p7_minCoin.coinChange_recur(coins, 9864));

        System.out.println(p7_minCoin.coinChange_mem(coins, 11));

        System.out.println(p7_minCoin.coinChange_tab(coins, 11));

        System.out.println(p7_minCoin.coinChange_tab_better(coins, 11));

    }
}

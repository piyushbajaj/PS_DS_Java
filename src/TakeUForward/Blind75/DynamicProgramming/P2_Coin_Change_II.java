package TakeUForward.Blind75.DynamicProgramming;

/**
 * Project: DS_Algo
 * Package: TakeUForward.Blind75.DynamicProgramming
 * <p>
 * User: piyushbajaj
 * Date: 26/01/23
 * Time: 8:16 pm
 * <p>
 * lc: <a href="https://leetcode.com/problems/coin-change-ii/">...</a>
 * striver: <a href="https://takeuforward.org/data-structure/coin-change-2-dp-22/">...</a>
 */
public class P2_Coin_Change_II {

    /**
     * Recursive Approach: Top-Down Approach
     * TC: O(2^N)
     * SC: O(N)
     *
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        return change_util(coins.length - 1, amount, coins);
    }

    public int change_util(int index, int amount, int[] coins) {
        // base condition
        if (index < 0 || amount < 0) {
            return 0;
        }

        if (amount == 0) {
            return 1;
        }

        if (index == 0 && amount % coins[index] == 0) {
            return 1;
        }

        int pick = change_util(index, amount - coins[index], coins);
        int notPick = change_util(index - 1, amount, coins);

        return pick + notPick;
    }

    /**
     * Memoization
     * TC: O(N*Amount)
     * SC: O(N*Amount) + O(N+Amount)
     *
     * @param amount
     * @param coins
     * @return
     */
    public int change_mem(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];

        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = -1;
            }
        }

        return change_mem_util(coins.length - 1, amount, coins, dp);
    }

    public int change_mem_util(int index, int amount, int[] coins, int[][] dp) {
        // base condition
        if (index == 0) {
            return amount % coins[index] == 0 ? 1 : 0;
        }
        if (amount < 0) {
            return 0;
        }

        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }

        int pick = change_mem_util(index, amount - coins[index], coins, dp);
        int notPick = change_mem_util(index - 1, amount, coins, dp);

        return dp[index][amount] = pick + notPick;
    }

    /**
     * Tabulation
     * TC: O(N*Amount)
     * SC: O(N*Amount) + O(N)
     *
     * @param amount
     * @param coins
     * @return
     */
    public int change_tab(int amount, int[] coins) {
        int n = coins.length;

        int[][] dp = new int[n][amount + 1];

        // Base Condition
        for (int target = 0; target <= amount; target++) {
            if (target % coins[0] == 0) {
                dp[0][target] = 1;
            }
        }

        for (int index = 1; index < n; index++) {
            for (int target = 0; target <= amount; target++) {
                int pick = 0;
                if (target - coins[index] >= 0) {
                    pick = dp[index][target - coins[index]];
                }
                int notPick = dp[index - 1][target];

                dp[index][target] = pick + notPick;
            }
        }

        return dp[n - 1][amount];
    }

    /**
     * @param amount
     * @param coins
     * @return
     */
    public int change_tab_improve(int amount, int[] coins) {
        int n = coins.length;

        // prev row
        int[] prev = new int[amount + 1];

        // Base Condition
        for (int target = 0; target <= amount; target++) {
            if (target % coins[0] == 0) {
                prev[target] = 1;
            }
        }

        for (int index = 1; index < n; index++) {
            int[] curr = new int[amount + 1];
            for (int target = 0; target <= amount; target++) {
                int pick = 0;
                if (target - coins[index] >= 0) {
                    pick = curr[target - coins[index]];
                }
                int notPick = prev[target];

                curr[target] = pick + notPick;
            }
            prev = curr;
        }

        return prev[amount];
    }

    public static void main(String[] args) {
        P2_Coin_Change_II p2_coin_change_ii = new P2_Coin_Change_II();
        System.out.println(p2_coin_change_ii.change(5, new int[] {1, 2, 5}));

        System.out.println(p2_coin_change_ii.change_mem(5, new int[] {1, 2, 5}));

        System.out.println(p2_coin_change_ii.change_tab(5, new int[] {1, 2, 5}));

        System.out.println(p2_coin_change_ii.change_tab_improve(5, new int[] {1, 2, 5}));
    }
}

package TakeUForward.CompleteCourse_456.S16_DP.S16_6_DP_Stocks;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S16_DP.S16_6_DP_Stocks
 * <p>
 * User: piyushbajaj
 * Date: 20/12/22
 * Time: 5:52 pm
 * <p>
 * Link lc: <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/">...</a>
 */
public class P3_Best_Time_III {
    /**
     * Recursion
     * TC: O(2^N)
     * SC: O(N)
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        return maxProfit_recur_util(n, prices, 0, 1, 2);
    }

    public int maxProfit_recur_util(int n, int[] prices, int index, int buy, int cap) {
        if (cap == 0) {
            return 0;
        }
        if (index == n) {
            return 0;
        }

        int profit = 0;

        if (buy == 1) {
            profit = Math.max(
                -prices[index] + maxProfit_recur_util(n, prices, index + 1, 0, cap),
                maxProfit_recur_util(n, prices, index + 1, 1, cap));
        } else {
            profit = Math.max(
                prices[index] + maxProfit_recur_util(n, prices, index + 1, 1, cap - 1),
                maxProfit_recur_util(n, prices, index + 1, 0, cap));
        }

        return profit;
    }

    /**
     * Memoization
     * TC: O(N) * O(2) * O(3)
     * SC: O(N) * O(2) * O(3) + O(N+2+3)
     *
     * @param prices
     * @return
     */
    public int maxProfit_mem(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return maxProfit_mem_util(dp, n, prices, 0, 1, 2);
    }

    public int maxProfit_mem_util(int[][][] dp, int n, int[] prices, int index, int buy, int cap) {
        if (cap == 0) {
            return 0;
        }
        if (index == n) {
            return 0;
        }

        if (dp[index][buy][cap] != -1) {
            return dp[index][buy][cap];
        }

        int profit = 0;

        if (buy == 1) {
            profit = Math.max(
                -prices[index] + maxProfit_mem_util(dp, n, prices, index + 1, 0, cap),
                maxProfit_mem_util(dp, n, prices, index + 1, 1, cap));
        } else {
            profit = Math.max(
                prices[index] + maxProfit_mem_util(dp, n, prices, index + 1, 1, cap - 1),
                maxProfit_mem_util(dp, n, prices, index + 1, 0, cap));
        }

        return dp[index][buy][cap] = profit;
    }

    /**
     * TC: O(N) * O(2) * O(3)
     * SC: O(N) * O(2) * O(3)
     *
     * @param prices
     * @return
     */
    public int maxProfit_tab(int[] prices) {
        int n = prices.length;
        // Index, buy, cap
        int[][][] dp = new int[n + 1][2][3];

        // base condition
        for (int j = 0; j < 2; j++) {
            for (int k = 0; k < 3; k++) {
                dp[n][j][0] = 0;
            }
        }

        for (int index = n - 1; index >= 0; index--) {
            for (int buy = 0; buy < 2; buy++) {
                for (int cap = 1; cap < 3; cap++) {
                    int profit = 0;

                    if (buy == 1) {
                        profit = Math.max(
                            -prices[index] + dp[index + 1][0][cap],
                            dp[index + 1][1][cap]);
                    } else {
                        profit = Math.max(
                            prices[index] + dp[index + 1][1][cap - 1],
                            dp[index + 1][0][cap]);
                    }
                    dp[index][buy][cap] = profit;
                }
            }
        }

        return dp[0][1][2];
    }


    public static void main(String[] args) {
        P3_Best_Time_III p3_best_time_iii = new P3_Best_Time_III();
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(p3_best_time_iii.maxProfit(prices));
        System.out.println(p3_best_time_iii.maxProfit_mem(prices));
        System.out.println(p3_best_time_iii.maxProfit_tab(prices));
    }
}

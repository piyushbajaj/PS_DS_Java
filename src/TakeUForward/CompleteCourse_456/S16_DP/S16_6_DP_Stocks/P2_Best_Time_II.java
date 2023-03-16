package TakeUForward.CompleteCourse_456.S16_DP.S16_6_DP_Stocks;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S16_DP.S16_6_DP_Stocks
 * <p>
 * User: piyushbajaj
 * Date: 19/12/22
 * Time: 2:48 pm
 */
public class P2_Best_Time_II {

    /**
     * Recursion
     * TC: O(2^N)
     * SC: O(N)
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        return maxProfit_util(prices, 0, true);
    }

    public int maxProfit_util(int[] prices, int index, boolean buy) {
        // base case
        if (index == prices.length) {
            return 0;
        }

        int profit;

        if (buy) {
            // If bought, then now ready for sale
            profit = Math.max(-prices[index] + maxProfit_util(prices, index + 1, false),
                // If not bought, then skip for further buy
                maxProfit_util(prices, index + 1, true));
        } else {
            // If sold, then now ready for buy
            profit = Math.max(prices[index] + maxProfit_util(prices, index + 1, true),
                // If not sold, then skip for further selling
                maxProfit_util(prices, index + 1, false));
        }

        return profit;
    }

    /**
     * Memoization
     * TC: O(N*2)
     * SC: O(N*2) + Auxiliary Space O(N+2)
     *
     * @param prices
     * @return
     */
    public int maxProfit_mem(int[] prices) {
        int n = prices.length;
        int[][] dp_profits = new int[n + 1][2];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                dp_profits[i][j] = -1;
            }
        }

        return maxProfit_mem_util(dp_profits, prices, 0, 1);
    }

    public int maxProfit_mem_util(int[][] dp_profits, int[] prices, int index, int buy) {
        // base case
        if (index == prices.length) {
            return 0;
        }

        if (dp_profits[index][buy] != -1) {
            return dp_profits[index][buy];
        }

        int profit = 0;

        if (buy == 1) {
            // If bought, then now ready for sale
            profit = Math.max(-prices[index] + maxProfit_mem_util(dp_profits, prices, index + 1, 0),
                // If not bought, then skip for further buy
                maxProfit_mem_util(dp_profits, prices, index + 1, 1));
        } else {
            // If sold, then now ready for buy
            profit = Math.max(prices[index] + maxProfit_mem_util(dp_profits, prices, index + 1, 1),
                // If not sold, then skip for further selling
                maxProfit_mem_util(dp_profits, prices, index + 1, 0));
        }

        return dp_profits[index][buy] = profit;
    }

    public int maxProfit_tab(int[] prices) {
        int n = prices.length;
        int[][] dp_profits = new int[n + 1][2];

        // base case
        for (int i = 0; i < 2; i++) {
            dp_profits[n][i] = 0;
        }

        for (int index = n - 1; index >= 0; index--) {
            for (int buy = 1; buy >= 0; buy--) {
                int profit = 0;

                if (buy == 1) {
                    // If bought, then now ready for sale
                    profit = Math.max(-prices[index] + dp_profits[index + 1][0],
                        // If not bought, then skip for further buy
                        dp_profits[index + 1][1]);
                } else {
                    // If sold, then now ready for buy
                    profit = Math.max(prices[index] + dp_profits[index + 1][1],
                        // If not sold, then skip for further selling
                        dp_profits[index + 1][0]);
                }

                dp_profits[index][buy] = profit;
            }
        }

        return dp_profits[0][1];
    }

    /**
     * TC: O(N*2)
     * SC: O(1)
     *
     * @param prices
     * @return
     */
    public int maxProfit_tab_improve(int[] prices) {
        int n = prices.length;
        // ahead row
        int[] ahead = new int[2];

        // base case
        for (int i = 0; i < 2; i++) {
            ahead[i] = 0;
        }

        for (int index = n - 1; index >= 0; index--) {
            int[] curr = new int[2];
            for (int buy = 1; buy >= 0; buy--) {
                int profit = 0;

                if (buy == 1) {
                    // If bought, then now ready for sale
                    profit = Math.max(-prices[index] + ahead[0],
                        // If not bought, then skip for further buy
                        ahead[1]);
                } else {
                    // If sold, then now ready for buy
                    profit = Math.max(prices[index] + ahead[1],
                        // If not sold, then skip for further selling
                        ahead[0]);
                }

                curr[buy] = profit;
            }
            ahead = curr;
        }

        return ahead[1];
    }

    public static void main(String[] args) {
        P2_Best_Time_II p2_best_time_ii = new P2_Best_Time_II();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(p2_best_time_ii.maxProfit(prices));

        System.out.println(p2_best_time_ii.maxProfit_mem(prices));

        System.out.println(p2_best_time_ii.maxProfit_tab(prices));

        System.out.println(p2_best_time_ii.maxProfit_tab_improve(prices));
    }
}

package TakeUForward.CompleteCourse_456.S16_DP.S16_6_DP_Stocks;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S16_DP.S16_6_DP_Stocks
 * <p>
 * User: piyushbajaj
 * Date: 21/12/22
 * Time: 12:56 pm
 * <p>
 * Link lc: <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/">...</a>
 */
public class P5_Best_Time_To_Buy_Sell_Cooldown {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp_profits = new int[n + 2][2];

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
                    profit = Math.max(prices[index] + dp_profits[index + 2][1],
                        // If not sold, then skip for further selling
                        dp_profits[index + 1][0]);
                }

                dp_profits[index][buy] = profit;
            }
        }

        return dp_profits[0][1];
    }

    public static void main(String[] args) {
        P5_Best_Time_To_Buy_Sell_Cooldown p5_best_time_to_buy_sell_cooldown = new P5_Best_Time_To_Buy_Sell_Cooldown();
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(p5_best_time_to_buy_sell_cooldown.maxProfit(prices));
    }
}

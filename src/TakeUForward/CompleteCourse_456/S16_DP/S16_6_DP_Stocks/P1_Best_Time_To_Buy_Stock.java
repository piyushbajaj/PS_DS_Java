package TakeUForward.CompleteCourse_456.S16_DP.S16_6_DP_Stocks;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S16_DP.S16_6_DP_Stocks
 * <p>
 * User: piyushbajaj
 * Date: 18/12/22
 * Time: 12:47 pm
 * <p>
 * Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 */
public class P1_Best_Time_To_Buy_Stock {
    public static void main(String[] args) {
        P1_Best_Time_To_Buy_Stock p1_best_time_to_buy_stock = new P1_Best_Time_To_Buy_Stock();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(p1_best_time_to_buy_stock.maxProfit(prices));
    }

    /**
     * 1. Get the Current cost by current element cost - minimum element
     * 2. Maximize profit by comparing cost
     * 3. Keep the track of minimum elements in the left
     * TC: O(N)
     * SC: O(1)
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int mini = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            int cost = prices[i] - mini;
            profit = Math.max(profit, cost);
            mini = Math.min(mini, prices[i]);
        }

        return profit;
    }
}

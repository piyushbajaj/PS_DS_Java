package PracticeSessionMay2024.Blind75.Day1_Array;

/**
 * Project: DSAlgo
 * Package: PracticeSessionMay2024.Blind75.Day1_Array
 * <p>
 * User: piyushbajaj
 * Date: 12/08/24
 * Time: 8:29 am
 */
public class P2_BestTimeForStock {

    /**
     * TC: O(N)
     * SC: O(1)
     * <p>
     * Link: <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/">...</a>
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

    public static void main(String[] args) {

    }
}

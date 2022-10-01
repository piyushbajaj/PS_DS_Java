package Practice75Problems.Array;

/**
 * Created by bajajp on 18 Jun, 2022
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * <p>
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * <p>
 * Example 1:
 * <p>
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * <p>
 * Example 2:
 * <p>
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 */
public class P2_BestTimeBuyAndSellStock {
    // wont work for [2,1,4]
    public static int maxProfit_firstTime(int[] prices) {
        int n = prices.length;
        int maxValue = 0, l = 0, r = n - 1;

        while (l < r) {
            int diff = prices[r] - prices[l];
            if (diff > maxValue) {
                maxValue = diff;
            }

            if (prices[l] > prices[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxValue;
    }

    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, max = 0;
        int n = prices.length;
        for (int i = 0; i < n; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > max) {
                max = prices[i] - min;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}

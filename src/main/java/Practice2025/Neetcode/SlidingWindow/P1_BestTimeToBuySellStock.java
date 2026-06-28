package Practice2025.Neetcode.SlidingWindow;

/**
 * Project: DSAlgo
 * Package: Practice2025.Neetcode.SlidingWindow
 * <p>
 * User: piyushbajaj
 * Date: 18/06/25
 * Time: 9:37 am
 */
public class P1_BestTimeToBuySellStock {

    /**
     * Approach: Using 2-Pointer Approach
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int days = prices.length;
        int profit = 0; // cannot go negative

        int left = 0;
        int right = 1;

        while (right < days) {
            if (prices[left] < prices[right]) {
                profit = Math.max(profit, prices[right] - prices[left]);
            } else {
                left = right;
            }
            right++;
        }

        return profit;

    }

    public static void main(String[] args) {
        P1_BestTimeToBuySellStock bestTimeToBuySellStock = new P1_BestTimeToBuySellStock();
        int[] prices = {1};
        System.out.println(bestTimeToBuySellStock.maxProfit(prices));
    }
}

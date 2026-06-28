package Practice2025.Grind75.Array;

/**
 * Project: DSAlgo
 * Package: Practice2025.Grind75.Array
 * <p>
 * User: piyushbajaj
 * Date: 30/03/25
 * Time: 10:58 pm
 */
public class P2_BestTimeToBuySellStock {

    /**
     * TC: O(N), N: Number of days
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int minCost = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            minCost = Math.min(minCost, prices[i]);
            maxProfit = Math.max(prices[i] - minCost, maxProfit);
        }

        return maxProfit;
    }

    public static void main(String[] args) {

    }
}

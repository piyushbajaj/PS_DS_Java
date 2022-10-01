package StriverSDESheet.Arrays_Part1;

/**
 * Created by bajajp on 13 Aug, 2022
 */
public class P6_BuyAndSellStock {

    /**
     * TC: O(n^2)
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int profit = 0;
        int n = prices.length;

        for (int i = 0; i < n; i++) {
            int buy = prices[i];
            int maxSell = 0;
            for (int j = i + 1; j < n; j++) {
                if (prices[j] >= buy) {
                    maxSell = Math.max(maxSell, prices[j]);
                    profit = Math.max(profit, maxSell - buy);
                }
            }
        }
        return profit;
    }

    /**
     * TC: O(n)
     *
     * @param prices
     * @return
     */
    public static int maxProfit_better(int[] prices) {
        int maxProfit = 0, minPrice = Integer.MAX_VALUE;
        int n = prices.length;

        for (int i = 0; i < n; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit_better(arr));
    }
}

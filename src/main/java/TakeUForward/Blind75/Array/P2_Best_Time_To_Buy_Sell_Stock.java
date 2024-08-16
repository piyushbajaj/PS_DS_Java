package TakeUForward.Blind75.Array;

/**
 * Project: DS_Algo
 * Package: TakeUForward.Blind75.Array
 * <p>
 * User: piyushbajaj
 * Date: 06/03/23
 * Time: 11:34 am
 * <p>
 * lc: <a href="https://leetcode.com/problems/contains-duplicate/">...</a>
 */
public class P2_Best_Time_To_Buy_Sell_Stock {

    /**
     * TC: O(N)
     * SC: O(1)
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            int currProfit = prices[i] - min;
            if (currProfit > profit) {
                profit = currProfit;
            }
            if (prices[i] < min) {
                min = prices[i];
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
    }
}

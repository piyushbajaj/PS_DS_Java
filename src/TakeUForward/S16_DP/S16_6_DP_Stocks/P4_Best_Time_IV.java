package TakeUForward.S16_DP.S16_6_DP_Stocks;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S16_DP.S16_6_DP_Stocks
 * <p>
 * User: piyushbajaj
 * Date: 20/12/22
 * Time: 7:18 pm
 */
public class P4_Best_Time_IV {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        // Index, buy, cap
        int[][][] dp = new int[n + 1][2][k + 1];

        // base condition
        for (int j = 0; j < 2; j++) {
            for (int cap = 0; cap <= k; cap++) {
                dp[n][j][0] = 0;
            }
        }

        for (int index = n - 1; index >= 0; index--) {
            for (int buy = 0; buy < 2; buy++) {
                for (int cap = 1; cap <= k; cap++) {
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

        return dp[0][1][k];
    }

    public static void main(String[] args) {
        P4_Best_Time_IV p4_best_time_iv = new P4_Best_Time_IV();
        System.out.println(p4_best_time_iv.maxProfit(2, new int[] {3, 2, 6, 5, 0, 3}));
    }
}

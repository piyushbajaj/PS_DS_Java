package TakeUForward.S16_DP.S16_4_DP_Subsequences;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S16_DP.S16_4_DP_Subsequences
 * <p>
 * User: piyushbajaj
 * Date: 26/11/22
 * Time: 3:54 pm
 * <p>
 * Link g4g: <a href="https://practice.geeksforgeeks.org/problems/rod-cutting0840/1">...</a>
 */
public class P11_Rod_Cutting {
    /**
     * Recursion
     * TC: O(2^N)
     * SC: O(N)
     *
     * @param price
     * @param n
     * @return
     */
    public int cutRod_recur(int[] price, int n) {
        return cutRod_recur_util(price, n - 1, n);
    }

    public int cutRod_recur_util(int[] price, int index, int n) {
        // Base case
        if (index == 0) {
            return n * price[index];
        }

        int notPick = cutRod_recur_util(price, index - 1, n);
        int pick = Integer.MIN_VALUE;
        int rodLength = index + 1;
        if (rodLength <= n) {
            pick = price[index] + cutRod_recur_util(price, index, n - rodLength);
        }

        return Math.max(pick, notPick);
    }

    /**
     * Memoization
     *
     * @param price
     * @param n
     * @return
     */
    public int cutRod_mem(int[] price, int n) {
        int[][] dp = new int[price.length][n + 1];

        for (int i = 0; i < price.length; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        return cutRod_mem_util(price, n - 1, n, dp);
    }

    public int cutRod_mem_util(int[] price, int index, int n, int[][] dp) {
        // Base case
        if (index == 0) {
            return n * price[index];
        }

        if (dp[index][n] != -1) {
            return dp[index][n];
        }

        int notPick = cutRod_mem_util(price, index - 1, n, dp);
        int pick = Integer.MIN_VALUE;
        int rodLength = index + 1;
        if (rodLength <= n) {
            pick = price[index] + cutRod_mem_util(price, index, n - rodLength, dp);
        }

        return dp[index][n] = Math.max(pick, notPick);
    }

    /**
     * Tabulation
     *
     * @param price
     * @param n
     * @return
     */
    public int cutRod_tab(int[] price, int n) {
        int[][] dp = new int[n][n + 1];

        for (int N = 0; N <= n; N++) {
            dp[0][N] = n * price[0];
        }

        for (int index = 1; index < price.length; index++) {
            for (int maxRodLength = 0; maxRodLength <= n; maxRodLength++) {
                int notPick = dp[index - 1][maxRodLength];
                int pick = Integer.MIN_VALUE;
                int rodLength = index + 1;
                if (rodLength <= maxRodLength) {
                    pick = price[index] + dp[index][maxRodLength - rodLength];
                }

                dp[index][maxRodLength] = Math.max(pick, notPick);
            }
        }

        return dp[n - 1][n];
    }

    public static void main(String[] args) {
        P11_Rod_Cutting p11_rod_cutting = new P11_Rod_Cutting();
        int[] arr = {1, 5, 8, 9, 10, 17, 17, 20};

        System.out.println(p11_rod_cutting.cutRod_recur(arr, 8));

        System.out.println(p11_rod_cutting.cutRod_mem(arr, 8));

        System.out.println(p11_rod_cutting.cutRod_tab(arr, 8));
    }
}

package TakeUForward.Blind75.DynamicProgramming.Misc;

import java.util.Arrays;

/**
 * Project: DSAlgo
 * Package: TakeUForward.Blind75.DynamicProgramming.Misc
 * <p>
 * User: piyushbajaj
 * Date: 05/04/23
 * Time: 1:44 pm
 * <p>
 * ref: <a href="https://www.geeksforgeeks.org/ways-to-sum-to-n-using-natural-numbers-up-to-k-with-repetitions-allowed/">...</a>
 * <p>
 * Given two integers N and K, the task is to find the total number of ways of representing N as the sum of positive
 * integers in the range [1, K], where each integer can be chosen multiple times.
 * <p>
 * Input: N = 8, K = 2
 * Output: 5
 * <p>
 * Explanation: All possible ways of representing N as sum of positive integers less than or equal to K are:
 * <p>
 * {1, 1, 1, 1, 1, 1, 1, 1}, the sum is 8.
 * {2, 1, 1, 1, 1, 1, 1}, the sum is 8.
 * {2, 2, 1, 1, 1, 1}, the sum is 8.
 * 2, 2, 2, 1, 1}, the sum is 8.
 * {2, 2, 2, 2}}, the sum is 8.
 * Therefore, the total number of ways is 5.
 */
public class P1_WaysToSum {

    /**
     * TC: 2^N
     *
     * @param n
     * @param k
     * @return
     */
    public int waysToSum(int n, int k) {
        return waysToSum_util(n, k);
    }

    public int waysToSum_util(int n, int k) {
        if (n == 0) {
            return 1;
        }

        if (n < 0 || k <= 0) {
            return 0;
        }

        return waysToSum_util(n - k, k) + waysToSum_util(n, k - 1);
    }

    /**
     * Memoization: Not working correctly
     *
     * @param n
     * @param k
     * @return
     */
    public int waysToSum_mem(int n, int k) {
        int[] dp = new int[n + 1];

        Arrays.fill(dp, -1);

        return waysToSum_mem_util(n, k, dp);
    }

    public int waysToSum_mem_util(int n, int k, int[] dp) {
        // base
        dp[0] = 1;

        if (n < 0 || k <= 0) {
            return 0;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int c1 = 0;
        if (n >= k) {
            c1 = waysToSum_mem_util(n - k, k, dp);
        }

        int c2 = 0;
        if (k > 1) {
            c2 = waysToSum_mem_util(n, k - 1, dp);
        }

        return dp[n] = c1 + c2;
    }

    public static void main(String[] args) {
        P1_WaysToSum waysToSum = new P1_WaysToSum();
        System.out.println(waysToSum.waysToSum(4, 2));
        System.out.println(waysToSum.waysToSum(2, 2));

        System.out.println(waysToSum.waysToSum_mem(4, 2));
        System.out.println(waysToSum.waysToSum_mem(2, 2));
    }
}

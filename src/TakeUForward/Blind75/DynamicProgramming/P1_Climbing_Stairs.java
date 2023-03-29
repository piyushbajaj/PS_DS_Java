package TakeUForward.Blind75.DynamicProgramming;

import java.util.Arrays;

/**
 * Project: DS_Algo
 * Package: TakeUForward.Blind75.DynamicProgramming
 * <p>
 * User: piyushbajaj
 * Date: 26/01/23
 * Time: 7:12 pm
 * <p>
 * lc: <a href="https://leetcode.com/problems/climbing-stairs/description/">...</a>
 */
public class P1_Climbing_Stairs {

    public static void main(String[] args) {
        P1_Climbing_Stairs p1_climbing_stairs = new P1_Climbing_Stairs();
        System.out.println(p1_climbing_stairs.climbStairs(3));
        System.out.println(p1_climbing_stairs.climbStairs_mem(3));
        System.out.println(p1_climbing_stairs.climbStairs_tab(3));
    }

    /**
     * Recursive Approach: Top Down
     * TC: O(2^N)
     * SC: O(N)
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        return climbStairs_util(n);
    }

    public int climbStairs_util(int n) {
        // base condition
        if (n < 0) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        int climb1 = climbStairs_util(n - 1);
        int climb2 = climbStairs_util(n - 2);

        return climb1 + climb2;

    }

    /**
     * Memoization: Top-Down Approach
     * TC: O(N)
     * SC: O(N) + O(N)
     *
     * @param n
     * @return
     */
    public int climbStairs_mem(int n) {
        int[] dp = new int[n + 1];

        Arrays.fill(dp, -1);

        return climbStairs_mem_util(n, dp);
    }

    public int climbStairs_mem_util(int n, int[] dp) {
        // base case
        dp[0] = 1;

        if (dp[n] != -1) {
            return dp[n];
        }

        int climb1 = 0, climb2 = 0;

        if (n >= 1) {
            climb1 = climbStairs_mem_util(n - 1, dp);
        }

        if (n >= 2) {
            climb2 = climbStairs_mem_util(n - 2, dp);
        }

        return dp[n] = climb1 + climb2;
    }

    /**
     * To remove Auxiliary Space, Tabulation gets introduced here.
     * Its Bottom Up Approach means starting from leaf node, and we go to root.
     * TC: O(N)
     * SC: O(N)
     *
     * @param n
     * @return
     */
    public int climbStairs_tab(int n) {
        // base case
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            int climb1 = 0, climb2 = 0;
            climb1 = dp[i - 1];
            if (i >= 2) {
                climb2 = dp[i - 2];
            }
            dp[i] = climb1 + climb2;
        }

        return dp[n];
    }

    /**
     * Optimizing tabulation for Space
     * TC: O(N)
     * SC: O(1)
     *
     * @param n
     * @return
     */
    public int climbStairs_tab_improve(int n) {
        // base case
        int climb1 = 1;
        int climb2 = 1;
        int sum = climb2;

        for (int i = 2; i <= n; i++) {
            sum = climb1 + climb2;
            climb2 = climb1;
            climb1 = sum;
        }

        return sum;
    }
}

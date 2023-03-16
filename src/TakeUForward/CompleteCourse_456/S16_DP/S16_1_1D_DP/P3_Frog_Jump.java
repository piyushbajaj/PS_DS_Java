package TakeUForward.CompleteCourse_456.S16_DP.S16_1_1D_DP;

import java.util.Arrays;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S16_DP
 * <p>
 * User: piyushbajaj
 * Date: 11/11/22
 * Time: 2:00 pm
 * <p>
 * ninja: <a href="https://www.codingninjas.com/codestudio/problems/frog-jump_3621012">...</a>
 * g4g: <a href="https://practice.geeksforgeeks.org/problems/geek-jump/1">...</a>
 */
public class P3_Frog_Jump {
    /**
     * Recursive Way
     * TC: O(2^N)
     *
     * @param n
     * @param heights
     * @return
     */
    public int frogJump(int n, int heights[]) {
        if (n == 0) {
            return 0;
        }

        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;

        if (n > 0) {
            left = frogJump(n - 1, heights) + Math.abs(heights[n] - heights[n - 1]);
        }

        if (n > 1) {
            right = frogJump(n - 2, heights) + Math.abs(heights[n] - heights[n - 2]);
        }

        return Math.min(left, right);
    }

    /**
     * Memoization
     * <p>
     * TC: O(N)
     * SC: O(N) -> Array + O(N) -> Recursive Stack
     *
     * @param n
     * @param heights
     * @return
     */
    public int frogJump_mem(int n, int[] heights) {
        int[] dp = new int[heights.length];

        Arrays.fill(dp, -1);

        return frogJump_mem_util(n, heights, dp);
    }

    public int frogJump_mem_util(int n, int[] heights, int[] dp) {
        if (n == 0) {
            return 0;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;

        left = frogJump_mem(n - 1, heights) + Math.abs(heights[n] - heights[n - 1]);


        if (n > 1) {
            right = frogJump_mem(n - 2, heights) + Math.abs(heights[n] - heights[n - 2]);
        }

        return dp[n] = Math.min(left, right);
    }

    /**
     * Tabulation
     * <p>
     * TC: O(N)
     * SC: O(N)
     *
     * @param n
     * @param heights
     * @return
     */
    public int frogJump_tab(int n, int[] heights) {
        int[] dp = new int[heights.length];

        Arrays.fill(dp, -1);

        return frogJump_tab_util(n, heights, dp);
    }

    public int frogJump_tab_util(int n, int[] heights, int[] dp) {
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int left = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            int right = Integer.MAX_VALUE;
            if (i > 1) {
                right = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
            }

            dp[i] = Math.min(left, right);
        }

        return dp[n];
    }

    /**
     * Tabulation with Space Optimization - Best
     * TC: O(N)
     * SC: O(1)
     *
     * @param n
     * @param heights
     * @return
     */
    public int frogJump_tab_improve(int n, int[] heights) {
        int prevFirst = 0, prevSecond = 0;

        for (int i = 1; i <= n; i++) {
            int left = prevFirst + Math.abs(heights[i] - heights[i - 1]);
            int right = Integer.MAX_VALUE;
            if (i > 1) {
                right = prevSecond + Math.abs(heights[i] - heights[i - 2]);
            }

            int curr = Math.min(left, right);
            prevSecond = prevFirst;
            prevFirst = curr;
        }

        return prevFirst;
    }

    public static void main(String[] args) {
        P3_Frog_Jump p3_frog_jump = new P3_Frog_Jump();

        System.out.println(p3_frog_jump.frogJump(3, new int[] {10, 20, 30, 10}));
        System.out.println(p3_frog_jump.frogJump_mem(3, new int[] {10, 20, 30, 10}));
        System.out.println(p3_frog_jump.frogJump_tab(3, new int[] {10, 20, 30, 10}));
        System.out.println(p3_frog_jump.frogJump_tab_improve(3, new int[] {10, 20, 30, 10}));
    }
}

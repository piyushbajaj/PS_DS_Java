package TakeUForward.S16_DP.S16_1_1D_DP;

import java.util.Arrays;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S16_DP
 * <p>
 * User: piyushbajaj
 * Date: 11/11/22
 * Time: 5:21 pm
 */
public class P4_Frog_Jump_K_Distance {

    /**
     * Memoization
     * TC: O(N*K)
     * SC: O(N) + O(K)
     *
     * @param n
     * @param k
     * @param heights
     * @return
     */
    public int frogJump_mem(int n, int k, int[] heights) {
        int[] dp = new int[heights.length];

        Arrays.fill(dp, -1);

        return frogJump_mem_util(n, k, heights, dp);
    }

    public int frogJump_mem_util(int n, int k, int[] heights, int[] dp) {
        if (n == 0) {
            return 0;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int jump = Integer.MAX_VALUE, minJump = Integer.MAX_VALUE;
        for (int j = 1; j <= k; j++) {

            if (n - j >= 0) {
                jump = frogJump_mem_util(n - j, k, heights, dp) + Math.abs(heights[n] - heights[n - j]);
            }

            minJump = Math.min(minJump, jump);
        }

        return dp[n] = minJump;
    }

    /**
     * Tabulation
     * TC: O(N*K)
     * SC: O(N)
     *
     * @param n
     * @param k
     * @param heights
     * @return
     */
    public int frogJump_tab(int n, int k, int[] heights) {
        int[] dp = new int[heights.length];

        return frogJump_tab_util(n, k, heights, dp);
    }

    public int frogJump_tab_util(int n, int k, int[] heights, int[] dp) {
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int jump = Integer.MAX_VALUE, minJump = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {

                if (i - j >= 0) {
                    jump = dp[i - j] + Math.abs(heights[i] - heights[i - j]);
                }

                minJump = Math.min(minJump, jump);
            }
            dp[i] = minJump;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        P4_Frog_Jump_K_Distance p4_frog_jump_k_distance = new P4_Frog_Jump_K_Distance();

        System.out.println(p4_frog_jump_k_distance.frogJump_mem(3, 2, new int[] {10, 20, 30, 10}));

        System.out.println(p4_frog_jump_k_distance.frogJump_tab(3, 2, new int[] {10, 20, 30, 10}));
    }
}

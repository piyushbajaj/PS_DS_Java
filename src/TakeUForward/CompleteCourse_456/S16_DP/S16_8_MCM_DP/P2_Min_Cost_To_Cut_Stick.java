package TakeUForward.CompleteCourse_456.S16_DP.S16_8_MCM_DP;

import java.util.Arrays;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S16_DP.S16_8_MCM_DP
 * <p>
 * User: piyushbajaj
 * Date: 05/01/23
 * Time: 2:41 pm
 * <p>
 * lc: <a href="https://leetcode.com/problems/minimum-cost-to-cut-a-stick/description/">...</a>
 */
public class P2_Min_Cost_To_Cut_Stick {
    /**
     * Recursive
     * TC: Exponential
     * SC: O(N) + O(N) + O(N)
     *
     * @param n
     * @param cuts
     * @return
     */
    public int minCost_recur(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[] temp = new int[cuts.length + 2];

        temp[0] = 0;
        temp[cuts.length + 1] = n;
        System.arraycopy(cuts, 0, temp, 1, cuts.length);
        return minCost_recur_util(1, cuts.length, temp);
    }

    public int minCost_recur_util(int i, int j, int[] cuts) {
        if (i > j) {
            return 0;
        }

        int mini = Integer.MAX_VALUE;

        for (int index = i; index <= j; index++) {
            int cost =
                cuts[j + 1] - cuts[i - 1] + minCost_recur_util(i, index - 1, cuts) +
                    minCost_recur_util(index + 1, j, cuts);
            mini = Math.min(mini, cost);
        }

        return mini;
    }

    /**
     * Memoization
     * TC: O(n*logN) + O(N*N*N)
     * SC: O(N*N) + O(N)
     *
     * @param n
     * @param cuts
     * @return
     */
    public int minCost_mem(int n, int[] cuts) {

        Arrays.sort(cuts);
        int[] temp = new int[cuts.length + 2];
        int[][] dp = new int[cuts.length + 1][cuts.length + 1];

        for (int i = 0; i <= cuts.length; i++) {
            for (int j = 0; j <= cuts.length; j++) {
                dp[i][j] = -1;
            }
        }

        temp[0] = 0;
        temp[cuts.length + 1] = n;
        System.arraycopy(cuts, 0, temp, 1, cuts.length);
        return minCost_mem_util(dp, 1, cuts.length, temp);
    }

    public int minCost_mem_util(int[][] dp, int i, int j, int[] cuts) {
        //base case
        if (i > j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int mini = Integer.MAX_VALUE;

        for (int index = i; index <= j; index++) {
            int cost =
                cuts[j + 1] - cuts[i - 1] + minCost_mem_util(dp, i, index - 1, cuts) +
                    minCost_mem_util(dp, index + 1, j, cuts);
            mini = Math.min(mini, cost);
        }

        return dp[i][j] = mini;
    }

    /**
     * Tabulation
     * 1. Copy the base case
     * 2. Write down the changing parameter
     * 3. Copy the changing parameter
     * <p>
     * TC: O(N*N*N) + O(NlogN)
     * SC: O(N*N)
     *
     * @param n
     * @param cuts
     * @return
     */
    public int minCost_tab(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[] temp = new int[cuts.length + 2];
        int[][] dp = new int[cuts.length + 2][cuts.length + 2];

        temp[0] = 0;
        temp[cuts.length + 1] = n;
        System.arraycopy(cuts, 0, temp, 1, cuts.length);

        for (int i = cuts.length; i >= 1; i--) {
            for (int j = 1; j <= cuts.length; j++) {
                int mini = (int) 1e9;

                if (i > j) {
                    continue;
                }

                for (int index = i; index <= j; index++) {
                    int cost =
                        temp[j + 1] - temp[i - 1] + dp[i][index - 1] +
                            dp[index + 1][j];
                    mini = Math.min(mini, cost);
                }

                dp[i][j] = mini;
            }
        }

        return dp[1][cuts.length];

    }

    public static void main(String[] args) {
        P2_Min_Cost_To_Cut_Stick p2_min_cost_to_cut_stick = new P2_Min_Cost_To_Cut_Stick();
        System.out.println(p2_min_cost_to_cut_stick.minCost_recur(9, new int[] {5, 6, 1, 4, 2}));
        System.out.println(p2_min_cost_to_cut_stick.minCost_mem(9, new int[] {5, 6, 1, 4, 2}));
        System.out.println(p2_min_cost_to_cut_stick.minCost_tab(9, new int[] {5, 6, 1, 4, 2}));
    }
}

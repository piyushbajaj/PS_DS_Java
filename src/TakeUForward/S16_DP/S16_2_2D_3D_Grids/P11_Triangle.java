package TakeUForward.S16_DP.S16_2_2D_3D_Grids;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S16_DP.S16_2_2D_DP_Grids
 * <p>
 * User: piyushbajaj
 * Date: 14/11/22
 * Time: 8:34 pm
 * <p>
 * Link: <a href="https://leetcode.com/problems/triangle/">...</a>
 */
public class P11_Triangle {

    /**
     * Recursion
     * TC: O[2^(N*(N+1)/2)]
     * SC: O(N)
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        return minimumTotal_recur(triangle, 0, 0, n);
    }

    public int minimumTotal_recur(List<List<Integer>> triangle, int i, int j, int n) {
        if (i == n - 1) {
            return triangle.get(i).get(j);
        }

        int d = minimumTotal_recur(triangle, i + 1, j, n);
        int dg = minimumTotal_recur(triangle, i + 1, j + 1, n);

        return Math.min(d, dg) + triangle.get(i).get(j);
    }

    /**
     * Memoization
     * TC: O(N*(M^2))
     * SC: O(N*M) + O(N + M)
     *
     * @param triangle
     * @return
     */
    public int minimumTotal_mem(List<List<Integer>> triangle) {
        int n = triangle.size();

        int[][] dp = new int[n][triangle.get(n - 1).size() - 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < triangle.get(n - 1).size() - 1; j++) {
                dp[i][j] = -1;
            }
        }

        return minimumTotal_mem_util(triangle, 0, 0, n, dp);
    }

    public int minimumTotal_mem_util(List<List<Integer>> triangle, int i, int j, int n, int[][] dp) {
        if (i == n - 1) {
            return triangle.get(i).get(j);
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int d = minimumTotal_mem_util(triangle, i + 1, j, n, dp);
        int dg = minimumTotal_mem_util(triangle, i + 1, j + 1, n, dp);

        return dp[i][j] = Math.min(d, dg) + triangle.get(i).get(j);
    }

    /**
     * Tabulation
     * <p>
     * TC: O(N*N)
     * SC: O(N*N)
     *
     * @param triangle
     * @return
     */
    public int minimumTotal_tab(List<List<Integer>> triangle) {
        int n = triangle.size();

        int[][] dp = new int[n][triangle.get(n - 1).size()];

        // base case - filling for the last row
        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = triangle.get(n - 1).get(j);
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int d = dp[i + 1][j];
                int dg = dp[i + 1][j + 1];

                dp[i][j] = Math.min(d, dg) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    /**
     * Best Approach with Improved Tabulation
     * TC: O(N*N)
     * SC: O(N)
     *
     * @param triangle
     * @return
     */
    public int minimumTotal_tab_better(List<List<Integer>> triangle) {
        int n = triangle.size();

        // previous row
        int[] prev = new int[n];

        // base case - filling for the last row
        for (int j = 0; j < n; j++) {
            prev[j] = triangle.get(n - 1).get(j);
        }

        for (int i = n - 2; i >= 0; i--) {
            int[] curr = new int[n];

            for (int j = i; j >= 0; j--) {
                int d = prev[j];
                int dg = prev[j + 1];

                curr[j] = Math.min(d, dg) + triangle.get(i).get(j);
            }

            prev = curr;
        }
        return prev[0];
    }

    public static void main(String[] args) {
        P11_Triangle p11_triangle = new P11_Triangle();
        List<List<Integer>> triangle = Arrays.asList(
            Collections.singletonList(2), Arrays.asList(3, 4), Arrays.asList(6, 5, 7),
            Arrays.asList(4, 1, 8, 3));
        System.out.println(p11_triangle.minimumTotal(triangle));

        System.out.println(p11_triangle.minimumTotal_mem(triangle));

        System.out.println(p11_triangle.minimumTotal_tab(triangle));

        System.out.println(p11_triangle.minimumTotal_tab_better(triangle));
    }
}

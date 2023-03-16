package TakeUForward.CompleteCourse_456.S16_DP.S16_2_2D_3D_Grids;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S16_DP.S16_2_2D_DP_Grids
 * <p>
 * User: piyushbajaj
 * Date: 14/11/22
 * Time: 5:37 pm
 * <p>
 * Link lc: <a href="https://leetcode.com/problems/minimum-path-sum/">...</a>
 */
public class P10_Min_Path_Sum {

    /**
     * Recursion
     * TC: O(2^(M*N))
     * SC: O((m-1) + (n-1))
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        return minPathSum(n - 1, m - 1, grid);
    }

    public int minPathSum(int i, int j, int[][] grid) {
        // base case
        if (i == 0 && j == 0) {
            return grid[0][0];
        }

        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }

        int up = minPathSum(i - 1, j, grid);
        int left = minPathSum(i, j - 1, grid);

        return Math.min(up, left) + grid[i][j];
    }

    /**
     * Memoization
     * TC: O(N*M)
     * SC: O(N*M) + O(N-1 + M-1)
     *
     * @param grid
     * @return
     */
    public int minPathSum_mem(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }

        return minPathSum_mem(n - 1, m - 1, grid, dp);
    }

    public int minPathSum_mem(int i, int j, int[][] grid, int[][] dp) {
        // base case
        if (i == 0 && j == 0) {
            return grid[0][0];
        }

        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int up = minPathSum_mem(i - 1, j, grid, dp);
        int left = minPathSum_mem(i, j - 1, grid, dp);

        return dp[i][j] = Math.min(up, left) + grid[i][j];
    }

    /**
     * Tabulation
     * TC: O(N*M)
     * SC: O(N*M)
     *
     * @param grid
     * @return
     */
    public int minPathSum_tab(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = grid[0][0];
                } else {
                    int up, left;
                    if (i > 0) {
                        up = dp[i - 1][j];
                    } else {
                        up = Integer.MAX_VALUE;
                    }

                    if (j > 0) {
                        left = dp[i][j - 1];
                    } else {
                        left = Integer.MAX_VALUE;
                    }

                    dp[i][j] = Math.min(up, left) + grid[i][j];
                }
            }
        }

        return dp[n - 1][m - 1];
    }

    /**
     * Space Optimization with Tabulation
     * <p>
     * TC: O(N*M)
     * SC: O(M)
     *
     * @param grid
     * @return
     */
    public int minPathSum_tab_better(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // Previous row
        int[] prev = new int[m];

        for (int i = 0; i < n; i++) {
            // Current row
            int[] curr = new int[m];
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    curr[j] = grid[0][0];
                } else {
                    int up = 0, left = 0;
                    if (i > 0) {
                        up = prev[j];
                    } else {
                        up = Integer.MAX_VALUE;
                    }

                    if (j > 0) {
                        left = curr[j - 1];
                    } else {
                        left = Integer.MAX_VALUE;
                    }
                    curr[j] = Math.min(up, left) + grid[i][j];
                }
            }
            prev = curr;
        }

        return prev[m - 1];
    }

    public static void main(String[] args) {
        P10_Min_Path_Sum p10_min_path_sum = new P10_Min_Path_Sum();
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(p10_min_path_sum.minPathSum(grid));

        System.out.println(p10_min_path_sum.minPathSum_mem(grid));

        System.out.println(p10_min_path_sum.minPathSum_tab(grid));

        System.out.println(p10_min_path_sum.minPathSum_tab_better(grid));
    }
}

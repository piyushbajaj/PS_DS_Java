package TakeUForward.CompleteCourse_456.S16_DP.S16_2_2D_3D_Grids;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S16_DP.S16_2_2D_DP_Grids
 * <p>
 * User: piyushbajaj
 * Date: 14/11/22
 * Time: 8:59 am
 * <p>
 * Link: <a href="https://www.codingninjas.com/codestudio/problems/total-unique-paths_1081470">...</a>
 * Link lc: <a href="https://leetcode.com/problems/unique-paths/">...</a>
 */
public class P8_Unique_Paths {

    public static void main(String[] args) {
        P8_Unique_Paths p8_unique_paths = new P8_Unique_Paths();
        System.out.println(p8_unique_paths.uniquePaths(2, 2));

        System.out.println(p8_unique_paths.uniquePaths_mem(2, 2));

        System.out.println(p8_unique_paths.uniquePaths_tab(2, 2));

        System.out.println(p8_unique_paths.uniquePaths_tab_improve(2, 2));
    }

    /**
     * Recursion
     * <p>
     * TC: O(2^(M*N))
     * SC: O(Path Length) -> O(m-1 + n-1)
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        return uniquePaths_util(m - 1, n - 1);
    }

    public int uniquePaths_util(int i, int j) {
        // Base case
        if (i == 0 && j == 0) {
            return 1;
        }

        // Corner case if the rows and cols breach
        if (i < 0 || j < 0) {
            return 0;
        }

        // Starting from bottom right, then we can only go up and left
        int up = uniquePaths_util(i - 1, j);
        int down = uniquePaths_util(i, j - 1);

        // Return the sum
        return up + down;
    }

    /**
     * Overlapping sub-problem: Memoization
     * <p>
     * TC: O(M*N)
     * SC: O(Path length: (m-1) + (n-1)) + O(M*N)
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths_mem(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        return uniquePaths_mem_util(m - 1, n - 1, dp);
    }

    public int uniquePaths_mem_util(int i, int j, int[][] dp) {
        // Base case
        if (i == 0 && j == 0) {
            return 1;
        }

        // Corner case if the rows and cols breach
        if (i < 0 || j < 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Starting from bottom right, then we can only go up and left
        int up = uniquePaths_util(i - 1, j);
        int down = uniquePaths_util(i, j - 1);

        // Return the sum
        return dp[i][j] = up + down;
    }

    /**
     * Tabulation
     * TC: O(M*N)
     * SC: O(M*N)
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths_tab(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else {
                    int up = 0, left = 0;

                    if (i > 0) {
                        up = dp[i - 1][j];
                    }

                    if (j > 0) {
                        left = dp[i][j - 1];
                    }

                    dp[i][j] = up + left;
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    /**
     * Tabulation with Space Optimization
     * TC: O(M*N)
     * SC: O(N)
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths_tab_improve(int m, int n) {
        // previous row
        int[] prev = new int[n];

        for (int i = 0; i < m; i++) {
            // current row
            int[] curr = new int[n];
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    curr[j] = 1;
                } else {
                    int up = 0, left = 0;

                    if (i > 0) {
                        up = prev[j];
                    }

                    if (j > 0) {
                        left = curr[j - 1];
                    }

                    curr[j] = up + left;
                }
            }
            prev = curr;
        }

        return prev[n - 1];

    }
}

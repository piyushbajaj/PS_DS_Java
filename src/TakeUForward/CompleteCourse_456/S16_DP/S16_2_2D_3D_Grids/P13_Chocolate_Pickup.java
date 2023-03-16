package TakeUForward.CompleteCourse_456.S16_DP.S16_2_2D_3D_Grids;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S16_DP.S16_2_2D_DP_Grids
 * <p>
 * User: piyushbajaj
 * Date: 16/11/22
 * Time: 5:37 pm
 */
public class P13_Chocolate_Pickup {
    /**
     * Recursion
     * TC: O(3^N * 3^N)
     * SC: O(N)
     *
     * @param r
     * @param c
     * @param grid
     * @return
     */
    public int maximumChocolates(int r, int c, int[][] grid) {
        return maximumChocolates_recur_util(0, 0, grid[0].length - 1, grid, r, c);
    }

    public int maximumChocolates_recur_util(int i, int j1, int j2, int[][] grid, int n, int m) {
        // out of bound case
        if (j1 < 0 || j1 >= m || j2 < 0 || j2 >= m) {
            return (int) -1e9;
        }

        // base case
        if (i == n - 1) {
            if (j1 == j2) {
                return grid[i][j1];
            } else {
                return grid[i][j1] + grid[i][j2];
            }
        }

        // Going in three directions for the columns: -1, 0, 1
        int maxi = (int) -1e9;
        for (int aliceJth = -1; aliceJth <= 1; aliceJth++) {
            for (int bobJth = -1; bobJth <= 1; bobJth++) {
                if (j1 == j2) {
                    maxi = Math.max(maxi, grid[i][j1] +
                        maximumChocolates_recur_util(i + 1, j1 + aliceJth, j2 + bobJth, grid, n, m));
                } else {
                    maxi = Math.max(maxi, grid[i][j1] + grid[i][j2] +
                        maximumChocolates_recur_util(i + 1, j1 + aliceJth, j2 + bobJth, grid, n, m));
                }
            }
        }

        return maxi;
    }

    /**
     * Memoization
     * TC: O(N*M*M) * 9 States
     * SC: O(N*M*M) + O(N): Auxiliary stack space
     *
     * @param r
     * @param c
     * @param grid
     * @return
     */
    public int maximumChocolates_mem(int r, int c, int[][] grid) {
        int[][][] dp = new int[r][c][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                for (int k = 0; k < c; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return maximumChocolates_mem_util(0, 0, grid[0].length - 1, grid, r, c, dp);
    }

    public int maximumChocolates_mem_util(int i, int j1, int j2, int[][] grid, int n, int m, int[][][] dp) {
        // out of bound case
        if (j1 < 0 || j1 >= m || j2 < 0 || j2 >= m) {
            return (int) -1e9;
        }

        // base case
        if (i == n - 1) {
            if (j1 == j2) {
                return grid[i][j1];
            } else {
                return grid[i][j1] + grid[i][j2];
            }
        }

        if (dp[i][j1][j2] != -1) {
            return dp[i][j1][j2];
        }

        // Going in three directions for the columns: -1, 0, 1
        int maxi = (int) -1e9;
        for (int aliceJth = -1; aliceJth <= 1; aliceJth++) {
            for (int bobJth = -1; bobJth <= 1; bobJth++) {
                if (j1 == j2) {
                    maxi = Math.max(maxi, grid[i][j1] +
                        maximumChocolates_mem_util(i + 1, j1 + aliceJth, j2 + bobJth, grid, n, m, dp));
                } else {
                    maxi = Math.max(maxi, grid[i][j1] + grid[i][j2] +
                        maximumChocolates_mem_util(i + 1, j1 + aliceJth, j2 + bobJth, grid, n, m, dp));
                }
            }
        }

        return dp[i][j1][j2] = maxi;
    }

    public int maximumChocolates_tabulation(int r, int c, int[][] grid) {
        int[][][] dp = new int[r][c][c];
        int n = grid.length;
        int m = grid[0].length;

        // base case
        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2) {
                    dp[n - 1][j1][j2] = grid[n - 1][j1];
                } else {
                    dp[n - 1][j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
                }
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    // Going in three directions for the columns: -1, 0, 1
                    int maxi = (int) -1e9;
                    for (int aliceJth = -1; aliceJth <= 1; aliceJth++) {
                        for (int bobJth = -1; bobJth <= 1; bobJth++) {
                            if (j1 == j2) {
                                if (j1 + aliceJth >= 0 && j1 + aliceJth < m &&
                                    j2 + bobJth >= 0 && j2 + bobJth < m) {
                                    maxi = Math.max(maxi, grid[i][j1] +
                                        dp[i + 1][j1 + aliceJth][j2 + bobJth]);
                                }
                            } else {
                                if (j1 + aliceJth >= 0 && j1 + aliceJth < m &&
                                    j2 + bobJth >= 0 && j2 + bobJth < m) {
                                    maxi = Math.max(maxi, grid[i][j1] + grid[i][j2] +
                                        dp[i + 1][j1 + aliceJth][j2 + bobJth]);
                                }
                            }
                        }
                    }
                    dp[i][j1][j2] = maxi;
                }
            }
        }

        return dp[0][0][grid[0].length - 1];
    }

    public static void main(String[] args) {
        P13_Chocolate_Pickup p13_chocolate_pickup = new P13_Chocolate_Pickup();
        int[][] grid = {{2, 3, 1, 2}, {3, 4, 2, 2}, {5, 6, 3, 5}};

        System.out.println(p13_chocolate_pickup.maximumChocolates(grid.length, grid[0].length, grid));

        System.out.println(p13_chocolate_pickup.maximumChocolates_mem(grid.length, grid[0].length, grid));

        System.out.println(p13_chocolate_pickup.maximumChocolates_tabulation(grid.length, grid[0].length, grid));
    }
}

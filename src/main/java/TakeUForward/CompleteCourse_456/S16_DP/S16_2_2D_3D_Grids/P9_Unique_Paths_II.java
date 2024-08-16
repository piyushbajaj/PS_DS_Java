package TakeUForward.CompleteCourse_456.S16_DP.S16_2_2D_3D_Grids;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S16_DP.S16_2_2D_DP_Grids
 * <p>
 * User: piyushbajaj
 * Date: 14/11/22
 * Time: 4:17 pm
 * <p>
 * Link: <a href="https://leetcode.com/problems/unique-paths-ii/">...</a>
 */
public class P9_Unique_Paths_II {

    public static void main(String[] args) {
        P9_Unique_Paths_II p9_unique_paths_ii = new P9_Unique_Paths_II();
        int[][] mat = {{0, 0, 0}, {0, 1, 0},
            {0, 0, 0}};

        System.out.println(p9_unique_paths_ii.uniquePathsWithObstacles(mat));
    }

    /**
     * Tabulation with Space Optimization
     * TC: O(M*N)
     * SC: O(N)
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        // previous row
        int[] prev = new int[m];

        for (int i = 0; i < n; i++) {
            // current row
            int[] curr = new int[m];
            for (int j = 0; j < m; j++) {
                if (obstacleGrid[i][j] == 1) {
                    curr[j] = 0;
                } else if (i == 0 && j == 0) {
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

        return prev[m - 1];
    }
}

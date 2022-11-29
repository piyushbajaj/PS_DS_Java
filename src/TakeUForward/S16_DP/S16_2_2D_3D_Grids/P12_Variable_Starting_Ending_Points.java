package TakeUForward.S16_DP.S16_2_2D_3D_Grids;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S16_DP.S16_2_2D_DP_Grids
 * <p>
 * User: piyushbajaj
 * Date: 15/11/22
 * Time: 6:47 pm
 */
public class P12_Variable_Starting_Ending_Points {

    /**
     * TC: O(m) * O(3^n)
     * SC: O(N)
     *
     * @param matrix
     * @return
     */
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int sum = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            sum = Math.min(sum, minFallingPathSum_util(n - 1, j, matrix));
        }

        return sum;
    }

    public int minFallingPathSum_util(int i, int j, int[][] matrix) {
        // base case
        if (j < 0 || j >= matrix[0].length) {
            return Integer.MAX_VALUE;
        }

        if (i == 0) {
            return matrix[i][j];
        }

        int ld = minFallingPathSum_util(i - 1, j - 1, matrix);
        int s = minFallingPathSum_util(i - 1, j, matrix);
        int rd = minFallingPathSum_util(i - 1, j + 1, matrix);

        return Math.min(Math.min(ld, s), rd) + matrix[i][j];
    }

    /**
     * Memoization
     * <p>
     * TC: O(N*M) + O(N*M)
     * SC: O(N*M) + O(3*N)
     *
     * @param matrix
     * @return
     */
    public int minFallingPathSum_mem(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }

        int sum = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            sum = Math.min(sum, minFallingPathSum_mem_util(n - 1, j, matrix, dp));
        }

        return sum;
    }

    public int minFallingPathSum_mem_util(int i, int j, int[][] matrix, int[][] dp) {
        // base case
        if (j < 0 || j >= matrix[0].length) {
            return Integer.MAX_VALUE;
        }

        if (i == 0) {
            return matrix[i][j];
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int ld = minFallingPathSum_mem_util(i - 1, j - 1, matrix, dp);
        int s = minFallingPathSum_mem_util(i - 1, j, matrix, dp);
        int rd = minFallingPathSum_mem_util(i - 1, j + 1, matrix, dp);

        return dp[i][j] = Math.min(Math.min(ld, s), rd) + matrix[i][j];
    }

    /**
     * Tabulation
     * TC: O(N*M)
     * SC: O(N*M)
     *
     * @param matrix
     * @return
     */
    public int minFallingPathSum_tabulation(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];

        // base case
        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int ld = 0, s = 0, rd = 0;
                if (j > 0) {
                    ld = dp[i - 1][j - 1];
                } else {
                    ld = (int) 1e9;
                }
                s = dp[i - 1][j];
                if (j < m - 1) {
                    rd = dp[i - 1][j + 1];
                } else {
                    rd = (int) 1e9;
                }

                dp[i][j] = Math.min(Math.min(ld, s), rd) + matrix[i][j];
            }
        }

        int min = dp[n - 1][0];

        for (int j = 1; j < m; j++) {
            min = Math.min(min, dp[n - 1][j]);
        }

        return min;
    }

    public int minFallingPathSum_tabulation_better(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // prev row
        int[] prev = new int[m];

        // base case
        for (int j = 0; j < m; j++) {
            prev[j] = matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            // curr row
            int[] curr = new int[m];

            for (int j = 0; j < m; j++) {
                int ld = 0, s = 0, rd = 0;
                if (j > 0) {
                    ld = prev[j - 1];
                } else {
                    ld = (int) 1e9;
                }
                s = prev[j];
                if (j < m - 1) {
                    rd = prev[j + 1];
                } else {
                    rd = (int) 1e9;
                }

                curr[j] = Math.min(Math.min(ld, s), rd) + matrix[i][j];
            }

            prev = curr;
        }

        int min = prev[0];

        for (int j = 1; j < m; j++) {
            min = Math.min(min, prev[j]);
        }

        return min;
    }

    public static void main(String[] args) {
        P12_Variable_Starting_Ending_Points p12_variable_starting_ending_points =
            new P12_Variable_Starting_Ending_Points();

        int[][] matrix = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        System.out.println(p12_variable_starting_ending_points.minFallingPathSum(matrix));

        System.out.println(p12_variable_starting_ending_points.minFallingPathSum_mem(matrix));

        System.out.println(p12_variable_starting_ending_points.minFallingPathSum_tabulation(matrix));

        System.out.println(p12_variable_starting_ending_points.minFallingPathSum_tabulation_better(matrix));
    }
}

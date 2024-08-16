package TakeUForward.Blind75.DynamicProgramming;

/**
 * Project: DS_Algo
 * Package: TakeUForward.Blind75.DynamicProgramming
 * <p>
 * User: piyushbajaj
 * Date: 02/02/23
 * Time: 4:11 pm
 * <p>
 * LC: <a href="https://leetcode.com/problems/unique-paths/">...</a>
 */
public class P10_Unique_Paths {

    public static void main(String[] args) {
        P10_Unique_Paths p10_unique_paths = new P10_Unique_Paths();
        System.out.println(p10_unique_paths.uniquePaths_recur(3, 7));
        System.out.println(p10_unique_paths.uniquePaths_mem(3, 7));
        System.out.println(p10_unique_paths.uniquePaths_tab(3, 7));
    }

    /**
     * Recursion way
     * TC: O(2^N)
     * SC: O(M+N)
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths_recur(int m, int n) {
        return uniquePaths_recur_util(m, m - 1, n, n - 1);
    }

    public int uniquePaths_recur_util(int m, int mth, int n, int nth) {
        // base
        if (mth == 0 && nth == 0) {
            return 1;
        }

        if (mth < 0 || nth < 0) {
            return 0;
        }
        // going up
        int lenUp = uniquePaths_recur_util(m, mth - 1, n, nth);

        int lenLeft = uniquePaths_recur_util(m, mth, n, nth - 1);

        return lenUp + lenLeft;
    }

    /**
     * Memoization
     * TC: O(M*N)
     * SC: O(M*N) + O(M+N): Auxiliary
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

        return uniquePaths_mem_util(dp, m - 1, n - 1);
    }

    public int uniquePaths_mem_util(int[][] dp, int mth, int nth) {
        // base
        if (mth == 0 && nth == 0) {
            return 1;
        }

        if (mth < 0 || nth < 0) {
            return 0;
        }

        if (dp[mth][nth] != -1) {
            return dp[mth][nth];
        }

        // going up
        int lenUp = uniquePaths_mem_util(dp, mth - 1, nth);

        // going left
        int lenLeft = uniquePaths_mem_util(dp, mth, nth - 1);

        return dp[mth][nth] = lenUp + lenLeft;
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

        for (int mth = 0; mth < m; mth++) {
            for (int nth = 0; nth < n; nth++) {
                if (mth == 0 && nth == 0) {
                    dp[mth][nth] = 1;
                } else {
                    // going up
                    int lenUp = 0;
                    if (mth > 0) {
                        lenUp = dp[mth - 1][nth];
                    }
                    // going right
                    int lenLeft = 0;
                    if (nth > 0) {
                        lenLeft = dp[mth][nth - 1];
                    }

                    dp[mth][nth] = lenUp + lenLeft;
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}

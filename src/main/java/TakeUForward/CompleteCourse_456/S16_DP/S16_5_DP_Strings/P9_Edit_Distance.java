package TakeUForward.CompleteCourse_456.S16_DP.S16_5_DP_Strings;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S16_DP.S16_5_DP_Strings
 * <p>
 * User: piyushbajaj
 * Date: 17/12/22
 * Time: 5:55 pm
 * <p>
 * Link: <a href="https://leetcode.com/problems/edit-distance/description/">...</a>
 */
public class P9_Edit_Distance {

    public static void main(String[] args) {
        P9_Edit_Distance p9_edit_distance = new P9_Edit_Distance();
        System.out.println(p9_edit_distance.minDistance("horse", "ros"));
        System.out.println(p9_edit_distance.minDistance_mem("horse", "ros"));
        System.out.println(p9_edit_distance.minDistance_tab("horse", "ros"));
        System.out.println(p9_edit_distance.minDistance_tab_improve("horse", "ros"));
    }

    /**
     * Recursion
     * TC: Exponential
     * SC: O(N+M)
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        return minDistance_rec_util(word1, n - 1, word2, m - 1);
    }

    public int minDistance_rec_util(String word1, int i, String word2, int j) {
        // base case
        if (i < 0) {
            return j + 1;
        }

        if (j < 0) {
            return i + 1;
        }

        // matches, then reduce the size, with no operation.
        if (word1.charAt(i) == word2.charAt(j)) {
            return minDistance_rec_util(word1, i - 1, word2, j - 1);
        }

        return Math.min(Math.min(
                1 + minDistance_rec_util(word1, i, word2, j - 1), // Insert
                1 + minDistance_rec_util(word1, i - 1, word2, j)), // Delete
            1 + minDistance_rec_util(word1, i - 1, word2, j - 1)); // Replace
    }

    /**
     * Memoization
     * <p>
     * TC: O(N*M)
     * SC: O(N*M) + Auxiliary Space: O(N+M)
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance_mem(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = -1;
            }
        }

        return minDistance_mem_util(dp, word1, n - 1, word2, m - 1);
    }

    public int minDistance_mem_util(int[][] dp, String word1, int i, String word2, int j) {
        // base case
        if (i < 0) {
            return j + 1;
        }

        if (j < 0) {
            return i + 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // matches, then reduce the size, with no operation.
        if (word1.charAt(i) == word2.charAt(j)) {
            return dp[i][j] = minDistance_mem_util(dp, word1, i - 1, word2, j - 1);
        }

        return dp[i][j] = Math.min(Math.min(
                1 + minDistance_mem_util(dp, word1, i, word2, j - 1), // Insert
                1 + minDistance_mem_util(dp, word1, i - 1, word2, j)), // Delete
            1 + minDistance_mem_util(dp, word1, i - 1, word2, j - 1)); // Replace
    }

    /**
     * Tabulation
     * TC: O(N*M)
     * SC: O(N*M)
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance_tab(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];

        // base case
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // matches, then reduce the size, with no operation.
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(
                            1 + dp[i][j - 1], // Insert
                            1 + dp[i - 1][j]), // Delete
                        1 + dp[i - 1][j - 1]); // Replace
                }
            }
        }

        return dp[n][m];
    }

    public int minDistance_tab_improve(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // Store previous row
        int[] prev = new int[m + 1];

        // base case
        for (int j = 0; j <= m; j++) {
            prev[j] = j;
        }

        for (int i = 1; i <= n; i++) {
            int[] curr = new int[m + 1];
            curr[0] = i;
            for (int j = 1; j <= m; j++) {
                // matches, then reduce the size, with no operation.
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    curr[j] = prev[j - 1];
                } else {
                    curr[j] = Math.min(Math.min(
                            1 + curr[j - 1], // Insert
                            1 + prev[j]), // Delete
                        1 + prev[j - 1]); // Replace
                }
            }
            prev = curr;
        }

        return prev[m];
    }
}

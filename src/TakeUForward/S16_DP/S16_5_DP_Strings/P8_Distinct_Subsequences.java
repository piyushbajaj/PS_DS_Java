package TakeUForward.S16_DP.S16_5_DP_Strings;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S16_DP.S16_5_DP_Strings
 * <p>
 * User: piyushbajaj
 * Date: 17/12/22
 * Time: 12:50 pm
 * <p>
 * Link: https://leetcode.com/problems/distinct-subsequences/description/
 */
public class P8_Distinct_Subsequences {

    /**
     * Recursion
     * TC: Exponential
     * SC: O(N+M)
     *
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {
        return numDistinct_util(s, s.length() - 1, t, t.length() - 1);
    }

    public int numDistinct_util(String s, int i, String t, int j) {
        // base case
        if (j < 0) {
            return 1;
        }
        if (i < 0) {
            return 0;
        }

        if (s.charAt(i) == t.charAt(j)) {
            return numDistinct_util(s, i - 1, t, j - 1) + numDistinct_util(s, i - 1, t, j);
        } else {
            return numDistinct_util(s, i - 1, t, j);
        }
    }

    /**
     * Memoization
     * TC: O(N*M)
     * SC: O(N*M) + Auxiliary Space: O(N+M)
     *
     * @param s
     * @param t
     * @return
     */
    public int numDistinct_mem(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }

        return numDistinct_mem_util(dp, s, n - 1, t, m - 1);
    }

    public int numDistinct_mem_util(int[][] dp, String s, int i, String t, int j) {
        // base case
        if (j < 0) {
            return 1;
        }
        if (i < 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = numDistinct_mem_util(dp, s, i - 1, t, j - 1) +
                numDistinct_mem_util(dp, s, i - 1, t, j);
        } else {
            return dp[i][j] = numDistinct_mem_util(dp, s, i - 1, t, j);
        }
    }

    /**
     * Tabulation
     * TC: O(N*M)
     * SC: O(N*M)
     *
     * @param s
     * @param t
     * @return
     */
    public int numDistinct_tab(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];

        // base case

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][m];
    }

    /**
     * Tabulation Improve Space
     * TC: O(N*M)
     * SC: O(M)
     *
     * @param s
     * @param t
     * @return
     */
    public int numDistinct_tab_improve(String s, String t) {
        int n = s.length();
        int m = t.length();
        // Stores just prev row only
        int[] prev = new int[m + 1];

        // base case
        prev[0] = 1;

        for (int i = 1; i <= n; i++) {
            int[] curr = new int[m + 1];
            curr[0] = 1;
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    curr[j] = prev[j - 1] + prev[j];
                } else {
                    curr[j] = prev[j];
                }
            }
            prev = curr;
        }

        return prev[m];
    }

    public static void main(String[] args) {
        P8_Distinct_Subsequences p8_distinct_subsequences = new P8_Distinct_Subsequences();
        System.out.println(p8_distinct_subsequences.numDistinct("babgbag", "bag"));

        System.out.println(p8_distinct_subsequences.numDistinct_mem("babgbag", "bag"));

        System.out.println(p8_distinct_subsequences.numDistinct_tab("babgbag", "bag"));

        System.out.println(p8_distinct_subsequences.numDistinct_tab_improve("babgbag", "bag"));
    }
}

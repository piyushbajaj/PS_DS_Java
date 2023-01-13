package TakeUForward.S16_DP.S16_5_DP_Strings;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S16_DP.S16_5_DP_Strings
 * <p>
 * User: piyushbajaj
 * Date: 17/12/22
 * Time: 10:29 pm
 */
public class P10_WildCard_Matching {
    /**
     * Recursion
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        return isMatch_rec_util(s, n - 1, p, m - 1);
    }

    public boolean isMatch_rec_util(String s, int i, String p, int j) {
        // base case
        if (i < 0 && j < 0) {
            return true;
        }

        if (i >= 0 && j < 0) {
            return false;
        }

        if (i < 0 && j >= 0) {
            for (int k = 0; k <= j; k++) {
                if (p.charAt(k) != '*') {
                    return false;
                }
            }
            return true;
        }

        if (p.charAt(j) == '*') {
            return isMatch_rec_util(s, i - 1, p, j) || isMatch_rec_util(s, i, p, j - 1);
        }

        // match
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            return isMatch_rec_util(s, i - 1, p, j - 1);
        }

        return false;
    }

    public boolean isMatch_mem(String s, String p) {
        int n = s.length();
        int m = p.length();

        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }

        return isMatch_mem_util(dp, s, n - 1, p, m - 1) == 1;
    }

    public int isMatch_mem_util(int[][] dp, String s, int i, String p, int j) {
        // base case
        if (i < 0 && j < 0) {
            return 1;
        }

        if (i >= 0 && j < 0) {
            return 0;
        }

        if (i < 0 && j >= 0) {
            for (int k = 0; k <= j; k++) {
                if (p.charAt(k) != '*') {
                    return 0;
                }
            }
            return 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            return dp[i][j] = isMatch_mem_util(dp, s, i - 1, p, j - 1);
        } else {
            if (p.charAt(j) == '*') {
                return (isMatch_mem_util(dp, s, i - 1, p, j) == 1 || isMatch_mem_util(dp, s, i, p, j - 1) == 1) ? 1 : 0;
            } else {
                return 0;
            }
        }
    }

    /**
     * Tabulation
     * <p>
     * First Convert to 1-based indexing
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch_mem_1_based(String s, String p) {
        int n = s.length();
        int m = p.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = -1;
            }
        }

        return isMatch_mem_1_based_util(dp, s, n, p, m) == 1;
    }

    public int isMatch_mem_1_based_util(int[][] dp, String s, int i, String p, int j) {
        // base case
        if (i == 0 && j == 0) {
            return 1;
        }

        if (i > 0 && j == 0) {
            return 0;
        }

        if (i == 0 && j > 0) {
            for (int k = 1; k <= j; k++) {
                if (p.charAt(k - 1) != '*') {
                    return 0;
                }
            }
            return 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
            return dp[i][j] = isMatch_mem_1_based_util(dp, s, i - 1, p, j - 1);
        } else {
            if (p.charAt(j - 1) == '*') {
                return (isMatch_mem_1_based_util(dp, s, i - 1, p, j) == 1 ||
                    isMatch_mem_1_based_util(dp, s, i, p, j - 1) == 1) ? 1 : 0;
            } else {
                return 0;
            }
        }
    }

    /**
     * TC: O(N*M)
     * SC: O(N*M)
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch_tab(String s, String p) {
        int n = s.length();
        int m = p.length();

        boolean[][] dp = new boolean[n + 1][m + 1];

        // base case
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = false;
        }

        for (int j = 1; j <= m; j++) {
            boolean flag = true;
            for (int k = 1; k <= j; k++) {
                if (p.charAt(k - 1) != '*') {
                    flag = false;
                    break;
                }
            }
            dp[0][j] = flag;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    if (p.charAt(j - 1) == '*') {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }

        return dp[n][m];
    }

    /**
     * Tabulation with space optimize
     * <p>
     * TC: O(N*M)
     * SC: O(M)
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch_tab_improve(String s, String p) {
        int n = s.length();
        int m = p.length();

        boolean[] prev = new boolean[m + 1];

        // base case
        prev[0] = true;

        for (int j = 1; j <= m; j++) {
            boolean flag = true;
            for (int k = 1; k <= j; k++) {
                if (p.charAt(k - 1) != '*') {
                    flag = false;
                    break;
                }
            }
            prev[j] = flag;
        }

        for (int i = 1; i <= n; i++) {
            boolean[] curr = new boolean[m + 1];
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    curr[j] = prev[j - 1];
                } else {
                    if (p.charAt(j - 1) == '*') {
                        curr[j] = prev[j] || curr[j - 1];
                    } else {
                        curr[j] = false;
                    }
                }
            }
            prev = curr;
        }

        return prev[m];
    }

    public static void main(String[] args) {
        P10_WildCard_Matching p10_wildCard_matching = new P10_WildCard_Matching();
        System.out.println(p10_wildCard_matching.isMatch("cb", "?a"));
        System.out.println(p10_wildCard_matching.isMatch_mem("cb", "?a"));
        System.out.println(p10_wildCard_matching.isMatch_mem_1_based("cb", "?a"));
        System.out.println(p10_wildCard_matching.isMatch_tab("cb", "?a"));
        System.out.println(p10_wildCard_matching.isMatch_tab_improve("aab", "c*a*b"));
    }
}

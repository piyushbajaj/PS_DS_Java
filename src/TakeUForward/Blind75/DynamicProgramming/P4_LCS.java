package TakeUForward.Blind75.DynamicProgramming;

/**
 * Project: DS_Algo
 * Package: TakeUForward.Blind75.DynamicProgramming
 * <p>
 * User: piyushbajaj
 * Date: 31/01/23
 * Time: 10:49 pm
 */
public class P4_LCS {

    /**
     * Recursion
     * TC: Exponential
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence_recur(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        return longestCommonSubsequence_recur_util(text1, n - 1, text2, m - 1);
    }

    public int longestCommonSubsequence_recur_util(String text1, int t1_index, String text2, int t2_index) {
        if (t1_index < 0 || t2_index < 0) {
            return 0;
        }

        if (text1.charAt(t1_index) == text2.charAt(t2_index)) {
            return 1 + longestCommonSubsequence_recur_util(text1, t1_index - 1, text2, t2_index - 1);
        }

        return Math.max(longestCommonSubsequence_recur_util(text1, t1_index - 1, text2, t2_index),
            longestCommonSubsequence_recur_util(text1, t1_index, text2, t2_index - 1));
    }

    /**
     * Memoization
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence_mem(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }

        return longestCommonSubsequence_mem_util(dp, text1, n - 1, text2, m - 1);
    }

    public int longestCommonSubsequence_mem_util(int[][] dp, String text1, int t1_index, String text2, int t2_index) {
        if (t1_index < 0 || t2_index < 0) {
            return 0;
        }

        if (dp[t1_index][t2_index] != -1) {
            return dp[t1_index][t2_index];
        }

        if (text1.charAt(t1_index) == text2.charAt(t2_index)) {
            return 1 + longestCommonSubsequence_mem_util(dp, text1, t1_index - 1, text2, t2_index - 1);
        }

        return Math.max(longestCommonSubsequence_mem_util(dp, text1, t1_index - 1, text2, t2_index),
            longestCommonSubsequence_mem_util(dp, text1, t1_index, text2, t2_index - 1));
    }

    /**
     * Memoization, shifting index towards right to cover the case
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence_mem_better(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                dp[i][j] = -1;
            }
        }

        return longestCommonSubsequence_mem_better_util(dp, text1, n, text2, m);
    }

    public int longestCommonSubsequence_mem_better_util(int[][] dp, String text1, int t1_index, String text2,
                                                        int t2_index) {
        if (t1_index == 0 || t2_index == 0) {
            return 0;
        }

        if (dp[t1_index][t2_index] != -1) {
            return dp[t1_index][t2_index];
        }

        if (text1.charAt(t1_index - 1) == text2.charAt(t2_index - 1)) {
            return dp[t1_index][t2_index] = 1 + longestCommonSubsequence_mem_better_util(dp, text1, t1_index - 1,
                text2, t2_index - 1);
        }

        return dp[t1_index][t2_index] = Math.max(longestCommonSubsequence_mem_better_util(dp, text1, t1_index - 1,
                text2, t2_index),
            longestCommonSubsequence_mem_better_util(dp, text1, t1_index, text2, t2_index - 1));
    }

    /**
     * Tabulation
     * TC: O(N*M)
     * SC: O(N*M)
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence_tab(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int t1_index = 0; t1_index < n + 1; t1_index++) {
            dp[t1_index][0] = 0;
        }

        for (int t2_index = 0; t2_index < m + 1; t2_index++) {
            dp[0][t2_index] = 0;
        }

        for (int t1_index = 1; t1_index < n + 1; t1_index++) {
            for (int t2_index = 1; t2_index < m + 1; t2_index++) {
                if (text1.charAt(t1_index - 1) == text2.charAt(t2_index - 1)) {
                    dp[t1_index][t2_index] = 1 + dp[t1_index - 1][t2_index - 1];
                } else {
                    dp[t1_index][t2_index] = Math.max(dp[t1_index - 1][t2_index], dp[t1_index][t2_index - 1]);
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        P4_LCS p4_lcs = new P4_LCS();
        System.out.println(p4_lcs.longestCommonSubsequence_recur("abcde", "ace"));
        System.out.println(p4_lcs.longestCommonSubsequence_mem("abcde", "ace"));
        System.out.println(p4_lcs.longestCommonSubsequence_mem_better("abcde", "ace"));
        System.out.println(p4_lcs.longestCommonSubsequence_tab("abcde", "ace"));
    }
}

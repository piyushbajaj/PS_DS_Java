package TakeUForward.CompleteCourse_456.S16_DP.S16_5_DP_Strings;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S16_DP.S16_5_DP_Strings
 * <p>
 * User: piyushbajaj
 * Date: 26/11/22
 * Time: 7:12 pm
 */
public class P1_Longest_Common_Subsequence {
    public static void main(String[] args) {
        P1_Longest_Common_Subsequence p1_longest_common_subsequence = new P1_Longest_Common_Subsequence();
        System.out.println(p1_longest_common_subsequence.longestCommonSubsequence_recur("acd", "ced"));

        System.out.println(p1_longest_common_subsequence.longestCommonSubsequence_recur("ABCDGH", "AEDFHR"));

        System.out.println(p1_longest_common_subsequence.longestCommonSubsequence_mem("ABCDGH", "AEDFHR"));

        System.out.println(p1_longest_common_subsequence.longestCommonSubsequence_mem_better("ABCDGH", "AEDFHR"));

        System.out.println(p1_longest_common_subsequence.longestCommonSubsequence_tab("ABCDGH", "AEDFHR"));

        System.out.println(p1_longest_common_subsequence.longestCommonSubsequence_tab_better("ABCDGH", "AEDFHR"));
    }

    /**
     * Recursion
     * TC: O(2^N * 2^M)
     * SC: O(N)
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence_recur(String text1, String text2) {
        return longestCommonSubsequence_recur_util(text1, text2, text1.length() - 1, text2.length() - 1);
    }

    public int longestCommonSubsequence_recur_util(String text1, String text2, int ind1, int ind2) {
        // base case
        if (ind1 < 0 || ind2 < 0) {
            return 0;
        }

        // match condition
        if (text1.charAt(ind1) == text2.charAt(ind2)) {
            return 1 + longestCommonSubsequence_recur_util(text1, text2, ind1 - 1, ind2 - 1);
        }

        // not match condition
        return Math.max(longestCommonSubsequence_recur_util(text1, text2, ind1 - 1, ind2),
            longestCommonSubsequence_recur_util(text1, text2, ind1, ind2 - 1));
    }

    /**
     * Memoization
     * TC: O(N*M)
     * SC: O(N*M) + O(N+M): Auxiliary
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

        return longestCommonSubsequence_mem_util(text1, text2, text1.length() - 1, text2.length() - 1, dp);
    }

    public int longestCommonSubsequence_mem_util(String text1, String text2, int ind1, int ind2, int[][] dp) {
        // base case
        if (ind1 < 0 || ind2 < 0) {
            return 0;
        }

        if (dp[ind1][ind2] != -1) {
            return dp[ind1][ind2];
        }

        // match condition
        if (text1.charAt(ind1) == text2.charAt(ind2)) {
            return dp[ind1][ind2] = 1 + longestCommonSubsequence_mem_util(text1, text2, ind1 - 1, ind2 - 1, dp);
        }

        // not match condition
        return dp[ind1][ind2] = Math.max(longestCommonSubsequence_mem_util(text1, text2, ind1 - 1, ind2, dp),
            longestCommonSubsequence_mem_util(text1, text2, ind1, ind2 - 1, dp));
    }

    /**
     * Shifting index by 1 towards right, to cover the base case of (i < 0 || j < 0)
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

        return longestCommonSubsequence_mem_better_util(text1, text2, text1.length(), text2.length(), dp);
    }

    public int longestCommonSubsequence_mem_better_util(String text1, String text2, int ind1, int ind2, int[][] dp) {
        // base case
        if (ind1 == 0 || ind2 == 0) {
            return 0;
        }

        if (dp[ind1][ind2] != -1) {
            return dp[ind1][ind2];
        }

        // match condition
        if (text1.charAt(ind1 - 1) == text2.charAt(ind2 - 1)) {
            return dp[ind1][ind2] = 1 + longestCommonSubsequence_mem_better_util(text1, text2, ind1 - 1, ind2 - 1, dp);
        }

        // not match condition
        return dp[ind1][ind2] = Math.max(longestCommonSubsequence_mem_better_util(text1, text2, ind1 - 1, ind2, dp),
            longestCommonSubsequence_mem_better_util(text1, text2, ind1, ind2 - 1, dp));
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

        // base case
        for (int ind1 = 0; ind1 < n + 1; ind1++) {
            dp[ind1][0] = 0;
        }
        for (int ind2 = 0; ind2 < m + 1; ind2++) {
            dp[0][ind2] = 0;
        }

        for (int ind1 = 1; ind1 < n + 1; ind1++) {
            for (int ind2 = 1; ind2 < m + 1; ind2++) {

                // match condition
                if (text1.charAt(ind1 - 1) == text2.charAt(ind2 - 1)) {
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                } else {

                    // not match condition
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
                }
            }
        }
        return dp[n][m];
    }

    /**
     * Space Optimized with Tabulation
     * TC: O(N*M)
     * SC: O(M)
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence_tab_better(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        // Storing previous row value
        int[] prev = new int[m + 1];

        // base case
        prev[0] = 0;
        for (int ind2 = 0; ind2 < m + 1; ind2++) {
            prev[ind2] = 0;
        }

        for (int ind1 = 1; ind1 < n + 1; ind1++) {
            int[] curr = new int[m + 1];
            for (int ind2 = 1; ind2 < m + 1; ind2++) {

                // match condition
                if (text1.charAt(ind1 - 1) == text2.charAt(ind2 - 1)) {
                    curr[ind2] = 1 + prev[ind2 - 1];
                } else {

                    // not match condition
                    curr[ind2] = Math.max(prev[ind2], curr[ind2 - 1]);
                }
            }
            prev = curr;
        }
        return prev[m];
    }
}

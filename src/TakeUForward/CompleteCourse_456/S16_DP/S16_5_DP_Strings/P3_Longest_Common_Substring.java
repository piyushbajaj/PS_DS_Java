package TakeUForward.CompleteCourse_456.S16_DP.S16_5_DP_Strings;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S16_DP.S16_5_DP_Strings
 * <p>
 * User: piyushbajaj
 * Date: 28/11/22
 * Time: 5:48 pm
 * <p>
 * Link: <a href="https://practice.geeksforgeeks.org/problems/longest-common-substring1452/1">...</a>
 */
public class P3_Longest_Common_Substring {

    /**
     * Tabulation
     * TC: O(N*M)
     * SC: O(N*M)
     *
     * @param S1
     * @param S2
     * @param n
     * @param m
     * @return
     */
    public int longestCommonSubstr(String S1, String S2, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (S1.charAt(i - 1) == S2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        P3_Longest_Common_Substring p3_longest_common_substring = new P3_Longest_Common_Substring();
        System.out.println(p3_longest_common_substring.longestCommonSubstr("abcd", "abzd", 4, 4));
    }
}

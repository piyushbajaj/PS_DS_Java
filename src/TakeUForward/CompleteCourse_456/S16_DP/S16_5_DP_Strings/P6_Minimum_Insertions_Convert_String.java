package TakeUForward.CompleteCourse_456.S16_DP.S16_5_DP_Strings;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S16_DP.S16_5_DP_Strings
 * <p>
 * User: piyushbajaj
 * Date: 29/11/22
 * Time: 8:15 pm
 * <p>
 * Link lc: <a href="https://leetcode.com/problems/delete-operation-for-two-strings/">...</a>
 */
public class P6_Minimum_Insertions_Convert_String {
    public int minOperations(String str1, String str2) {
        int lcsCount = longestCommonSubsequence_tab(str1, str2);
        return (str1.length() - lcsCount) + (str2.length() - lcsCount);
    }

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

    public static void main(String[] args) {
        P6_Minimum_Insertions_Convert_String p6_minimum_insertions_convert_string =
            new P6_Minimum_Insertions_Convert_String();

        System.out.println(p6_minimum_insertions_convert_string.minOperations("sea", "eat"));
    }
}

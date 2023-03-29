package TakeUForward.CompleteCourse_456.S16_DP.S16_5_DP_Strings;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S16_DP.S16_5_DP_Strings
 * <p>
 * User: piyushbajaj
 * Date: 29/11/22
 * Time: 9:32 am
 * <p>
 * Link g4g: <a href="https://practice.geeksforgeeks.org/problems/form-a-palindrome1455/1">...</a>
 * Link lc: <a href="https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/">...</a>
 */
public class P5_Form_Palindrome {

    public static void main(String[] args) {
        P5_Form_Palindrome p5_form_palindrome = new P5_Form_Palindrome();

        System.out.println(p5_form_palindrome.countMin("abcaa"));
    }

    /**
     * Approach: N - The Longest Palindromic subsequence
     *
     * @param str
     * @retur
     */
    public int countMin(String str) {
        String reverse = reverseStr(str);
        int count = longestCommonSubsequence_tab(str, reverse);
        return str.length() - count;
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

    public String reverseStr(String S) {
        int n = S.length();
        char[] charStr = S.toCharArray();

        for (int i = 0; i < n / 2; i++) {
            char temp = charStr[i];
            charStr[i] = charStr[n - i - 1];
            charStr[n - i - 1] = temp;
        }

        return new String(charStr);
    }
}

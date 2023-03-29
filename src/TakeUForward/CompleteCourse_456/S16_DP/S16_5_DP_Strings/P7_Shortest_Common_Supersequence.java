package TakeUForward.CompleteCourse_456.S16_DP.S16_5_DP_Strings;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S16_DP.S16_5_DP_Strings
 * <p>
 * User: piyushbajaj
 * Date: 15/12/22
 * Time: 8:20 pm
 * <p>
 * Link: <a href="https://leetcode.com/problems/shortest-common-supersequence/description/">...</a>
 */
public class P7_Shortest_Common_Supersequence {
    public static void main(String[] args) {
        P7_Shortest_Common_Supersequence p7_shortest_common_supersequence = new P7_Shortest_Common_Supersequence();
        System.out.println(p7_shortest_common_supersequence.shortestCommonSupersequence("brute", "groot"));


    }

    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
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
                if (str1.charAt(ind1 - 1) == str2.charAt(ind2 - 1)) {
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                } else {

                    // not match condition
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
                }
            }
        }

        StringBuilder res = new StringBuilder();

        int i = str1.length();
        int j = str2.length();

        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                res.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                res.append(str1.charAt(i - 1));
                i--;
            } else {
                res.append(str2.charAt(j - 1));
                j--;
            }
        }

        while (i > 0) {
            res.append(str1.charAt(i - 1));
            i--;
        }

        while (j > 0) {
            res.append(str2.charAt(j - 1));
            j--;
        }

        return reverseStr(String.valueOf(res));
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

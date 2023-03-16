package TakeUForward.CompleteCourse_456.S16_DP.S16_5_DP_Strings;

import java.util.Arrays;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S16_DP.S16_5_DP_Strings
 * <p>
 * User: piyushbajaj
 * Date: 28/11/22
 * Time: 3:08 pm
 */
public class P2_Print_LCS {
    public String all_longest_common_subsequences(String text1, String text2) {
        // copy the code from LCS tabulation
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

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        int len = dp[n][m];

        // tracing back and printing the element
        String ans = "";
        for (int i = 0; i < len; i++) {
            ans += "$";
        }
        char[] chAns = ans.toCharArray();

        int index = len - 1;
        int ind1 = n, ind2 = m;

        while (ind1 > 0 && ind2 > 0) {
            if (text1.charAt(ind1 - 1) == text2.charAt(ind2 - 1)) {
                chAns[index] = text1.charAt(ind1 - 1);
                index--;
                ind1--;
                ind2--;
            } else if (dp[ind1 - 1][ind2] > dp[ind1][ind2 - 1]) {
                ind1--;
            } else {
                ind2--;
            }
        }

        return Arrays.toString(chAns);
    }

    public static void main(String[] args) {
        P2_Print_LCS p2_print_lcs = new P2_Print_LCS();
        System.out.println(p2_print_lcs.all_longest_common_subsequences("acd", "ced"));
        System.out.println(p2_print_lcs.all_longest_common_subsequences("abaaa", "baabaca"));
    }
}

package TakeUForward.CompleteCourse_456.S16_DP.S16_7_DP_LIS;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S16_DP.S16_7_DP_LIS
 * <p>
 * User: piyushbajaj
 * Date: 24/12/22
 * Time: 12:16 pm
 * <p>
 * lc: <a href="https://leetcode.com/problems/longest-string-chain/description/">...</a>
 */
public class P5_Longest_String_Chain {

    public static void main(String[] args) {
        P5_Longest_String_Chain p5_longest_string_chain = new P5_Longest_String_Chain();

        String[] words = {"xbc", "pcxbcf", "xb", "xc", "cxbc", "pcxbc"};
        System.out.println(p5_longest_string_chain.longestStrChain(words));
    }

    public boolean compareStrings(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if (n - m != 1) {
            return false;
        }

        int p = 0, q = 0;

        while (p < n) {
            if (q < m && s1.charAt(p) == s2.charAt(q)) {
                p++;
                q++;
            } else {
                p++;
            }
        }

        return p == n && q == m;
    }

    /**
     * TC: O(N logN) + O(N*N) * string length
     * SC: O(N*N)
     *
     * @param words
     * @return
     */
    public int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, new stringComparator());

        int[] dp = new int[n];

        // Fill the arrays with 1
        Arrays.fill(dp, 1);
        int maxi = 1;

        for (int index = 0; index < n; index++) {

            for (int prev = 0; prev < index; prev++) {
                if (compareStrings(words[index], words[prev]) && 1 + dp[prev] > dp[index]) {
                    dp[index] = 1 + dp[prev];
                }
            }

            if (dp[index] > maxi) {
                maxi = dp[index];
            }
        }

        return maxi;
    }

    static class stringComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            if (o1.length() < o2.length()) {
                return -1;
            } else if (o1.length() > o2.length()) {
                return 1;
            }
            return 0;
        }
    }
}

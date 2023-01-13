package TakeUForward.S16_DP.S16_8_MCM_DP;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S16_DP.S16_8_MCM_DP
 * <p>
 * User: piyushbajaj
 * Date: 06/01/23
 * Time: 5:13 pm
 */
public class P5_Palindromic_Partitioning {
    public int palindromicPartition_recur(String str) {
        int n = str.length();
        return palindromicPartition_recur_util(0, n, str) - 1;
    }

    public int palindromicPartition_recur_util(int i, int n, String str) {
        if (i == n) {
            return 0;
        }
        int minCost = Integer.MAX_VALUE;

        for (int j = i; j < n; j++) {
            if (isPalindrome(i, j, str)) {
                int cost = 1 + palindromicPartition_recur_util(j + 1, n, str);
                minCost = Math.min(cost, minCost);
            }
        }
        return minCost;
    }

    public boolean isPalindrome(int start, int end, String str) {
        while (start <= end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    /**
     * Memoization
     * TC: O(N*N)
     * SC: O(N) + O(N)
     *
     * @param str
     * @return
     */
    public int palindromicPartition_mem(String str) {
        int n = str.length();
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = -1;
        }

        return palindromicPartition_mem_util(dp, 0, n, str) - 1;
    }

    public int palindromicPartition_mem_util(int[] dp, int i, int n, String str) {
        if (i == n) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int minCost = Integer.MAX_VALUE;

        for (int j = i; j < n; j++) {
            if (isPalindrome(i, j, str)) {
                int cost = 1 + palindromicPartition_mem_util(dp, j + 1, n, str);
                minCost = Math.min(cost, minCost);
            }
        }
        return dp[i] = minCost;
    }

    /**
     * TC: O(N*N)
     * SC: O(N)
     *
     * @param str
     * @return
     */
    public int palindromicPartition_tab(String str) {
        int n = str.length();
        int[] dp = new int[n + 1];
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            int minCost = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                if (isPalindrome(i, j, str)) {
                    int cost = 1 + dp[j + 1];
                    minCost = Math.min(cost, minCost);
                }
            }
            dp[i] = minCost;
        }
        return dp[0] - 1;
    }

    public static void main(String[] args) {
        P5_Palindromic_Partitioning p5_palindromic_partitioning = new P5_Palindromic_Partitioning();
        System.out.println(p5_palindromic_partitioning.palindromicPartition_recur("ababbbabbababa"));
        System.out.println(p5_palindromic_partitioning.palindromicPartition_mem("ababbbabbababa"));
        System.out.println(p5_palindromic_partitioning.palindromicPartition_tab("ababbbabbababa"));
    }
}

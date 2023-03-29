package TakeUForward.Blind75.DynamicProgramming;

/**
 * Project: DS_Algo
 * Package: TakeUForward.Blind75.DynamicProgramming
 * <p>
 * User: piyushbajaj
 * Date: 26/01/23
 * Time: 11:57 pm
 */
public class P3_LIS {

    public static void main(String[] args) {
        P3_LIS p3_lis = new P3_LIS();
        System.out.println(p3_lis.lengthOfLIS_recur(new int[] {10, 9, 2, 5, 3, 7, 101, 18}));

        System.out.println(p3_lis.lengthOfLIS_mem(new int[] {10, 9, 2, 5, 3, 7, 101, 18}));

        System.out.println(p3_lis.lengthOfLIS_tab(new int[] {10, 9, 2, 5, 3, 7, 101, 18}));
    }

    /**
     * Recursive: Ideally recursive we go from top to bottom, but here in this case we need to go from bottom to top
     * because of LIS
     * <p>
     * TC: O(2^N)
     * SC: O(N)
     *
     * @param a
     * @return
     */
    public int lengthOfLIS_recur(int[] a) {

        // index 0, tells the longest increasing subsequence from length 0 till n
        return lengthOfLIS_recur_util(0, -1, a);
    }

    public int lengthOfLIS_recur_util(int index, int prev, int[] a) {
        // base condition
        if (index == a.length) {
            return 0;
        }

        // not pick, means just moving index ahead
        int len = lengthOfLIS_recur_util(index + 1, prev, a);

        // pick, means
        if (prev == -1 || a[index] > a[prev]) {
            len = Math.max(len, 1 + lengthOfLIS_recur_util(index + 1, index, a));
        }

        return len;
    }

    /**
     * Memoization
     * TC: O(N*N)
     * SC: O(N*N) + O(N)
     *
     * @param a
     * @return
     */
    public int lengthOfLIS_mem(int[] a) {
        int n = a.length;
        int[][] dp = new int[n][n + 1];

        for (int index = 0; index < n; index++) {
            for (int prev = 0; prev <= n; prev++) {
                dp[index][prev] = -1;
            }
        }

        // index 0, tells the longest increasing subsequence from length 0 till n
        return lengthOfLIS_mem_util(0, -1, a, dp);
    }

    public int lengthOfLIS_mem_util(int index, int prev, int[] a, int[][] dp) {
        // base condition
        if (index == a.length) {
            return 0;
        }

        if (dp[index][prev + 1] != -1) {
            return dp[index][prev + 1];
        }

        // not pick, means just moving index ahead
        int len = lengthOfLIS_mem_util(index + 1, prev, a, dp);

        // pick, means
        if (prev == -1 || a[index] > a[prev]) {
            len = Math.max(len, 1 + lengthOfLIS_mem_util(index + 1, index, a, dp));
        }

        return dp[index][prev + 1] = len;
    }

    /**
     * Tabulation
     *
     * @param a
     * @return
     */
    public int lengthOfLIS_tab(int[] a) {
        int n = a.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int index = n - 1; index >= 0; index--) {
            for (int prev = index - 1; prev >= -1; prev--) {
                // not pick, means just moving index ahead
                int len = dp[index + 1][prev + 1];

                // pick, means
                if (prev == -1 || a[index] > a[prev]) {
                    len = Math.max(len, 1 + dp[index + 1][index + 1]);
                }

                dp[index][prev + 1] = len;
            }
        }

        // index 0, tells the longest increasing subsequence from length 0 till n
        return dp[0][0];
    }
}

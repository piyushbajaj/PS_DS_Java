package TakeUForward.CompleteCourse_456.S16_DP.S16_1_1D_DP;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S16_DP
 * <p>
 * User: piyushbajaj
 * Date: 12/11/22
 * Time: 1:48 pm
 * <p>
 * lc: <a href="https://practice.geeksforgeeks.org/problems/max-sum-without-adjacents2430/1">...</a>
 * Link: <a href="https://practice.geeksforgeeks.org/problems/stickler-theif-1587115621/1">...</a>
 */
public class P5_Maximum_Sum_Non_Adjacent {

    public static void main(String[] args) {
        P5_Maximum_Sum_Non_Adjacent p5_maximum_sum_non_adjacent = new P5_Maximum_Sum_Non_Adjacent();

        int[] arr = {5, 5, 10, 100, 10, 5};

        System.out.println(p5_maximum_sum_non_adjacent.findMaxSum(arr, arr.length));

        System.out.println(p5_maximum_sum_non_adjacent.findMaxSum_mem(arr, arr.length));

        System.out.println(p5_maximum_sum_non_adjacent.findMaxSum_tab(arr, arr.length));

        System.out.println(p5_maximum_sum_non_adjacent.findMaxSum_tab_improve(arr, arr.length));

    }

    /**
     * Recursive Solution
     * <p>
     * TC: O(2^N)
     *
     * @param arr
     * @param n
     * @return
     */
    public int findMaxSum(int[] arr, int n) {
        return findMaxSum_util(arr, n - 1);
    }

    public int findMaxSum_util(int[] arr, int index) {
        if (index == 0) {
            return arr[index];
        }

        if (index < 0) {
            return 0;
        }

        // pick
        int pick = arr[index] + findMaxSum_util(arr, index - 2);

        // non-pick
        int nonPick = findMaxSum_util(arr, index - 1);

        return Math.max(pick, nonPick);
    }

    /**
     * Memoization: Here we reduce the overlapping calls
     * TC: O(N)
     * SC: O(N) + O(N)
     *
     * @param arr
     * @param n
     * @return
     */
    public int findMaxSum_mem(int[] arr, int n) {
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = -1;
        }

        return findMaxSum_mem_util(arr, n - 1, dp);
    }

    public int findMaxSum_mem_util(int[] arr, int index, int[] dp) {
        if (index == 0) {
            dp[index] = arr[index];
        }

        if (index < 0) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int pick = arr[index] + findMaxSum_mem_util(arr, index - 2, dp);
        int nonPick = findMaxSum_mem_util(arr, index - 1, dp);

        dp[index] = Math.max(pick, nonPick);
        return dp[index];
    }

    /**
     * Tabulation with Optimized space
     * <p>
     * TC: O(N)
     * SC: O(N)
     *
     * @param arr
     * @param n
     * @return
     */
    public int findMaxSum_tab(int[] arr, int n) {
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = -1;
        }

        dp[0] = arr[0];

        for (int i = 1; i < n; i++) {

            int pick = arr[i];
            if (i > 1) {
                pick += dp[i - 2];
            }
            int nonPick = arr[i - 1];

            dp[i] = Math.max(pick, nonPick);
        }

        return dp[n - 1];
    }

    /**
     * Tabulation with Space Optimization - Best
     * <p>
     * TC: O(N)
     * SC: O(1)
     *
     * @param arr
     * @param n
     * @return
     */
    public int findMaxSum_tab_improve(int[] arr, int n) {
        int prevFirst = arr[0];
        int prevSecond = 0;

        for (int i = 1; i < n; i++) {

            int pick = arr[i];
            if (i > 1) {
                pick += prevSecond;
            }
            int nonPick = prevFirst;

            int curr = Math.max(pick, nonPick);
            prevSecond = prevFirst;
            prevFirst = curr;
        }

        return prevFirst;
    }


}

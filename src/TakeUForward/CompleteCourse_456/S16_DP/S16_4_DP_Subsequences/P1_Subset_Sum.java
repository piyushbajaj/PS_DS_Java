package TakeUForward.CompleteCourse_456.S16_DP.S16_4_DP_Subsequences;

import java.util.Arrays;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S16_DP.S16_4_DP_Subsequences
 * <p>
 * User: piyushbajaj
 * Date: 16/11/22
 * Time: 10:44 pm
 * <p>
 * Link g4g: <a href="https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1">...</a>
 */
public class P1_Subset_Sum {

    public static void main(String[] args) {
        P1_Subset_Sum p1_subset_sum = new P1_Subset_Sum();
        int[] arr = {2, 3, 1, 1};
        System.out.println(p1_subset_sum.isSubsetSum(arr.length, arr, 5));

        System.out.println(p1_subset_sum.isSubsetSum_mem(arr.length, arr, 5));

        int[] arr2 = {3, 34, 4, 12, 5, 2};

        System.out.println(p1_subset_sum.isSubsetSum_tab(arr2.length, arr2, 9));

        System.out.println(p1_subset_sum.isSubsetSum_tab(arr.length, arr, 5));

        System.out.println(p1_subset_sum.isSubsetSum_tab_better(arr.length, arr, 5));

        int[] arr1 = {1, 5, 11, 5};

        System.out.println(p1_subset_sum.isSubsetSum_recur(arr1.length - 1, 11, arr1));
    }

    /**
     * Recursive solution
     * <p>
     * TC: O(2^N)
     * SC: O(N)
     * <p>
     * Problem: TLE (time limit exceeded)
     *
     * @param N
     * @param arr
     * @param sum
     * @return
     */
    public boolean isSubsetSum(int N, int[] arr, int sum) {
        return isSubsetSum_recur(N - 1, sum, arr);
    }

    public boolean isSubsetSum_recur(int index, int target, int[] arr) {
        // base condition
        if (target == 0) {
            return true;
        }

        if (index == 0) {
            return arr[index] == target;
        }

        // We can decrease index and move ahead without changing target
        boolean notPick = isSubsetSum_recur(index - 1, target, arr);

        // We can decrease index and move ahead with reducing target
        boolean pick = false;

        if (target >= arr[index]) {
            pick = isSubsetSum_recur(index - 1, target - arr[index], arr);
        }

        return pick || notPick;
    }

    /**
     * Memoization
     * TC: O(N*target)
     * SC: O(N*target) + O(N)
     *
     * @param N
     * @param arr
     * @param sum
     * @return
     */
    public boolean isSubsetSum_mem(int N, int[] arr, int sum) {
        // Index and Target
        int[][] dp = new int[N][sum + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return isSubsetSum_mem_util(N - 1, sum, arr, dp);
    }

    public boolean isSubsetSum_mem_util(int index, int target, int[] arr, int[][] dp) {
        // base condition
        if (target == 0) {
            return true;
        }

        if (index == 0) {
            return arr[index] == target;
        }

        if (dp[index][target] != -1) {
            return dp[index][target] == 1;
        }

        // We can decrease index and move ahead without changing target
        boolean notPick = isSubsetSum_mem_util(index - 1, target, arr, dp);

        // We can decrease index and move ahead with reducing target
        boolean pick = false;

        if (target >= arr[index]) {
            pick = isSubsetSum_mem_util(index - 1, target - arr[index], arr, dp);
        }

        dp[index][target] = (pick || notPick) ? 1 : 0;
        return pick || notPick;
    }

    /**
     * Tabulation
     * TC: O(N*Target)
     * SC: O(N*Target)
     *
     * @param N
     * @param arr
     * @param sum
     * @return
     */
    public boolean isSubsetSum_tab(int N, int[] arr, int sum) {
        // Index and Target
        boolean[][] dp = new boolean[N][sum + 1];

        // base case
        for (int index = 0; index < N; index++) {
            dp[index][0] = true;
        }

        dp[0][arr[0]] = true;

        for (int index = 1; index < N; index++) {
            for (int target = 1; target <= sum; target++) {
                // We can decrease index and move ahead without changing target
                boolean notPick = dp[index - 1][target];

                // We can decrease index and move ahead with reducing target
                boolean pick = false;

                if (target >= arr[index]) {
                    pick = dp[index - 1][target - arr[index]];
                }

                dp[index][target] = pick || notPick;
            }
        }

        return dp[N - 1][sum];
    }

    /**
     * Tabulation with Optimized time
     * TC: O(N*Target)
     * SC: O(Target)
     *
     * @param N
     * @param arr
     * @param sum
     * @return
     */
    public boolean isSubsetSum_tab_better(int N, int[] arr, int sum) {
        // Previous Row
        boolean[] prev = new boolean[sum + 1];
        prev[0] = true;

        for (int index = 1; index < N; index++) {
            // Current Row
            boolean[] curr = new boolean[sum + 1];
            curr[0] = true;

            for (int target = 1; target <= sum; target++) {
                // We can decrease index and move ahead without changing target
                boolean notPick = prev[target];

                // We can decrease index and move ahead with reducing target
                boolean pick = false;

                if (target >= arr[index]) {
                    pick = prev[target - arr[index]];
                }
                curr[target] = pick || notPick;
            }

            prev = curr;
        }
        return prev[sum];
    }
}

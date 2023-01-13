package TakeUForward.S16_DP.S16_8_MCM_DP;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S16_DP.S16_8_MCM_DP
 * <p>
 * User: piyushbajaj
 * Date: 07/01/23
 * Time: 2:27 pm
 */
public class P6_Partition_Array_For_Max_Sum {

    /**
     * Same approach like Palindromic Partitioning
     * <p>
     * TC: Exponential
     * SC: O(N)
     *
     * @param N
     * @param k
     * @param arr
     * @return
     */
    public int solve_recur(int N, int k, int[] arr) {
        return solve_recur_util(0, N, k, arr);
    }

    public int solve_recur_util(int i, int N, int k, int[] arr) {
        if (i == N) {
            return 0;
        }

        int len = 0;
        int maxSum = 0;
        int sum = 0;
        int maxi = Integer.MIN_VALUE;

        for (int j = i; j < Math.min(N, i + k); j++) {
            len++;
            maxi = Math.max(maxi, arr[j]);
            sum = (len * maxi) + solve_recur_util(j + 1, N, k, arr);
            maxSum = Math.max(sum, maxSum);
        }

        return maxSum;
    }

    /**
     * Memoization
     * <p>
     * TC: O(N*N)
     * SC: O(N) + Auxiliary: O(N)
     *
     * @param N
     * @param k
     * @param arr
     * @return
     */
    public int solve_mem(int N, int k, int[] arr) {
        int[] dp = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            dp[i] = -1;
        }

        return solve_mem_util(dp, 0, N, k, arr);
    }

    public int solve_mem_util(int[] dp, int i, int N, int k, int[] arr) {
        dp[N] = 0;

        if (dp[i] != -1) {
            return dp[i];
        }

        int len = 0;
        int maxSum = 0;
        int sum = 0;
        int maxi = Integer.MIN_VALUE;

        for (int j = i; j < Math.min(N, i + k); j++) {
            len++;
            maxi = Math.max(maxi, arr[j]);
            sum = (len * maxi) + solve_recur_util(j + 1, N, k, arr);
            maxSum = Math.max(sum, maxSum);
        }

        return dp[i] = maxSum;
    }

    /**
     * Tabulation
     * <p>
     * TC: O(N*N)
     * SC: O(N)
     *
     * @param N
     * @param k
     * @param arr
     * @return
     */
    public int solve_tab(int N, int k, int[] arr) {
        int[] dp = new int[N + 1];

        dp[N] = 0;

        for (int i = N - 1; i >= 0; i--) {

            int len = 0;
            int maxSum = 0;
            int sum = 0;
            int maxi = Integer.MIN_VALUE;

            for (int j = i; j < Math.min(N, i + k); j++) {
                len++;
                maxi = Math.max(maxi, arr[j]);
                sum = (len * maxi) + solve_recur_util(j + 1, N, k, arr);
                maxSum = Math.max(sum, maxSum);
            }
            dp[i] = maxSum;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        P6_Partition_Array_For_Max_Sum p6_partition_array_for_max_sum = new P6_Partition_Array_For_Max_Sum();
        int[] arr = {1, 15, 7, 9, 2, 5, 10};
        System.out.println(p6_partition_array_for_max_sum.solve_recur(arr.length, 3, arr));
        System.out.println(p6_partition_array_for_max_sum.solve_mem(arr.length, 3, arr));
        System.out.println(p6_partition_array_for_max_sum.solve_tab(arr.length, 3, arr));
    }
}

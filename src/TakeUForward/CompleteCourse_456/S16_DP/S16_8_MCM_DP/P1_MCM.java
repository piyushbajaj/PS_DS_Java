package TakeUForward.CompleteCourse_456.S16_DP.S16_8_MCM_DP;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S16_DP.S16_8_MCM_DP
 * <p>
 * User: piyushbajaj
 * Date: 29/12/22
 * Time: 4:16 pm
 */
public class P1_MCM {

    /**
     * Recursion
     * TC: Exponential
     *
     * @param N
     * @param arr
     * @return
     */
    public int matrixMultiplication(int N, int[] arr) {
        return matrixMultiplication_recur(1, N - 1, arr);
    }

    public int matrixMultiplication_recur(int i, int j, int[] arr) {
        // Base case
        if (i == j) {
            return 0;
        }

        int min = (int) 1e9;

        for (int k = i; k < j; k++) {
            int steps = arr[i - 1] * arr[k] * arr[j] + matrixMultiplication_recur(i, k, arr) +
                matrixMultiplication_recur(k + 1, j, arr);
            min = Math.min(steps, min);
        }

        return min;

    }

    /**
     * Memoization
     * TC: O(N*N*N)
     * SC: O(N*N) + O(N): Auxiliary
     *
     * @param N
     * @param arr
     * @return
     */
    public int matrixMultiplication_mem(int N, int[] arr) {
        int[][] dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = -1;
            }
        }

        return matrixMultiplication_mem_util(dp, 1, N - 1, arr);
    }

    public int matrixMultiplication_mem_util(int[][] dp, int i, int j, int[] arr) {
        // Base case
        if (i == j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int min = (int) 1e9;

        for (int k = i; k < j; k++) {
            int steps = arr[i - 1] * arr[k] * arr[j] + matrixMultiplication_mem_util(dp, i, k, arr) +
                matrixMultiplication_mem_util(dp, k + 1, j, arr);
            min = Math.min(steps, min);
        }

        return dp[i][j] = min;
    }

    /**
     * Tabulation
     * TC: O(N*N*N)
     * SC: O(N*N)
     *
     * @param N
     * @param arr
     * @return
     */
    public int matrixMultiplication_tab(int N, int[] arr) {
        int[][] dp = new int[N][N];

        // bottom up approach
        for (int i = N - 1; i >= 1; i--) {
            for (int j = i + 1; j <= N - 1; j++) {
                int min = (int) 1e9;
                for (int k = i; k < j; k++) {
                    int steps = arr[i - 1] * arr[k] * arr[j]
                        + dp[i][k] + dp[k + 1][j];
                    min = Math.min(steps, min);
                }
                dp[i][j] = min;
            }
        }

        return dp[1][N - 1];
    }

    public static void main(String[] args) {
        P1_MCM p1_mcm = new P1_MCM();
        int[] arr = {10, 20, 30, 40, 50};
        System.out.println(p1_mcm.matrixMultiplication(arr.length, arr));
        System.out.println(p1_mcm.matrixMultiplication_mem(arr.length, arr));
        System.out.println(p1_mcm.matrixMultiplication_tab(arr.length, arr));
    }
}

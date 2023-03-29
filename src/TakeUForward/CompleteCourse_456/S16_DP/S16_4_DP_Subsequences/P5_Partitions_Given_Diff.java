package TakeUForward.CompleteCourse_456.S16_DP.S16_4_DP_Subsequences;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S16_DP.S16_4_DP_Subsequences
 * <p>
 * User: piyushbajaj
 * Date: 23/11/22
 * Time: 9:16 am
 * <p>
 * Link: <a href="https://www.codingninjas.com/codestudio/problems/partitions-with-given-difference_3751628">...</a>
 */
public class P5_Partitions_Given_Diff {

    int mod = (int) 1e9 + 7;

    public static void main(String[] args) {
        P5_Partitions_Given_Diff p5_partitions_given_diff = new P5_Partitions_Given_Diff();
        int[] arr = {5, 2, 6, 4};

        System.out.println(p5_partitions_given_diff.countPartitions(4, 3, arr));

    }

    public int perfectSum_mem(int[] arr, int n, int sum) {
        int[][] dp = new int[n][sum + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < sum + 1; j++) {
                dp[i][j] = -1;
            }
        }

        return perfectSum_mem_util(arr, n - 1, sum, dp);
    }

    public int perfectSum_mem_util(int[] arr, int index, int sum, int[][] dp) {

        if (index == 0) {
            if (sum == 0 && arr[0] == 0) {
                return 2;
            }

            if (sum == 0 || sum == arr[0]) {
                return 1;
            }
            return 0;
        }

        if (dp[index][sum] != -1) {
            return dp[index][sum];
        }

        int notPick = perfectSum_mem_util(arr, index - 1, sum, dp);

        int pick = 0;

        if (arr[index] <= sum) {
            pick = perfectSum_mem_util(arr, index - 1, sum - arr[index], dp);
        }

        dp[index][sum] = (pick + notPick) % mod;

        return dp[index][sum];
    }

    public int countPartitions(int n, int d, int[] arr) {

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        // corner condition
        if (sum - d < 0 || (sum - d) % 2 != 0) {
            return 0;
        }

        return perfectSum_mem(arr, n, (sum - d) / 2);
    }
}

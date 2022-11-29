package TakeUForward.S16_DP.S16_4_DP_Subsequences;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S16_DP.S16_4_DP_Subsequences
 * <p>
 * User: piyushbajaj
 * Date: 22/11/22
 * Time: 2:13 pm
 */
public class P3_Partition_As_Set {
    public int minDifference(int[] arr, int N) {
        int sum = 0;

        for (int i = 0; i < N; i++) {
            sum += arr[i];
        }

        // Index and Target
        boolean[][] dp = new boolean[N][sum + 1];

        // base case
        for (int index = 0; index < N; index++) {
            dp[index][0] = true;
        }

        if (arr[0] <= sum) {
            dp[0][arr[0]] = true;
        }

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

        int min = (int) 1e9;
        for (int i = 0; i <= sum; i++) {
            if (dp[N - 1][i]) {
                int s1 = i;
                int s2 = sum - s1;

                min = Math.min(min, Math.abs(s1 - s2));
            }
        }

        return min;
    }

    public static void main(String[] args) {
        P3_Partition_As_Set p3_partition_as_set = new P3_Partition_As_Set();
        int[] arr = {1, 6, 11, 5};

        System.out.println(p3_partition_as_set.minDifference(arr, arr.length));
    }
}

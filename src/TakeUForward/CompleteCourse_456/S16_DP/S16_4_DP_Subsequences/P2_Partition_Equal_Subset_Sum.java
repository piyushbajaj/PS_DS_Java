package TakeUForward.CompleteCourse_456.S16_DP.S16_4_DP_Subsequences;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S16_DP.S16_4_DP_Subsequences
 * <p>
 * User: piyushbajaj
 * Date: 19/11/22
 * Time: 4:52 pm
 */
public class P2_Partition_Equal_Subset_Sum {
    public int equalPartition(int N, int[] arr) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        if (sum % 2 != 0) {
            return 0;
        }

        sum = sum / 2;

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
        return prev[sum] ? 1 : 0;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 11, 5};

        P2_Partition_Equal_Subset_Sum p2_partition_equal_subset_sum = new P2_Partition_Equal_Subset_Sum();
        System.out.println(p2_partition_equal_subset_sum.equalPartition(arr.length, arr));
    }
}

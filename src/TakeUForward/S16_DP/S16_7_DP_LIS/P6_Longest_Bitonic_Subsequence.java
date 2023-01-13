package TakeUForward.S16_DP.S16_7_DP_LIS;

import java.util.Arrays;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S16_DP.S16_7_DP_LIS
 * <p>
 * User: piyushbajaj
 * Date: 24/12/22
 * Time: 2:36 pm
 * <p>
 * lc: <a href="https://practice.geeksforgeeks.org/problems/longest-bitonic-subsequence0824/1">...</a>
 */
public class P6_Longest_Bitonic_Subsequence {

    /**
     * TC: O(N*N) + O(N*N) + O(N)
     * SC: 2*O(N)
     *
     * @param nums
     * @return
     */
    public int longestBitonicSequence(int[] nums) {
        int n = nums.length;
        int[] dp_left_to_right = new int[n];
        Arrays.fill(dp_left_to_right, 1);

        for (int index = 0; index < n; index++) {
            for (int prev = 0; prev < index; prev++) {
                if (nums[index] > nums[prev] && 1 + dp_left_to_right[prev] > dp_left_to_right[index]) {
                    dp_left_to_right[index] = 1 + dp_left_to_right[prev];
                }
            }
        }

        int[] dp_right_to_left = new int[n];
        Arrays.fill(dp_right_to_left, 1);

        for (int index = n - 1; index >= 0; index--) {
            for (int prev = n - 1; prev > index; prev--) {
                if (nums[index] > nums[prev] && 1 + dp_right_to_left[prev] > dp_right_to_left[index]) {
                    dp_right_to_left[index] = 1 + dp_right_to_left[prev];
                }
            }
        }

        int maxi = 0;
        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, dp_left_to_right[i] + dp_right_to_left[i] - 1);
        }

        return maxi;
    }

    public static void main(String[] args) {
        P6_Longest_Bitonic_Subsequence p6_longest_bitonic_subsequence = new P6_Longest_Bitonic_Subsequence();

        int[] nums = {1, 11, 2, 10, 4, 5, 2, 1};
        System.out.println(p6_longest_bitonic_subsequence.longestBitonicSequence(nums));
    }
}

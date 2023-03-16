package TakeUForward.CompleteCourse_456.S16_DP.S16_7_DP_LIS;

import java.util.Arrays;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S16_DP.S16_7_DP_LIS
 * <p>
 * User: piyushbajaj
 * Date: 24/12/22
 * Time: 6:00 pm
 * <p>
 * lc: <a href="https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/">...</a>
 */
public class P7_Number_LIS {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] cnt = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(cnt, 1);

        int maxi = 1;
        for (int index = 0; index < n; index++) {
            for (int prev = 0; prev < index; prev++) {
                if (nums[index] > nums[prev] && 1 + dp[prev] > dp[index]) {
                    dp[index] = 1 + dp[prev];
                    // inherit
                    cnt[index] = cnt[prev];
                } else if (nums[index] > nums[prev] && 1 + dp[prev] == dp[index]) {
                    cnt[index] += cnt[prev];
                }
            }
            maxi = Math.max(maxi, dp[index]);
        }

        int nos = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == maxi) {
                nos += cnt[i];
            }
        }

        return nos;
    }

    public static void main(String[] args) {
        P7_Number_LIS p7_number_lis = new P7_Number_LIS();
        System.out.println(p7_number_lis.findNumberOfLIS(new int[] {2, 2, 2, 2, 2}));
    }
}

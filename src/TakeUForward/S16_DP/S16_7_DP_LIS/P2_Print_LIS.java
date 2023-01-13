package TakeUForward.S16_DP.S16_7_DP_LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S16_DP.S16_7_DP_LIS
 * <p>
 * User: piyushbajaj
 * Date: 22/12/22
 * Time: 6:01 pm
 * lc: <a href="https://practice.geeksforgeeks.org/problems/printing-longest-increasing-subsequence/1">...</a>
 * g4g: <a href="https://practice.geeksforgeeks.org/problems/printing-longest-increasing-subsequence/1">...</a>
 */
public class P2_Print_LIS {

    public ArrayList<Integer> longestIncreasingSubsequence(int n, int[] nums) {
        int[] dp = new int[n];
        int[] hash = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(hash, 1);

        for (int index = 0; index < n; index++) {
            hash[index] = index;
            for (int prev = 0; prev < index; prev++) {
                if (nums[prev] < nums[index] && 1 + dp[prev] > dp[index]) {
                    dp[index] = 1 + dp[prev];
                    hash[index] = prev;
                }
            }
        }

        int lastIndex = -1;
        int ans = -1;

        for (int i = 0; i < n; i++) {
            if (dp[i] > ans) {
                ans = dp[i];
                lastIndex = i;
            }
        }

        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(nums[lastIndex]);

        while (lastIndex != hash[lastIndex]) {
            lastIndex = hash[lastIndex];
            temp.add(nums[lastIndex]);
        }

        Collections.reverse(temp);

        return temp;
    }

    public static void main(String[] args) {
        P2_Print_LIS p2_print_lis = new P2_Print_LIS();
        System.out.println(p2_print_lis.longestIncreasingSubsequence(6, new int[] {6, 3, 7, 4, 6, 9}));
    }
}

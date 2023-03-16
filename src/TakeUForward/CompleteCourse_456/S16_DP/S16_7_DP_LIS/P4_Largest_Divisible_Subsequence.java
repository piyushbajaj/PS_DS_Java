package TakeUForward.CompleteCourse_456.S16_DP.S16_7_DP_LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S16_DP.S16_7_DP_LIS
 * <p>
 * User: piyushbajaj
 * Date: 23/12/22
 * Time: 5:40 pm
 * lc: <a href="https://leetcode.com/problems/largest-divisible-subset/">...</a>
 * <p>
 * g4g: <a href="https://practice.geeksforgeeks.org/problems/e866d887f78664cdbf24c61ef9404691f4fb9e59/1">...</a>
 */
public class P4_Largest_Divisible_Subsequence {

    /**
     * TC: O(N*N)
     * SC: O(N*N)
     *
     * @param nums
     * @return
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        int[] hash = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(hash, 1);

        for (int index = 0; index < n; index++) {
            hash[index] = index;
            for (int prev = 0; prev < index; prev++) {
                if (nums[index] % nums[prev] == 0 && 1 + dp[prev] > dp[index]) {
                    dp[index] = 1 + dp[prev];
                    hash[index] = prev;
                }
            }
        }

        int ans = -1;
        int lastIndex = -1;

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
        P4_Largest_Divisible_Subsequence p4_largest_divisible_subsequence = new P4_Largest_Divisible_Subsequence();
        int[] nums = {1, 2, 4, 8};
        System.out.println(p4_largest_divisible_subsequence.largestDivisibleSubset(nums));
    }
}

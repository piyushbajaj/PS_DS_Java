package PrefixSum;

import java.util.Arrays;

/**
 * Created by bajajp on 25 Sep, 2022
 */
public class P1_RunningSum {
    static int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = nums[i] + prefixSum[i - 1];
        }

        return prefixSum;
    }

    static int[] runningSum1(int[] nums) {
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }

        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(runningSum(new int[] {1, 2, 3, 4})));
        System.out.println(Arrays.toString(runningSum1(new int[] {1, 2, 3, 4})));
    }
}

package StriverSDESheet.Arrays_Part1;

/**
 * Created by bajajp on 31 Jul, 2022
 */
public class P4_MaximumSubArray {
    public static int maxSubArray(int[] nums) {
        int maxSoFar = Integer.MIN_VALUE;
        int n = nums.length;
        int maxSum = 0, l = 0;
        while (l < n) {
            maxSum += nums[l];

            if (maxSum > maxSoFar) {
                maxSoFar = maxSum;
            }

            if (maxSum < 0) {
                maxSum = 0;
            }
            l++;
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
//        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int[] arr = {-2, -3, -1, -5};
        System.out.println(maxSubArray(arr));
    }
}

package Array.Practice_2022.SlidingWindow;

/**
 * Created by bajajp on 21 May, 2022
 */
public class MinimumSizeSubArray {
    public int minimumSizeSubArray(int[] arr, int target) {
        int len = arr.length;
        int maxSum = 0;
        int minLen = 0;

        for (int i = 0; i < len; i++) {
            maxSum += arr[i];
            if (maxSum >= target) {
                minLen = i;
                break;
            }
        }

        int windowSum = maxSum;

        for (int i = minLen; i < len; i++) {
            windowSum += arr[i] - arr[i - minLen];
            if (windowSum >= target) {
//                minLen = Math.min(minLen, (i - ()))
            }
        }

        return -1;


    }

    public static int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = 0, sum = 0, min = Integer.MAX_VALUE;
        int n = nums.length;
        while (r < n) {
            if (sum < target) {
                sum += nums[r++];
            } else {
                min = Math.min(min, r - l);
                l = r;
                sum = 0;
            }
        }
        min = Math.min(min, r - l);
        return min;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }
}

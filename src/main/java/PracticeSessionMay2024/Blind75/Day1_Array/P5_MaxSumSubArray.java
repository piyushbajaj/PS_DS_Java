package PracticeSessionMay2024.Blind75.Day1_Array;

/**
 * Project: DSAlgo
 * Package: PracticeSessionMay2024.Blind75.Day1_Array
 * <p>
 * User: piyushbajaj
 * Date: 12/08/24
 * Time: 9:16 am
 * <p>
 * Link: <a href="https://leetcode.com/problems/maximum-subarray/description/">...</a>
 */
public class P5_MaxSumSubArray {

    /**
     * TC: O(N)
     * SC: O(1)
     *
     * @param arr
     * @return
     */
    public int maxSubArray(int[] arr) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (sum > max) {
                max = sum;
            }

            if (sum < 0) {
                sum = 0;
            }
        }

        return max;
    }

    /**
     * This also works for all -ve number
     * TC: O(N)
     * SC: O(1)
     *
     * @param arr
     * @return
     */
    public int maxSubArray_better(int[] arr) {
        int currSumMax = arr[0];
        int maxSoFar = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currSumMax = Math.max(currSumMax + arr[i], arr[i]);
            maxSoFar = Math.max(currSumMax, maxSoFar);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        P5_MaxSumSubArray maxSubArray = new P5_MaxSumSubArray();
        System.out.println(maxSubArray.maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(maxSubArray.maxSubArray_better(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}

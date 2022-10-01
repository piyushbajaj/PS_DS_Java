package Practice75Problems.Array;

/*
https://www.techiedelight.com/maximum-subarray-problem-kadanes-algorithm/
 */
public class P5_MaximumSumSubArray {
    public static int maximumSumSubArray(int[] arr) {
        int maxSoFar = Integer.MIN_VALUE;
        int currMax = 0;

        for (int val : arr) {
            currMax = currMax + val;

            if (currMax > maxSoFar) {
                maxSoFar = currMax;
            }

            if (currMax < 0) {
                currMax = 0;
            }
        }
        return maxSoFar;
    }

    public static int maximumSumSubArray_withNegative(int[] arr) {
        int maxSoFar = arr[0];
        int currMax = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currMax = Math.max(currMax + arr[i], arr[i]);
            maxSoFar = Math.max(currMax, maxSoFar);
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, 5, 4};
        int[] arr1 = {-8, -3, -6, -2, -5, -4};

        System.out.println(P5_MaximumSumSubArray.maximumSumSubArray(arr1));

        System.out.println(P5_MaximumSumSubArray.maximumSumSubArray_withNegative(arr1));
    }
}

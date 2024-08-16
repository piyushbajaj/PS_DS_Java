package Array.Practice_2022.SlidingWindow;

/**
 * Created by bajajp on 21 May, 2022
 */
public class MaximumSum {
    public static void main(String[] args) {
        MaximumSum maximumSum = new MaximumSum();

        int[] arr = {1, 4, 2, 10, 2, 3, 1, 0, 20};

        System.out.println(maximumSum.maximumSum(arr, 4));
    }

    /**
     * Reference: https://www.geeksforgeeks.org/window-sliding-technique/
     * <p>
     * Description:
     * 1. Calculate for the first k blocks
     * 2. Start the loop from the kth to the nth element
     *
     * @param arr
     * @param k
     * @return int
     * <p>
     * Complexity
     * TC: O(N)
     * SC: O(1)
     */
    public int maximumSum(int[] arr, int k) {
        int len = arr.length;
        int maxSum = 0;

        if (k > len) {
            return -1;
        }

        for (int i = 0; i < k; i++) {
            maxSum += arr[i];
        }

        int windowSum = maxSum;

        for (int j = k; j < len; j++) {
            windowSum += arr[j] - arr[j - k];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;

    }
}

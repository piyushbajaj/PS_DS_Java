package SlidingWindow;

/**
 * Created by bajajp on 23 Sep, 2022
 */
public class Grokking2_SmallestSubarrayWithSum {

    /**
     * TC: O(N)
     * SC: O(1)
     *
     * @param arr
     * @param S
     * @return
     */
    static int findMinSubArray(int[] arr, int S) {
        int l = 0, r = 0, n = arr.length;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;

        while (r < n) {
            sum += arr[r++];
            while (sum >= S) {
                minLength = Math.min(minLength, r - l);
                sum -= arr[l];
                l++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        System.out.println(findMinSubArray(new int[] {2, 1, 5, 2, 3, 2}, 7));
    }
}

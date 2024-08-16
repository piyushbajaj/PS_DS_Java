package SlidingWindow;

/**
 * Created by bajajp on 23 Sep, 2022
 * <p>
 * link: https://akshay-iyangar.github.io/system-design/grokking-coding-interviews/2-patttern-sliding-window/2-Maximum-Sum-Subarray-of-Size-K-easy/1.1-Maximum-Sum-Subarray-of-Size-K-easy.html
 */
public class Grokking1_MaximumSumOfContiguousSubarray {

    static int findMaxSumSubArray(int k, int[] arr) {
        int l = 0, r = 0, n = arr.length;
        int maxSoFar = 0;
        int sum = 0;

        while (r < n) {
            sum += arr[r];
            r++;

            if (r - l == k) {
                maxSoFar = Math.max(maxSoFar, sum);
                sum -= arr[l];
                l++;
            }
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        System.out.println(findMaxSumSubArray(3, new int[] {2, 1, 5, 1, 3, 2}));
    }
}

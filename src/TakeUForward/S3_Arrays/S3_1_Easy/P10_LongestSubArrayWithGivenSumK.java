package TakeUForward.S3_Arrays.S3_1_Easy;

/**
 * Created by bajajp on 28 Sep, 2022
 * Link: https://takeuforward.org/data-structure/longest-subarray-with-given-sum-k/
 */
public class P10_LongestSubArrayWithGivenSumK {
    static int subarraySum(int[] arr, int k) {
        int l = 0, r = 0, n = arr.length;
        int maxLenSoFar = 0;
        int sum = 0;

        while (r < n) {
            sum += arr[r++];

            if (sum == k) {
                maxLenSoFar = Math.max(maxLenSoFar, r - l);
            } else if (sum > k) {
                sum = sum - arr[l];
                l++;
            }
        }
        return maxLenSoFar;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{7, 1, 6, 0}, 7));
        System.out.println(subarraySum(new int[]{2, 3, 5, 1, 9}, 10));
    }
}

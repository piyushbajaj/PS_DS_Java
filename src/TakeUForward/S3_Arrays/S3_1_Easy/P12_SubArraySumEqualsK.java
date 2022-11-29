package TakeUForward.S3_Arrays.S3_1_Easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bajajp on 21 Sep, 2022
 * <p>
 * Link: https://leetcode.com/problems/subarray-sum-equals-k/
 * <p>
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 * <p>
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 */
public class P12_SubArraySumEqualsK {
    /**
     * Total number of subarrays whose sum equals to k -> At-most k - At-most k-1
     *
     * @param arr
     * @param k
     * @return
     */
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

    static int subarraySum_util(int[] arr, int k) {
        int l = 0, r = 0, n = arr.length;
        int res = 0, sum = k;

        // Storing Integers with frequency
        Map<Integer, Integer> hashMap = new HashMap<>();


        while (r < n) {
            if (arr[r] > k) {
                r++;
                l++;
            } else {

            }

            if (arr[r] <= k) {
                k = k - arr[r];
            }

            hashMap.put(arr[r], hashMap.getOrDefault(arr[r], 0) + 1);

            while (k < arr[r]) {

            }
            r++;
            res += r - l;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[] {7, 1, 6, 0}, 7));
        System.out.println(subarraySum(new int[] {2, 3, 5, 1, 9}, 10));
    }
}

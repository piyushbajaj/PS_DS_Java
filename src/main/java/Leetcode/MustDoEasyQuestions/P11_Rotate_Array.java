package Leetcode.MustDoEasyQuestions;

import java.util.Arrays;

/**
 * Project: DS_Algo
 * Package: Leetcode.MustDoEasyQuestions
 * <p>
 * User: piyushbajaj
 * Date: 31/12/22
 * Time: 11:57 am
 * <p>
 * lc: <a href="https://leetcode.com/problems/rotate-array/description/">...</a>
 */
public class P11_Rotate_Array {

    public static void main(String[] args) {
        P11_Rotate_Array p11_rotate_array = new P11_Rotate_Array();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        p11_rotate_array.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * Rotate array by right for k steps
     * <p>
     * 1. Reverse the array from 0 to n
     * 2. Reverse the array from o to k
     * 3. Reverse the array from k to n
     * <p>
     * TC: O(2N)
     * SC: O(1)
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;

        // base case
        if (k > n) {
            k = k % n;
        }

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    public void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}

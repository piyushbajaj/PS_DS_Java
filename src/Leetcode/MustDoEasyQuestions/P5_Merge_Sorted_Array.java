package Leetcode.MustDoEasyQuestions;

import java.util.Arrays;

/**
 * Project: DS_Algo
 * Package: Leetcode.MustDoEasyQuestions
 * <p>
 * User: piyushbajaj
 * Date: 30/12/22
 * Time: 1:48 pm
 * Pattern: Array, Two Pointers, Sorting
 * <p>
 * lc: <a href="https://leetcode.com/problems/merge-sorted-array/">...</a>
 */
public class P5_Merge_Sorted_Array {

    /**
     * Start from back
     * TC: O(M+N)
     * SC: O(1)
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // base condition
        int k = m + n;
        k = k - 1;
        m = m - 1;
        n = n - 1;

        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[k] = nums1[m];
                m--;
            } else {
                nums1[k] = nums2[n];
                n--;
            }
            k--;
        }

        while (m >= 0) {
            nums1[k] = nums1[m];
            k--;
            m--;
        }

        while (n >= 0) {
            nums1[k] = nums2[n];
            n--;
            k--;
        }
    }

    public static void main(String[] args) {
        P5_Merge_Sorted_Array p5_merge_sorted_array = new P5_Merge_Sorted_Array();
        int[] num1 = {1, 2, 3, 0, 0, 0};
        int[] num2 = {2, 5, 6};
        p5_merge_sorted_array.merge(num1, 3, num2, 3);
        System.out.println(Arrays.toString(num1));
    }
}

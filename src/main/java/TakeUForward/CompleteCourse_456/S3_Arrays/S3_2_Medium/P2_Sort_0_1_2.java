package TakeUForward.CompleteCourse_456.S3_Arrays.S3_2_Medium;

import java.util.Arrays;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S3_Arrays.S3_2_Medium
 * <p>
 * User: piyushbajaj
 * Date: 25/12/22
 * Time: 10:43 pm
 * <p>
 * lc: <a href="https://leetcode.com/problems/sort-colors/description/">...</a>
 * g4g: <a href="https://practice.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1">...</a>
 */
public class P2_Sort_0_1_2 {
    public static void main(String[] args) {
        P2_Sort_0_1_2 p2_sort_0_1_2 = new P2_Sort_0_1_2();
        int[] nums = {2, 0, 2, 1, 1, 0};
        p2_sort_0_1_2.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * Approach
     * Dutch National Flag algorithm
     * 3 Pointers approach
     * TC: O(N)
     * SC: O(1)
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0, mid = 0, high = n - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else if (nums[mid] == 2) {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

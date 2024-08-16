package StriverSDESheet.Arrays_Part1;

import java.util.Arrays;

/**
 * Created by bajajp on 31 Jul, 2022
 */
public class P5_SortAnArray {
    /**
     * We can use 3 pointer in this approach: low, mid and high
     * TC: O(N), SC: O(1)
     *
     * @param nums: Array of integers
     */
    public static void SortArray(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            switch (nums[mid]) {
                case 0:
                    swap(nums, low, mid);
                    low++;
                    mid++;
                case 1:
                    mid++;
                case 2:
                    swap(nums, mid, high);
                    high--;
            }
        }
    }

    public static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        SortArray(nums);
        System.out.println(Arrays.toString(nums));
    }
}

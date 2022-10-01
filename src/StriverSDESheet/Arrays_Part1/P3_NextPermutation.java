package StriverSDESheet.Arrays_Part1;

import java.util.Arrays;

/**
 * Created by bajajp on 30 Jul, 2022
 */
public class P3_NextPermutation {
    /**
     * Steps:
     * 1. Get the largest i which has kth(i-1) < kth(i)
     * 2. Get the largest j which has kth(i-1) < kth(j)
     * 3. Swap kth(i-1) and kth(j)
     * 4. Reverse the digits from kth(i), kth(i+1), ..., kth(n)
     *
     * @param nums
     */
    public static void nextPermutation(int[] nums) {
        int n = nums.length - 2;
        int i, j = 0;
        for (i = n; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }

        if (i >= 0) {
            for (j = nums.length - 1; j >= 0; j--) {
                if (nums[i] < nums[j]) {
                    break;
                }
            }
            swap(nums, i, j);
        }

        reverse(nums, i + 1, nums.length - 1);
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void reverse(int[] arr, int start, int end) {

        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}

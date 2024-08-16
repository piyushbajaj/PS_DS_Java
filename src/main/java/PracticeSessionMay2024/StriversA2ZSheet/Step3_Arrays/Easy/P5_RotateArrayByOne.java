package PracticeSessionMay2024.StriversA2ZSheet.Step3_Arrays.Easy;

import java.util.Arrays;

/**
 * Project: DSAlgo
 * Package: PracticeSessionMay2024.StriversA2ZSheet.Step3_Arrays.Easy
 * <p>
 * User: piyushbajaj
 * Date: 17/07/24
 * Time: 11:40 am
 */
public class P5_RotateArrayByOne {

    public static void rotate(int[] nums, int n) {
        int temp = nums[0];

        for (int i = 1; i < n; i++) {
            nums[i - 1] = nums[i];
        }

        nums[n - 1] = temp;
    }

    /**
     * Right Rotate By K
     *
     * @param nums
     * @param k
     */
    public static void rotateByK(int[] nums, int k) {
        int n = nums.length;

        // reverse the array
        reverse(nums, 0, n - 1); // 5, 4, 3, 2, 1
        // reverse k array to n
        reverse(nums, k, n - 1); // 5, 4, 1, 2, 3
        // reverse 0 to k
        reverse(nums, 0, k - 1); // 4, 5, 1, 2, 3
    }

    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        rotate(nums, nums.length);
        System.out.println(Arrays.toString(nums));

        int[] arr = {1, 2, 3, 4, 5};
        // rotate by 2, output will be 4, 5, 1, 2, 3
        rotateByK(arr, 2);
        System.out.println(Arrays.toString(arr));
    }
}

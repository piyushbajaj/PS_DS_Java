package Array.Practice_2022.TwoPointers;

import java.util.Arrays;

/**
 * Multiple ways to solve this problem
 */
public class P3_RotateArrayByKSteps {

    public static void main(String[] args) {
        P3_RotateArrayByKSteps p3_rotateArrayByKSteps = new P3_RotateArrayByKSteps();
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        p3_rotateArrayByKSteps.rotateArrays_reversal(arr, 3);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Using reversal algorithm
     * TC: O(N)
     *
     * @param arr
     * @param d
     */
    public void rotateArrays_reversal(int[] arr, int d) {
        int n = arr.length;
        d = d % n;

        reverse(arr, 0, n - 1);
        reverse(arr, 0, d - 1);
        reverse(arr, d, n - 1);
    }

    public void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

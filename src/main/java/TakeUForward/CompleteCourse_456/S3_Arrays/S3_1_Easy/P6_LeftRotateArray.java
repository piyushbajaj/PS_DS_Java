package TakeUForward.CompleteCourse_456.S3_Arrays.S3_1_Easy;

import java.util.Arrays;

/**
 * Created by bajajp on 18 Sep, 2022
 * ref: <a href="https://takeuforward.org/data-structure/rotate-array-by-k-elements/">...</a>
 */
public class P6_LeftRotateArray {
    /**
     * Rotate array left by D positions
     * TC: O(N)
     * SC: O(1)
     *
     * @param arr
     * @param d
     */
    static void rotateArrayLeftByD(int[] arr, int d) {
        int n = arr.length - 1;
        reverseArray(arr, 0, n);
        reverseArray(arr, 0, n - d);
        reverseArray(arr, n - d + 1, n);
    }

    /**
     * Rotate array left by D positions
     * TC: O(N)
     *
     * @param arr
     * @param d
     */
    static void rotateArrayRightByD(int[] arr, int d) {
        int n = arr.length - 1;
        // original array: 1, 2, 3, 4, 5, d: 2
        reverseArray(arr, 0, n); // 5, 4, 3, 2, 1
        reverseArray(arr, n - d, n);
        reverseArray(arr, 0, n - d - 1);

        // output: 4, 5, 1, 2, 3
    }

    static void reverseArray(int[] arr, int low, int high) {
        while (low <= high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4, 5};
        System.out.println("Original Array: " + Arrays.toString(arr));
        rotateArrayLeftByD(arr, 2);
        System.out.println("Left rotation: " + Arrays.toString(arr));
        arr = new int[] {1, 2, 3, 4, 5};
        System.out.println("Original Array: " + Arrays.toString(arr));
        rotateArrayRightByD(arr, 2);
        System.out.println("Right rotation: " + Arrays.toString(arr));
    }
}

package TakeUForward.S3_Arrays.S3_1_Easy;

import java.util.Arrays;

/**
 * Created by bajajp on 18 Sep, 2022
 */
public class P5_LeftRotateArray {
    /**
     * TC: O(N)
     * @param arr
     * @param d
     */
    static void reverseArrayByD(int[] arr, int d) {
        int n = arr.length - 1;
        reverseArray(arr, 0, n);
        reverseArray(arr, 0, n - d);
        reverseArray(arr, n - d + 1, n);
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
        int[] arr = new int[]{1, 2, 3, 4, 5};
        reverseArrayByD(arr, 2);
        System.out.println(Arrays.toString(arr));
    }
}

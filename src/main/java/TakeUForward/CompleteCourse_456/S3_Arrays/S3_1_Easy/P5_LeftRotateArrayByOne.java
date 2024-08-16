package TakeUForward.CompleteCourse_456.S3_Arrays.S3_1_Easy;

import java.util.Arrays;

/**
 * Project: DSAlgo
 * Package: TakeUForward.CompleteCourse_456.S3_Arrays.S3_1_Easy
 * <p>
 * User: piyushbajaj
 * Date: 28/07/23
 * Time: 4:47 pm
 */
public class P5_LeftRotateArrayByOne {


    /**
     * TC: O(N)
     * SC: O(1)
     *
     * @param arr
     * @param n
     */
    static void solve(int[] arr, int n) {
        int temp = arr[0];
        for (int i = 1; i < n; i++) {
            arr[i - 1] = arr[i];
        }
        arr[n - 1] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        solve(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}

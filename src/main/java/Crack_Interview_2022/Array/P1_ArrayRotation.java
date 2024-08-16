package Crack_Interview_2022.Array;

import java.util.Arrays;

/**
 * Created by bajajp on 04 Aug, 2022
 */
public class P1_ArrayRotation {
    /**
     * TC: O(N+d)
     * SC: O(D)
     * Problem with this approach is the space complexity.
     *
     * @param arr
     * @param d
     * @param n
     */
    public static void rotateArrByLeft(int[] arr, int d, int n) {
        int[] delta = new int[d];

        for (int i = 0; i < d; i++) {
            delta[i] = arr[i];
        }

        for (int i = 0; i < n - d; i++) {
            arr[i] = arr[i + d];
        }

        for (int i = n - d; i < n; i++) {
            arr[i] = delta[i - (n - d)];
        }
    }

    // Let's try to reduce space here

    /**
     * TC: O(N*D)
     * SC: O(1)
     * In the approach we will rotate the array one by one till d is reached
     * Pros:
     * - We used O(1) space
     * Cons:
     * - Time has increased to N^2 almost
     *
     * @param arr
     * @param d
     * @param n
     */
    public static void rotateArrByLeft_less_space(int[] arr, int d, int n) {
        for (int i = 0; i < d; i++) {
            int temp = arr[0];
            for (int j = 0; j < n - 1; j++) {
                arr[j] = arr[j + 1];
            }
            arr[n - 1] = temp;
        }
    }

    // Let's try to reduce the time here, here with the help of Juggling Algorithm


    /**
     * Reversal Algorithm
     * For e.g.: [1, 2, 3, 4, 5, 6, 7], d = 2; Expected Output: [3, 4, 5, 6, 7, 1, 2]
     * Steps:
     * - Reverse the complete array: [7, 6, 5, 4, 3, 2, 1]
     * - Reverse N-D elements from start: [3, 4, 5, 6, 7, 2, 1]
     * - Reverse D elements from end: [3, 4, 5, 6, 7, 1, 2]
     *
     * @param arr
     * @param d
     * @param n
     */
    public static void rotateArrByLeft_reversal(int[] arr, int d, int n) {
        reverseArray(arr, 0, n - 1);
        reverseArray(arr, 0, n - 1 - d);
        reverseArray(arr, n - d, n - 1);
    }

    /**
     * @param arr
     * @param start
     * @param end
     */
    public static void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }


    /**
     * Reversal Algorithm
     * For e.g.: [1, 2, 3, 4, 5, 6, 7], d = 2; Expected Output: [6, 7, 1, 2, 3, 4, 5]
     * Steps:
     * - Reverse the complete array: [7, 6, 5, 4, 3, 2, 1]
     * - Reverse first D elements: [6, 7, 5, 4, 3, 2, 1]
     * - Reverse last N-D elements: [6, 7, 1, 2, 3, 4, 5]
     * @param arr
     * @param d
     * @param n
     */
    public static void rotateArrByRight_reversal(int[] arr, int d, int n) {
        d = d % n;
        reverseArray(arr, 0, n - 1);
        reverseArray(arr, 0, d-1);
        reverseArray(arr, d, n - 1);
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
//        rotateArrByLeft(arr, 1, 7);
//        rotateArrByLeft_less_space(arr, 2, 7);
        rotateArrByLeft_reversal(arr, 2, 7);
        System.out.println(Arrays.toString(arr));


        int[] arrRight = {1, 2, 3, 4, 5, 6, 7};
        rotateArrByRight_reversal(arrRight, 2, 7);
        System.out.println(Arrays.toString(arrRight));
    }
}

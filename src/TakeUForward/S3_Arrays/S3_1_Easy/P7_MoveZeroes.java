package TakeUForward.S3_Arrays.S3_1_Easy;

import java.util.Arrays;

/**
 * Created by bajajp on 18 Sep, 2022
 * <p>
 * Link: https://takeuforward.org/data-structure/move-all-zeros-to-the-end-of-the-array/
 * <p>
 * Problem Statement: You are given an array of integers, your task is to move all the zeros in the array to the end
 * of the array and move non-negative integers to the front by maintaining their order.
 * <p>
 * Example 1:
 * Input: 1 ,0 ,2 ,3 ,0 ,4 ,0 ,1
 * Output: 1 ,2 ,3 ,4 ,1 ,0 ,0 ,0
 * Explanation: All the zeros are moved to the end and non-negative integers are moved to front by maintaining order
 * <p>
 * Example 2:
 * Input: 1,2,0,1,0,4,0
 * Output: 1,2,1,4,0,0,0
 * Explanation: All the zeros are moved to the end and non-negative integers are moved to front by maintaining order
 */
public class P7_MoveZeroes {

    /**
     * TC: O(N)
     *
     * @param arr
     */
    static void moveZeroes(int[] arr) {

        int i = 0, j = i + 1, n = arr.length;

        while (j < n) {
            if (arr[i] == 0) {
                if (arr[j] != 0) {
                    swap(arr, i, j);
                    i++;
                }
            } else {
                i++;
            }
            j++;
        }
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 3, 0, 4, 0, 1};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
}

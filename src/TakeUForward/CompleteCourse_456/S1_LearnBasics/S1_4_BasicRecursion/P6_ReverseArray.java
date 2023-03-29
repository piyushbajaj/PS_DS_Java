package TakeUForward.CompleteCourse_456.S1_LearnBasics.S1_4_BasicRecursion;

import java.util.Arrays;

/**
 * Created by bajajp on 17 Sep, 2022
 * <p>
 * Link: https://takeuforward.org/data-structure/reverse-a-given-array/
 * <p>
 * Problem Statement: You are given an array. The task is to reverse the array and print it.
 * <p>
 * Example 1:
 * Input: N = 5, arr[] = {5,4,3,2,1}
 * Output: {1,2,3,4,5}
 * Explanation: Since the order of elements gets reversed the first element will occupy the fifth position,
 * the second element occupies the fourth position and so on.
 * <p>
 * Example 2:
 * Input: N=6 arr[] = {10,20,30,40}
 * Output: {40,30,20,10}
 * Explanation: Since the order of elements gets reversed the first element will occupy the fifth position,
 * the second element occupies the fourth position and so on.
 */
public class P6_ReverseArray {

    /**
     * Iterative Approach
     * TC: O(N)
     * SC: O(1)
     *
     * @param arr
     * @return
     */
    static int[] reverseArray(int[] arr) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
        return arr;
    }

    /**
     * Recursive Approach
     * TC: O(N)
     * SC: O(1)
     *
     * @param arr
     * @return
     */
    static int[] reverseArray_recur(int[] arr) {
        return reverseArray_recur_util(arr, 0, arr.length - 1);
    }

    static int[] reverseArray_recur_util(int[] arr, int low, int high) {
        if (low <= high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            reverseArray_recur_util(arr, low + 1, high - 1);
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(reverseArray(new int[] {5, 4, 3, 2, 1})));

        System.out.println(Arrays.toString(reverseArray_recur(new int[] {5, 4, 3, 2, 1})));
    }
}

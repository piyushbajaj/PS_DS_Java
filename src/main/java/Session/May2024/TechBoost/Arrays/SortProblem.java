package Session.May2024.TechBoost.Arrays;

import java.util.Arrays;

/**
 * Project: DSAlgo
 * Package: PracticeSessionMay2024.TechBoost.Arrays
 * <p>
 * User: piyushbajaj
 * Date: 08/07/24
 * Time: 8:11 am
 */
public class SortProblem {

    /**
     * Steps:
     * 1. Inner loop: Get the minimum of all elements, and place in the start.
     * 2. Outer loop: Keep element increasing one by one
     * <p>
     * TC: O(N*N)
     * SC: O(1)
     *
     * @param arr
     * @param n
     */
    public static void selectionSort(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int min = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(arr, min, i);
            }
        }
    }

    /**
     * Steps:
     * 1. Inner loop: One by one move bigger element to the end
     * 2. Outer loop: Starts from end and finish in the start
     * TC: O(N*N)
     * SC: O(1)
     *
     * @param arr
     * @param n
     */
    public static void bubbleSort(int[] arr, int n) {
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 8, 4, 9, 0};
        selectionSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));

        int[] arr1 = {1, 3, 2, 8, 4, 9, 0};
        bubbleSort(arr1, arr1.length);
        System.out.println(Arrays.toString(arr1));
    }
}

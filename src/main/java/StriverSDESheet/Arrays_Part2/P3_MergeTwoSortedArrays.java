package StriverSDESheet.Arrays_Part2;

import java.util.Arrays;

/**
 * Created by bajajp on 14 Aug, 2022
 */
public class P3_MergeTwoSortedArrays {

    /**
     * Insertion Algo approach
     * TC: O(N*M)
     * SC: O(1)
     *
     * @param arr1
     * @param arr2
     * @param n
     * @param m
     */
    public static void merge(int[] arr1, int arr2[], int n, int m) {
        for (int i = 0; i < n; i++) {
            if (arr1[i] > arr2[0]) {
                int temp = arr1[i];
                arr1[i] = arr2[0];
                arr2[0] = temp;
            }

            int first = arr2[0], j = 1;
            for (j = 1; j < m && arr2[j] < first; j++) {
                arr2[j - 1] = arr2[j];
            }
            if (arr2[0] != first) {
                arr2[j - 1] = first;
            }
        }
    }

    /**
     * Gap Algorithm: https://takeuforward.org/data-structure/merge-two-sorted-arrays-without-extra-space/
     *
     * @param arr1
     */
    public static void merge_better(int[] arr1, int arr2[], int n, int m) {
        for (int i = 0; i < n; i++) {
            if (arr1[i] > arr2[0]) {
                int temp = arr1[i];
                arr1[i] = arr2[0];
                arr2[0] = temp;
            }

            int first = arr2[0], j = 1;
            for (j = 1; j < m && arr2[j] < first; j++) {
                arr2[j - 1] = arr2[j];
            }
            if (arr2[0] != first) {
                arr2[j - 1] = first;
            }
        }
    }


    public static void main(String[] args) {
        int[] arr1 = {1, 4, 7, 8, 10};
        int[] arr2 = {2, 3, 9};

        merge(arr1, arr2, arr1.length, arr2.length);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}

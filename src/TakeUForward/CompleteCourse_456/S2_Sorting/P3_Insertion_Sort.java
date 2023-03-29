package TakeUForward.CompleteCourse_456.S2_Sorting;

import java.util.Arrays;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S1_Sorting
 * <p>
 * User: piyushbajaj
 * Date: 12/10/22
 * Time: 8:12 pm
 * <p>
 */
public class P3_Insertion_Sort {

    public static void main(String[] args) {
        P3_Insertion_Sort p3_insertion_sort = new P3_Insertion_Sort();
        int[] arr = {13, 46, 24, 52, 20, 9};
        p3_insertion_sort.insertionSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Approach:
     * 1. Keeping the outer loop from 2nd element
     * 2. Considering 1st element in temp
     * 3. if temp < 1st element, replace 2nd with 1st
     * 4. In the end, replace 2nd with temp
     * <p>
     * TC: O(N*N)
     * SC: O(1)
     *
     * @param arr
     * @param n
     */
    public void insertionSort(int[] arr, int n) {

        for (int i = 1; i < n; i++) {
            int curr = arr[i];
            int j = i - 1;
            while (j >= 0 && curr < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = curr;
        }
    }
}

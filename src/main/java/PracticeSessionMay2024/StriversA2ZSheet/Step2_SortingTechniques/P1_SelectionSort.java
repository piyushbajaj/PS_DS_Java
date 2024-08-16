package PracticeSessionMay2024.StriversA2ZSheet.Step2_SortingTechniques;

import java.util.Arrays;

/**
 * Project: DSAlgo
 * Package: StriversA2ZSheet.Step2_SortingTechniques
 * <p>
 * User: piyushbajaj
 * Date: 22/05/24
 * Time: 12:31 pm
 *
 * <a href="https://takeuforward.org/sorting/selection-sort-algorithm/">...</a>
 */
public class P1_SelectionSort {

    /**
     * Algorithm:
     * 1. Loop through all the elements from 0 to n-1
     * 2. Get the minimum element and replace with the outer loop ith Index
     * <p>
     * TC: O(N*2)
     * SC: O(1)
     *
     * @param arr
     * @param n
     */
    public void selectionSort(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
                if (minIndex != i) {
                    //swap
                    int temp = arr[minIndex];
                    arr[minIndex] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        P1_SelectionSort p1SelectionSort = new P1_SelectionSort();
        int[] arr = {13, 46, 24, 52, 20, 9};
        p1SelectionSort.selectionSort(arr, 6);
        System.out.println(Arrays.toString(arr));
    }
}

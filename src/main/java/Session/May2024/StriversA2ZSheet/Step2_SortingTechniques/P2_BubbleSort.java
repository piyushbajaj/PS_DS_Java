package Session.May2024.StriversA2ZSheet.Step2_SortingTechniques;

import java.util.Arrays;

/**
 * Project: DSAlgo
 * Package: StriversA2ZSheet.Step2_SortingTechniques
 * <p>
 * User: piyushbajaj
 * Date: 22/05/24
 * Time: 6:22 pm
 *
 * <a href="https://takeuforward.org/data-structure/bubble-sort-algorithm/">...</a>
 */
public class P2_BubbleSort {

    /**
     * Algo:
     * 1. Loop from n-1 to 0
     * 2. Swap each element side by side
     *
     * TC: O(N^2)
     * SC: O(1)
     * @param arr
     * @param n
     */
    public void bubbleSort(int[] arr, int n) {
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    Utils.swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        P2_BubbleSort p2BubbleSort = new P2_BubbleSort();
        int[] arr = {13, 46, 24, 52, 20, 9};
        p2BubbleSort.bubbleSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}

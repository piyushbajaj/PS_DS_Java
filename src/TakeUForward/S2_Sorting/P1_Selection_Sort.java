package TakeUForward.S2_Sorting;

import java.util.Arrays;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S1_Sorting
 * <p>
 * User: piyushbajaj
 * Date: 12/10/22
 * Time: 9:01 am
 * <p>
 */
public class P1_Selection_Sort {

    /**
     * Approach:
     * 1. Get the minimum the element from the inner loop like from i+1 to n-1
     * 2. Swap that element with the first element
     * <p>
     * TC: O(N*N)
     * SC: O(1)
     */
    public void selectionSort(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            Utility.swap(arr, i, minIndex);
        }
    }

    public static void main(String[] args) {
        P1_Selection_Sort p1_selection_sort = new P1_Selection_Sort();
        int[] arr = {4, 1, 3, 9, 7};
        p1_selection_sort.selectionSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}

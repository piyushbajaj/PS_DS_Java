package TakeUForward.CompleteCourse_456.S2_Sorting;

import java.util.Arrays;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S1_Sorting
 * <p>
 * User: piyushbajaj
 * Date: 12/10/22
 * Time: 9:40 am
 * <p>
 */
public class P2_Bubble_Sort {

    public static void main(String[] args) {
        P2_Bubble_Sort p2_bubble_sort = new P2_Bubble_Sort();
        int[] arr = {4, 1, 3, 9, 7};
        p2_bubble_sort.bubbleSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Approach:
     * 1. Swap the adjacent elements, which is greater
     * 2. Reduce the loop one by one from last
     * <p>
     * TC: O(N*N)
     * SC: O(1)
     *
     * @param arr
     * @param n
     */
    public void bubbleSort(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    Utility.swap(arr, j, j + 1);
                }
            }
        }
    }
}

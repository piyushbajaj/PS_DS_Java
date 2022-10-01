package TakeUForward.S2_Sorting.S2_2_Sorting_2;

import java.util.Arrays;

/**
 * Created by bajajp on 27 Sep, 2022
 */
public class P4_QuickSort {
    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left;

        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, right);
        return i;
    }

    public void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);

            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
    }

    public static void main(String[] args) {
        P4_QuickSort p4_quickSort = new P4_QuickSort();
        int[] arr = {12, 3, 5, 7, 4, 19, 26};
        p4_quickSort.quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}

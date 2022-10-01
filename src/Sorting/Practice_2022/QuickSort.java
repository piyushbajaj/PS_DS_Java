package Sorting.Practice_2022;

import java.util.Arrays;

public class QuickSort extends BaseClass {
    /**
     *
     * @param arr
     * @param start
     * @param end
     */
    public void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pivot = partition(arr, start, end);
            quickSort(arr, start, pivot - 1);
            quickSort(arr, pivot + 1, end);
        }
    }

    public int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int leftCtr = start, rightCtr = end;

        while (leftCtr < rightCtr) {

            while (leftCtr <= end && arr[leftCtr] <= pivot) {
                leftCtr++;
            }

            while (rightCtr >= start && arr[rightCtr] > pivot) {
                rightCtr--;
            }

            if (leftCtr < rightCtr) {
                swap(arr, leftCtr, rightCtr);
            }
        }

        arr[start] = arr[rightCtr];
        arr[rightCtr] = pivot;

        return rightCtr;
    }

    public static void main(String[] args) {
//        int[] arr = {6, 4, 2, 1, 3, 5};
        int[] arr = {3, 10, 1, 5, 0, 20};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}

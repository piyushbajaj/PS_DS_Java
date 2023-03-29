package Leetcode.Sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int a[] = {6, 4, 2, 1, 3, 5};
        System.out.println(Arrays.toString(selectionSort.selection(a)));

        System.out.println(Arrays.toString(a));
    }

    // Validating and swapping the minimum element in the start
    public int[] selection(int[] arr) {
        int n = arr.length;
        int minIndex = -1;
        for (int i = 0; i <= n - 1; i++) {
            minIndex = i;

            for (int j = i + 1; j <= n - 1; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            swap(arr, minIndex, i);
        }
        return arr;
    }

    public void swap(int[] arr, int p, int q) {
        int temp = arr[p];
        arr[p] = arr[q];
        arr[q] = temp;
    }
}

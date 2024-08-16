package Leetcode.Sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] a = {6, 4, 2, 1, 3, 5};
        System.out.println(Arrays.toString(bubbleSort.bubble(a)));
    }

    // Sorting 2 elements at a time
    public int[] bubble(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
        return arr;
    }

    public void swap(int[] arr, int p, int q) {
        int temp = arr[p];
        arr[p] = arr[q];
        arr[q] = temp;
    }
}

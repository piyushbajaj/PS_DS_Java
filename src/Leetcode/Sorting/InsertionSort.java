package Leetcode.Sorting;

import java.util.Arrays;

public class InsertionSort {

    // selecting the sorting the element within a group from start
    public int[] insertion(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int v = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > v) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = v;
        }

        return arr;
    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int[] a = {6, 4, 2, 1, 3, 5};
        System.out.println(Arrays.toString(insertionSort.insertion(a)));
    }
}

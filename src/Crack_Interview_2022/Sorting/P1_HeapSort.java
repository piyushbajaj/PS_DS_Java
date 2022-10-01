package Crack_Interview_2022.Sorting;

import java.util.Arrays;

/**
 * Created by bajajp on 04 Aug, 2022
 */
public class P1_HeapSort {

    public static int leftChild(int i) {
        return 2 * i + 1;
    }

    public static int rightChild(int i) {
        return 2 * i + 2;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * This is Maximum heap
     * TC: O(logN)
     *
     * @param arr
     * @param n
     * @param i
     */
    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int l = leftChild(i);
        int r = rightChild(i);

        if (l < n && arr[l] > arr[largest]) {
            largest = l;
        }

        if (r < n && arr[r] > arr[largest]) {
            largest = r;
        }

        if (largest != i) {
            swap(arr, largest, i);
            heapify(arr, n, largest);
        }
    }

    /**
     * Sort the Array using Heap Sort Max Algorithm
     *
     * @param arr
     */
    public static void heapSort(int[] arr) {
        int n = arr.length;

        //Re-Arrange the array in the form of Max Heap, TC: O(N\2 * LogN)
        for (int i = (n - 1) / 2; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = (n - 1); i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 10, 3, 2, 4, 7};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

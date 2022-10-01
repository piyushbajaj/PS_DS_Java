package Heap.Practice_2022;

import java.util.Arrays;

public class HeapSort {

    public void swap(int[] arr, int val1, int val2) {
        int temp = arr[val1];
        arr[val1] = arr[val2];
        arr[val2] = temp;
    }

    public int leftChildren(int i) {
        return 2 * i + 1;
    }

    public int rightChildren(int i) {
        return 2 * i + 2;
    }

    public int parent(int i) {
        return (i - 1) / 2;
    }

    public void heapify_percolateDown(int[] arr, int i, int n) {
        int max = i;
        int left = leftChildren(i);
        int right = rightChildren(i);

        if (left < n && arr[left] > arr[i]) {
            max = left;
        }
//        } else {
//            max = i;
//        }

        if (right < n && arr[right] > arr[max]) {
            max = right;
        }

        if (max != i) {
            // swap
            swap(arr, max, i);
            heapify_percolateDown(arr, max, n);
        }
    }

    public void sort(int[] arr) {
        int n = arr.length;

        // Building heap
        for (int i = (n - 1) / 2; i >= 0; i--) {
            heapify_percolateDown(arr, i, n);
        }

        // Now swap the elements from the array and heapify again
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify_percolateDown(arr, 0, i);
        }
    }

    public static void main(String[] args) {
//        int[] arr = {10, 11, 34, 9, 5, 13};

        int[] arr = {5, 10, 3, 2, 4, 7};

        HeapSort heapSort = new HeapSort();
        heapSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

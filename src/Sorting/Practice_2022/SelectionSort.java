package Sorting.Practice_2022;

import java.util.Arrays;

// Means select minimum and put in the start of the array in the every first loop
public class SelectionSort extends BaseClass {

    /*
    TC: O(N^2)
    SC: O(1)
     */
    private void selectionSort(int[] arr) {
        int n = arr.length;

        for (int firstPtr = 0; firstPtr < n; firstPtr++) {
            int minIndex = firstPtr;
            for (int secondPtr = firstPtr + 1; secondPtr < n; secondPtr++) {
                if (arr[minIndex] > arr[secondPtr]) {
                    minIndex = secondPtr;
                }
            }
            swap(arr, minIndex, firstPtr);
        }
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        int[] inputArr = {1, 3, 6, 2, 9, 5, 6};
        selectionSort.selectionSort(inputArr);
        System.out.println(Arrays.toString(inputArr));
    }

}

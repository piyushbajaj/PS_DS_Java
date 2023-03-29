package Sorting.Practice_2022;

import java.util.Arrays;

public class InsertionSort extends BaseClass {

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int[] inputArr = {1, 3, 6, 2, 9, 5, 6};
        insertionSort.insertionSort(inputArr);
        System.out.println(Arrays.toString(inputArr));
    }

    /**
     * It keeps sorting the arrays, by swapping
     * TC: O(N^2)
     *
     * @param arr
     */
    public void insertionSort(int[] arr) {
        int n = arr.length;

        for (int firstPtr = 1; firstPtr < n; firstPtr++) {
            int temp = arr[firstPtr];
            int secondPtr = firstPtr;

            while (secondPtr >= 1 && arr[secondPtr - 1] > temp) {
                arr[secondPtr] = arr[secondPtr - 1];
                secondPtr--;
            }
            arr[secondPtr] = temp;
        }
    }
}

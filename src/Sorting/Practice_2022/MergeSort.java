package Sorting.Practice_2022;

import java.util.Arrays;

public class MergeSort extends BaseClass {

    /**
     * TC: O(N*logN)
     *
     * @param arr
     * @param start
     * @param end
     */
    public void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            mergeSort_util(arr, start, mid, end);
        }
    }

    private void mergeSort_util(int[] arr, int start, int mid, int end) {
        int firstArrLen = mid - start + 1;
        int secondArrLen = end - mid;

        int[] firstArr = new int[firstArrLen];
        int[] secondArr = new int[secondArrLen];

        for (int i = 0; i < firstArrLen; i++) {
            firstArr[i] = arr[start + i];
        }

        for (int i = 0; i < secondArrLen; i++) {
            secondArr[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0, k = start;

        while (i < firstArrLen && j < secondArrLen) {
            if (firstArr[i] < secondArr[j]) {
                arr[k] = firstArr[i];
                i++;
                k++;
            } else {
                arr[k] = secondArr[j];
                j++;
                k++;
            }
        }

        while (i < firstArrLen) {
            arr[k] = firstArr[i];
            k++;
            i++;
        }

        while (j < secondArrLen) {
            arr[k] = secondArr[j];
            k++;
            j++;
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] arr = {6, 4, 2, 1, 3, 5};
        mergeSort.mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}

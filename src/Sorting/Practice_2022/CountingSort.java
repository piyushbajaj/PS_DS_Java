package Sorting.Practice_2022;

import java.util.Arrays;

/**
 * Created by bajajp on 18 May, 2022
 */
public class CountingSort extends BaseClass {

    /**
     *
     * @param arr
     */
    public void countingSort(int[] arr) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[256];

        for (int j : arr) {
            count[j]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int j : arr) {
            output[count[j] - 1] = j;
        }

        System.arraycopy(output, 0, arr, 0, n);
    }

    public static void main(String[] args) {
        int[] arr = {3, 10, 1, 5, 0, 20};
        CountingSort countingSort = new CountingSort();
        countingSort.countingSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

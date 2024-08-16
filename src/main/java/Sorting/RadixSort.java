package Sorting;

import java.util.Arrays;

/**
 * Created by piyush.bajaj on 15/01/17.
 */
public class RadixSort {
    public static void main(String[] args) {
        RadixSort RS = new RadixSort();
        int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
        int n = arr.length;
        System.out.println("Original Array: ");
        RS.printArray(arr);
        RS.radixSortAlgo(arr);
        System.out.println("After appliying Radix Sort: ");
        RS.printArray(arr);
    }

    public int getMax(int arr[], int n) {
        int mx = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > mx) {
                mx = arr[i];
            }
        }
        return mx;
    }

    public void radixSortAlgo(int[] arr) {
        // Find the maximum number to know number of digits
        int n = arr.length;
        int m = getMax(arr, n);

        // Do counting sort for every digit. Note that instead
        // of passing digit number, exp is passed. exp is 10^i
        // where i is current digit number
        for (int exp = 1; m / exp > 0; exp *= 10) {
            countSort(arr, n, exp);
        }
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    public void countSort(int arr[], int n, int exp) {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        for (i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    public void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

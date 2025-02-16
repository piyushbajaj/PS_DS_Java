package Session.May2024.StriversA2ZSheet.Step3_Arrays.Easy;

import java.util.Arrays;

/**
 * Project: DSAlgo
 * Package: StriversA2ZSheet.Step3_Arrays
 * <p>
 * User: piyushbajaj
 * Date: 23/05/24
 * Time: 7:13 pm
 * Link: <a href="https://takeuforward.org/data-structure/find-second-smallest-and-second-largest-element-in-an-array/">...</a>
 */
public class P2_SecondSmallestLargestElementInArray {

    /**
     * Brute-force approach
     * TC: O(N*LogN)
     * SC: O(1)
     *
     * @param arr
     * @param n
     */
    static private void getElements(int[] arr, int n) {
        int secondSmallest = -1, secondLargest = -1;
        if (n < 2) {
            System.out.println(secondSmallest);
            System.out.println(secondLargest);
            return;
        }

        Arrays.sort(arr);

        int i = 0;
        while (i < n - 1 && arr[i] == arr[i + 1]) {
            i++;
        }

        if (i != n - 1) {
            secondSmallest = arr[i + 1];
        }

        i = n - 1;
        while (i > 0 && arr[i] == arr[i - 1]) {
            i--;
        }

        if (i != 0) {
            secondLargest = arr[i - 1];
        }

        System.out.println(secondSmallest);
        System.out.println(secondLargest);
    }

    static private void getElements_best(int[] arr, int n) {
        int smallest = Integer.MAX_VALUE,
            secondSmallest = Integer.MAX_VALUE,
            largest = Integer.MIN_VALUE,
            secondLargest = Integer.MIN_VALUE;

        if (n < 2) {
            System.out.println(secondSmallest);
            System.out.println(secondLargest);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] < smallest) {
                secondSmallest = smallest;
                smallest = arr[i];
            } else if (arr[i] < secondSmallest && arr[i] != smallest) {
                secondSmallest = arr[i];
            }

            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
            }
        }

        System.out.println(secondSmallest);
        System.out.println(secondLargest);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, 7, 5};
//        int[] arr = {1, 1, 1, 1, 1};
        getElements(arr, arr.length);
        getElements_best(arr, arr.length);
    }
}

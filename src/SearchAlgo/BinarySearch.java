package SearchAlgo;

import java.util.Scanner;

/**
 * Created by piyush.bajaj on 10/09/16.
 */
public class BinarySearch {
    /*
    Given a sorted array arr[] of n elements, write a function to search a given element x in arr[].
    A simple approach is to do linear search, i.e., start from the leftmost element of arr[] and
    one by one compare x with each element of arr[], if x matches with an element, return the index.
    If x doesn’t match with any of elements, return -1.
     */

    public static void main(String[] args) {

        BinarySearch BS = new BinarySearch();

        System.out.println("Input the size of an array");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        System.out.println("Input an array one by one");
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        System.out.println("Input the number to be matched in an array: ");
        //int x = s.nextInt();

        //System.out.println("Index position where the given number is present is: " + search(a, n, x));

        //System.out.println("Index position where the given number is present is using Binary Search: " + binarySearch(a, 0, n, x));

        /*
        System.out.println("Sorting using Selection Sort is ");
        printArray(selectionSort(a));



        System.out.println("Sorting using Bubble Sort is ");
        printArray(bubbleSort(a));



        System.out.println("Sorting using Insertion Sort is ");
        printArray(insertionSort(a));

        */


        //printArray(insertionSort(a));


        System.out.println("Given Array");
        printArray(a);
        System.out.println("Sorting using Merge Sort is ");
        sort(a, 0, a.length - 1);
        printArray(a);

    }

    public static int search(int a[], int n, int x) {
        for (int i = 0; i < n; i++) {
            if (a[i] == x) {
                return i;
            }
        }
        return -1;
        /*
        Time complexity here is: O(n)
         */
    }

    public static int binarySearch(int a[], int left, int right, int x) {
        int mid = left + (right - 1) / 2;
        if (a[mid] == x) {
            return mid;
        } else if (x < a[mid]) {
            return binarySearch(a, left, mid - 1, x);
        } else {
            return binarySearch(a, mid + 1, right, x);
        }
    }

    /*
    Time complexity: T(n) = T(n\2) + c
    So to get to the n, we need to multiple 2^k times
    2^k = n
    k = log(n) is the time complexity
     */

    public static int[] selectionSort(int a[]) {
        int n = a.length;
        int temp;
        //int[] sort = new int[n];
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            temp = a[i];
            a[i] = a[min];
            a[min] = temp;

        }
        return a;

        /*
        Time Complexity: O(n^2)
         */
    }

    public static int[] bubbleSort(int a[]) {
        int n = a.length;
        boolean swapped;
        for (int i = 0; i < n; i++) {
            swapped = false;
            for (int j = 0; j < n - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                    swapped = true;
                }
            }
            if (swapped == false) {
                break;
            }
        }
        return a;
        /*
        Time Complexity: T(n): O(n^2)
         */
    }


    public static int[] insertionSort(int b[]) {
        int n = b.length;
        int key;

        for (int i = 1; i < n; i++) {
            key = b[i];
            int j = i - 1;

            while (j >= 0 && b[j] > key) {
                b[j + 1] = b[j];
                j = j - 1;
            }
            b[j + 1] = key;
        }

        return b;

    }


    public static void merge(int a[], int l, int m, int r) {

        // Find sizes of two subarrays to be merged

        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */

        int[] L = new int[n1];
        int[] R = new int[n2];

        /*Copy data to temp arrays*/

        for (int i = 0; i < n1; i++) {
            L[i] = a[l + i];
        }

        for (int j = 0; j < n2; j++) {
            R[j] = a[m + 1 + j];
        }

        /* Merge the temp arrays */

        int i = 0;
        int j = 0;
        int k = l;

        // Initial indexes of first and second subarrays

        // Initial index of merged subarry array
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                a[k] = L[i];
                i++;
            } else {
                a[k] = R[j];
                j++;
            }
            k++;
        }

        //copy rest indexes

        while (i < n1) {
            a[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            a[k] = R[j];
            j++;
            k++;
        }
    }

    //this is a function which breaks arrays into individual numbers
    public static void sort(int a[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            sort(a, l, m);

            sort(a, m + 1, r);

            // Merge the sorted halves
            merge(a, l, m, r);
        }

    }

    public static void printArray(int a[]) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }
}

package Sorting;

import java.util.Arrays;

/**
 * Created by piyush.bajaj on 02/10/16.
 * <p>
 * Few descriptions about Selection Sort are:
 * 1. It is in-place algorithm.
 * 2. It is not stable algorithm, and its stability depends upon implementation
 * 3. It works well for the small files.
 * 4. It is used for sorting the files with very large values and small keys.
 * 5. Find the minimum value in the array and replace with current value.
 * <p>
 * Complexities:
 * Worst Case Time: O(n*n)
 * Average Case Time: O(n*n)
 * Best Case Time: O(n)
 * <p>
 * Space Complexities: O(1)
 * <p>
 * Algorithm:
 * 1. First loop starts with i = 0 to n-1, and assigning min = i.
 * 2. Second loop starts with j = 0 to n-1, and comparing a[j] with a[min] and so replacing min with that index, and
 * finally swapping min index with i index.
 * 3. And proceeding further i+1 everytime. Like this we will get increasing sorted order.
 * 4. We can improve the time complexity here by keeping flag = true, inside the first loop. While inside second loop making
 * it false, when the second loop completes will check this FLAG
 */
public class SelectionSort {
    public static void main(String[] args) {
//        int[] a = {5, 4, 1, 2, 10, 3, 2};
        int[] ab = {1, 3, 6, 2, 9, 5, 6};
        //SelectionSortAlgo(a);
        //SelectionSortAlgo_Improved(a);

        SelectionSortAlgo_Improved(ab);
        System.out.print(Arrays.toString(ab));

    }

    //Practice
    public static void selectSort_prac(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }


    public static int[] SelectionSortAlgo(int a[]) {
        int i, j, min, temp;
        for (i = 0; i < a.length; i++) {
            min = i;
            for (j = i + 1; j < a.length; j++) {
                if (a[j] < a[min])
                    min = j;
            }
            //swap min element
            temp = a[min];
            a[min] = a[i];
            a[i] = temp;
        }
        return a;
    }

    public static int[] SelectionSortAlgo_Improved(int a[]) {
        int i, j, min, temp;
        boolean isSorted;
        for (i = 0; i < a.length; i++) {
            min = i;
            isSorted = true;
            for (j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                    isSorted = false;
                }
            }
            //swap min element
            if (isSorted) return a;
            temp = a[min];
            a[min] = a[i];
            a[i] = temp;

        }
        return a;
    }


}

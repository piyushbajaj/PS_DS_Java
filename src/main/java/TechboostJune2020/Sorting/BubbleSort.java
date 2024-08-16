package TechboostJune2020.Sorting;

/**
 * Created by piyush.bajaj on 01/10/16.
 * <p>
 * Few Descriptions about Bubble Sort:
 * 1. It is the simplest Algorithm.
 * 2. This starts collecting maximum element in the right hand side.
 * 3. It is Stable Algorithm.
 * 4. Insertion sort is improved version of Bubble Sort.
 * <p>
 * Complexities:
 * Worst Time Complexity: O(n*n)
 * Average Time Complexity: O(n*n)
 * Best Time Complexity: O(n) // Improved version: BubbleSortAlgo_Improved
 * Space Complexity: O(1)
 * <p>
 * Algorithm:
 * 1. First loop starts with n-1, while second loop starts with 0
 * 2. Inside second loop every alternative elements needs to compare, so that the largest element will reach to the end every
 * time, the loop ends.
 * 3. After that it will take n-1, n-2...and so on till its sorted in increasing order.
 * 4. The time can be improved here, by keeping flag by default as TRUE, and when the swapping happens make it TRUE, but
 * after first loop it will be FALSE.
 */

public class BubbleSort {
    public static void main(String[] args) {
        int a[] = {5, 4, 1, 2, 10, 3, 2};
        //BubbleSortAlgo(a);
        //BubbleSortAlgo_Improved(a);
        bubbleSort_prac(a);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }


    //Practice


    public static void bubbleSort_prac(int[] arr) {
        int n = arr.length - 1;
        int temp = 0;
        boolean flag = true;
        for (int i = n; i >= 0 && flag; i--) {
            flag = false;
            for (int j = 0; j <= i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    flag = true;
                }
            }
        }

    }


    public static int[] BubbleSortAlgo(int a[]) {
        for (int i = a.length - 1; i >= 0; i--) {
            for (int j = 0; j <= i - 1; j++) {
                //Here i-1 is kept to make sure that every time the greatest element is reaching at the end of an array
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        return a;
    }

    public static int[] BubbleSortAlgo_Improved(int a[]) {
        //int swapped = 1;
        boolean is_sorted = true;
        for (int i = a.length - 1; i >= 0 && is_sorted; i--) {
            is_sorted = false;
            for (int j = 0; j <= i - 1; j++) {
                //Here i-1 is kept to make sure that every time the greatest element is reaching at the end of an array
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    is_sorted = true;
                }
            }
            if (is_sorted) {
                return a;
            }
        }
        return a;
    }
}

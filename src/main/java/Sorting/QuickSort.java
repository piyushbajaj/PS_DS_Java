package Sorting;

/**
 * Created by piyush.bajaj on 15/01/17.
 * <p>
 * Few descriptions on Quick-Sort:
 * <p>
 * 1. Quick Sort is an example of divide and conquer algorithm technique.
 * 2. It is called partition exchanged sort.
 * 3. It uses recursive calls for sorting the elements.
 * 4. It is one of the famous algorithm among comparison based sorting algorithm.
 * 5. Divide: The array A[low..high] is partitioned into two non-empty sub arrays A[low..q] & A[q+1..high],
 * such that each element of A[low..q] is less than or equal to A[q+1..high]
 * 6. Conquer: The two sub arrays A[low..q] and A[q+1..high] are sorted by recursive calls to Quick Sort.
 * 7. Quick Sort is an in-place sort, i.e, it doesn't require any extra storage.
 * 8. Quick sort is also a cache friendly sorting algorithm.
 * 9. It has good locality of reference when used for Arrays.
 * 10. Quick sort is also tail recursive, therefore tail call optimization can be done.
 * 11. Not all QuickSort implementations are stable. It depends on how you implement the partitioning.
 * <p>
 * Complexities:
 * Worst Case Time Complexity: O(n*n)
 * Average Case Time Complexity: O(nlog(n))
 * Best Case Time Complexity: O(nlog(n))
 * Worst Space Complexity: O(log(n))
 * <p>
 * Algorithm:
 * 1. First we make a partition(arr, l, h) function which will return the actual pivot mid-point index.
 * 2. In this partition function, we are doing following activities:
 * a. pivot = a[h] //consider extreme right value as the pivot value
 * b. initialize i = l-1
 * c. loop for j = l to h-1
 * 1. if(a[j] < pivot)
 * i++
 * swap(i, j);
 * d. i++, swap(i, h);
 * e. return i;
 * 3. Second we make a quickSort(arr, l, r) recursive function, which will check low < high every time.
 * a. pivot = partition(arr, l, h)
 * b. recursively call quicksort(arr, l, pivot-1)
 * c. recursively call quicksort(arr, pivot+1, h)
 */
public class QuickSort {

    static void arrayMethod(int[] a) {
        int[] b = new int[5];
        a = b;
    }

    ///This is done considering that last element is the pivot

    // All elements lesser than Pivot are moving in left and greater than Pivot are moving right
    // O(N) time for first time

    public static void main(String[] args) {
        QuickSort QS = new QuickSort();
        //int[] arr = {10, 80, 30, 90, 40, 50, 70};
//        int[] arr = {4, 5, 3, 2, 1, 7, 6};
        int[] arr = {12, 3, 5, 7, 4, 19, 26};
        int low = 0;
        int high = arr.length - 1;
        System.out.println("Original Array: ");
        QS.printArray(arr);
        System.out.println("After applying Quick Sort in an Array: ");
        QS.quickSort(arr, low, high);
        QS.printArray(arr);

        int[] arr1 = new int[10];
        arrayMethod(arr1);
        System.out.println(arr1.length);


//        System.out.println(i[0]);

        // QS.quickSort_prac(arr, low, high);
        //QS.printArray(arr);
    }

    public int[] quickSort(int[] arr, int low, int high) {

        if (low < high) {
            //pivot_index is the partitioning index
            int pivot_index = partition(arr, low, high);

            quickSort(arr, low, pivot_index - 1);
            quickSort(arr, pivot_index + 1, high);

        }
        return arr;
    }

    public int partition(int[] arr, int low, int high) {
        int pivot = arr[high];

        int i = low - 1;

        for (int j = low; j <= high - 1; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(i, j, arr);
            }
        }
        //Final Swap
        swap(i + 1, high, arr);
        return (i + 1);
    }

    public void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    //practice

    public void quickSort_prac(int[] arr, int l, int h) {
        if (l < h) {
            int pivot = partition_prac(arr, l, h);
            quickSort_prac(arr, l, pivot - 1);
            quickSort_prac(arr, pivot + 1, h);
        }
    }

    public int partition_prac(int[] arr, int l, int h) {
        int pivot = arr[h];

        int i = l - 1;
        for (int j = l; j <= h - 1; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(i, j, arr);
            }
        }

        i++;
        swap(i, h, arr);
        return i - 1;
    }
}

package Sorting;

/**
 * Created by piyush.bajaj on 15/01/17.
 */
public class BucketSort {
    public static void main(String[] args) {
        BucketSort QS = new BucketSort();
        int[] arr = {1, 4, 1, 2, 7, 5, 2};
        double[] dbl_arr = {0.897, 0.565, 0.656, 0.1234, 0.665, 0.3434};
        System.out.println("Original Array: ");
        QS.printArray(arr);
        System.out.println("After applying Counting Sort in an Array: ");
        QS.BucketSortAlgo(arr);
        QS.printArray(arr);
    }

    public void BucketSortAlgo(int[] arr) {
        int bucket_size = 10;
        int[] buckets = new int[bucket_size];
        for (int j = 0; j < bucket_size; j++) {
            buckets[j] = 0;
        }

        for (int value : arr) {
            ++buckets[value];
        }

        int i, j;

        for (i = 0, j = 0; j < bucket_size; j++) {
            for (int k = buckets[j]; k > 0; k--) {
                arr[i++] = j;
            }
        }
    }

    //In case of float numbers
    public void BucketSort_float(double[] fltArr) {
        int n = fltArr.length;

        double[] bucket = new double[n];

        for (int i = 0; i < n; i++) {
            int bi = n * ((int) fltArr[i]);

        }
    }

    public void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

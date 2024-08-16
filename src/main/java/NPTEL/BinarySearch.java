package NPTEL;

/**
 * Created by piyush.bajaj on 15/11/16.
 */
public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch BS = new BinarySearch();
        int arr[] = {2, 4, 5, 7, 8, 9, 12, 14, 17, 19, 22, 23, 27, 28, 33, 37};
        int u_arr[] = {1, 2, 3, 5, 4, 10, 6, 3};
        int k;
        int low = 0;
        int high = arr.length;
        System.out.println("The node at which the key present is: " + BS.BinarySearchRecursive(arr, 2, low, high));
        //BS.BinarySearchRecursive(arr, 5, low, high);
        System.out.println("The node at which the key present is using iterative approach: " +
            BS.BinarySearchIterative(arr, 10, low, high));
        System.out.println("The node at which the key present is using unsorted array approach: " +
            BS.BinarySearchUsingUnsortedArray(arr, 4, low, high));

        //time complexity: O(n)

    }

    public int BinarySearchRecursive(int[] A, int k, int low, int high) {
        int mid;
        if (low > high) {
            return -1;
        } else {
            mid = (low + high) / 2;
        }

        if (k == A[mid]) {
            return mid;
        } else if (k < A[mid]) {
            return BinarySearchRecursive(A, k, low, mid - 1);
        } else {
            return BinarySearchRecursive(A, k, mid + 1, high);
        }
    }

    public int BinarySearchIterative(int[] A, int k, int low, int high) {
        int mid;
        do {
            mid = (low + high) / 2;
            if (A[mid] == k) {
                return mid;
            } else if (A[mid] > k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        } while (low <= high);
        return -1;
    }

    //Running time is log2n comparisons

    public int BinarySearchUsingUnsortedArray(int[] A, int k, int low, int high) {

        while (low <= high - 1 && A[low] != k) {
            low++;
        }
        if (low <= high - 1) {
            return low;
        } else {
            return -1;
        }

    }
}

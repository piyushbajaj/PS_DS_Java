package Array.BinarySearchQuestions;

/**
 * Created by piyush.bajaj on 28/05/17.
 * Given a sorted array of distinct elements,
 * and the array is rotated at an unknown position.
 * Find minimum element in the array.
 */
public class RotatedArray {
    BinarySearch BS = new BinarySearch();

    public static void main(String[] args) {
        RotatedArray RA = new RotatedArray();
        int[] arr = {7, 1, 2, 3, 4};
        System.out.println(RA.getMin(arr, 0, arr.length - 1));
        System.out.println(RA.findKey(arr, 0, arr.length - 1, 7));
    }

    public int getMin(int[] arr, int l, int r) {
        while (r >= l) {
            if (r == l) {
                return l;
            }
            int m = (l + r) / 2;
            if (arr[m] > arr[r]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return -1;
    }

    public int findKey(int[] arr, int l, int r, int key) {
        int pivot = getPivot(arr, l, r);


        while (l <= r) {
            if (arr[pivot] == key) {
                return pivot;
            }
            if (key < arr[0]) {
                return BS.BinarySearch_Recursive(arr, key, pivot + 1, r);
            } else {
                return BS.BinarySearch_Recursive(arr, key, 0, pivot - 1);
            }
        }
        return -1;
    }

    public int getPivot(int[] arr, int low, int high) {
        if (high < low) {
            return -1;
        }

        if (high == low) {
            return low;
        }

        int mid = (high + low) / 2;

        if (mid < high && arr[mid] > arr[mid + 1]) {
            return mid;
        }
        if (mid > low && arr[mid - 1] > arr[mid]) {
            return mid - 1;
        }
        if (arr[low] >= arr[mid]) {
            return getPivot(arr, low, mid - 1);
        } else {
            return getPivot(arr, mid + 1, high);
        }
    }
}

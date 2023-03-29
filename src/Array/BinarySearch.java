package Array;

/**
 * Created by piyush.bajaj on 02/12/16.
 */
public class BinarySearch {
    public static void binaryLook(int[] arr, int key) {
        int mid, first, last;
        first = 0;
        last = arr.length - 1;
        mid = (first + last) / 2;

        while (first <= last) {
            if (arr[mid] < key) {
                first = mid + 1;
            } else if (arr[mid] == key) {
                System.out.println(key + " found at location " + (mid + 1));
                return;
            } else {
                last = mid - 1;
            }
            mid = (first + last) / 2;
        }
    }

    public static void main(String[] args) {
        BinarySearch BS = new BinarySearch();
        int[] a = {2, 5, 6, 8, 9};
        int key = 8;
        binaryLook(a, key);

        //BS.findPos(a, key);

    }

    // function takes an infinite size array and a key to be
    //  searched and returns its position if found else -1.
    // We don't know size of arr[] and we can assume size to be
    // infinite in this function.
    // NOTE THAT THIS FUNCTION ASSUMES arr[] TO BE OF INFINITE SIZE
    // THEREFORE, THERE IS NO INDEX OUT OF BOUND CHECKING

    public void binaryLook(int[] arr, int first, int last, int key) {
        int mid;
        //first = 0;
        //last = arr.length-1;
        mid = (first + last) / 2;

        while (first <= last) {
            if (arr[mid] < key) {
                first = mid + 1;
            } else if (arr[mid] == key) {
                System.out.println(key + " found at location " + (mid + 1));
                return;
            } else {
                last = mid - 1;
            }
            mid = (first + last) / 2;
        }
    }

    public void findPos(int[] arr, int key) {
        int l = 0;
        int h = 1;
        int val = arr[0];

        while (val < key) {
            l = h;
            h = 2 * h;
            val = arr[h];
        }
        binaryLook(arr, l, h - 1, key);
        return;
    }
}

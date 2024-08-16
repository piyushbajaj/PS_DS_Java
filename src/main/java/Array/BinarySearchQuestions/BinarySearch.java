package Array.BinarySearchQuestions;

/**
 * Created by piyush.bajaj on 03/04/17.
 */
public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch BS = new BinarySearch();
        int[] arr = {1, 5, 6, 7, 9, 19, 20, 27, 56};
        System.out.println("Binary Search using iterative approach: ");
        System.out.println(BS.getBSIterativeIndex(arr, 1));

        System.out.println("Binary Search using recursive approach: ");
        System.out.println(BS.BinarySearch_Recursive(arr, 7, 0, arr.length));
    }

    public int getBSIterativeIndex(int[] arr, int data) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == data) {
                return mid;
            } else if (arr[mid] < data) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public int BinarySearch_Recursive(int[] arr, int data, int low, int high) {
        int mid = low + (high - low) / 2;

        if (low > high) {
            return -1;
        }

        if (arr[mid] == data) {
            return mid;
        } else if (arr[mid] < data) {
            return BinarySearch_Recursive(arr, data, mid + 1, high);
        } else {
            return BinarySearch_Recursive(arr, data, low, mid - 1);
        }

    }
}

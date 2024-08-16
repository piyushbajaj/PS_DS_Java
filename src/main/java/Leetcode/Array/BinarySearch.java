package Leetcode.Array;

public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] arr = {1, 2, 4, 6, 8, 9, 12, 15};
        System.out.println(binarySearch.BS_iterative(arr, 9));
        System.out.println(binarySearch.BS_recursive(arr, 9));
    }

    // T.C: O(logN)
    // S.C: O(logN)
    public int BS_iterative(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] == key) {
                return arr[mid];
            } else if (arr[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    public int BS_recursive(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;

        return BS_util(arr, start, end, key);
    }

    public int BS_util(int[] arr, int start, int end, int key) {
        if (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] == key) {
                return arr[mid];
            } else if (arr[mid] > key) {
                return BS_util(arr, start, mid - 1, key);
            } else {
                return BS_util(arr, mid + 1, end, key);
            }
        }
        return -1;
    }
}

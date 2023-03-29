package Array.Prelim;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        System.out.println(binarySearch_Recursive(arr, 7, 0, arr.length - 1));
//        System.out.println(binarySearch_Iterative(arr, 7));
        System.out.println(ceil_iterative(arr, 1));
    }

    public static int binarySearch_Recursive(int[] arr, int searchData, int start, int end) {
        if (start <= end) {
            int mid = (start + end) / 2;

            if (searchData == arr[mid]) {
                return mid;
            } else if (searchData > arr[mid]) {
                return binarySearch_Recursive(arr, searchData, mid + 1, end);
            } else {
                return binarySearch_Recursive(arr, searchData, start, mid - 1);
            }
        }
        return -1;

    }

    public static int binarySearch_Iterative(int[] arr, int searchData) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (searchData == arr[mid]) {
                return mid;
            } else if (searchData > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    // Returning the next bigger element than searchData
    public static int ceil_iterative(int[] arr, int searchData) {
        int start = 0;
        int end = arr.length - 1;

        while (end - start > 1) {
            int mid = (start + end) / 2;
            if (arr[mid] > searchData) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (start == 0) {
            return arr[start];
        }
//        if (end == arr.length - 1) {
//            return arr[end];
//        } else {
//            return arr[end + 1];
//        }

        return arr[end];


    }
}

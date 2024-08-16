package PracticeSessionMay2024.StriversA2ZSheet.Step4_BinarySearch.Easy;

import java.util.Arrays;

/**
 * Project: DSAlgo
 * Package: PracticeSessionMay2024.StriversA2ZSheet.Step4_BinarySearch.Easy
 * <p>
 * User: piyushbajaj
 * Date: 19/07/24
 * Time: 7:33 pm
 */
public class P2_FloorCeil {

    /**
     * TC: O(LogN)
     *
     * @param arr
     * @param n
     * @param x
     * @return
     */
    public static int findFloor(long[] arr, int n, long x) {
        int low = 0, high = n - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            // low bound can be this or on the left side
            if (arr[mid] > x) {
                high = mid - 1;
            } else {
                ans = mid;
                low = mid + 1;
            }
        }

        return ans;
    }

    public static int findCeil(long[] arr, int n, long x) {
        int low = 0, high = n - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            // low bound can be this or on the left side
            if (arr[mid] > x) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public static int[] findFloorCeil(long[] arr, int n, long x) {
        int low = 0, high = n - 1;
        int floor = -1, ceil = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            // low bound can be this or on the left side
            if (arr[mid] > x) {
                ceil = mid;
                high = mid - 1;
            } else if (arr[mid] < x) {
                floor = mid;
                low = mid + 1;
            } else if (arr[mid] == x) {
                ceil = mid;
                floor = mid;
                return new int[] {floor, ceil};
            }
        }

        return new int[] {floor, ceil};
    }

    public static void main(String[] args) {
        long[] arr = {1, 2, 8, 10, 11, 12, 19};
        System.out.println(findFloor(arr, arr.length, 3));
        System.out.println(findCeil(arr, arr.length, 3));
        System.out.println(Arrays.toString(findFloorCeil(arr, arr.length, 8)));
    }
}

package TakeUForward.S16_DP.S16_7_DP_LIS;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S16_DP.S16_7_DP_LIS
 * <p>
 * User: piyushbajaj
 * Date: 23/12/22
 * Time: 1:39 pm
 */
public class P3_LIS_Using_Binary_Search {

    /**
     * Following the approach for Binary Search
     * TC: O(N* logN)
     * SC: O(N)
     *
     * @param size
     * @param a
     * @return
     */
    public int longestSubsequence(int size, int a[]) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(a[0]);
        int len = 1;

        for (int i = 1; i < size; i++) {
            // If element is greater than the current element, add to the array list
            if (a[i] > result.get(result.size() - 1)) {
                result.add(a[i]);
                len++;
            } else {
                // If element is less than or equal to the current element, then replace with next greater element
                int index = binarySearch_Ceil(result, a[i]);
                result.set(index, a[i]);
            }
        }

        return len;
    }

    public int binarySearch_Ceil(List<Integer> arr, int key) {
        int low = 0;
        int high = arr.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr.get(mid) == key) {
                return mid;
            } else if (arr.get(mid) < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return high + 1;
    }

    public static void main(String[] args) {
        P3_LIS_Using_Binary_Search p3_lis_using_binary_search = new P3_LIS_Using_Binary_Search();
        System.out.println(
            p3_lis_using_binary_search.longestSubsequence(16,
                new int[] {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15}));
    }
}

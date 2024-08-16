package Array.Practice_2022.BinarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bajajp on 04 Sep, 2022
 */
public class ThreeSortedArrays {
    public static void main(String[] args) {
        ThreeSortedArrays sortedArrays = new ThreeSortedArrays();
        System.out.println(sortedArrays.arraysIntersection(
            new int[] {1, 2, 3, 4, 5},
            new int[] {1, 2, 5, 7, 9},
            new int[] {1, 3, 4, 5, 8}));

        System.out.println(sortedArrays.arraysIntersectionBetter(
            new int[] {1, 2, 3, 4, 5},
            new int[] {1, 2, 5, 7, 9},
            new int[] {1, 3, 4, 5, 8}));
    }

    /**
     * Bruteforce using HashMap
     * TC: O(N)
     * SC: O(N)
     *
     * @param arr1
     * @param arr2
     * @param arr3
     * @return
     */
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> mapResult = new HashMap<>();

        for (int val : arr1) {
            mapResult.put(val, mapResult.getOrDefault(val, 0) + 1);
        }

        for (int val : arr2) {
            mapResult.put(val, mapResult.getOrDefault(val, 0) + 1);
        }

        for (int val : arr3) {
            mapResult.put(val, mapResult.getOrDefault(val, 0) + 1);
        }

        for (int item : mapResult.keySet()) {
            if (mapResult.get(item) == 3) {
                result.add(item);
            }
        }

        return result;
    }

    /**
     * Optimizing Space here
     * We can use p1, p2, p3 to use the information stored in such a way that by comparison we will increment result
     *
     * @param arr1
     * @param arr2
     * @param arr3
     * @return
     */
    public List<Integer> arraysIntersectionBetter(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> result = new ArrayList<>();

        int p = 0, q = 0, r = 0;

        while (p < arr1.length && q < arr2.length && r < arr3.length) {
            if ((arr1[p] == arr2[q]) && (arr2[q] == arr3[r])) {
                result.add(arr1[p]);
                p++;
                q++;
                r++;
            } else {
                if (arr1[p] < arr2[q]) {
                    p++;
                } else if (arr2[q] < arr3[r]) {
                    q++;
                } else {
                    r++;
                }
            }
        }

        return result;
    }
}

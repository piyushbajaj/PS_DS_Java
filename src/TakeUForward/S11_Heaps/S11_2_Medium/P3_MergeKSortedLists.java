package TakeUForward.S11_Heaps.S11_2_Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by bajajp on 27 Sep, 2022
 */
public class P3_MergeKSortedLists {

    static class Pair {
        public int first, second, third;

        Pair(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }


    // Implements Comparator interface for min-heap, for sorted
    static class PqComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair pair1, Pair pair2) {
            if (pair1.first < pair2.first) {
                return -1;
            }
            if (pair1.first == pair2.first) {
                return 0;
            }
            return 1;
        }
    }

    /**
     * Brute-force approach
     * TC: O(N * K * log (N*K)), Since the resulting array is of size N*K.
     * SC: O(N * K), The output array is of size N * K.
     *
     * @param arr
     * @param K
     * @return
     */
    public ArrayList<Integer> mergeKArrays(int[][] arr, int K) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int rows = arr.length;
        int cols = arr[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.add(arr[i][j]);
            }
        }

        Collections.sort(result);

        return result;
    }


    /**
     * Approach which involves min heap:
     * 1. Create a class Pair with first, second, third integers
     * 2. Create a comparator class, which would compare first integer in pairs
     * 3. Use this comparator as an argument to min heap
     *
     * @param arr
     * @param K
     * @return
     */
    public ArrayList<Integer> mergeKArrays1(int[][] arr, int K) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int rows = arr.length;
        int cols = arr[0].length;

        // Create a min heap to store atmost k heap nodes at a time.
        PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>(new PqComparator());

        for (int i = 0; i < rows; i++) {
            minHeap.add(new Pair(arr[i][0], i, 0));
        }


        while (!minHeap.isEmpty()) {

            // Remove the minimum element from the heap.
            Pair curr = minHeap.remove();

            // i is the array number and j is the index of the removed element in the ith array.
            int i = curr.second;
            int j = curr.third;

            // Add the removed element to the output array.
            result.add(curr.first);

            // If the next element of the extracted element exists, add it to the heap.
            if (j + 1 < arr[i].length) {
                minHeap.add(new Pair(arr[i][j + 1], i, j + 1));
            }
        }

        // Return the output array.
        return result;
    }

    public static void main(String[] args) {
        P3_MergeKSortedLists p3_mergeKSortedLists = new P3_MergeKSortedLists();
        int K = 4;
        int[][] arr = {
            {1, 2, 3, 4},
            {2, 2, 3, 4},
            {5, 5, 6, 6},
            {7, 8, 9, 9}};

        System.out.println(p3_mergeKSortedLists.mergeKArrays(arr, K));

        System.out.println(Arrays.deepToString(arr));

        System.out.println(p3_mergeKSortedLists.mergeKArrays1(arr, K));
    }
}

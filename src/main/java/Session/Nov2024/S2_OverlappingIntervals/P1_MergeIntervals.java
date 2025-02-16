package Session.Nov2024.S2_OverlappingIntervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Project: DSAlgo
 * Package: Session.Nov2024.S2_OverlappingIntervals
 * <p>
 * User: piyushbajaj
 * Date: 14/01/25
 * Time: 10:17 am
 * Question: <a href="https://leetcode.com/problems/merge-intervals/description/">...</a>
 */
public class P1_MergeIntervals {

    /**
     * TC: O(NlogN)
     * SC: O(NlogN)
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        // Sort the intervals by start time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        LinkedList<int[]> linkedList = new LinkedList<>();

        for (int[] interval : intervals) {
            if (linkedList.isEmpty() || linkedList.getLast()[1] < interval[0]) {
                linkedList.add(interval);
            } else {
                // Overlap
                linkedList.getLast()[1] = Math.max(interval[1], linkedList.getLast()[1]);
            }
        }

        return linkedList.toArray(new int[linkedList.size()][2]);
    }

    public static void main(String[] args) {
        P1_MergeIntervals p1MergeIntervals = new P1_MergeIntervals();
        int[][] intervals = new int[][] {{1, 9}, {2, 5}, {19, 20}, {10, 11}, {12, 20}, {0, 3}, {0, 1}, {0, 2}};
        System.out.println(Arrays.deepToString(p1MergeIntervals.merge(intervals)));
    }
}

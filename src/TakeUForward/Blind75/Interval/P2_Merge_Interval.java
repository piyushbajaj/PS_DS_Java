package TakeUForward.Blind75.Interval;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Project: DS_Algo
 * Package: TakeUForward.Blind75.Interval
 * <p>
 * User: piyushbajaj
 * Date: 09/02/23
 * Time: 2:14 pm
 * <p>
 * lc: <a href="https://leetcode.com/problems/merge-intervals/">...</a>
 */
public class P2_Merge_Interval {

    /**
     * Approach:
     * 1. Sort the intervals based on the start time
     * 2. If the list is empty or current interval start time is greater than the previous end time, then just insert
     * into the list.
     * 3. Overlapping case, merge with the greatest interval end value
     * <p>
     * TC: O(n*logN)
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        // Sort the elements by interval start
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        LinkedList<int[]> list = new LinkedList<>();

        for (int[] interval : intervals) {
            if (list.isEmpty() || list.getLast()[1] < interval[0]) {
                list.add(interval);
            } else {
                // Overlap
                list.getLast()[1] = Math.max(list.getLast()[1], interval[1]);
            }
        }

        return list.toArray(new int[list.size()][2]);

    }

    public static void main(String[] args) {
        P2_Merge_Interval p2_merge_interval = new P2_Merge_Interval();
        System.out.println(
            Arrays.deepToString(p2_merge_interval.merge(new int[][] {{1, 3}, {2, 6}, {8, 10}, {15, 18}})));

        System.out.println(
            Arrays.deepToString(p2_merge_interval.merge(new int[][] {{1, 4}, {4, 5}})));
    }
}

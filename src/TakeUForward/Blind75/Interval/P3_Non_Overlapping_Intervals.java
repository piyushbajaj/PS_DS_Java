package TakeUForward.Blind75.Interval;

import java.util.Arrays;

/**
 * Project: DS_Algo
 * Package: TakeUForward.Blind75.Interval
 * <p>
 * User: piyushbajaj
 * Date: 21/02/23
 * Time: 1:16 pm
 * <p>
 * lc: <a href="https://leetcode.com/problems/non-overlapping-intervals/description/">...</a>
 */
public class P3_Non_Overlapping_Intervals {

    /**
     * Approach:
     * 1. Sort the intervals on the basis of interval end time
     * 2. If the current start time is greater than previous end time, then increment
     * TC: O(NlogN)
     * SC: O(N*N)
     *
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int count = 1;
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                count++;
            }
        }

        return intervals.length - count;
    }

    public static void main(String[] args) {
        P3_Non_Overlapping_Intervals p3_non_overlapping_intervals = new P3_Non_Overlapping_Intervals();
        System.out.println(p3_non_overlapping_intervals.eraseOverlapIntervals(new int[][] {{1, 2}, {2, 3}, {3, 4}, {1
            , 3}}));
    }
}

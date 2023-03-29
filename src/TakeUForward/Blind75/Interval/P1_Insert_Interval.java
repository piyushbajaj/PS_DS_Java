package TakeUForward.Blind75.Interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Project: DS_Algo
 * Package: TakeUForward.Blind75.Interval
 * <p>
 * User: piyushbajaj
 * Date: 08/02/23
 * Time: 12:43 pm
 * <p>
 * g4g: <a href="https://practice.geeksforgeeks.org/problems/insert-interval-1666733333/1">...</a>
 * lc: <a href="https://leetcode.com/problems/insert-interval/">...</a>
 */
public class P1_Insert_Interval {

    public static void main(String[] args) {
        int[][] interval = {{1, 3}, {6, 9}};
        P1_Insert_Interval p1_insert_interval = new P1_Insert_Interval();
        System.out.println(Arrays.deepToString(p1_insert_interval.insert(interval, new int[] {2, 5})));
    }

    /**
     * Approach:
     * 1. Add all the intervals if the end of interval is smaller than newInterval start
     * 2. For the overlapping intervals like if the start of interval is less than equal to newInterval end, then
     * keep updating the new interval with start and end.
     * 3. Once the condition fails, then add this new interval to the result.
     * 4. Add the leftOver intervals from i onwards.
     * TC: O(N)
     * SC: O(N)
     *
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;

        List<int[]> list = new ArrayList<>();

        int i = 0;
        while (i < n && intervals[i][1] < newInterval[0]) {
            list.add(intervals[i++]);
        }

        // overlapping intervals
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);

            i++;
        }

        list.add(newInterval);

        while (i < n) {
            list.add(intervals[i++]);
        }

        return list.toArray(new int[list.size()][2]);
    }
}

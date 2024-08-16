package TakeUForward.Blind75.Interval;

import java.util.Arrays;

/**
 * Project: DS_Algo
 * Package: TakeUForward.Blind75.Interval
 * <p>
 * User: piyushbajaj
 * Date: 21/02/23
 * Time: 9:13 pm
 * <p>
 * lc: <a href="https://leetcode.com/problems/meeting-rooms/">...</a>
 */
public class P5_Meeting_Rooms {

    public static void main(String[] args) {
        P5_Meeting_Rooms p5_meeting_rooms = new P5_Meeting_Rooms();
        System.out.println(p5_meeting_rooms.canAttendMeetings(new int[][] {{0, 30}, {5, 10}, {15, 20}}));
    }

    /**
     * Approach:
     * 1.
     * <p>
     * TC: O(NlogN)
     * SC: O(1)
     *
     * @param intervals
     * @return
     */
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
            } else {
                return false;
            }
        }
        return true;
    }
}

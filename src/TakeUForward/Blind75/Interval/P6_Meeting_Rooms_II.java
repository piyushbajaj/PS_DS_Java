package TakeUForward.Blind75.Interval;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Project: DS_Algo
 * Package: TakeUForward.Blind75.Interval
 * <p>
 * User: piyushbajaj
 * Date: 21/02/23
 * Time: 11:56 pm
 * <p>
 * TC: <a href="https://leetcode.com/problems/meeting-rooms-ii/">...</a>
 */
public class P6_Meeting_Rooms_II {

    /**
     * Approach:
     * 1. Sort the intervals based on the start time
     * 2. Maintain the end interval time in min PQ, so the one room which gets available early, will be in the top
     * always
     * 3. If the top element in the PQ is smaller, that means room is free now, and then once the meeting is booked,
     * then also add end interval time in the PQ
     * 4. If the top element is not smaller that means, we need one more room right now, and will insert it in the PQ.
     * 5. Number of values in PQ wil determine the number of rooms needed.
     * <p>
     * TC: O(NlogN): Sorting + [O(logN): Extracting min + O(logN): Adding to PQ] * O(N): For n operations => O(NlogN)
     * SC: O(N)
     *
     * @param intervals
     * @return
     */
    public static int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> a - b);

        int end = intervals[0][1];

        priorityQueue.add(end);

        for (int i = 1; i < n; i++) {
            // room is free, that means assign the one in pq
            if (!priorityQueue.isEmpty() && intervals[i][0] >= priorityQueue.peek()) {
                priorityQueue.poll();
            }

            // assigning meeting end time everytime ensures, we are tracking
            priorityQueue.add(intervals[i][1]);
        }

        return priorityQueue.size();
    }

    public static void main(String[] args) {
        System.out.println(minMeetingRooms(new int[][] {{2, 15}, {36, 45}, {9, 29}, {16, 23}, {4, 9}}));
    }
}

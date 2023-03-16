package TakeUForward.CompleteCourse_456.S12_Greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S12_Greedy
 * <p>
 * User: piyushbajaj
 * Date: 19/10/22
 * Time: 12:54 pm
 * <p>
 */
public class P6_N_Meetings {

    static class Meeting {
        int start, end, meetingNo;

        Meeting(int start, int end, int meetingNo) {
            this.start = start;
            this.end = end;
            this.meetingNo = meetingNo;
        }
    }

    // sort in increasing order
    static class meetingComparator implements Comparator<Meeting> {
        @Override
        public int compare(Meeting o1, Meeting o2) {
            if (o1.end < o2.end) {
                return -1;
            } else if (o1.end > o2.end) {
                return 1;
            }
            return 0;
        }
    }

    /**
     * TC: O(NlogN + N)
     * SC: O(N)
     *
     * @param start
     * @param end
     * @param n
     * @return
     */
    public int maxMeetings(int start[], int end[], int n) {
        Meeting[] meetings = new Meeting[n];

        for (int i = 0; i < n; i++) {
            meetings[i] = new Meeting(start[i], end[i], i + 1);
        }

        Arrays.sort(meetings, new meetingComparator());
        int limit = 0;
        int meetingCnt = 0;
        for (int i = 0; i < n; i++) {
            if (limit < meetings[i].start) {
                meetingCnt++;
                limit = meetings[i].end;
            }
        }

        return meetingCnt;
    }

    public static void main(String[] args) {
        P6_N_Meetings p6_n_meetings = new P6_N_Meetings();

//        System.out.println(p6_n_meetings.maxMeetings(new int[] {1, 3, 0, 5, 8, 5}, new int[] {2, 4, 5, 7, 9, 9}, 6));

        System.out.println(p6_n_meetings.maxMeetings(new int[] {10, 12, 20}, new int[] {20, 25, 30}, 3));
    }
}

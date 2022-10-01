package TakeUForward.S10_SlidingWindow.S10_SlidingWindow_Medium;

import java.util.HashMap;

/**
 * Created by bajajp on 26 Sep, 2022
 */
public class P5_BinarySubarrayWithSum {
    static int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int cnt = 0;

        HashMap<Integer, Integer> prevSum = new HashMap<>();
        prevSum.put(0, 1);

        int currsum = 0;
        for (int i = 0; i < n; i++) {
            currsum += nums[i];

            if (currsum == goal)
                cnt++;

            if (prevSum.containsKey(currsum - goal) && (currsum != goal))
                cnt += prevSum.get(currsum - goal);

            prevSum.put(currsum, prevSum.getOrDefault(currsum, 0) + 1);
        }
        return cnt;
    }

    /**
     * TC: O(N)
     * SC: O(1)
     * With the help of sliding window technique
     * Neeeded to find out exact number of subarrays matching the Goal S,
     * Exact Number of SubArrays = Atmost number of subarrays matching the Goal S - Atmost number of subarrays
     * matching the Goal S-1
     *
     * @param A
     * @param S
     * @return
     */
    public static int numSubarraysWithSum1(int[] A, int S) {
        return atMost(A, S) - atMost(A, S - 1);
    }

    public static int atMost(int[] A, int S) {
        int res = 0;
        int l = 0, r = 0, n = A.length;

        if (S < 0) return 0;

        while (r < n) {
            S -= A[r];

            while (S < 0) {
                S += A[l];
                l++;
            }
            r++;
            res += r - l;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2));
        System.out.println(numSubarraysWithSum(new int[]{0, 0, 0, 0, 0}, 0));
        System.out.println(numSubarraysWithSum1(new int[]{1, 0, 1, 0, 1}, 2));
        System.out.println(numSubarraysWithSum1(new int[]{0, 0, 0, 0, 0}, 0));
    }
}

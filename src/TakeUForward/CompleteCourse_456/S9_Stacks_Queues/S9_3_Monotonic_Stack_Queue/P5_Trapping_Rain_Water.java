package TakeUForward.CompleteCourse_456.S9_Stacks_Queues.S9_3_Monotonic_Stack_Queue;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S9_Stacks_Queues.S9_3_Monotonic_Stack_Queue
 * <p>
 * User: piyushbajaj
 * Date: 09/01/23
 * Time: 6:57 pm
 * <p>
 * lc: <a href="https://leetcode.com/problems/trapping-rain-water/description/">...</a>
 * g4g: <a href="https://practice.geeksforgeeks.org/problems/trapping-rain-water-1587115621/1">...</a>
 * youtube: <a href="https://www.youtube.com/watch?v=m18Hntz4go8&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=43&ab_channel=takeUforward">...</a>
 */
public class P5_Trapping_Rain_Water {

    /**
     * Approach 1:
     * 1. For each index get the left highest element, and the right highest element. Get the minimum of both and
     * subtract with the own element, to get the rain water trapped at this index
     * 2. Keep adding the trapped rain water
     * <p>
     * TC: O(3N)
     * SC: O(2N)
     *
     * @param arr
     * @param n
     * @return long
     */
    public long trappingWater(int[] arr, int n) {
        long trappingRainWater = 0;
        int[] prefixArray = prefixSum(arr, n);
        int[] suffixArray = suffixSum(arr, n);

        for (int i = 0; i < n; i++) {
            trappingRainWater += Math.min(prefixArray[i], suffixArray[i]) - arr[i];
        }

        return trappingRainWater;
    }

    public int[] prefixSum(int[] arr, int n) {
        int[] result = new int[n];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            result[i] = Math.max(arr[i], max);
            max = result[i];
        }

        return result;
    }

    public int[] suffixSum(int[] arr, int n) {
        int[] result = new int[n];
        int max = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            result[i] = Math.max(arr[i], max);
            max = result[i];
        }

        return result;
    }

    /**
     * Two pointer approach
     * TC: O(N)
     * SC: O(1)
     *
     * @param arr
     * @param n
     * @return
     */
    public long trappingWater_better(int[] arr, int n) {
        int l = 0;
        int r = n - 1;
        int leftMax = 0;
        int rightMax = 0;
        long result = 0;

        while (l <= r) {

            if (arr[l] <= arr[r]) {
                // This means on right side there exist element greater than l
                if (arr[l] >= leftMax) {
                    leftMax = arr[l];
                } else {
                    result += leftMax - arr[l];
                }
                l++;
            } else {
                // This means on left side there exist element greater than r
                if (arr[r] >= rightMax) {
                    rightMax = arr[r];
                } else {
                    result += rightMax - arr[r];
                }
                r--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        P5_Trapping_Rain_Water p5_trapping_rain_water = new P5_Trapping_Rain_Water();
        System.out.println(p5_trapping_rain_water.trappingWater(new int[] {3, 0, 0, 2, 0, 4}, 6));
        System.out.println(p5_trapping_rain_water.trappingWater_better(new int[] {3, 0, 0, 2, 0, 4}, 6));
    }
}

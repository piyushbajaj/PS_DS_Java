package CompanyWise.MMT;

import java.util.Stack;

/**
 * Project: DS_Algo
 * Package: CompanyWise.MMT
 * <p>
 * User: piyushbajaj
 * Date: 01/03/23
 * Time: 1:03 am
 * <p>
 * lc: <a href="https://leetcode.com/problems/shortest-unsorted-continuous-subarray/">...</a>
 */
public class P3_Shortest_Unsorted {

    /**
     * TC: O(N)
     * SC: O(N)
     *
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();

        int l = n, r = 0;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                l = Math.min(l, stack.pop());
            }
            stack.push(i);
        }

        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                r = Math.max(r, stack.pop());
            }
            stack.push(i);
        }

        return r - l > 0 ? r - l + 1 : 0;
    }

    public static void main(String[] args) {
        P3_Shortest_Unsorted p3_shortest_unsorted = new P3_Shortest_Unsorted();
        p3_shortest_unsorted.findUnsortedSubarray(new int[] {2, 6, 4, 8, 10, 9, 15});
    }
}

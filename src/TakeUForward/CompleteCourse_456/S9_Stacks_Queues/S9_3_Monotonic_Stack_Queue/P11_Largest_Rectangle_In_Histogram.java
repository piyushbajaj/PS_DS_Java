package TakeUForward.CompleteCourse_456.S9_Stacks_Queues.S9_3_Monotonic_Stack_Queue;

import java.util.Stack;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S9_Stacks_Queues.S9_3_Monotonic_Stack_Queue
 * <p>
 * User: piyushbajaj
 * Date: 08/01/23
 * Time: 12:29 pm
 * <p>
 * lc: <a href="https://leetcode.com/problems/largest-rectangle-in-histogram/description/">...</a>
 * g4g: <a href="https://practice.geeksforgeeks.org/problems/maximum-rectangular-area-in-a-histogram-1587115620/1">...</a>
 * helpful video: <a href="https://www.youtube.com/watch?v=X0X6G-eWgQ8&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=82&ab_channel=takeUforward">...</a>
 */
public class P11_Largest_Rectangle_In_Histogram {

    public static void main(String[] args) {
        P11_Largest_Rectangle_In_Histogram p11_largest_rectangle_in_histogram =
            new P11_Largest_Rectangle_In_Histogram();
        System.out.println(p11_largest_rectangle_in_histogram.getMaxArea(new long[] {7, 2, 8, 9, 1, 3, 6, 5}, 8));
        System.out.println(
            p11_largest_rectangle_in_histogram.getMaxArea_better(new long[] {7, 2, 8, 9, 1, 3, 6, 5}, 8));
    }

    /**
     * Approach:
     * 1. LeftArray -> Stores the first left index from the element, which is less than or equal to the element
     * 2. Stack -> Stores the index of elements in increasing fashion
     * 3. If there are element, which is less than or equal to stack peek(), then start popping the stack untill it
     * matches
     * 4. Once we have leftArray and rightArray, then use this formula: a[i] * width, width -> (RS-LS + 1)
     * TC: O(N)
     * SC: O(N)
     *
     * @param hist
     * @param n
     * @return
     */
    public long getMaxArea(long[] hist, long n) {
        Stack<Integer> indexStack = new Stack<>();
        long[] leftSmallArray = new long[hist.length];

        // going from left to right
        int i = 0;
        leftSmallArray[i] = i;
        indexStack.add(i);
        i++;

        while (i < n) {
            if (!indexStack.isEmpty() && hist[i] > hist[indexStack.peek()]) {
                leftSmallArray[i] = indexStack.peek() + 1;
                indexStack.push(i);
                i++;
            } else {
                if (!indexStack.isEmpty()) {
                    indexStack.pop();
                } else {
                    leftSmallArray[i] = 0;
                    indexStack.push(i);
                    i++;
                }
            }
        }

        indexStack.clear();
        long[] rightSmallArray = new long[hist.length];
        i = hist.length - 1;
        rightSmallArray[i] = i;
        indexStack.add(i);
        i--;

        while (i >= 0) {
            if (!indexStack.isEmpty() && hist[i] > hist[indexStack.peek()]) {
                rightSmallArray[i] = indexStack.peek() - 1;
                indexStack.push(i);
                i--;
            } else {
                if (!indexStack.isEmpty()) {
                    indexStack.pop();
                } else {
                    rightSmallArray[i] = n - 1;
                    indexStack.push(i);
                    i--;
                }
            }
        }

        long maxArea = 0;

        for (int j = 0; j < n; j++) {
            long area = (rightSmallArray[j] - leftSmallArray[j] + 1) * hist[j];
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    /**
     * TC: O(N)
     * SC: O(N)
     *
     * @param hist
     * @param n
     * @return
     */
    public long getMaxArea_better(long[] hist, long n) {
        Stack<Integer> stack = new Stack<>();
        long maxArea = 0;
        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || hist[stack.peek()] >= hist[i])) {
                long height = hist[stack.pop()];
                long width;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}

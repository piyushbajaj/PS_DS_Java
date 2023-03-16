package TakeUForward.CompleteCourse_456.S9_Stacks_Queues.S9_3_Monotonic_Stack_Queue;

import java.util.Arrays;
import java.util.Stack;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S9_Stacks_Queues.S9_3_Monotonic_Stack_Queue
 * <p>
 * User: piyushbajaj
 * Date: 08/01/23
 * Time: 2:52 pm
 * <p>
 * g4g: <a href="https://practice.geeksforgeeks.org/problems/next-larger-element-1587115620/1">...</a>
 */
public class P1_Next_Greater_Element {

    /**
     * Using Stacks
     * <p>
     * TC: O(N)
     * SC: O(N)
     *
     * @param arr
     * @param n
     * @return
     */
    public long[] nextLargerElement(long[] arr, int n) {
        Stack<Long> stack = new Stack<>();
        long[] result = new long[n];
        int i = n - 1;

        while (i >= 0) {
            if (stack.isEmpty()) {
                result[i] = -1;
                stack.push(arr[i]);
                i--;
            } else {
                if (stack.peek() > arr[i]) {
                    result[i] = stack.peek();
                    stack.push(arr[i]);
                    i--;
                } else {
                    stack.pop();
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        P1_Next_Greater_Element p1_next_greater_element = new P1_Next_Greater_Element();
        long[] arr = {6, 8, 0, 1, 3};
        System.out.println(Arrays.toString(p1_next_greater_element.nextLargerElement(arr, 5)));
    }
}

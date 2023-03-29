package TakeUForward.CompleteCourse_456.S9_Stacks_Queues.S9_3_Monotonic_Stack_Queue;

import java.util.Arrays;
import java.util.Stack;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S9_Stacks_Queues.S9_3_Monotonic_Stack_Queue
 * <p>
 * User: piyushbajaj
 * Date: 08/01/23
 * Time: 3:10 pm
 * <p>
 * g4g: <a href="https://practice.geeksforgeeks.org/problems/next-greater-element-2/1">...</a>
 */
public class P2_Next_Greater_Element_II {

    public static void main(String[] args) {
        P2_Next_Greater_Element_II p2_next_greater_element_ii = new P2_Next_Greater_Element_II();
        int[] arr = {1, 2, 1};
        System.out.println(Arrays.toString(p2_next_greater_element_ii.nextGreaterElement(3, arr)));
    }

    /**
     * Approach
     * 1. Will iterate i from 2N - 1 to 0
     * 2. We are using to get the index i%N, for the circular array
     * 3. Assign the topmost element of the stack to the result array
     * TC: O(N)
     * SC: O(N)
     *
     * @param N
     * @param arr
     * @return
     */
    public int[] nextGreaterElement(int N, int[] arr) {
        int[] result = new int[N];
        Stack<Integer> stack = new Stack<>();

        for (int i = 2 * N - 1; i >= 0; i--) {
            // Keep popping element from the stack if the current array element is greater than or equal to peek stack
            // element
            while (!stack.isEmpty() && stack.peek() <= arr[i % N]) {
                stack.pop();
            }

            // assign the value to result array only in case i < N
            if (i < N) {
                if (!stack.isEmpty()) {
                    result[i] = stack.peek();
                } else {
                    result[i] = -1;
                }
            }

            // keep pushing the element to the stack
            stack.push(arr[i % N]);
        }

        return result;
    }
}

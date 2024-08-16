package TakeUForward.CompleteCourse_456.S9_Stacks_Queues.S9_3_Monotonic_Stack_Queue;

import java.util.Arrays;
import java.util.Stack;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S9_Stacks_Queues.S9_3_Monotonic_Stack_Queue
 * <p>
 * User: piyushbajaj
 * Date: 08/01/23
 * Time: 10:47 pm
 */
public class P3_Next_Smaller_Element {
    public static void main(String[] args) {
        P3_Next_Smaller_Element p3_next_smaller_element = new P3_Next_Smaller_Element();
        int[] arr = {4, 2, 1, 5, 3};
        p3_next_smaller_element.immediateSmaller(arr, 5);
        System.out.println(Arrays.toString(arr));
    }

    public void immediateSmaller(int[] arr, int n) {
        Stack<Integer> stack = new Stack<>();

        int i = n - 1;

        while (i >= 0) {
            if (stack.isEmpty()) {
                stack.push(arr[i]);
                arr[i] = -1;
                i--;
            } else {
                if (stack.peek() <= arr[i]) {
                    int temp = arr[i];
                    arr[i] = stack.peek();
                    stack.push(temp);
                    i--;
                } else {
                    stack.pop();
                }
            }
        }
    }
}

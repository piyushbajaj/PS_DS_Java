package TakeUForward.CompleteCourse_456.S9_Stacks_Queues.S9_3_Monotonic_Stack_Queue;

import java.util.Arrays;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S9_Stacks_Queues.S9_3_Monotonic_Stack_Queue
 * <p>
 * User: piyushbajaj
 * Date: 09/01/23
 * Time: 11:49 am
 * <p>
 * g4g: <a href="https://practice.geeksforgeeks.org/problems/immediate-smaller-element1142/1">...</a>
 */
public class P3_Immediate_Smaller_Element {

    public static void main(String[] args) {
        P3_Immediate_Smaller_Element p3_immediate_smaller_element = new P3_Immediate_Smaller_Element();
        int[] arr = {4, 2, 1, 5, 3};
        p3_immediate_smaller_element.immediateSmaller(arr, 5);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * TC: O(N)
     * SC: O(1)
     *
     * @param arr
     * @param n
     */
    void immediateSmaller(int[] arr, int n) {
        int next = arr[n - 1];
        arr[n - 1] = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (next < arr[i]) {
                int temp = arr[i];
                arr[i] = next;
                next = temp;
            } else {
                next = arr[i];
                arr[i] = -1;
            }
        }
    }
}

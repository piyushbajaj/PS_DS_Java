package TakeUForward.CompleteCourse_456.S9_Stacks_Queues.S9_3_Monotonic_Stack_Queue;

import java.util.Arrays;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S9_Stacks_Queues.S9_3_Monotonic_Stack_Queue
 * <p>
 * User: piyushbajaj
 * Date: 09/01/23
 * Time: 12:12 pm
 * <p>
 * g4g: <a href="https://practice.geeksforgeeks.org/problems/number-of-nges-to-the-right/1">...</a>
 */
public class P4_Number_Of_NGEs_Right {

    public static void main(String[] args) {
        P4_Number_Of_NGEs_Right p4_number_of_ngEs_right = new P4_Number_Of_NGEs_Right();
        int[] arr = {3, 4, 2, 7, 5, 8, 10, 6};
        int[] indices = {0, 5};

        System.out.println(Arrays.toString(p4_number_of_ngEs_right.count_NGEs(8, arr, 2, indices)));
    }

    /**
     * TC: O(N*queries)
     * SC: O(queries)
     *
     * @param N
     * @param arr
     * @param queries
     * @param indices
     * @return
     */
    public int[] count_NGEs(int N, int[] arr, int queries, int[] indices) {
        int[] output = new int[queries];
        for (int i = 0; i < queries; i++) {
            int index = indices[i];

            int val = arr[index];
            int count = 0;
            for (int j = index + 1; j < N; j++) {
                if (val < arr[j]) {
                    count++;
                }
            }

            output[i] = count;
        }
        return output;
    }
}

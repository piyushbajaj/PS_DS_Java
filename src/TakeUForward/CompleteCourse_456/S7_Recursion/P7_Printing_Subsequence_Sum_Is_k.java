package TakeUForward.CompleteCourse_456.S7_Recursion;

import java.util.ArrayList;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S7_Recursion
 * <p>
 * User: piyushbajaj
 * Date: 15/10/22
 * Time: 10:24 pm
 * <p>
 * <p>
 * Print - Parameter
 * Print 1 -> return true/false & avoid function calls if you get true
 * count -> return 1 and 0
 */
public class P7_Printing_Subsequence_Sum_Is_k {

    /**
     * TC: O(2^N)
     *
     * @param arr
     * @param result
     * @param index
     * @param sum
     * @param k
     */
    public void subsequence(int[] arr, ArrayList<Integer> result, int index, int sum, int k) {
        // Base Condition
        if (index == arr.length) {
            if (sum == k) {
                System.out.println(result);
            }
            return;
        }
        // Pick
        result.add(arr[index]);
        sum += arr[index];
        subsequence(arr, result, index + 1, sum, k);
        sum -= arr[index];
        result.remove(result.size() - 1);

        // Not Pick
        subsequence(arr, result, index + 1, sum, k);
    }

    // First Subsequence
    public boolean first_subsequence(int[] arr, ArrayList<Integer> result, int index, int sum, int k) {
        if (index == arr.length) {
            // condition satisfied
            if (sum == k) {
                System.out.println(result);
                return true;
            }
            // condition not satisfied
            else {
                return false;
            }
        }
        // Pick
        result.add(arr[index]);
        sum += arr[index];
        if (first_subsequence(arr, result, index + 1, sum, k)) {
            return true;
        }
        sum -= arr[index];
        result.remove(result.size() - 1);

        // Not Pick
        if (first_subsequence(arr, result, index + 1, sum, k)) {
            return true;
        }
        return false;
    }

    // TC: O(2^N)
    public int count_subsequence(int[] arr, ArrayList<Integer> result, int index, int sum, int k) {
        // Base Case
        if (index == arr.length) {
            if (sum == k) {
                return 1;
            } else {
                return 0;
            }
        }

        result.add(arr[index]);
        sum += arr[index];
        int left = count_subsequence(arr, result, index + 1, sum, k);
        sum -= arr[index];
        result.remove(result.size() - 1);

        int right = count_subsequence(arr, result, index + 1, sum, k);

        return left + right;
    }


    public static void main(String[] args) {
        P7_Printing_Subsequence_Sum_Is_k p7_printing_subsequence_sum_is_k = new P7_Printing_Subsequence_Sum_Is_k();
        int[] arr = {1, 2, 1};
        int k = 2;
        ArrayList<Integer> result = new ArrayList<>();
        p7_printing_subsequence_sum_is_k.subsequence(arr, result, 0, 0, 2);
        p7_printing_subsequence_sum_is_k.first_subsequence(arr, result, 0, 0, 2);
        System.out.println(p7_printing_subsequence_sum_is_k.count_subsequence(arr, result, 0, 0, 2));

    }

}

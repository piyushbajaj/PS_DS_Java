package PracticeSessionMay2024.StriversA2ZSheet.Step3_Arrays.Easy;

/**
 * Project: DSAlgo
 * Package: StriversA2ZSheet.Step3_Arrays
 * <p>
 * User: piyushbajaj
 * Date: 23/05/24
 * Time: 7:05 pm
 */
public class P1_LargestElementInArray {

    /**
     * TC: O(N)
     * SC: O(1)
     *
     * @param arr
     * @param n
     * @return
     */
    public int largest(int[] arr, int n) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {

    }
}

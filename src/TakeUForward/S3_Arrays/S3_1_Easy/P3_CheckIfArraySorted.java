package TakeUForward.S3_Arrays.S3_1_Easy;

/**
 * Created by bajajp on 18 Sep, 2022
 */
public class P3_CheckIfArraySorted {
    /**
     * TC: O(N)
     * @param arr
     * @return
     */
    static boolean checkIfArraySorted(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkIfArraySorted(new int[]{1, 2, 3, 4, 5}));
    }
}

package TakeUForward.S3_Arrays.S3_1_Easy;

/**
 * Created by bajajp on 18 Sep, 2022
 */
public class P4_RemoveDuplicates {

    /**
     * TC: O(N)
     * SC: O(1)
     *
     * @param arr
     * @return
     */
    static int removeDuplicates(int[] arr) {
        int i = 0, j = i + 1;
        int n = arr.length;
        while (j < n) {
            if (arr[i] != arr[j]) {
                arr[i + 1] = arr[j];
                i++;
            }
            j++;
        }
        return i + 1;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1, 1, 2, 2, 2, 3, 3}));
    }
}

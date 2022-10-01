package Array.Practice_2022.TwoPointers;

/**
 * TC: O(N)
 * Created by bajajp on 10 Sep, 2022
 */
public class P1_RemoveDuplicates {
    public int removeDuplicates(int[] arr) {
        /**
         * Here once we get the duplicates, we avoid them, and finally return i+1
         */
        int n = arr.length;
        int i = 0; // Slow Pointer
        for (int j = 1; j < n; j++) {
            if (arr[j] != arr[i]) {
                i++;
                arr[i] = arr[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        P1_RemoveDuplicates p1_removeDuplicates = new P1_RemoveDuplicates();
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(p1_removeDuplicates.removeDuplicates(arr));
    }
}

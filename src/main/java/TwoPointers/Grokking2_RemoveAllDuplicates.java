package TwoPointers;

/**
 * Created by bajajp on 24 Sep, 2022
 */
public class Grokking2_RemoveAllDuplicates {

    /**
     * TC: O(n)
     *
     * @param arr
     * @return
     */
    static int removeDuplicates(int[] arr) {
        int l = 0;
        int r = l + 1;
        int n = arr.length;

        while (r < n) {
            if (arr[l] != arr[r]) {
                l++;
                arr[l] = arr[r];
            }
            r++;
        }

        return l + 1;
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[] {2, 3, 3, 3, 6, 9, 9}));
    }
}

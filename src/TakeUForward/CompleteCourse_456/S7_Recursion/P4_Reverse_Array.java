package TakeUForward.CompleteCourse_456.S7_Recursion;

import java.util.Arrays;

import static Sorting.InsertionSort.swap;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S7_Recursion
 * <p>
 * User: piyushbajaj
 * Date: 14/10/22
 * Time: 7:23 pm
 * <p>
 */
public class P4_Reverse_Array {

    /**
     * TC: O(N)
     * SC: O(N)
     *
     * @param arr
     * @param l
     * @param r
     */
    public void reverseArr(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        swap(arr, l, r);
        reverseArr(arr, l + 1, r - 1);
    }

    public void reverseArr_oneVariable(int[] arr, int i, int n) {
        if (i >= n / 2) {
            return;
        }
        swap(arr, i, n - i - 1);
        reverseArr_oneVariable(arr, i + 1, n);
    }

    // TC: O(N), SC: (N)
    public boolean isPalindrome(char[] arr, int i, int n) {
        if (i >= n / 2) {
            return true;
        }

        if (arr[i] != arr[n - i - 1]) {
            return false;
        }

        return isPalindrome(arr, i + 1, n);
    }


    public static void main(String[] args) {
        P4_Reverse_Array p4_reverse_array = new P4_Reverse_Array();
        int[] arr = {1, 2, 3, 4, 5};
        p4_reverse_array.reverseArr(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

        int[] arr1 = {1, 2, 3, 4, 5};
        p4_reverse_array.reverseArr_oneVariable(arr1, 0, arr1.length);
        System.out.println(Arrays.toString(arr1));

        String str = "piyip";
        System.out.println(p4_reverse_array.isPalindrome(str.toCharArray(), 0, str.length()));
    }
}

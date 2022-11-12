package TakeUForward.S7_Recursion;

import java.util.ArrayList;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S7_Recursion
 * <p>
 * User: piyushbajaj
 * Date: 15/10/22
 * Time: 12:56 pm
 * <p>
 */
public class P6_Subsequence_Recursion {

    /**
     * Approach:
     * TC: O(2^N)
     * SC: O(N)
     *
     * @param originalArray
     * @param arrayList
     * @param index
     * @param n
     */
    public void subsequence(int[] originalArray, ArrayList<Integer> arrayList, int index, int n) {
        if (index == n) {
            if (arrayList.size() > 0) {
                System.out.println(arrayList);
            }

            if (arrayList.isEmpty()) {
                System.out.println(arrayList);
            }
            return;
        }

        arrayList.add(originalArray[index]);
        subsequence(originalArray, arrayList, index + 1, n);// pick an element
        arrayList.remove(arrayList.size() - 1);
        subsequence(originalArray, arrayList, index + 1, n); // not pick an element
    }

    public static void main(String[] args) {
        P6_Subsequence_Recursion p6_subsequence_recursion = new P6_Subsequence_Recursion();
        int[] arr = {3, 1, 2};
        int n = 3;
        ArrayList<Integer> arrayList = new ArrayList<>();
        p6_subsequence_recursion.subsequence(arr, arrayList, 0, n);
    }
}

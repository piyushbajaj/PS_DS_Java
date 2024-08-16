package TakeUForward.CompleteCourse_456.S7_Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S7_Recursion
 * <p>
 * User: piyushbajaj
 * Date: 15/10/22
 * Time: 12:56 pm
 * <p>
 */
public class P6_Subsequence_PowerSet_Recursion {

    public static void main(String[] args) {
        P6_Subsequence_PowerSet_Recursion p6_subsequence_recursion = new P6_Subsequence_PowerSet_Recursion();
        int[] arr = {3, 1, 2};
        int n = 3;
        ArrayList<Integer> arrayList = new ArrayList<>();
//        p6_subsequence_recursion.subsequence(arr, arrayList, 0, n);

        System.out.println(p6_subsequence_recursion.AllPossibleStrings("abc"));
    }

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

    /**
     * Power Set
     * Link g4g: https://practice.geeksforgeeks.org/problems/power-set4302/1
     * TC: O(2^N)
     * SC: O(1)
     *
     * @param s
     * @return
     */
    public List<String> AllPossibleStrings(String s) {
        List<String> result = new ArrayList<>();

        int n = s.length();
        // Code here
        for (int num = 0; num <= Math.pow(2, n) - 1; num++) {
            StringBuilder sub = new StringBuilder();

            for (int i = 0; i <= n - 1; i++) {
                if ((num & (1 << i)) != 0) {
                    sub.append(s.charAt(i));
                }
            }
            if (sub.length() > 0) {
                result.add(String.valueOf(sub));
            }
        }
        Collections.sort(result);
        return result;
    }
}

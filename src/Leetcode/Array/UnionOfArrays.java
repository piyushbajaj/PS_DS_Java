package Leetcode.Array;

import java.util.Arrays;

public class UnionOfArrays {

    public int[] union(int[] a, int[] b) {
        int aL = a.length;
        int bL = b.length;

        int nL = aL + bL;

        int[] newArray = new int[nL];

        int k = 0;

        if (aL < bL) {
            k = aL;
        } else
            k = bL;

        int i, j = 0;
        int m = 0;
        for (i = 0; i < k; i++) {
            if (a[i] < b[j]) {
                newArray[m] = a[i];
            } else {
                newArray[m] = b[j];
                j++;
            }
            m++;
        }

        while (i < aL) {
            newArray[m] = a[i];
            m++;
            i++;
        }

        while (j < bL) {
            newArray[m] = b[j];
            m++;
            j++;
        }

        return newArray;
    }

    public static void main(String[] args) {
        int[] a1 = {1, 2, 3, 4, 5};
        int[] a2 = {3, 5, 7, 8, 9};

        UnionOfArrays unionOfArrays = new UnionOfArrays();
        System.out.println(Arrays.toString(unionOfArrays.union(a1, a2)));
    }
}

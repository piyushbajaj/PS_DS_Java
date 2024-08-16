package Array;

/**
 * Created by piyush.bajaj on 10/12/16.
 */
public class AdjacentDuplicates {
    public static int removeAdjDuplicates(int[] A) {
        int stkptr = -1;
        int i = 0;
        while (i < A.length) {
            if (stkptr == -1 || A[stkptr] != A[i]) {
                stkptr++;
                A[stkptr] = A[i];
                i++;
            } else {
                while (i < A.length && A[stkptr] == A[i]) {
                    i++;
                }
                stkptr--;
            }
        }
        return stkptr;
    }

    public static void main(String[] args) {
        int[] A = {10, 12, 5, 6, 8, 8, 8, 0, 1, 1, 0, 6, 5};
        int index = removeAdjDuplicates(A);
        for (int i = 0; i <= index; i++) {
            System.out.println(" " + A[i]);
        }

    }
}

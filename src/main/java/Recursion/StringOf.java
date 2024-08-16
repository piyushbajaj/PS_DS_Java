package Recursion;

/**
 * Created by piyush.bajaj on 25/03/16.
 */
public class StringOf {

    public static void main(String args[]) {
        nbits(5);
    }


    public static void nbits(int n) {
        int[] A = new int[n];
        if (n < 1) {
            System.out.println(A);
        } else {
            A[n - 1] = 0;
            nbits(n - 1);
            A[n - 1] = 1;
            nbits(n - 1);
        }
        for (int i : A) {
            System.out.println(i);
        }
    }

}



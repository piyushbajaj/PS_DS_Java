package TwoPointers;

import java.util.Arrays;

/**
 * Created by bajajp on 24 Sep, 2022
 */
public class Grokking3_SquaringSortedArray {
    static int[] makeSquares(int[] arr) {
        int n = arr.length;

        int[] squares = new int[n];

        int l = 0, r = arr.length - 1;
        int squareIndex = r;

        while (l <= r) {
            int leftSquare = arr[l] * arr[l];
            int rightSquare = arr[r] * arr[r];

            if (leftSquare < rightSquare) {
                squares[squareIndex] = rightSquare;
                squareIndex--;
                r--;
            } else {
                squares[squareIndex] = leftSquare;
                squareIndex--;
                l++;
            }
        }

        return squares;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(makeSquares(new int[] {-2, -1, 0, 2, 3})));
    }
}

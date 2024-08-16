package Recursion;

import java.util.Scanner;

/**
 * Created by piyush.bajaj on 19/03/16.
 */
public class sortedArray {
    public static void main(String[] args) {

        System.out.println("Enter number of inputs: ");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] number = new int[n];

        System.out.println("Enter the number one by one: ");
        for (int i = 0; i < n; i++) {
            number[i] = s.nextInt();
        }
        isArraySortedOrder(number, n);
    }

    public static void isArraySortedOrder(int[] A, int index) {
        if (A.length == 1 || index - 2 == -1) {
            System.out.println("sorted");
            return;
        } else if (A[index - 1] < A[index - 2]) {
            System.out.println("Un-sorted");
            return;
        } else {
            isArraySortedOrder(A, index - 1);
        }
    }
}

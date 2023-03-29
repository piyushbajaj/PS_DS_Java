package spoj;

import java.util.Scanner;

/**
 * Your program is to use the brute-force approach in order to find the Answer to Life, the Universe, and Everything.
 * More precisely... rewrite small numbers from input to output.
 * Stop processing input after reading in the number 42. All numbers at input are integers of one or two digits.
 */
public class adhoc1 {


    public static void main(String[] args) {


        System.out.println("Enter number of inputs: ");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] number = new int[n];


        System.out.println("Enter the number one by one: ");
        for (int i = 0; i < n; i++) {
            int a = s.nextInt();
            int length = String.valueOf(a).length();
            if (length == 1 || length == 2) {
                number[i] = a;
            } else {
                System.out.println("Enter the number of 1 or 2 digit ");
                number[i] = s.nextInt();
            }

        }

        System.out.println("Output: ");
        for (int i = 0; i < n; i++) {
            if (number[i] == 42) {
                break;
            } else {
                System.out.println(number[i]);
            }
        }


    }
}



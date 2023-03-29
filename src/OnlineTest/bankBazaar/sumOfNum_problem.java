package OnlineTest.bankBazaar;

import java.util.Scanner;

/**
 * Created by piyush.bajaj on 14/01/18.
 */
public class sumOfNum_problem {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
            b[i] = s.nextInt();


        }

        checkSum(a, b, n);


    }

    public static void checkSum(int[] a, int[] b, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(a[i] + b[i]);
        }

    }
}

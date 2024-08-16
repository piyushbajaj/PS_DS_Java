package Recursion;

/**
 * Created by piyush.bajaj on 12/03/16.
 */
public class fac {
    public static void main(String args[]) {
        System.out.println(Factorial(5));
    }

    ;

    public static int Factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * Factorial(n - 1);
        }
    }
}

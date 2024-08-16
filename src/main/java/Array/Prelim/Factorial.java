package Array.Prelim;

public class Factorial {
    public static void main(String[] args) {
        for (int i = 0; i <= 5; i++) {
            System.out.print(fact(i) + " ");
        }
    }

    /*
    TC: O(N)
     */
    public static int fact(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return n * fact(n - 1);
    }
}

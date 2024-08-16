package DynamicProgramming;

/**
 * Created by piyush.bajaj on 23/01/17.
 */
public class Tabulation {
    public static void main(String[] args) {
        Tabulation mem = new Tabulation();
        System.out.println(mem.fib(4));
    }

    public int fib(int n) {
        int[] F = new int[n + 1];
        F[0] = 0;
        F[1] = 1;
        for (int i = 2; i <= n; i++) {
            F[i] = F[i - 1] + F[i - 2];
        }
        return F[n];
    }
}

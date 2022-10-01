package Array.Prelim;

public class Fibanacci {
    public static void main(String[] args) {
        printFibSequence(4);
//        System.out.printf("Fibonacci for %d is %d%n", 4, fib_bf(4));
    }

    public static void printFibSequence(int n) {
        System.out.print("Fibonacci in Recursive: ");
        for (int i = 0; i <= n; i++) {
            System.out.print(fib_rec_bf(i) + " ");
        }
        System.out.println();

        System.out.print("Fibonacci in Iterative: ");
        for (int i = 0; i <= n; i++) {
            System.out.print(fib_iterative(i) + " ");
        }
        System.out.println();

        System.out.print("Fibonacci in Recursive Memoization: ");
        for (int i = 0; i <= n; i++) {
            System.out.print(fib_rec_mem(i) + " ");
        }
    }

    /*
    TC: O(N)
    SC: O(1)
     */
    public static int fib_iterative(int n) {
        int a = 0, b = 1;
        if (n == 0 || n == 1) {
            return n;
        }

        for (int i = 2; i <= n; i++) {
            int fibSum = a + b;
            a = b;
            b = fibSum;
        }
        return b;
    }

    // TC: O(2^N-1)
    // SC: O(N)
    public static int fib_rec_bf(int n) {
        if (n == 0 || n == 1) return n;

        return fib_rec_bf(n - 1) + fib_rec_bf(n - 2);
    }

    /*
    With Memoization the TC can be brought lower to O(N)
     */
    public static int fib_rec_mem(int n) {
        if (n == 0 || n == 1) return n;

        int[] memArr = new int[1000];

        if (memArr[n] != 0) return memArr[n];

        memArr[n] = fib_rec_mem(n - 1) + fib_rec_mem(n - 2);

        return memArr[n];
    }
}

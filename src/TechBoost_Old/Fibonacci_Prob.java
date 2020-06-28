package TechBoost_Old;

/**
 * Created by piyush.bajaj on 07/03/18.
 */
public class Fibonacci_Prob {
    public static int fib_recur(int n){
        if(n == 0) return 0;

        if(n == 1) return 1;

        return fib_recur(n-1) + fib_recur(n-2);

        /*
        Time Complexity: O(2^n)
        Space Complexity: O(n)
         */
    }

    public static int fib_iterative(int n){
        if(n == 0) return 0;

        if(n == 1) return 1;
        int temp1 = 0;
        int temp2 = 1;
        int fib = 0;
        for(int i = 2; i <= n; i++){
            fib = temp1+temp2;
            temp1 = temp2;
            temp2 = fib;
        }

        return fib;
    }

    public static void main(String[] args) {
        System.out.println("Fibonacci Numbers using Recusrive: " + fib_recur(10));

        System.out.println("Fibonacci Numbers using Iterative: " + fib_iterative(10));
    }
}

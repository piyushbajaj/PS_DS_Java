package DynamicProgramming;

/**
 * Created by piyush.bajaj on 23/01/17.
 */
public class Memoization {
    public int fib(int n){
        if(n <=1) {
            //System.out.print(n + " ");
            return n;
        }
        //System.out.print((fib(n-1) + fib(n-2)) + " ");
        return fib(n-1) + fib(n-2);
    }

    /* Function to initialize NIL values in lookup table */
    int Max = 100;
    int Nil = -1;

    int[] lookup = new int[41];

    public void initialize(int N){
        int i;
        for(i = 0; i <= N; i++)
            lookup[i] = Nil;
    }

    public int fib_Mem(int n){
        if(lookup[n]==Nil){
            if(n <= 1)
                lookup[n] = n;
            else
                lookup[n] = fib(n-1) + fib(n-2);
        }

        return lookup[n];
    }


    public static void main(String[] args) {
        Memoization mem = new Memoization();
        System.out.println(mem.fib(40));

        mem.initialize(40);
        System.out.println("With memoization " + mem.fib_Mem(40));
    }
}

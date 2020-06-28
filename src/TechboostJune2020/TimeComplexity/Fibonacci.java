package TechboostJune2020.TimeComplexity;

import java.util.ArrayList;
import java.util.Scanner;

public class Fibonacci {
    //Iterative Approach

    //TC: O(N)
    //SC: O(1)
    public int fib_i(int n){
        int a = 0, b = 1, sum = 0;
        if(n == 0) return a;
        if(n == 1) return b;

        for(int i = 2; i <= n; i++) {
            sum = a+b;
            a = b;
            b = sum;
        }

        return sum;
    }

    //TC: O(N)
    //SC: O(N)
    public ArrayList fib_series_i(int n) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        int a = 0, b = 1, sum = 0;
        if(n == 0) {
            arrayList.add(a);
            return arrayList;
        }
        if(n == 1) {
            arrayList.add(b);
            return arrayList;
        }

        arrayList.add(a);
        arrayList.add(b);

        for(int i = 2; i <= n; i++) {
            sum = a+b;
            a = b;
            b = sum;
            arrayList.add(sum);
        }

        return arrayList;
    }

    //Recursive Approach
    //T.C: O(2^N)
    //S.C: O(N)
    public int fib_r(int n){
        if(n==0 || n==1)
            return n;
        else
            return fib_r(n-1) + fib_r(n-2);
    }


    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();
        Scanner s = new Scanner(System.in);
        System.out.println("Please input the number to get Fibonacci number: ");
        int key = s.nextInt();
        System.out.println(String.format("Fibonacci number for input (Iterative): %d is: %d ", key, fib.fib_i(key)));
        System.out.println(String.format("Fibonacci number for input (Recursive): %d is: %d ", key, fib.fib_r(key)));

        System.out.println("Printing Fibonacci Series (Iterative): " + fib.fib_series_i(key).toString());
    }
}

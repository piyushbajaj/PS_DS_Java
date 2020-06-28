package TechboostJune2020.TimeComplexity;

import java.util.Scanner;

public class Factorial {
    //Iterative
    public int fact_i(int n){
        int cal = n;
        while ( n > 1) {
            cal = cal*(n-1);
            n--;
        }
        return cal;
    }

    //Recursive
    public int fact_r(int n){
        if(n==0 || n==1)
            return 1;
        return n*fact_r(n-1);
    }

    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        Scanner s = new Scanner(System.in);
        System.out.println("Please input the number to get Factorial number: ");
        int key = s.nextInt();
        System.out.println(String.format("Factorial number for input (Iterative): %d is: %d ", key, factorial.fact_i(key)));
        System.out.println(String.format("Factorial number for input (Recursive): %d is: %d ", key, factorial.fact_r(key)));
    }
}

package Recursion;
import java.util.Scanner;
import java.lang.String;

/**
 * Created by piyush.bajaj on 25/03/16.
 */
public class PermutationOfString {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("enter the string");
        String a =s.nextLine();
        permutation(a);
    }

    public static void permutation(String a){
    int l = a.length();
        int b = factorial(l);
        System.out.println(b);
    }

    public static int factorial(int n){
        int b = n;
        if(n<1)
            return 1;
        for(int i=n-1; i > 0; i-- ){
            b=b*i;
        }
        return b;
    }
}

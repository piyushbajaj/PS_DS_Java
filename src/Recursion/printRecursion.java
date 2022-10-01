package Recursion;

public class printRecursion {
    public int print(int n) {
        if (n == 0)
            return 0;
        else {
            System.out.println(n);
            return print(n-1);
        }
    }

    public static void main(String[] args) {
        printRecursion pr = new printRecursion();
        pr.print(5);
    }

}

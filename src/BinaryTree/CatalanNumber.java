package BinaryTree;

/**
 * Created by piyush.bajaj on 03/01/17.
 * Total number of possible Binary Search Trees with n different keys = Catalan number Cn = (2n)!/(n+1)!*n!
 * int res = 0;
 * if(n <=1) return 1;
 * for(int i = 0; i < n; i++){
 * res += catalan(i) * catalan(n-i-1);
 * }
 */


public class CatalanNumber {

    //Complexity is O(4^n)
    int catalan(int n) {
        int res = 0;

        if (n <= 1)
            return 1;

        for (int i = 0; i < n; i++) {
            res += catalan(i) * catalan(n - i - 1);
        }
        return res;
    }

    int catalanDP(int n) {
        // Table to store results of subproblems
        int[] catalan = new int[n + 1];

        // Initialize first two values in table
        if (n == 0 || n == 1)
            return 1;

        catalan[0] = 1;
        catalan[1] = 1;

        // Fill entries in catalan[] using recursive formula
        for (int i = 2; i <= n; i++) {
            catalan[i] = 0;
            for (int j = 0; j < i; j++)
                catalan[i] += catalan[j] * catalan[i - j - 1];
        }

        // Return last entry
        return catalan[n];
    }

    public static void main(String[] args) {
        CatalanNumber CN = new CatalanNumber();
        System.out.println("Hence first 10 catalan numbers are: ");
        for (int i = 0; i <= 3; i++) {
            System.out.print(CN.catalan(i) + " ");
        }
        System.out.println();
        for (int i = 0; i <= 3; i++) {
            System.out.print(CN.catalanDP(i) + " ");
        }
    }
}

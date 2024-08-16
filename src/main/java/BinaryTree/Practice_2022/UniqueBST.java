package BinaryTree.Practice_2022;

import java.util.ArrayList;

public class UniqueBST extends CommonUtils {
    public static int uniqueBST(int n) {
        ArrayList<Integer> arr = new ArrayList<>();
        int[] cat = new int[n + 1];
        cat[0] = 1;
        cat[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                cat[i] += cat[j - 1] * cat[i - j];
            }
        }
        return cat[n];
    }

    public static void main(String[] args) {
        System.out.println(uniqueBST(3));
    }
}

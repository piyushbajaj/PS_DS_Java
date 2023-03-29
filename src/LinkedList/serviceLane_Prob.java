package LinkedList;

import java.util.Scanner;

/**
 * Created by piyush.bajaj on 23/01/18.
 */
public class serviceLane_Prob {
    static int[] serviceLane(int n, int[][] cases, int[] width) {
        // Complete this function


        int row = cases.length;
        int col = cases[0].length;
        int[] res = new int[row];
        int m = 0, k = 0;

        for (int i = 0; i < row; i++) {
            res[i] = (width_col(width, cases[i][0], cases[i][1]));
        }


        return res;
    }

    public static int width_col(int[] width, int i, int j) {
        int min = Integer.MAX_VALUE;

        for (int k = i; k <= j; k++) {
            if (width[k] < min) {
                min = width[k];
            }
        }

        return min;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int t = in.nextInt();
        int[] width = new int[n];
        for (int width_i = 0; width_i < n; width_i++) {
            width[width_i] = in.nextInt();
        }
        int[][] cases = new int[t][2];
        for (int cases_i = 0; cases_i < t; cases_i++) {
            for (int cases_j = 0; cases_j < 2; cases_j++) {
                cases[cases_i][cases_j] = in.nextInt();
            }
        }
        int[] result = serviceLane(n, cases, width);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");


        in.close();
    }
}

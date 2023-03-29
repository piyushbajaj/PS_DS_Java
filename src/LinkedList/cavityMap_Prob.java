package LinkedList;

import java.util.Scanner;

/**
 * Created by piyush.bajaj on 24/01/18.
 */
public class cavityMap_Prob {
    static String[] cavityMap(String[] grid) {
        // Complete this function
        int n = grid.length;
        char[][] chArr = new char[n][n];

        for (int i = 1; i < n - 1; i++) {
            //StringBuilder str = new StringBuilder(grid[i]);
            for (int j = 1; j < n - 1; j++) {
                if ((grid[i].charAt(j) > grid[i].charAt(j - 1)) &&
                    //(grid[i].charAt(j) >= grid[i-1].charAt(j-1)) &&
                    //(grid[i].charAt(j) >= grid[i+1].charAt(j-1)) &&
                    (grid[i].charAt(j) > grid[i - 1].charAt(j)) &&
                    (grid[i].charAt(j) > grid[i + 1].charAt(j)) &&
                    //(grid[i].charAt(j) >= grid[i-1].charAt(j+1)) &&
                    (grid[i].charAt(j) > grid[i].charAt(j + 1))
                    //(grid[i].charAt(j) >= grid[i+1].charAt(j+1))
                ) {
                    //grid[i].charAt(j) = 'X';
                    //grid[i].replace(grid[i].charAt(j), 'X');
                    chArr[i][j] = 'X';
                    //str.setCharAt(j, '0');
                }
            }
            //grid[i] = str.toString();
        }

        for (int i = 1; i < n - 1; i++) {
            StringBuilder str = new StringBuilder(grid[i]);
            for (int j = 1; j < n - 1; j++) {
                if (chArr[i][j] == 'X') {
                    //grid[i].charAt(j) = 'X';
                    //grid[i].replace(grid[i].charAt(j), 'X');
                    str.setCharAt(j, 'X');
                }
            }
            grid[i] = str.toString();
        }

        return grid;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] grid = new String[n];
        for (int grid_i = 0; grid_i < n; grid_i++) {
            grid[grid_i] = in.next();
        }
        String[] result = cavityMap(grid);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");


        in.close();
    }
}

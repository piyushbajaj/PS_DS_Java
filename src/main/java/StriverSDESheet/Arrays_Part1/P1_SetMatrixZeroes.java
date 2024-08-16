package StriverSDESheet.Arrays_Part1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by bajajp on 27 Jul, 2022
 */
public class P1_SetMatrixZeroes {
    public static void main(String[] args) {
        P1_SetMatrixZeroes p1SetMatrixZeroes = new P1_SetMatrixZeroes();
//        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        p1SetMatrixZeroes.setZeroes_betterSpace(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    /**
     * TC: O(N*M)
     * SC: O(N+M)
     **/
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        Set<Integer> hashZeroesRows = new HashSet<Integer>();
        Set<Integer> hashZeroesCols = new HashSet<Integer>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    hashZeroesRows.add(i);
                    hashZeroesCols.add(j);
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hashZeroesRows.contains(i) || hashZeroesCols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * TC: O(N*M)
     * SC: O(1)
     **/
    public void setZeroes_betterSpace(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        // If any column value is 0 for the 1st row, then make this true
        boolean isCol = false;

        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                isCol = true;
            }
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Set matrix value to 0 if encounter any col and row starting from 1st
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Setting 0 for the 0th col values, if mat[0][0] is 0
        if (matrix[0][0] == 0) {
            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }

        // Setting 0 for the 0th col values, if isCol is true
        if (isCol) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}

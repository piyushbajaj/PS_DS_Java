package TakeUForward.Blind75.Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.util.Pair;

/**
 * Project: DS_Algo
 * Package: TakeUForward.Blind75.Matrix
 * <p>
 * User: piyushbajaj
 * Date: 25/01/23
 * Time: 12:03 am
 * <p>
 * lc: <a href="https://leetcode.com/problems/set-matrix-zeroes/">...</a>
 */
public class P1_Set_Matrix_Zeroes {

    /**
     * Approach:
     * 1. Capture indexes, which contains zeros in the map
     * 2. Then run from 1st col to last col, or from first row to last row, and if matrix element matches 0, then
     * insert to the array list.
     * <p>
     * TC: O(N*N)
     * SC: O(N)
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        List<Pair<Integer, Integer>> indexes = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    indexes.add(new Pair<Integer, Integer>(i, j));
                }
            }
        }

        for (Pair<Integer, Integer> index : indexes) {
            int ith = index.getKey();
            int jth = index.getValue();

            // Make columns zero
            for (int i = 0; i < n; i++) {
                matrix[i][jth] = 0;
            }

            // Make rows zero
            for (int j = 0; j < m; j++) {
                matrix[ith][j] = 0;
            }
        }

    }

    public static void main(String[] args) {
        P1_Set_Matrix_Zeroes p1_set_matrix_zeroes = new P1_Set_Matrix_Zeroes();
        int[][] matrix = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        p1_set_matrix_zeroes.setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}

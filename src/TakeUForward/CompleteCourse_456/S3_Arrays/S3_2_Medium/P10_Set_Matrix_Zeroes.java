package TakeUForward.CompleteCourse_456.S3_Arrays.S3_2_Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.util.Pair;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S3_Arrays.S3_2_Medium
 * <p>
 * User: piyushbajaj
 * Date: 26/12/22
 * Time: 9:07 pm
 * <p>
 * lc: <a href="https://leetcode.com/problems/set-matrix-zeroes/description/">...</a>
 */
public class P10_Set_Matrix_Zeroes {
    /**
     * TC: O(N * M) + O(k * (N + M))
     * SC: O(k)
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        List<Pair<Integer, Integer>> arrayList = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    arrayList.add(new Pair<>(i, j));
                }
            }
        }

        for (Pair<Integer, Integer> pair : arrayList) {
            int ith = pair.getKey();
            int jth = pair.getValue();

            for (int i = 0; i < row; i++) {
                matrix[i][jth] = 0;
            }

            for (int j = 0; j < col; j++) {
                matrix[ith][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        P10_Set_Matrix_Zeroes p10_set_matrix_zeroes = new P10_Set_Matrix_Zeroes();
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        p10_set_matrix_zeroes.setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}

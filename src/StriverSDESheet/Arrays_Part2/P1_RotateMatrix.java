package StriverSDESheet.Arrays_Part2;

import java.util.Arrays;

/**
 * Created by bajajp on 13 Aug, 2022
 */
public class P1_RotateMatrix {
    /**
     * TC: O(N*N)
     * SC: O(2N)
     *
     * @param matrix
     * @return
     */
    public static int[][] rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] newMatrix = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                newMatrix[j][col - 1 - i] = matrix[i][j];
            }
        }

        return newMatrix;
    }

    /**
     * Given N by N matrix
     * Let's try to reduce the SC
     * 1. Transpose the matrix
     * 2. Reverse the value in the row one by one
     *
     * @param matrix
     */

    public static int[][] rotate_better(int[][] matrix) {
        int n = matrix.length;

        // Transpose matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse matrix rows value
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.deepToString(rotate_better(matrix)));
    }
}

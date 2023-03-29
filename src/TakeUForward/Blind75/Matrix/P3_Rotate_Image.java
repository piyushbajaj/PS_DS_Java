package TakeUForward.Blind75.Matrix;

import java.util.Arrays;

/**
 * Project: DS_Algo
 * Package: TakeUForward.Blind75.Matrix
 * <p>
 * User: piyushbajaj
 * Date: 24/02/23
 * Time: 7:05 pm
 * <p>
 * lc:
 */
public class P3_Rotate_Image {

    public static void main(String[] args) {
        P3_Rotate_Image p3_rotate_image = new P3_Rotate_Image();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        p3_rotate_image.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));

        int[][] matrix1 = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
//        p3_rotate_image.rotate(matrix1);
//        System.out.println(Arrays.deepToString(matrix1));

        p3_rotate_image.rotate_better(matrix1);
        System.out.println(Arrays.deepToString(matrix1));
    }

    /**
     * Approach: We will use layer approach to rotate matrix to clock-wise 90 degree
     * 1. For 1st layer, Rotate all the 4 corner elements, one by one. Once corner is done, then next element unless
     * it reaches last.
     * 2. Keep doing the same thing for each layer. For e.g: If n = 3, then just in one layer, its done. If n = 4,
     * then it has to go till 2.
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int layer = 0; layer < n / 2; layer++) {
            int last = n - 1 - layer;
            for (int first = layer; first < last; first++) {
                int temp = matrix[layer][first]; // temp: 1: matrix[0][0]
                matrix[layer][first] = matrix[last - first][layer]; // matrix[0][0] => matrix[2][0] => 7
                matrix[last - first][layer] = matrix[last][last - first]; // matrix[2][0] => matrix[2][2] => 9
                matrix[last][last - first] = matrix[first][last]; // matrix[2][2] => matrix[0][2] => 3
                matrix[first][last] = temp; // matrix[0][2] => temp
            }
        }
    }

    /**
     * Approach:
     * 1. Transpose the matrix
     * 2. Reverse all the elements in the matrix
     * <p>
     * TC: O(N*N)
     * SC: O(1)
     *
     * @param matrix
     */
    public void rotate_better(int[][] matrix) {
        int n = matrix.length;

        // Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }
}

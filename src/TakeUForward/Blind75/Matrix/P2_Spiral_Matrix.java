package TakeUForward.Blind75.Matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: DS_Algo
 * Package: TakeUForward.Blind75.Matrix
 * <p>
 * User: piyushbajaj
 * Date: 24/02/23
 * Time: 6:16 pm
 * lc: <a href="https://leetcode.com/problems/spiral-matrix/">...</a>
 */
public class P2_Spiral_Matrix {

    /**
     * TC: O(N*M)
     * SC: O(1)
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> result = new ArrayList<>();

        int left = 0, right = m - 1, top = 0, bottom = n - 1;

        /**
         * 1. Left to Right, keeping top -> ith (static), will increase top
         * 2. Top to Bottom, keeping right -> jth (static), will decrement right
         * 3. Right to Left, keeping bottom -> ith (static), will
         * 4. Bottom to Top, keeping left -> jth (static)
         *
         *
         */
        while (left <= right && top <= bottom) {
            // Top is static
            for (int j = left; j <= right; j++) {
                result.add(matrix[top][j]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    result.add(matrix[bottom][j]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        P2_Spiral_Matrix p2_spiral_matrix = new P2_Spiral_Matrix();
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(p2_spiral_matrix.spiralOrder(matrix));
    }
}

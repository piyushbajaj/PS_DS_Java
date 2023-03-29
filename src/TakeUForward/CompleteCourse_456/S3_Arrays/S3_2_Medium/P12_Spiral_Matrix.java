package TakeUForward.CompleteCourse_456.S3_Arrays.S3_2_Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S3_Arrays.S3_2_Medium
 * <p>
 * User: piyushbajaj
 * Date: 27/12/22
 * Time: 12:23 pm
 */
public class P12_Spiral_Matrix {

    public static void main(String[] args) {
        P12_Spiral_Matrix p12_spiral_matrix = new P12_Spiral_Matrix();
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(p12_spiral_matrix.spiralOrder(matrix));
    }

    /**
     * Going Spiral way
     * 1. Left to Right
     * 2. Top to Bottom
     * 3. Right to Left
     * 4. Bottom to Top
     * <p>
     * TC: O(N*M)
     * SC: O(1)
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        List<Integer> result = new ArrayList<>();

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            for (int j = top; j <= bottom; j++) {
                result.add(matrix[j][right]);
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int j = bottom; j >= top; j--) {
                    result.add(matrix[j][left]);
                }
                left++;
            }
        }

        return result;
    }
}

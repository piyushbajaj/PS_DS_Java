package TakeUForward.CompleteCourse_456.S3_Arrays.S3_2_Medium;

import java.util.Arrays;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S3_Arrays.S3_2_Medium
 * <p>
 * User: piyushbajaj
 * Date: 26/12/22
 * Time: 11:41 pm
 * <p>
 * lc: <a href="https://leetcode.com/problems/rotate-image/description/">...</a>
 */
public class P11_Rotate_Image {

    /**
     * Rotate one by one element, first do the outer layer then inner layer
     * TC: O(N*N)
     * SC: O(1)
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int layer = 0; layer < n / 2; layer++) {
            int last = n - layer - 1;

            for (int first = layer; first < last; first++) {
                int offset = first - layer;

                int temp = matrix[layer][first];
                matrix[layer][first] = matrix[last - offset][layer];
                matrix[last - offset][layer] = matrix[last][last - offset];
                matrix[last][last - offset] = matrix[first][last];
                matrix[first][last] = temp;
            }
        }

    }

    public static void main(String[] args) {
        P11_Rotate_Image p3_rotate_image = new P11_Rotate_Image();
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//
//        p3_rotate_image.rotate(matrix);
//        System.out.println(Arrays.deepToString(matrix));

        int[][] matrix1 = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        p3_rotate_image.rotate(matrix1);
        System.out.println(Arrays.deepToString(matrix1));
    }
}

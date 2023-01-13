package TakeUForward.S3_Arrays.S3_2_Medium;

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
            int first = layer;
            int last = n - layer - 1;

            for (int i = first; i < last; i++) {
                int offset = i - first;

                int temp = matrix[first][i];
                matrix[first][i] = matrix[last - offset][first];
                matrix[last - offset][first] = matrix[last][last - offset];
                matrix[last][last - offset] = matrix[i][last];
                matrix[i][last] = temp;
            }
        }

    }

    public static void main(String[] args) {

    }
}

package TakeUForward.CompleteCourse_456.S3_Arrays.S3_1_Easy;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S3_Arrays.S3_1_Easy
 * <p>
 * User: piyushbajaj
 * Date: 21/11/22
 * Time: 9:27 am
 */
public class P14_SearchElementIn2DMatrix {
    public static void main(String[] args) {
        P14_SearchElementIn2DMatrix p14_searchElementIn2DMatrix = new P14_SearchElementIn2DMatrix();

        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};

        System.out.println(p14_searchElementIn2DMatrix.searchMatrix(matrix, 3));

    }

    /**
     * Using Binary Search
     * TC: log(M*N)
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;

        int left = 0;
        int right = row * col - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int pivot = matrix[mid / col][mid % col];

            if (pivot == target) {
                return true;
            } else if (pivot < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }
}

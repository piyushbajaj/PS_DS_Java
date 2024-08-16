package StriverSDESheet.Arrays_Part3;

/**
 * Created by bajajp on 07 Sep, 2022
 */
public class P1_SearchIn2DMatrix {

    public static void main(String[] args) {
        P1_SearchIn2DMatrix p1_searchIn2DMatrix = new P1_SearchIn2DMatrix();
        System.out.println(p1_searchIn2DMatrix.searchMatrix_better(
            new int[][] {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
            }, 23));
    }

    /**
     * TC: O(N+M)
     * SC: O(1)
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int i = 0;
        boolean flag = false;
        for (i = 0; i < row; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][col - 1]) {
                flag = true;
                break;
            }
        }

        for (int j = 0; flag && j < col; j++) {
            if (matrix[i][j] == target) {
                return true;
            }
        }

        return false;
    }

    /**
     * TC: O(log(N*M)
     * SC: O(1)
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix_better(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0;
        int right = row * col - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int pivotMat = matrix[mid / col][mid % col];

            if (pivotMat == target) {
                return true;
            } else if (pivotMat < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}

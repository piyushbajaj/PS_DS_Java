package TakeUForward.CompleteCourse_456.S16_DP.S16_DP_Squares;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S16_DP.S16_DP_Squares
 * <p>
 * User: piyushbajaj
 * Date: 12/01/23
 * Time: 1:13 pm
 * <p>
 * g4g: <a href="https://practice.geeksforgeeks.org/problems/count-square-submatrices-with-all-ones/1">...</a>
 */
public class P2_Count_Square_Submatrices_With_1s {

    public static void main(String[] args) {
        P2_Count_Square_Submatrices_With_1s p2_count_square_submatrices_with_1s =
            new P2_Count_Square_Submatrices_With_1s();
        int[][] mat = {{0, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}};
        System.out.println(p2_count_square_submatrices_with_1s.countSquares(3, 4, mat));
    }

    /**
     * TC: O(2*N*M)
     * SC: O(1)
     *
     * @param N
     * @param M
     * @param mat
     * @return
     */
    public int countSquares(int N, int M, int[][] mat) {
        int countOfSquares = 0;

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if (mat[i][j] == 1) {
                    mat[i][j] =
                        Math.min(Math.min(mat[i][j - 1], mat[i - 1][j]), mat[i - 1][j - 1]) + mat[i][j];
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                countOfSquares += mat[i][j];
            }
        }

        return countOfSquares;
    }
}

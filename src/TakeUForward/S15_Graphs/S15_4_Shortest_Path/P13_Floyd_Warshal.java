package TakeUForward.S15_Graphs.S15_4_Shortest_Path;

import java.util.Arrays;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S15_Graphs.S15_4_Shortest_Path
 * <p>
 * User: piyushbajaj
 * Date: 04/11/22
 * Time: 1:37 pm
 *
 * Link g4g: <a href="https://practice.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1">...</a>
 */
public class P13_Floyd_Warshal {

    /**
     * TC: O(N^3)
     *
     * @param matrix
     */
    public void shortest_distance(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = (int) 1e9;
                }
                if (i == j) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Math.min(matrix[i][k] + matrix[k][j], matrix[i][j]);
                }
            }
        }

        // Checking -ve cycle if ask in some other variation
        for (int i = 0; i < n; i++) {
            if (matrix[i][i] < 0) {
                System.out.println("There exists Negative Cycle");
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1e9) {
                    matrix[i][j] = -1;
                }
            }
        }
    }

    public static void main(String[] args) {
        P13_Floyd_Warshal p13_floyd_warshal = new P13_Floyd_Warshal();

        int[][] matrix = {{0, 2, -1, -1}, {1, 0, 3, -1}, {-1, -1, 0, -1}, {3, 5, 4, 0}};

        p13_floyd_warshal.shortest_distance(matrix);

        System.out.println(Arrays.deepToString(matrix));
    }
}

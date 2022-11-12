package TakeUForward.S15_Graphs.S15_2_BFS_DFS;

import java.util.Arrays;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S15_Graphs.S15_2_BFS_DFS
 * <p>
 * User: piyushbajaj
 * Date: 20/10/22
 * Time: 5:05 pm
 * <p>
 * Link lc: <a href="https://takeuforward.org/graph/surrounded-regions-replace-os-with-xs/">...</a>
 * DFS Approach:
 * TC: O(N*M) + O(N*M*4)
 * SC: O(N*M)
 */
public class P8_Surrounded_Regions {
    public void solve(char[][] board) {
        int row = board.length;
        int col = board[0].length;

        boolean[][] cantBeConverted = new boolean[row][col];

        // Traverse first col and last col
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O' && !cantBeConverted[i][0]) {
                solve_util(board, cantBeConverted, i, 0);
            }
            if (board[i][col - 1] == 'O' && !cantBeConverted[i][col - 1]) {
                solve_util(board, cantBeConverted, i, col - 1);
            }
        }

        // Traverse first row and last row
        for (int j = 0; j < col; j++) {
            if (board[0][j] == 'O' && !cantBeConverted[0][j]) {
                solve_util(board, cantBeConverted, 0, j);
            }
            if (board[row - 1][j] == 'O' && !cantBeConverted[row - 1][j]) {
                solve_util(board, cantBeConverted, row - 1, j);
            }
        }

        // Set the rest of the cell value from O to X
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O' && !cantBeConverted[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void solve_util(char[][] board, boolean[][] cantBeConverted, int row, int col) {
        int n = board.length;
        int m = board[0].length;

        int[] rowDelta = {-1, 0, 1, 0};
        int[] colDelta = {0, 1, 0, -1};

        cantBeConverted[row][col] = true;

        for (int k = 0; k < 4; k++) {
            int neighbourRow = rowDelta[k] + row;
            int neighbourCol = colDelta[k] + col;

            if (neighbourRow >= 0 && neighbourRow < n && neighbourCol >= 0 && neighbourCol < m &&
                board[neighbourRow][neighbourCol] == 'O' && !cantBeConverted[neighbourRow][neighbourCol]) {

                solve_util(board, cantBeConverted, neighbourRow, neighbourCol);
            }
        }
    }


    public static void main(String[] args) {
        char[][] mat = {{'X', 'X', 'X', 'X'},
            {'X', 'O', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'O', 'X', 'X'},
            {'X', 'X', 'O', 'O'}};

        P8_Surrounded_Regions p8_surrounded_regions = new P8_Surrounded_Regions();
        p8_surrounded_regions.solve(mat);
        System.out.println(Arrays.deepToString(mat));
    }


}

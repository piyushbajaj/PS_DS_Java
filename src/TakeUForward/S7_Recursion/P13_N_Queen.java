package TakeUForward.S7_Recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S7_Recursion
 * <p>
 * User: piyushbajaj
 * Date: 18/10/22
 * Time: 4:50 pm
 * <p>
 */
public class P13_N_Queen {

    /**
     * TC: O(N*N)
     *
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        int[] rowArray = new int[n];
        int[] upperDiagonal = new int[2 * n - 1];
        int[] lowerDiagonal = new int[2 * n - 1];


        solveNQueens_util(res, board, 0, n, rowArray, upperDiagonal, lowerDiagonal);

        return res;
    }

    public void solveNQueens_util(List<List<String>> res, char[][] board, int col, int n, int[] rowArray,
                                  int[] upperDiagonal, int[] lowerDiagonal) {
        if (col == board.length) {
            res.add(constructBoard(board));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (rowArray[row] == 0 && upperDiagonal[n - 1 + col - row] == 0 && lowerDiagonal[row + col] == 0) {
                board[row][col] = 'Q';
                upperDiagonal[n - 1 + col - row] = 1;
                lowerDiagonal[row + col] = 1;
                rowArray[row] = 1;
                solveNQueens_util(res, board, col + 1, n, rowArray, upperDiagonal, lowerDiagonal);
                board[row][col] = '.';
                upperDiagonal[n - 1 + col - row] = 0;
                lowerDiagonal[row + col] = 0;
                rowArray[row] = 0;
            }
        }
    }

    private List<String> constructBoard(char[][] board) {
        List<String> res = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }

    public static void main(String[] args) {
        P13_N_Queen p13_n_queen = new P13_N_Queen();
        System.out.println(p13_n_queen.solveNQueens(4));
    }
}

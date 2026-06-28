package Practice2025.Neetcode.ArraysHashing;

import java.util.HashSet;
import java.util.Set;

/**
 * Project: DSAlgo
 * Package: Practice2025.Neetcode.ArraysHashing
 * <p>
 * User: piyushbajaj
 * Date: 15/04/25
 * Time: 9:32 am
 * <p>
 * Approach 1:
 * 1. Check all the row elements one by one should be in the range 1-9
 * 2. Check all the col elements one by one should be in the range 1-9
 * 3. Check all the 3 by 3 cube elements one by one should be in the range 1-9
 */
public class ValidSudoku {

    /**
     * TC: O(N^2 + N^2 + N^2)
     * SC: O(3N)
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        if (board.length != board[0].length) {
            return false;
        }
        int len = board.length;

        for (int ithIndex = 0; ithIndex < len; ithIndex++) {
            Set<Character> characterSet = new HashSet<>();
            for (int jthIndex = 0; jthIndex < len; jthIndex++) {
                if (board[ithIndex][jthIndex] == '.') {
                    continue;
                }
                if (characterSet.contains(board[ithIndex][jthIndex])) {
                    return false;
                }
                characterSet.add(board[ithIndex][jthIndex]);
            }
        }

        for (int jthIndex = 0; jthIndex < len; jthIndex++) {
            Set<Character> characterSet = new HashSet<>();
            for (int ithIndex = 0; ithIndex < len; ithIndex++) {
                if (board[ithIndex][jthIndex] == '.') {
                    continue;
                }
                if (characterSet.contains(board[ithIndex][jthIndex])) {
                    return false;
                }
                characterSet.add(board[ithIndex][jthIndex]);
            }
        }

        for (int square = 0; square < 9; square++) {
            Set<Character> characterSet = new HashSet<>();
            for (int ithIndex = 0; ithIndex < 3; ithIndex++) {
                for (int jthIndex = 0; jthIndex < 3; jthIndex++) {
                    int row = (square / 3) * 3 + ithIndex;
                    int col = (square % 3) * 3 + jthIndex;

                    if (board[row][col] == '.') {
                        continue;
                    }
                    if (characterSet.contains(board[row][col])) {
                        return false;
                    }
                    characterSet.add(board[row][col]);
                }
            }
        }

        return true;


    }

    public static void main(String[] args) {
        ValidSudoku validSudoku = new ValidSudoku();
        char[][] board = {{'1', '2', '.', '.', '3', '.', '.', '.', '.'},
            {'4', '.', '.', '5', '.', '.', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '.', '3'},
            {'5', '.', '.', '.', '6', '.', '.', '.', '4'},
            {'.', '.', '.', '8', '.', '3', '.', '.', '5'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '8'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        System.out.println(validSudoku.isValidSudoku(board));
    }
}

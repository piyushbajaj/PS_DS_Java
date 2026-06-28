package Practice2025.Neetcode.ArraysHashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Project: DSAlgo
 * Package: Practice2025.Neetcode.ArraysHashing
 * <p>
 * User: piyushbajaj
 * Date: 10/06/25
 * Time: 1:55 pm
 */
public class P8_ValidSudoku {

    /**
     * Approach 1: Brute-force
     * 1. Check all the rows, if contains repeated 0-9's using HashSet for each rows
     * 2. Check all the cols, if contains repeated 0-9's using HashSet for each cols
     * 3. Check for each squares, by going them 1 by 1 with 0-9 squares
     * 3.1. row we can get at (square/3)*3 + rowIndex
     * 3.2. col we can get at (square%3)*3 + colIndex
     * <p>
     * TC: O(N*N)
     * SC: O(N*N)
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku1(char[][] board) {
        int rowLen = board.length;
        int colLen = board[0].length;
        // check for the rows first
        for (int rowIndex = 0; rowIndex < rowLen; rowIndex++) {
            Set<Character> isSeen = new HashSet<>();
            for (int colIndex = 0; colIndex < colLen; colIndex++) {
                if (board[rowIndex][colIndex] == '.') {
                    continue;
                }

                if (isSeen.contains(board[rowIndex][colIndex])) {
                    return false;
                }
                isSeen.add(board[rowIndex][colIndex]);
            }
        }

        // check for the cols
        for (int colIndex = 0; colIndex < colLen; colIndex++) {
            Set<Character> isSeen = new HashSet<>();
            for (int rowIndex = 0; rowIndex < rowLen; rowIndex++) {
                if (board[rowIndex][colIndex] == '.') {
                    continue;
                }

                if (isSeen.contains(board[rowIndex][colIndex])) {
                    return false;
                }
                isSeen.add(board[rowIndex][colIndex]);
            }
        }

        // check for the cubes
        for (int square = 0; square < 9; square++) {
            Set<Character> isSeen = new HashSet<>();

            for (int rowIndex = 0; rowIndex < 3; rowIndex++) {
                for (int colIndex = 0; colIndex < 3; colIndex++) {
                    int rowCell = (square / 3) * 3 + rowIndex;
                    int colCell = (square % 3) * 3 + colIndex;
                    if (board[rowCell][colCell] == '.') {
                        continue;
                    }

                    if (isSeen.contains(board[rowCell][colCell])) {
                        return false;
                    }
                    isSeen.add(board[rowCell][colCell]);
                }
            }
        }

        return true;

    }

    /**
     * Using HashMap, pass it on one go
     * 1. Create 3 Maps: rowHashMap, colHashMap, squareHashMap
     * 2. Loop from 0 to 9 for rows
     * 2.1. Loop from 0 to 0 for cols
     * 2.1.1. Check if row, col, squareKey is part of hashMap
     * 2.1.2. If not, add them to the hashMap
     * <p>
     * TC: O(N*N)
     * SC: O(N*N)
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku2(char[][] board) {
        Map<Integer, Set<Character>> rowHashMap = new HashMap<>();
        Map<Integer, Set<Character>> colHashMap = new HashMap<>();
        Map<String, Set<Character>> squareHashMap = new HashMap<>();

        for (int rowIndex = 0; rowIndex < 9; rowIndex++) {
            for (int colIndex = 0; colIndex < 9; colIndex++) {
                if (board[rowIndex][colIndex] == '.') {
                    continue;
                }

                String squareKey = (rowIndex / 3) + "," + (colIndex / 3);

                if (rowHashMap.computeIfAbsent(rowIndex, k -> new HashSet<>()).contains(board[rowIndex][colIndex]) ||
                    colHashMap.computeIfAbsent(colIndex, k -> new HashSet<>()).contains(board[rowIndex][colIndex]) ||
                    squareHashMap.computeIfAbsent(squareKey, k -> new HashSet<>())
                        .contains(board[rowIndex][colIndex])) {
                    return false;
                }

                rowHashMap.get(rowIndex).add(board[rowIndex][colIndex]);
                colHashMap.get(colIndex).add(board[rowIndex][colIndex]);
                squareHashMap.get(squareKey).add(board[rowIndex][colIndex]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        P8_ValidSudoku validSudoku = new P8_ValidSudoku();

        char[][] board = {
            {'1', '2', '.', '.', '3', '.', '.', '.', '.'},
            {'4', '.', '.', '5', '.', '.', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '.', '3'},
            {'5', '.', '.', '.', '6', '.', '.', '.', '4'},
            {'.', '.', '.', '8', '.', '3', '.', '.', '5'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '8'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        System.out.println(validSudoku.isValidSudoku1(board));
        System.out.println(validSudoku.isValidSudoku2(board));
    }
}

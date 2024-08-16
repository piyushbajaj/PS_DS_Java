package Striver.Session_April2024.Day1_Arrays;

import javafx.util.Pair;

/**
 * Project: DSAlgo
 * Package: Striver.Session_April2024.Day1_Arrays
 * <p>
 * User: piyushbajaj
 * Date: 30/04/24
 * Time: 4:37 pm
 */
public class P1_SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        for (int rowIndex = 0; rowIndex < rowLen; rowIndex++) {
            for (int colIndex = 0; colIndex < colLen; colIndex++) {
                if (matrix[rowIndex][colIndex] == 0) {

                }
            }
        }

        Pair<Integer, Integer> integerPair = new Pair<>(0, 0);
    }

    public static void main(String[] args) {

    }
}

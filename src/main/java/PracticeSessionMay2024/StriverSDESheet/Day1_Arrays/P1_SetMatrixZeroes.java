package PracticeSessionMay2024.StriverSDESheet.Day1_Arrays;

import javafx.util.Pair;

/**
 * Project: DSAlgo
 * Package: PracticeSessionMay2024.StriverSDESheet.Day1_Arrays
 * <p>
 * User: piyushbajaj
 * Date: 21/07/24
 * Time: 11:13 am
 */
public class P1_SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;

//        Pair pair

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if(matrix[i][j] == 0) {

                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        P1_SetMatrixZeroes p1SetMatrixZeroes = new P1_SetMatrixZeroes();
        p1SetMatrixZeroes.setZeroes(matrix);
    }
}

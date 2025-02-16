package Session.May2024.StriverSDESheet.Day1_Arrays;

import java.util.ArrayList;
import java.util.Arrays;

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

    /**
     * TC: O(N*M) + O(k) * O(N+M)
     * SC: O(k)
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        ArrayList<Pair<Integer, Integer>> pairList = new ArrayList<>();

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if(matrix[i][j] == 0) {
                    pairList.add(new Pair<>(i, j));
                }
            }
        }

        for (Pair<Integer, Integer> pair: pairList) {
            int ithValue = pair.getKey();
            int jthValue = pair.getValue();

            for(int i = 0; i < rowLen; i++) {
                matrix[i][jthValue] = 0;
            }

            for(int j = 0; j < colLen; j++) {
                matrix[ithValue][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        P1_SetMatrixZeroes p1SetMatrixZeroes = new P1_SetMatrixZeroes();
        p1SetMatrixZeroes.setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}

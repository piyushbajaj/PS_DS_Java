package LC_Contest.BiWeekly_26thNov;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: DS_Algo
 * Package: LC_Contest.BiWeekly_26thNov
 * <p>
 * User: piyushbajaj
 * Date: 26/11/22
 * Time: 8:48 pm
 */
public class P2_Ones_And_Zeros {
    public static void main(String[] args) {

    }

    public int[][] onesMinusZeros(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] result = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int countOnesInRow = getCount(grid, i, j).get(0);
                int countZerosInRow = getCount(grid, i, j).get(1);
                int countOnesInCol = getCount(grid, i, j).get(2);
                int countZerosInCol = getCount(grid, i, j).get(3);

                result[i][j] = countOnesInRow + countOnesInCol - countZerosInRow - countZerosInCol;
            }
        }

        return result;
    }

    public List<Integer> getCount(int[][] grid, int a, int b) {
        int n = grid.length;
        int m = grid[0].length;
        List<Integer> result = new ArrayList<>();

        int countOnesInRow = 0;
        int countZerosInRow = 0;
        int countOnesInCol = 0;
        int countZerosInCol = 0;

        for (int i = 0; i < n; i++) {
            if (grid[i][b] == 0) {
                countZerosInCol++;
            } else if (grid[i][b] == 1) {
                countOnesInCol++;
            }
        }

        for (int j = 0; j < m; j++) {
            if (grid[a][j] == 0) {
                countZerosInRow++;
            } else if (grid[a][j] == 1) {
                countOnesInRow++;
            }
        }

        result.add(countOnesInRow);
        result.add(countZerosInRow);
        result.add(countOnesInCol);
        result.add(countZerosInCol);

        return result;
    }
}

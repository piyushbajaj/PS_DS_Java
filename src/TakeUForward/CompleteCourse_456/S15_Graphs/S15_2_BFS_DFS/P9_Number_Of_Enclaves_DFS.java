package TakeUForward.CompleteCourse_456.S15_Graphs.S15_2_BFS_DFS;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S15_Graphs.S15_2_BFS_DFS
 * <p>
 * User: piyushbajaj
 * Date: 21/10/22
 * Time: 2:05 pm
 * <p>
 */
public class P9_Number_Of_Enclaves_DFS {

    public int numEnclaves(int[][] grid) {
        int n = grid.length; // row len
        int m = grid[0].length; // col len

        boolean[][] isBoundaryCrossing = new boolean[n][m];

        // Checking 1st and last column
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1 && !isBoundaryCrossing[i][0]) {
                numEnclaves_util(grid, isBoundaryCrossing, i, 0);
            }

            if (grid[i][m - 1] == 1 && !isBoundaryCrossing[i][m - 1]) {
                numEnclaves_util(grid, isBoundaryCrossing, i, m - 1);
            }
        }

        // Checking 1st and last row
        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1 && !isBoundaryCrossing[0][j]) {
                numEnclaves_util(grid, isBoundaryCrossing, 0, j);
            }

            if (grid[n - 1][j] == 1 && !isBoundaryCrossing[n - 1][j]) {
                numEnclaves_util(grid, isBoundaryCrossing, n - 1, j);
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !isBoundaryCrossing[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }

    public void numEnclaves_util(int[][] grid, boolean[][] isBoundaryCrossing, int row, int col) {
        int n = grid.length; // row len
        int m = grid[0].length; // col len

        isBoundaryCrossing[row][col] = true;

        int[] rowDelta = {-1, 0, 1, 0};
        int[] colDelta = {0, 1, 0, -1};

        for (int k = 0; k < 4; k++) {
            int nRow = rowDelta[k] + row;
            int nCol = colDelta[k] + col;

            if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == 1 &&
                !isBoundaryCrossing[nRow][nCol]) {
                numEnclaves_util(grid, isBoundaryCrossing, nRow, nCol);
            }

        }
    }

    public static void main(String[] args) {
        P9_Number_Of_Enclaves_DFS p9_number_of_enclaves = new P9_Number_Of_Enclaves_DFS();

        int[][] grid = {{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};

        System.out.println(p9_number_of_enclaves.numEnclaves(grid));

    }
}

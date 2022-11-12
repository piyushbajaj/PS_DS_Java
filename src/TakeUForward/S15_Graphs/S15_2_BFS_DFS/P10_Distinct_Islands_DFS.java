package TakeUForward.S15_Graphs.S15_2_BFS_DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S15_Graphs.S15_2_BFS_DFS
 * <p>
 * User: piyushbajaj
 * Date: 22/10/22
 * Time: 9:16 am
 * <p>
 * Link: <a href="https://practice.geeksforgeeks.org/problems/number-of-distinct-islands/1">...</a>
 */
public class P10_Distinct_Islands_DFS {
    static class Pair {
        int rowIndex, colIndex;

        Pair(int rowIndex, int colIndex) {
            this.rowIndex = rowIndex;
            this.colIndex = colIndex;
        }
    }

    /**
     * DFS Approach
     * TC:
     * SC:
     *
     * @param grid
     * @return
     */
    public int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Set<List<String>> result = new HashSet<>();
        boolean[][] isVisited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!isVisited[i][j] && grid[i][j] == 1) {
                    List<String> arrayList = new ArrayList<>();
                    countDistinctIslands_util(grid, isVisited, result, new Pair(i, j), arrayList, i, j);
                    result.add(new ArrayList<>(arrayList));
                }
            }
        }
        return result.size();
    }

    public void countDistinctIslands_util(int[][] grid, boolean[][] isVisited, Set<List<String>> result, Pair pair,
                                          List<String> arrayList, int row, int col) {
        int n = grid.length;
        int m = grid[0].length;

        int baseRow = pair.rowIndex;
        int baseCol = pair.colIndex;

        arrayList.add(toString(row - baseRow, col - baseCol));

        isVisited[row][col] = true;

        int[] deltaRow = {0, 1, 0, -1};
        int[] deltaCol = {1, 0, -1, 0};

        for (int k = 0; k < 4; k++) {
            int nRow = deltaRow[k] + row;
            int nCol = deltaCol[k] + col;

            if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && !isVisited[nRow][nCol] && grid[nRow][nCol] == 1) {
                countDistinctIslands_util(grid, isVisited, result, pair, arrayList, nRow, nCol);
            }
        }
    }

    private String toString(int i, int i1) {
        return Integer.toString(i).concat(" ").concat(Integer.toString(i1));
    }

    public static void main(String[] args) {
        P10_Distinct_Islands_DFS p10_distinct_islands_dfs = new P10_Distinct_Islands_DFS();

        int[][] grid1 = {
            {1, 1, 0, 1, 1},
            {1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1},
            {1, 1, 0, 1, 1}};

        System.out.println(p10_distinct_islands_dfs.countDistinctIslands(grid1));
    }
}

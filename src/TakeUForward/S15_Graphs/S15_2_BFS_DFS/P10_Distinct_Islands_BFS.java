package TakeUForward.S15_Graphs.S15_2_BFS_DFS;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S15_Graphs.S15_2_BFS_DFS
 * <p>
 * User: piyushbajaj
 * Date: 21/10/22
 * Time: 7:43 pm
 * <p>
 * Link g4g: <a href="https://practice.geeksforgeeks.org/problems/number-of-distinct-islands/1">...</a>
 */
public class P10_Distinct_Islands_BFS {

    static class Pair {
        int rowIndex, colIndex;

        Pair(int rowIndex, int colIndex) {
            this.rowIndex = rowIndex;
            this.colIndex = colIndex;
        }
    }

    /**
     * BFS Approach
     * TC:
     * SC:
     *
     * @param grid
     * @return
     */
    public int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Set<Map<Integer, Integer>> result = new HashSet<>();
        Queue<Pair> pairQueue = new LinkedList<>();
        boolean[][] isVisited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!isVisited[i][j] && grid[i][j] == 1) {
                    pairQueue.add(new Pair(i, j));
                    countDistinctIslands_util(grid, isVisited, result, pairQueue);

                }
            }
        }

        return result.size();
    }

    public void countDistinctIslands_util(int[][] grid, boolean[][] isVisited, Set<Map<Integer, Integer>> result,
                                          Queue<Pair> pairQueue) {
        int n = grid.length;
        int m = grid[0].length;

        Map<Integer, Integer> subResult = new HashMap<>();

        int baseRow = pairQueue.peek().rowIndex;
        int baseCol = pairQueue.peek().colIndex;

        while (!pairQueue.isEmpty()) {
            int row = pairQueue.peek().rowIndex;
            int col = pairQueue.peek().colIndex;
            pairQueue.poll();
            subResult.put(row - baseRow, col - baseCol);
            isVisited[row][col] = true;

            int[] deltaRow = {0, 1, 0, -1};
            int[] deltaCol = {1, 0, -1, 0};

            for (int k = 0; k < 4; k++) {
                int nRow = deltaRow[k] + row;
                int nCol = deltaCol[k] + col;

                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && !isVisited[nRow][nCol] && grid[nRow][nCol] == 1) {
                    pairQueue.add(new Pair(nRow, nCol));
                }
            }
        }

        result.add(new HashMap<>(subResult));
    }

    public static void main(String[] args) {
        P10_Distinct_Islands_BFS p10_distinct_islands = new P10_Distinct_Islands_BFS();

        int[][] grid = {{1, 1, 0, 0, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1},
            {0, 0, 0, 1, 1}};

        int[][] grid1 = {{1, 1, 0, 1, 1},
            {1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1},
            {1, 1, 0, 1, 1}};


        System.out.println(p10_distinct_islands.countDistinctIslands(grid1));
    }
}

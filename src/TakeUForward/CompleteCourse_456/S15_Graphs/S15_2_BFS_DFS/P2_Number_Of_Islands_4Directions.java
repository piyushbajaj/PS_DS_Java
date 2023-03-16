package TakeUForward.CompleteCourse_456.S15_Graphs.S15_2_BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

import javafx.util.Pair;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S15_Graphs.S15_2_BFS_DFS
 * <p>
 * User: piyushbajaj
 * Date: 10/10/22
 * Time: 10:10 am
 * <p>
 * Followed BFS approach downside, same can be done using DFS also
 * TC: O(N*M)
 * SC: O(N*M)
 */
public class P2_Number_Of_Islands_4Directions {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;

        boolean[][] visited = new boolean[m][n];

        int[] ithDelta = {0, -1, 0, 1};
        int[] jthDelta = {-1, 0, 1, 0};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    count++;
                    numIslands_util(grid, visited, i, j, ithDelta, jthDelta);
                }
            }
        }
        return count;
    }

    public void numIslands_util(char[][] grid, boolean[][] visited, int startRow, int startCol, int[] ithDelta,
                                int[] jthDelta) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair<Integer, Integer>> pairQueue = new LinkedList<>();
        pairQueue.add(new Pair<>(startRow, startCol));
        // mark the node visited true
        visited[startRow][startCol] = true;

        while (!pairQueue.isEmpty()) {
            Pair<Integer, Integer> pairElement = pairQueue.poll();
            assert pairElement != null;
            int ithIndex = pairElement.getKey();
            int jthIndex = pairElement.getValue();

            // traverse all the neighbours, using delta technique, only 4 direction so i from 0 to 3

            for (int k = 0; k < 4; k++) {
                // including this condition for only horizontal and vertical path
                int neighbourIth = ithDelta[k] + ithIndex;
                int neighbourJth = jthDelta[k] + jthIndex;

                if (neighbourIth >= 0 && neighbourIth < m && neighbourJth >= 0 && neighbourJth < n &&
                    !visited[neighbourIth][neighbourJth] && grid[neighbourIth][neighbourJth] == '1') {
                    visited[neighbourIth][neighbourJth] = true;
                    pairQueue.add(new Pair<>(neighbourIth, neighbourJth));
                }
            }
        }
    }

    public static void main(String[] args) {
        P2_Number_Of_Islands_4Directions p2_number_of_islands_4Directions = new P2_Number_Of_Islands_4Directions();
        char[][] grid = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}};

        char[][] grid1 = {
            {'0', '1', '1', '0'},
            {'0', '1', '1', '0'},
            {'0', '0', '1', '0'},
            {'0', '0', '0', '0'},
            {'1', '1', '0', '1'}};

        char[][] grid2 = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };

        System.out.println(p2_number_of_islands_4Directions.numIslands(grid2));
    }
}

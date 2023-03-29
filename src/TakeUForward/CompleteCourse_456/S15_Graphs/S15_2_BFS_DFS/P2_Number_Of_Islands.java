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
 * Time: 8:36 am
 * <p>
 * TC: O(N^2)
 * SC: O(N^2)
 * <p>
 * g4g: <a href="https://practice.geeksforgeeks.org/problems/find-the-number-of-islands/1">...</a>
 */
public class P2_Number_Of_Islands {
    public static void main(String[] args) {
        P2_Number_Of_Islands p2_number_of_islands = new P2_Number_Of_Islands();
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

        System.out.println(p2_number_of_islands.numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;

        boolean[][] visited = new boolean[m][n];

        Queue<Pair<Integer, Integer>> pairQueue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    pairQueue.add(new Pair<>(i, j));
                    count++;
                    numIslands_util(grid, visited, pairQueue);
                }
            }
        }
        return count;

    }

    public void numIslands_util(char[][] grid, boolean[][] visited, Queue<Pair<Integer, Integer>> pairQueue) {
        int m = grid.length;
        int n = grid[0].length;

        while (!pairQueue.isEmpty()) {
            Pair<Integer, Integer> pairElement = pairQueue.poll();
            assert pairElement != null;
            int ithIndex = pairElement.getKey();
            int jthIndex = pairElement.getValue();

            // mark the node visited true
            visited[ithIndex][jthIndex] = true;

            // traverse all the neighbours, using delta technique

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {

                    int neighbourIth = i + ithIndex;
                    int neighbourJth = j + jthIndex;

                    if (neighbourIth >= 0 && neighbourIth < m && neighbourJth >= 0 && neighbourJth < n &&
                        !visited[neighbourIth][neighbourJth] && grid[neighbourIth][neighbourJth] == '1') {
                        visited[ithIndex][jthIndex] = true;
                        pairQueue.add(new Pair<>(neighbourIth, neighbourJth));
                    }
                }
            }
        }
    }
}

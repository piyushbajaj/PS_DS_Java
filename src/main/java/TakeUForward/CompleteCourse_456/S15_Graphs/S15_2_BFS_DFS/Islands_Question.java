package TakeUForward.CompleteCourse_456.S15_Graphs.S15_2_BFS_DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Project: DSAlgo
 * Package: TakeUForward.CompleteCourse_456.S15_Graphs.S15_2_BFS_DFS
 * <p>
 * User: piyushbajaj
 * Date: 27/03/25
 * Time: 11:38 pm
 */
public class Islands_Question {

    static class Pair {
        int first, second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public int numIslands(char[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        boolean[][] visited = new boolean[rowLen][colLen];
        Queue<Pair> queue = new LinkedList<>();
        int islandCount = 0;

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    islandCount++;
                    queue.add(new Pair(i, j));
                    numIslands_util(grid, visited, queue);
                }
            }
        }

        return islandCount;
    }

    public void numIslands_util(char[][] grid, boolean[][] visited, Queue<Pair> queue) {
        int rowLen = grid.length;
        int colLen = grid[0].length;

        while (!queue.isEmpty()) {
            int ithPosition = queue.peek().first;
            int jthPosition = queue.peek().second;
            queue.poll();

            visited[ithPosition][jthPosition] = true;

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int ithNeighbour = i + ithPosition;
                    int jthNeighbour = j + jthPosition;

                    if (ithNeighbour >= 0 && ithNeighbour < rowLen && jthNeighbour >= 0 && jthNeighbour < colLen &&
                        grid[ithNeighbour][jthNeighbour] == '1' && !visited[ithNeighbour][jthNeighbour]) {
                        visited[ithNeighbour][jthNeighbour] = true;
                        queue.add(new Pair(ithNeighbour, jthNeighbour));
                    }
                }
            }
        }
    }

    /**
     * TC: O(N*M*log(N*M) + N*M*4)
     * SC: O(N*M)
     *
     * @param grid
     * @return
     */
    public int countDistinctIslands(char[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        boolean[][] visited = new boolean[rowLen][colLen];
        Queue<Pair> queue = new LinkedList<>();
        Set<List<String>> result = new HashSet<>();

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    queue.add(new Pair(i, j));
                    countDistinctIslands_util(grid, visited, queue, result);
                }
            }
        }

        return result.size();
    }

    // Traverse in 4 directions
    public void countDistinctIslands_util(char[][] grid, boolean[][] visited, Queue<Pair> queue,
                                          Set<List<String>> result) {
        int rowLen = grid.length;
        int colLen = grid[0].length;

        List<String> arrayList = new ArrayList<>();

        assert queue.peek() != null;
        int ithBasePosition = queue.peek().first;
        int jthBasePosition = queue.peek().second;

        while (!queue.isEmpty()) {
            int ithPosition = queue.peek().first;
            int jthPosition = queue.peek().second;
            queue.poll();

            arrayList.add(toString(ithPosition - ithBasePosition, jthPosition - jthBasePosition));

            visited[ithPosition][jthPosition] = true;

            int[] neighbourRow = {0, 1, 0, -1};
            int[] neighbourCol = {1, 0, -1, 0};

            for (int k = 0; k < 4; k++) {
                int ithNeighbour = neighbourRow[k] + ithPosition;
                int jthNeighbour = neighbourCol[k] + jthPosition;

                if (ithNeighbour >= 0 && ithNeighbour < rowLen && jthNeighbour >= 0 && jthNeighbour < colLen &&
                    grid[ithNeighbour][jthNeighbour] == '1' && !visited[ithNeighbour][jthNeighbour]) {
                    visited[ithNeighbour][jthNeighbour] = true;
                    queue.add(new Pair(ithNeighbour, jthNeighbour));
                }
            }
        }

        result.add(new ArrayList<>(arrayList));
    }

    private String toString(int i, int i1) {
        return Integer.toString(i).concat(" ").concat(Integer.toString(i1));
    }

    public static void main(String[] args) {
        Islands_Question islandsQuestion = new Islands_Question();
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

        System.out.println(islandsQuestion.numIslands(grid1));

        System.out.println(islandsQuestion.countDistinctIslands(grid1));
    }
}

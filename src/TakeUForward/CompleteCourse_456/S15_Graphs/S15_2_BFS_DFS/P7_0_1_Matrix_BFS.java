package TakeUForward.CompleteCourse_456.S15_Graphs.S15_2_BFS_DFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S15_Graphs.S15_2_BFS_DFS
 * <p>
 * User: piyushbajaj
 * Date: 11/10/22
 * Time: 2:02 pm
 * <p>
 * Link Striver: <a href="https://takeuforward.org/graph/distance-of-nearest-cell-having-1/">...</a>
 * Link g4g: <a href="https://practice.geeksforgeeks.org/problems/distance-of-nearest-cell-having-1-1587115620/1">...</a>
 * Link leetcode:
 */
public class P7_0_1_Matrix_BFS {

    static class Pair {
        int rowVal;
        int colVal;
        int dist;

        Pair(int rowVal, int colVal, int dist) {
            this.rowVal = rowVal;
            this.colVal = colVal;
            this.dist = dist;
        }
    }

    public int[][] nearest_1(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int[][] distance = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                distance[i][j] = -1;
            }
        }

        boolean[][] isVisited = new boolean[row][col];

        Queue<Pair> pairQueue = new LinkedList<>();

        // Add all the cell which has distance as 1 as default
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1 && !isVisited[i][j]) {
                    pairQueue.add(new Pair(i, j, 0));
                    distance[i][j] = 0;
                }
            }
        }
        // call for the remaining elements
        nearest_1_util(grid, distance, isVisited, pairQueue);

        return distance;
    }

    /**
     * BFS Approach
     * TC: O(2(N*M)) + O(N+M) [Queue] * 4
     * SC: O(N+M) + O(N*M) + O(N*M)
     *
     * @param grid
     * @param distance
     * @param isVisited
     * @param pairQueue
     */
    public void nearest_1_util(int[][] grid, int[][] distance, boolean[][] isVisited, Queue<Pair> pairQueue) {
        int row = grid.length;
        int col = grid[0].length;

        int[] rowDelta = {-1, 0, 1, 0};
        int[] colDelta = {0, 1, 0, -1};

        while (!pairQueue.isEmpty()) {
            int rowIndex = pairQueue.peek().rowVal;
            int colIndex = pairQueue.peek().colVal;
            int currDist = pairQueue.peek().dist;
            pairQueue.poll();

            for (int k = 0; k < 4; k++) {
                int neighbourIthIndex = rowIndex + rowDelta[k];
                int neighbourJthIndex = colIndex + colDelta[k];

                if (neighbourIthIndex >= 0 && neighbourIthIndex < row &&
                    neighbourJthIndex >= 0 && neighbourJthIndex < col &&
                    grid[neighbourIthIndex][neighbourJthIndex] == 0 &&
                    !isVisited[neighbourIthIndex][neighbourJthIndex]) {

                    isVisited[neighbourIthIndex][neighbourJthIndex] = true;
                    distance[neighbourIthIndex][neighbourJthIndex] = currDist + 1;
                    // push this into the queue for future operations
                    pairQueue.add(new Pair(neighbourIthIndex, neighbourJthIndex, currDist + 1));
                }
            }
        }
    }


    public int[][] nearest_0(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int[][] distance = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                distance[i][j] = -1;
            }
        }

        boolean[][] isVisited = new boolean[row][col];

        Queue<Pair> pairQueue = new LinkedList<>();

        // Add all the cell which has distance as 1 as default
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0 && !isVisited[i][j]) {
                    pairQueue.add(new Pair(i, j, 0));
                    distance[i][j] = 0;
                }
            }
        }
        // call for the remaining elements
        nearest_0_util(grid, distance, isVisited, pairQueue);

        return distance;
    }

    /**
     * BFS Approach
     * TC: O(2(N*M)) + O(N+M) [Queue] * 4
     * SC: O(N+M) + O(N*M) + O(N*M)
     *
     * @param grid
     * @param distance
     * @param isVisited
     * @param pairQueue
     */
    public void nearest_0_util(int[][] grid, int[][] distance, boolean[][] isVisited, Queue<Pair> pairQueue) {
        int row = grid.length;
        int col = grid[0].length;

        int[] rowDelta = {-1, 0, 1, 0};
        int[] colDelta = {0, 1, 0, -1};

        while (!pairQueue.isEmpty()) {
            int rowIndex = pairQueue.peek().rowVal;
            int colIndex = pairQueue.peek().colVal;
            int currDist = pairQueue.peek().dist;
            pairQueue.poll();

            for (int k = 0; k < 4; k++) {
                int neighbourIthIndex = rowIndex + rowDelta[k];
                int neighbourJthIndex = colIndex + colDelta[k];

                if (neighbourIthIndex >= 0 && neighbourIthIndex < row &&
                    neighbourJthIndex >= 0 && neighbourJthIndex < col &&
                    grid[neighbourIthIndex][neighbourJthIndex] == 1 &&
                    !isVisited[neighbourIthIndex][neighbourJthIndex]) {

                    isVisited[neighbourIthIndex][neighbourJthIndex] = true;
                    distance[neighbourIthIndex][neighbourJthIndex] = currDist + 1;
                    // push this into the queue for future operations
                    pairQueue.add(new Pair(neighbourIthIndex, neighbourJthIndex, currDist + 1));
                }
            }
        }
    }

    public static void main(String[] args) {
        P7_0_1_Matrix_BFS p7_0_1_matrix_bfs = new P7_0_1_Matrix_BFS();
        int[][] grid = {{0, 0, 0},
            {0, 1, 0},
            {1, 0, 1}};

        System.out.println(Arrays.deepToString(p7_0_1_matrix_bfs.nearest_1(grid)));


        int[][] grid1 = {{0, 0, 0},
            {0, 1, 0},
            {1, 1, 1}};
        System.out.println(Arrays.deepToString(p7_0_1_matrix_bfs.nearest_0(grid1)));
    }
}

package TakeUForward.CompleteCourse_456.S15_Graphs.S15_4_Shortest_Path;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S15_Graphs.S15_4_Shortest_Path
 * <p>
 * User: piyushbajaj
 * Date: 02/11/22
 * Time: 9:45 am
 * <p>
 * Link: <a href="https://practice.geeksforgeeks.org/problems/shortest-path-in-a-binary-maze-1655453161/1">...</a>
 */
public class P7_Shortest_Distance_In_Binary_Maze {

    static class Tuple {
        int distance;
        int row, col;

        Tuple(int distance, int row, int col) {
            this.distance = distance;
            this.row = row;
            this.col = col;
        }
    }

    /**
     * Approach:
     * 1. Use queue to store distance, row, col
     * 2. Once it reaches the destination, stop and return the distance
     * TC: O(N*M*4)
     *
     * @param grid
     * @param source
     * @param destination
     * @return
     */
    public int shortestPath(int[][] grid, int[] source, int[] destination) {
        int rowLen = grid.length;
        int colLen = grid[0].length;

        if (source[0] == destination[0] && source[1] == destination[1]) {
            return 0;
        }

        int[][] distance = new int[rowLen][colLen];
        Queue<Tuple> queue = new LinkedList<>();

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }

        queue.add(new Tuple(0, source[0], source[1]));
        distance[source[0]][source[1]] = 0;

        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, -1, 0, 1};

        while (!queue.isEmpty()) {
            int currDistance = queue.peek().distance;
            int currRowIndex = queue.peek().row;
            int currColIndex = queue.peek().col;
            queue.poll();

            for (int k = 0; k < 4; k++) {
                int nRow = currRowIndex + deltaRow[k];
                int nCol = currColIndex + deltaCol[k];

                if (nRow >= 0 && nRow < rowLen && nCol >= 0 && nCol < colLen && grid[nRow][nCol] == 1 &&
                    currDistance + grid[nRow][nCol] < distance[nRow][nCol]) {
                    distance[nRow][nCol] = currDistance + grid[nRow][nCol];

                    if (nRow == destination[0] && nCol == destination[1]) {
                        return distance[nRow][nCol];
                    }

                    queue.add(new Tuple(distance[nRow][nCol], nRow, nCol));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1, 1},
            {1, 1, 0, 1},
            {1, 1, 1, 1},
            {1, 1, 0, 0},
            {1, 0, 0, 1}};

        P7_Shortest_Distance_In_Binary_Maze p7_shortest_distance_in_binary_maze =
            new P7_Shortest_Distance_In_Binary_Maze();

        System.out.println(p7_shortest_distance_in_binary_maze.shortestPath(grid, new int[] {0, 1}, new int[] {2, 2}));
    }
}

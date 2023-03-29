package TakeUForward.CompleteCourse_456.S15_Graphs.S15_4_Shortest_Path;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S15_Graphs.S15_4_Shortest_Path
 * <p>
 * User: piyushbajaj
 * Date: 02/11/22
 * Time: 12:54 pm
 * <p>
 * Link g4g: <a href="https://practice.geeksforgeeks.org/problems/path-with-minimum-effort/1">...</a>
 * Link lc: <a href="https://leetcode.com/problems/path-with-minimum-effort/">...</a>
 */
public class P8_Path_With_Minimum_Effort {

    public static void main(String[] args) {
        P8_Path_With_Minimum_Effort p8_path_with_minimum_effort = new P8_Path_With_Minimum_Effort();

        int[][] heights = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};

        System.out.println(p8_path_with_minimum_effort.minimumEffortPath(heights));
    }

    /**
     * Approach: Followe Dijkstras Algo
     * TC: E log V -> N*M*4*log (N*M)
     *
     * @param heights
     * @return
     */
    public int minimumEffortPath(int[][] heights) {
        int rowLen = heights.length;
        int colLen = heights[0].length;

        int[][] distance = new int[rowLen][colLen];

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Tuple> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a.difference));

        distance[0][0] = 0;
        priorityQueue.add(new Tuple(0, 0, 0));

        while (!priorityQueue.isEmpty()) {
            int currRowIndex = priorityQueue.peek().row;
            int currColIndex = priorityQueue.peek().col;
            int currDifference = priorityQueue.peek().difference;
            priorityQueue.poll();

            if (currRowIndex == rowLen - 1 && currColIndex == colLen - 1) {
                return currDifference;
            }

            int[] deltaRow = {-1, 0, 1, 0};
            int[] deltaCol = {0, 1, 0, -1};

            for (int k = 0; k < 4; k++) {
                int nRow = currRowIndex + deltaRow[k];
                int nCol = currColIndex + deltaCol[k];

                if (nRow >= 0 && nRow < rowLen && nCol >= 0 && nCol < colLen) {
                    int maxDiff =
                        Math.max(Math.abs(heights[nRow][nCol] - heights[currRowIndex][currColIndex]), currDifference);

                    if (maxDiff < distance[nRow][nCol]) {
                        distance[nRow][nCol] = maxDiff;
                        priorityQueue.add(new Tuple(distance[nRow][nCol], nRow, nCol));
                    }
                }
            }
        }

        return 0;
    }

    static class Tuple {
        int difference, row, col;

        Tuple(int difference, int row, int col) {
            this.difference = difference;
            this.row = row;
            this.col = col;
        }
    }
}

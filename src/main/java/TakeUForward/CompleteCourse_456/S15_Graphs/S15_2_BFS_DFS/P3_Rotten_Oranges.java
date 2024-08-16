package TakeUForward.CompleteCourse_456.S15_Graphs.S15_2_BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S15_Graphs.S15_2_BFS_DFS
 * <p>
 * User: piyushbajaj
 * Date: 10/10/22
 * Time: 1:48 pm
 * <p>
 * lc: <a href="https://leetcode.com/problems/rotting-oranges/">...</a>
 */
public class P3_Rotten_Oranges {

    public static void main(String[] args) {
        P3_Rotten_Oranges p3_rotten_oranges = new P3_Rotten_Oranges();
        int[][] grid = {
            {2, 1, 1}, {1, 1, 0}, {0, 1, 1}
        };

        int[][] grid1 = {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};

        System.out.println(p3_rotten_oranges.orangesRotting(grid));
    }

    /**
     * Approach using BFS
     * TC:
     *
     * @param grid
     * @return
     */
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair> queue = new LinkedList<>();
        boolean[][] rottenVisited = new boolean[m][n];

        int maxDistance = 0;
        int cntFresh = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2 && !rottenVisited[i][j]) {
                    queue.add(new Pair(i, j, 0));
                    rottenVisited[i][j] = true;
                }

                if (grid[i][j] == 1) {
                    cntFresh++;
                }
            }
        }

        int[] ithDelta = {0, -1, 0, 1};
        int[] jthDelta = {-1, 0, 1, 0};

        int cntFreshToRotten = 0;
        while (!queue.isEmpty()) {
            Pair currElement = queue.poll();
            int ithIndex = currElement.first;
            int jthIndex = currElement.second;
            int distance = currElement.distance;


            for (int k = 0; k < 4; k++) {
                int neighbourIth = ithIndex + ithDelta[k];
                int neighbourJth = jthIndex + jthDelta[k];

                if (neighbourIth >= 0 && neighbourIth < m && neighbourJth >= 0 && neighbourJth < n &&
                    grid[neighbourIth][neighbourJth] == 1 &&
                    !rottenVisited[neighbourIth][neighbourJth]) {

                    rottenVisited[neighbourIth][neighbourJth] = true;
                    queue.add(new Pair(neighbourIth, neighbourJth, distance + 1));
                    cntFreshToRotten++;
                }
            }

            maxDistance = Math.max(maxDistance, distance);
        }

        if (cntFresh != cntFreshToRotten) {
            return -1;
        }
        return maxDistance;
    }

    static class Pair {
        int first;
        int second;
        int distance;

        Pair(int first, int second, int distance) {
            this.first = first;
            this.second = second;
            this.distance = distance;
        }
    }
}

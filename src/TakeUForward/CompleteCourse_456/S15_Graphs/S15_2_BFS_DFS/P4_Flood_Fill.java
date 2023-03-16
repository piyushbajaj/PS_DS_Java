package TakeUForward.CompleteCourse_456.S15_Graphs.S15_2_BFS_DFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import javafx.util.Pair;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S15_Graphs.S15_2_BFS_DFS
 * <p>
 * User: piyushbajaj
 * Date: 10/10/22
 * Time: 8:34 pm
 * <p>
 * lc: <a href="https://leetcode.com/problems/flood-fill/description/">...</a>
 */
public class P4_Flood_Fill {

    /**
     * Followed BFS Approach
     * TC: O(N*M)
     * SC: O(N*M)
     *
     * @param image
     * @param sr
     * @param sc
     * @param color
     * @return
     */
    public int[][] floodFill_bfs(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int[][] visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = image[i][j];
            }
        }

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(sr, sc));
        visited[sr][sc] = color;

        int[] neighbourDeltaIth = {-1, 0, 1, 0};
        int[] neighbourDeltaJth = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            int ithIndex = queue.peek().getKey();
            int jthIndex = queue.peek().getValue();
            queue.poll();

            for (int k = 0; k < 4; k++) {
                int neighbourIthIndex = ithIndex + neighbourDeltaIth[k];
                int neighbourJthIndex = jthIndex + neighbourDeltaJth[k];

                if (neighbourIthIndex >= 0 && neighbourIthIndex < n && neighbourJthIndex >= 0 &&
                    neighbourJthIndex < m && image[neighbourIthIndex][neighbourJthIndex] == image[sr][sc] &&
                    visited[neighbourIthIndex][neighbourJthIndex] != color) {
                    visited[neighbourIthIndex][neighbourJthIndex] = color;
                    queue.add(new Pair<>(neighbourIthIndex, neighbourJthIndex));
                }
            }
        }
        return visited;
    }

    public int[][] floodFill_dfs(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        int[][] result = image;

        int key = image[sr][sc];
        result[sr][sc] = color;

        if (color != key) {
            floodFill_dfs_util(image, result, sr, sc, color, key);
        }

        return result;
    }


    public void floodFill_dfs_util(int[][] image, int[][] result, int ithIndex, int jthIndex, int color, int key) {
        int[] rowDelta = {-1, 0, 1, 0};
        int[] colDelta = {0, 1, 0, -1};

        for (int k = 0; k < 4; k++) {
            int nRow = ithIndex - rowDelta[k];
            int nCol = jthIndex - colDelta[k];

            if (nRow >= 0 && nRow < image.length && nCol >= 0 && nCol < image[0].length && image[nRow][nCol] == key &&
                result[nRow][nCol] != color) {
                result[nRow][nCol] = color;
                floodFill_dfs_util(image, result, nRow, nCol, color, key);
            }
        }
    }

    public static void main(String[] args) {
        P4_Flood_Fill p4_flood_fill = new P4_Flood_Fill();
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        System.out.println(Arrays.deepToString(p4_flood_fill.floodFill_bfs(image, 1, 1, 2)));
        System.out.println(Arrays.deepToString(p4_flood_fill.floodFill_dfs(image, 1, 1, 2)));

        int[][] image1 = {{0, 0, 0}, {0, 0, 0}};
        System.out.println(Arrays.deepToString(p4_flood_fill.floodFill_bfs(image1, 0, 0, 0)));

        int[][] image2 = {{0, 0, 0}, {0, 0, 0}};
        System.out.println(Arrays.deepToString(p4_flood_fill.floodFill_bfs(image2, 1, 0, 2)));

        System.out.println(Arrays.deepToString(p4_flood_fill.floodFill_dfs(image2, 1, 0, 2)));
    }
}

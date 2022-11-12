package TakeUForward.S15_Graphs.S15_2_BFS_DFS;

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
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
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
                    neighbourJthIndex < m &&
                    image[neighbourIthIndex][neighbourJthIndex] == image[sr][sc] &&
                    visited[neighbourIthIndex][neighbourJthIndex] != color) {
                    visited[neighbourIthIndex][neighbourJthIndex] = color;
                    queue.add(new Pair<>(neighbourIthIndex, neighbourJthIndex));
                }
            }
        }
        return visited;
    }

    public static void main(String[] args) {
        P4_Flood_Fill p4_flood_fill = new P4_Flood_Fill();
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        System.out.println(Arrays.deepToString(p4_flood_fill.floodFill(image, 1, 1, 2)));

        int[][] image1 = {{0, 0, 0}, {0, 0, 0}};
        System.out.println(Arrays.deepToString(p4_flood_fill.floodFill(image1, 0, 0, 0)));

        int[][] image2 = {{0, 0, 0}, {0, 0, 0}};
        System.out.println(Arrays.deepToString(p4_flood_fill.floodFill(image2, 1, 0, 2)));
    }
}

package TakeUForward.CompleteCourse_456.S15_Graphs.S15_5_MST_DisjointSet;

import java.util.List;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S15_Graphs.S15_5_MST_DisjointSet
 * <p>
 * User: piyushbajaj
 * Date: 10/11/22
 * Time: 10:03 am
 */
public class P7_Num_Of_Islands {

    /**
     * Approach:
     * 1.
     *
     * @param rows
     * @param cols
     * @param operators
     * @return
     */
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        int[][] matrix = new int[rows][cols];
        boolean[][] isVisited = new boolean[rows][cols];
        P2_Disjoint_Set disjoint_set = new P2_Disjoint_Set(rows * cols);

        return null;
    }

    public static void main(String[] args) {

    }
}

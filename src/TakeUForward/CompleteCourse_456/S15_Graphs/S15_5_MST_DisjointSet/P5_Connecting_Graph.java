package TakeUForward.CompleteCourse_456.S15_Graphs.S15_5_MST_DisjointSet;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S15_Graphs.S15_5_MST_DisjointSet
 * <p>
 * User: piyushbajaj
 * Date: 09/11/22
 * Time: 1:17 pm
 */
public class P5_Connecting_Graph {

    /**
     * Approach:
     * 1. Convert Adjacency Matrix to Adjacent List
     * 2. Count the number of provinces, means node is equal to the parent, means 1 component
     * 3. Count Extra edges, if the u and v vertex are pointing to
     *
     * @param n
     * @param edge
     * @return
     */
    public int Solve(int n, int[][] edge) {
        P2_Disjoint_Set disjoint_set = new P2_Disjoint_Set(n);

        int countExtraEdge = 0;

        // for counting extra edges
        for (int i = 0; i < edge.length; i++) {
            int u = edge[i][0];
            int v = edge[i][1];

            if (disjoint_set.findUParent(u) == disjoint_set.findUParent(v)) {
                countExtraEdge++;
            } else {
                disjoint_set.unionBySize(u, v);
            }
        }

        // for counting components
        int countComponent = 0;
        for (int i = 0; i < n; i++) {
            if (i == disjoint_set.findUParent(i)) {
                countComponent++;
            }
        }

        if (countExtraEdge >= countComponent - 1) {
            return countComponent - 1;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        P5_Connecting_Graph p5_connecting_graph = new P5_Connecting_Graph();
        System.out.println(p5_connecting_graph.Solve(4, new int[][] {{0, 1}, {0, 2}, {1, 2}}));
    }
}

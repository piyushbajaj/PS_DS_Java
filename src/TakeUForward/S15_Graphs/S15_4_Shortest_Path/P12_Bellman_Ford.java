package TakeUForward.S15_Graphs.S15_4_Shortest_Path;

import java.util.Arrays;
import java.util.List;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S15_Graphs.S15_4_Shortest_Path
 * <p>
 * User: piyushbajaj
 * Date: 04/11/22
 * Time: 8:48 am
 * <p>
 * Link g4g: <a href="https://practice.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1">...</a>
 */
public class P12_Bellman_Ford {

    /**
     * TC: O(V*E)
     *
     * @param V
     * @param edges
     * @param S
     * @return
     */
    public int[] bellman_ford(int V, List<List<Integer>> edges, int S) {
        int[] dist = new int[V];

        for (int i = 0; i < V; i++) {
            dist[i] = (int) 1e8;
        }

        dist[S] = 0;

        // Relaxing till V-1 vertices
        for (int i = 0; i < V - 1; i++) {
            for (List<Integer> edge : edges) {
                int u = edge.get(0);
                int v = edge.get(1);
                int weight = edge.get(2);

                if (dist[u] != 1e8 && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }

        // Validate if in the Vth vertex, if the distance is getting reduced, then there is negative cycle
        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int weight = edge.get(2);

            if (dist[u] != 1e8 && dist[u] + weight < dist[v]) {
                return new int[] {-1};
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        P12_Bellman_Ford p12_bellman_ford = new P12_Bellman_Ford();

        List<List<Integer>> edges = Arrays.asList(Arrays.asList(0, 1, 5), Arrays.asList(1, 0, 3), Arrays.asList(1
            , 2, -1), Arrays.asList(2, 0, 1));

        System.out.println(Arrays.toString(p12_bellman_ford.bellman_ford(3, edges, 2)));
    }
}

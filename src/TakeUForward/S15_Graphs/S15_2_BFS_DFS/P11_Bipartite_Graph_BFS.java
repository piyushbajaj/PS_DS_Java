package TakeUForward.S15_Graphs.S15_2_BFS_DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import TakeUForward.S15_Graphs.S15_1_Learning.P1_BFS;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S15_Graphs.S15_2_BFS_DFS
 * <p>
 * User: piyushbajaj
 * Date: 22/10/22
 * Time: 1:42 pm
 * <p>
 * Link: <a href="https://practice.geeksforgeeks.org/problems/bipartite-graph/1">...</a>
 */
public class P11_Bipartite_Graph_BFS {

    /**
     * TC: O(N + 2*E)
     * SC: O(N)
     *
     * @param V
     * @param adj
     * @return
     */
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] color = new int[V];

        for (int i = 0; i < V; i++) {
            color[i] = -1;
        }

        for (int i = 0; i < V; i++) {
            if (color[i] == -1 && !isBipartite_util(V, adj, i, color)) {
                return false;
            }
        }
        return true;
    }

    public boolean isBipartite_util(int V, ArrayList<ArrayList<Integer>> adj, int startVertex, int[] color) {
        Queue<Integer> queueElements = new LinkedList<>();

        // for two colors will use 0 and 1 as the color code
        queueElements.add(startVertex);
        color[startVertex] = 0;

        while (!queueElements.isEmpty()) {
            int currElement = queueElements.peek();
            queueElements.poll();

            int currColor = color[currElement];
            // Getting opposite color
            int newNodeColor = 1 - currColor;

            for (Integer adjacentNode : adj.get(currElement)) {
                if (color[adjacentNode] == -1) {
                    queueElements.add(adjacentNode);
                    color[adjacentNode] = newNodeColor;
                } else if (color[adjacentNode] != newNodeColor) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        P1_BFS p1_bfs = new P1_BFS(8);
        p1_bfs.addEdge(1, 2, P1_BFS.GraphDirection.BiDirectional);
        p1_bfs.addEdge(2, 3, P1_BFS.GraphDirection.BiDirectional);
        p1_bfs.addEdge(2, 6, P1_BFS.GraphDirection.BiDirectional);
        p1_bfs.addEdge(3, 4, P1_BFS.GraphDirection.BiDirectional);
        p1_bfs.addEdge(6, 5, P1_BFS.GraphDirection.BiDirectional);
        p1_bfs.addEdge(5, 4, P1_BFS.GraphDirection.BiDirectional);
        p1_bfs.addEdge(4, 7, P1_BFS.GraphDirection.BiDirectional);
        p1_bfs.addEdge(7, 8, P1_BFS.GraphDirection.BiDirectional);

        P11_Bipartite_Graph_BFS p11_bipartite_graph = new P11_Bipartite_Graph_BFS();
        p1_bfs.printAllEdges(P1_BFS.GraphType.OneBasedIndexing);
        System.out.println(p11_bipartite_graph.isBipartite(8, p1_bfs.adjList));

    }
}

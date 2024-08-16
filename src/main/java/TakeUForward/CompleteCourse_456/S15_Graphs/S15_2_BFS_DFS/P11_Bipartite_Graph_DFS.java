package TakeUForward.CompleteCourse_456.S15_Graphs.S15_2_BFS_DFS;

import java.util.ArrayList;

import TakeUForward.CompleteCourse_456.S15_Graphs.S15_1_Learning.P2_DFS;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S15_Graphs.S15_2_BFS_DFS
 * <p>
 * User: piyushbajaj
 * Date: 22/10/22
 * Time: 4:29 pm
 * <p>
 */
public class P11_Bipartite_Graph_DFS {
    public static void main(String[] args) {
        P2_DFS p2_dfs = new P2_DFS(8);
        p2_dfs.addEdge(0, 1, P2_DFS.GraphDirection.BiDirectional);
        p2_dfs.addEdge(1, 2, P2_DFS.GraphDirection.BiDirectional);
        p2_dfs.addEdge(1, 5, P2_DFS.GraphDirection.BiDirectional);
        p2_dfs.addEdge(2, 3, P2_DFS.GraphDirection.BiDirectional);
        p2_dfs.addEdge(5, 4, P2_DFS.GraphDirection.BiDirectional);
        p2_dfs.addEdge(4, 3, P2_DFS.GraphDirection.BiDirectional);
        p2_dfs.addEdge(3, 6, P2_DFS.GraphDirection.BiDirectional);
        p2_dfs.addEdge(6, 7, P2_DFS.GraphDirection.BiDirectional);

        P11_Bipartite_Graph_DFS p11_bipartite_graph = new P11_Bipartite_Graph_DFS();
        p2_dfs.printAllEdges(P2_DFS.GraphType.ZeroBasedIndexing);

        System.out.println(p11_bipartite_graph.isBipartite(8, p2_dfs.adjList));
    }

    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] color = new int[V];

        for (int i = 0; i < V; i++) {
            color[i] = -1;
        }

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!isBipartite_util(0, adj, i, color)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBipartite_util(int currColor, ArrayList<ArrayList<Integer>> adj, int startVertex, int[] color) {
        color[startVertex] = currColor;

        for (Integer adjacentNode : adj.get(startVertex)) {
            if (color[adjacentNode] == -1) {
                if (!isBipartite_util(1 - currColor, adj, adjacentNode, color)) {
                    return false;
                }
            } else if (color[adjacentNode] == color[startVertex]) {
                return false;
            }
        }
        return true;
    }
}

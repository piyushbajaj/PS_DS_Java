package TakeUForward.CompleteCourse_456.S15_Graphs.S15_2_BFS_DFS;

import java.util.ArrayList;

import TakeUForward.CompleteCourse_456.S15_Graphs.S15_1_Learning.P2_DFS;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S15_Graphs.S15_2_BFS_DFS
 * <p>
 * User: piyushbajaj
 * Date: 24/10/22
 * Time: 12:04 pm
 * <p>
 */
public class P12_Cycle_Detection_Directed_DFS {
    public static void main(String[] args) {
        P12_Cycle_Detection_Directed_DFS p12_cycle_detection_directed_dfs = new P12_Cycle_Detection_Directed_DFS();

        P2_DFS p2_dfs = new P2_DFS(10);
        p2_dfs.addEdge(1, 2, P2_DFS.GraphDirection.Directional);
        p2_dfs.addEdge(2, 3, P2_DFS.GraphDirection.Directional);
        p2_dfs.addEdge(3, 4, P2_DFS.GraphDirection.Directional);
        p2_dfs.addEdge(4, 5, P2_DFS.GraphDirection.Directional);
        p2_dfs.addEdge(5, 6, P2_DFS.GraphDirection.Directional);
        p2_dfs.addEdge(3, 7, P2_DFS.GraphDirection.Directional);
        p2_dfs.addEdge(7, 5, P2_DFS.GraphDirection.Directional);
        p2_dfs.addEdge(8, 2, P2_DFS.GraphDirection.Directional);
        p2_dfs.addEdge(8, 9, P2_DFS.GraphDirection.Directional);
        p2_dfs.addEdge(9, 10, P2_DFS.GraphDirection.Directional);
        p2_dfs.addEdge(10, 8, P2_DFS.GraphDirection.Directional);

        p2_dfs.printAllEdges(P2_DFS.GraphType.OneBasedIndexing);

        System.out.println(p12_cycle_detection_directed_dfs.isCyclic(10, p2_dfs.adjList));

    }

    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V + 1];
        boolean[] pathVisited = new boolean[V + 1];

        for (int i = 1; i <= V; i++) {
            if (!visited[i] && !pathVisited[i]) {
                if (isCyclic_util(i, adj, new boolean[V + 1], new boolean[V + 1])) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isCyclic_util(int vertex, ArrayList<ArrayList<Integer>> adj, boolean[] visited,
                                 boolean[] pathVisited) {
        visited[vertex] = true;
        pathVisited[vertex] = true;

        for (Integer adjacentNode : adj.get(vertex)) {
            if (!visited[adjacentNode] && !pathVisited[adjacentNode]) {
                if (isCyclic_util(adjacentNode, adj, visited, pathVisited)) {
                    return true;
                }
            } else if (pathVisited[adjacentNode]) {
                return true;
            }
        }
        pathVisited[vertex] = false;
        return false;
    }
}

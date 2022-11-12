package TakeUForward.S15_Graphs.S15_2_BFS_DFS;

import java.util.ArrayList;

import TakeUForward.S15_Graphs.S15_1_Learning.P2_DFS;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S15_Graphs.S15_2_BFS_DFS
 * <p>
 * User: piyushbajaj
 * Date: 11/10/22
 * Time: 10:14 am
 * <p>
 */
public class P6_Cycle_Detection_Undirected_DFS {

    static class Pair {
        int node, parent;

        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // create visited array
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (checkForCycle(i, -1, visited, adj)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean checkForCycle(int src, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[src] = true;
        for (Integer adjacentElement : adj.get(src)) {
            if (!visited[adjacentElement]) {
                if (checkForCycle(adjacentElement, src, visited, adj)) {
                    return true;
                }
            }
            // This is the condition to check if there exists cycle
            else if (adjacentElement != parent) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        P2_DFS p2_dfs = new P2_DFS(5);
        p2_dfs.addEdge(0, 1, P2_DFS.GraphDirection.BiDirectional);
        p2_dfs.addEdge(1, 4, P2_DFS.GraphDirection.BiDirectional);
        p2_dfs.addEdge(1, 2, P2_DFS.GraphDirection.BiDirectional);
        p2_dfs.addEdge(2, 3, P2_DFS.GraphDirection.BiDirectional);
        p2_dfs.addEdge(3, 4, P2_DFS.GraphDirection.BiDirectional);

        P6_Cycle_Detection_Undirected_DFS p6_cycle_detection_undirected_dfs = new P6_Cycle_Detection_Undirected_DFS();
        System.out.println(p6_cycle_detection_undirected_dfs.isCycle(5, p2_dfs.adjList));
    }
}

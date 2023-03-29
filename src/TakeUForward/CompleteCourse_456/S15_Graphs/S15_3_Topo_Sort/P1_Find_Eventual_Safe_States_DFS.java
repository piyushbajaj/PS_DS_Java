package TakeUForward.CompleteCourse_456.S15_Graphs.S15_3_Topo_Sort;

import java.util.ArrayList;
import java.util.List;

import TakeUForward.CompleteCourse_456.S15_Graphs.S15_1_Learning.P2_DFS;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S15_Graphs.S15_3_Topo_Sort
 * <p>
 * User: piyushbajaj
 * Date: 25/10/22
 * Time: 5:19 pm
 * <p>
 */

public class P1_Find_Eventual_Safe_States_DFS {

    public static void main(String[] args) {
        P1_Find_Eventual_Safe_States_DFS p1_find_eventual_safe_states = new P1_Find_Eventual_Safe_States_DFS();

        P2_DFS p2_dfs = new P2_DFS(7);
        p2_dfs.addEdge(0, 1, P2_DFS.GraphDirection.Directional);
        p2_dfs.addEdge(0, 2, P2_DFS.GraphDirection.Directional);
        p2_dfs.addEdge(1, 2, P2_DFS.GraphDirection.Directional);
        p2_dfs.addEdge(1, 3, P2_DFS.GraphDirection.Directional);
        p2_dfs.addEdge(2, 5, P2_DFS.GraphDirection.Directional);
        p2_dfs.addEdge(3, 0, P2_DFS.GraphDirection.Directional);
        p2_dfs.addEdge(4, 5, P2_DFS.GraphDirection.Directional);

        System.out.println(p1_find_eventual_safe_states.eventualSafeNodes(7, p2_dfs.adjList));

    }

    /**
     * Extension of Cycle Detection in DFS
     * TC: O(V+E)
     * SC: O(V)
     *
     * @param V
     * @param adj
     * @return
     */
    public List<Integer> eventualSafeNodes(int V, ArrayList<ArrayList<Integer>> adj) {
        List<Integer> result = new ArrayList<>();
        boolean[] isVisited = new boolean[V];
        boolean[] isPathVisited = new boolean[V];
        boolean[] isSafeNodeCheck = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!isVisited[i]) {
                dfs_check(i, adj, isVisited, isPathVisited, isSafeNodeCheck);
            }
        }

        for (int i = 0; i < V; i++) {
            if (isSafeNodeCheck[i]) {
                result.add(i);
            }
        }

        return result;
    }

    public boolean dfs_check(int vertex, ArrayList<ArrayList<Integer>> adj, boolean[] isVisited,
                             boolean[] isPathVisited, boolean[] isSafeNodeCheck) {
        isVisited[vertex] = true;
        isPathVisited[vertex] = true;

        for (Integer adjNode : adj.get(vertex)) {
            if (!isVisited[adjNode]) {
                if (dfs_check(adjNode, adj, isVisited, isPathVisited, isSafeNodeCheck)) {
                    // In case of Cycle, safe node is not needed
                    isSafeNodeCheck[adjNode] = false;
                    return true;
                }
            } else if (isPathVisited[adjNode]) {
                // In case of Cycle, safe node is not needed
                isSafeNodeCheck[adjNode] = false;
                return true;
            }
        }
        isSafeNodeCheck[vertex] = true;
        isPathVisited[vertex] = false;
        return false;
    }
}

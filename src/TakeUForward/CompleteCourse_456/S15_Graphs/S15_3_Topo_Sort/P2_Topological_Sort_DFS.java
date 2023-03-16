package TakeUForward.CompleteCourse_456.S15_Graphs.S15_3_Topo_Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import TakeUForward.CompleteCourse_456.S15_Graphs.S15_1_Learning.P2_DFS;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S15_Graphs.S15_3_Topo_Sort
 * <p>
 * User: piyushbajaj
 * Date: 26/10/22
 * Time: 7:50 am
 * <p>
 * TC: O(V+E)
 */
public class P2_Topological_Sort_DFS {

    public int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] result = new int[V];
        boolean[] isVisited = new boolean[V];
        Stack<Integer> storeElement = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!isVisited[i]) {
                topoSort_util(i, adj, storeElement, isVisited);
            }
        }

        for (int i = 0; i < V; i++) {
            result[i] = storeElement.pop();
        }

        return result;
    }

    public void topoSort_util(int vertex, ArrayList<ArrayList<Integer>> adj, Stack<Integer> storeElement,
                              boolean[] isVisited) {
        isVisited[vertex] = true;

        for (Integer adjNode : adj.get(vertex)) {
            if (!isVisited[adjNode]) {
                topoSort_util(adjNode, adj, storeElement, isVisited);
            }
        }

        storeElement.push(vertex);
    }

    public static void main(String[] args) {
        P2_Topological_Sort_DFS p2_topological_sort_dfs = new P2_Topological_Sort_DFS();

        P2_DFS p2_dfs = new P2_DFS(6);
        p2_dfs.addEdge(5, 0, P2_DFS.GraphDirection.Directional);
        p2_dfs.addEdge(4, 0, P2_DFS.GraphDirection.Directional);
        p2_dfs.addEdge(5, 2, P2_DFS.GraphDirection.Directional);
        p2_dfs.addEdge(2, 3, P2_DFS.GraphDirection.Directional);
        p2_dfs.addEdge(3, 1, P2_DFS.GraphDirection.Directional);
        p2_dfs.addEdge(4, 1, P2_DFS.GraphDirection.Directional);

        System.out.println(Arrays.toString(p2_topological_sort_dfs.topoSort(6, p2_dfs.adjList)));
    }
}

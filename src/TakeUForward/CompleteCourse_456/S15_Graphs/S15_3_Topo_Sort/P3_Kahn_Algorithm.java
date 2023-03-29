package TakeUForward.CompleteCourse_456.S15_Graphs.S15_3_Topo_Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import TakeUForward.CompleteCourse_456.S15_Graphs.S15_1_Learning.P2_DFS;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S15_Graphs.S15_3_Topo_Sort
 * <p>
 * User: piyushbajaj
 * Date: 26/10/22
 * Time: 8:22 am
 * <p>
 * Topological Sort in BFS
 */
public class P3_Kahn_Algorithm {

    public static void main(String[] args) {
        P3_Kahn_Algorithm p3_kahn_algorithm = new P3_Kahn_Algorithm();

        P2_DFS p2_dfs = new P2_DFS(6);
        p2_dfs.addEdge(5, 0, P2_DFS.GraphDirection.Directional);
        p2_dfs.addEdge(4, 0, P2_DFS.GraphDirection.Directional);
        p2_dfs.addEdge(5, 2, P2_DFS.GraphDirection.Directional);
        p2_dfs.addEdge(2, 3, P2_DFS.GraphDirection.Directional);
        p2_dfs.addEdge(3, 1, P2_DFS.GraphDirection.Directional);
        p2_dfs.addEdge(4, 1, P2_DFS.GraphDirection.Directional);

        System.out.println(Arrays.toString(p3_kahn_algorithm.topoSort(6, p2_dfs.adjList)));
    }

    public int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] resultArr = new int[V];
        int[] inDegree = new int[V];

        Queue<Integer> storeElement = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            for (Integer adjNode : adj.get(i)) {
                inDegree[adjNode]++;
            }
        }

        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                storeElement.add(i);
            }
        }
        topoSort_util(storeElement, adj, result, inDegree);

        int k = 0;
        for (Integer i : result) {
            resultArr[k++] = i;
        }

        return resultArr;
    }

    public void topoSort_util(Queue<Integer> storeElement, ArrayList<ArrayList<Integer>> adj,
                              ArrayList<Integer> result, int[] inDegree) {
        while (!storeElement.isEmpty()) {
            int currElement = storeElement.peek();
            storeElement.poll();
            result.add(currElement);

            for (Integer adjNode : adj.get(currElement)) {
                if (inDegree[adjNode] != 0) {
                    inDegree[adjNode]--;
                }

                if (inDegree[adjNode] == 0) {
                    storeElement.add(adjNode);
                }
            }

        }
    }
}

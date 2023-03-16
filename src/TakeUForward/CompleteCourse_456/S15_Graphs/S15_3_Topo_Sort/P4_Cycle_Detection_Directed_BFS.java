package TakeUForward.CompleteCourse_456.S15_Graphs.S15_3_Topo_Sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import TakeUForward.CompleteCourse_456.S15_Graphs.S15_1_Learning.P2_DFS;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S15_Graphs.S15_3_Topo_Sort
 * <p>
 * User: piyushbajaj
 * Date: 26/10/22
 * Time: 12:20 pm
 * <p>
 */
public class P4_Cycle_Detection_Directed_BFS {

    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result = new ArrayList<>();
        int[] inDegree = new int[V];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            for (Integer adjNode : adj.get(i)) {
                inDegree[adjNode]++;
            }
        }

        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        isCyclic_util(result, adj, queue, inDegree);

        return result.size() != V;
    }

    public void isCyclic_util(ArrayList<Integer> result, ArrayList<ArrayList<Integer>> adj, Queue<Integer> queue,
                              int[] inDegree) {
        while (!queue.isEmpty()) {
            int currElement = queue.poll();
            result.add(currElement);

            for (Integer adjNode : adj.get(currElement)) {
                if (inDegree[adjNode] > 0) {
                    inDegree[adjNode]--;
                }

                if (inDegree[adjNode] == 0) {
                    queue.add(adjNode);
                }
            }
        }
    }

    public static void main(String[] args) {
        P4_Cycle_Detection_Directed_BFS p4_cycle_detection_directed_bfs = new P4_Cycle_Detection_Directed_BFS();

        P2_DFS p2_dfs = new P2_DFS(5);
        p2_dfs.addEdge(0, 1, P2_DFS.GraphDirection.Directional);
        p2_dfs.addEdge(1, 2, P2_DFS.GraphDirection.Directional);
        p2_dfs.addEdge(2, 3, P2_DFS.GraphDirection.Directional);
        p2_dfs.addEdge(2, 4, P2_DFS.GraphDirection.Directional);
        p2_dfs.addEdge(3, 1, P2_DFS.GraphDirection.Directional);

        System.out.println(p4_cycle_detection_directed_bfs.isCyclic(6, p2_dfs.adjList));
    }
}

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
 * Date: 11/10/22
 * Time: 9:31 am
 * <p>
 */
public class P5_Cycle_Detection_Undirected_BFS {

    static class Pair {
        int node, parent;

        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    /**
     * TC: O(V + 2*E)
     *
     * @param V
     * @param adj
     * @return
     */
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // create visited array
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (checkForCycle(i, visited, adj)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean checkForCycle(int src, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {

        // Node and Parent
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(src, -1));
        visited[src] = true;

        while (!queue.isEmpty()) {
            int nodeValue = queue.peek().node;
            int parentValue = queue.peek().parent;
            queue.remove();

            for (Integer adjacentElement : adj.get(nodeValue)) {
                if (!visited[adjacentElement]) {
                    queue.add(new Pair(adjacentElement, nodeValue));
                    visited[adjacentElement] = true;
                }
                // This is the condition to check if there exists cycle
                else if (adjacentElement != parentValue) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        P1_BFS p1_bfs = new P1_BFS(5);
        p1_bfs.addEdge(0, 1, P1_BFS.GraphDirection.BiDirectional);
        p1_bfs.addEdge(1, 4, P1_BFS.GraphDirection.BiDirectional);
        p1_bfs.addEdge(1, 2, P1_BFS.GraphDirection.BiDirectional);
        p1_bfs.addEdge(2, 3, P1_BFS.GraphDirection.BiDirectional);
        p1_bfs.addEdge(3, 4, P1_BFS.GraphDirection.BiDirectional);

        P5_Cycle_Detection_Undirected_BFS p5_cycle_detection_undirected_bfs = new P5_Cycle_Detection_Undirected_BFS();
        System.out.println(p5_cycle_detection_undirected_bfs.isCycle(5, p1_bfs.adjList));
    }
}

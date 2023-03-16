package TakeUForward.CompleteCourse_456.S15_Graphs.S15_4_Shortest_Path;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S15_Graphs.S15_4_Shortest_Path
 * <p>
 * User: piyushbajaj
 * Date: 29/10/22
 * Time: 11:23 pm
 * <p>
 */
public class P1_Shortest_Path_In_DAG {

    static class Pair {
        int toNode, distance;

        Pair(int toNode, int distance) {
            this.toNode = toNode;
            this.distance = distance;
        }
    }

    /**
     * Approach:
     * 1. Do the topological sort
     * 2. Mark the distance for the 0th element as 0
     * 3. Pop the stack and calculate the distance and keep storing in the distance array
     *
     * TC: O(M + N): Topological sort
     * @param N
     * @param M
     * @param edges
     * @return
     */
    public int[] shortestPath(int N, int M, int[][] edges) {
        List<List<Pair>> adjList = new ArrayList<>();
        int[] dist = new int[N];

        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<Pair>());
            dist[i] = (int) (1e9);
        }

        for (int i = 0; i < M; i++) {
            adjList.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
        }

        Stack<Integer> topoSortList = topoSort(N, adjList);
        dist[0] = 0;
        while (!topoSortList.isEmpty()) {
            int topElement = topoSortList.peek();
            int topElementDistance = dist[topoSortList.peek()];
            topoSortList.pop();

            for (Pair adjNode : adjList.get(topElement)) {
                int adjacentElement = adjNode.toNode;
                int adjacentElementDistance = adjNode.distance;

                if (topElementDistance + adjacentElementDistance < dist[adjacentElement]) {
                    dist[adjacentElement] = topElementDistance + adjacentElementDistance;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (dist[i] == 1e9) {
                dist[i] = -1;
            }
        }

        return dist;
    }

    // dfs
    public Stack<Integer> topoSort(int V, List<List<Pair>> adj) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topoSort_util(adj, i, visited, stack);
            }
        }

        return stack;
    }

    public void topoSort_util(List<List<Pair>> adj, int vertex, boolean[] visited, Stack<Integer> stack) {
        visited[vertex] = true;

        for (Pair adjNode : adj.get(vertex)) {
            if (!visited[adjNode.toNode]) {
                topoSort_util(adj, adjNode.toNode, visited, stack);
            }
        }

        stack.push(vertex);
    }

    public static void main(String[] args) {
        P1_Shortest_Path_In_DAG p1_shortest_path_in_dag = new P1_Shortest_Path_In_DAG();
        int[][] edges = {{0, 1, 2}, {0, 4, 1}, {4, 5, 4}, {4, 2, 2}, {1, 2, 3}, {2, 3, 6}, {5, 3, 1}};
        System.out.println(Arrays.toString(p1_shortest_path_in_dag.shortestPath(6, 7, edges)));

        int[][] edges1 = {{0, 1, 2}, {2, 1, 2}, {2, 4, 2}, {1, 4, 8}, {1, 3, 6}};
        System.out.println(Arrays.toString(p1_shortest_path_in_dag.shortestPath(5, 5, edges1)));
    }
}

package TakeUForward.CompleteCourse_456.S15_Graphs.S15_1_Learning;

import java.util.ArrayList;

import static TakeUForward.CompleteCourse_456.S15_Graphs.S15_1_Learning.P2_DFS.GraphDirection.BiDirectional;
import static TakeUForward.CompleteCourse_456.S15_Graphs.S15_1_Learning.P2_DFS.GraphType.OneBasedIndexing;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S15_Graphs.S15_1_Learning
 * <p>
 * User: piyushbajaj
 * Date: 09/10/22
 * Time: 7:58 pm
 * <p>
 * SC: O(N) + O(N) + O(N)
 * TC: O(N) + Summation of degrees (2 * E)
 */
public class P2_DFS {
    public final ArrayList<ArrayList<Integer>> adjList;
    public final int capacity;

    public P2_DFS(final int capacity) {
        this.adjList = new ArrayList<>();
        this.capacity = capacity;

        for (int i = 0; i <= capacity; i++) {
            this.adjList.add(new ArrayList<Integer>());
        }
    }

    public static void main(String[] args) {
        P2_DFS p2_dfs = new P2_DFS(9);
        p2_dfs.addEdge(1, 2, BiDirectional);
        p2_dfs.addEdge(1, 6, BiDirectional);
        p2_dfs.addEdge(2, 3, BiDirectional);
        p2_dfs.addEdge(2, 4, BiDirectional);
        p2_dfs.addEdge(4, 5, BiDirectional);
        p2_dfs.addEdge(6, 7, BiDirectional);
        p2_dfs.addEdge(6, 9, BiDirectional);
        p2_dfs.addEdge(7, 8, BiDirectional);

        p2_dfs.printAllEdges(OneBasedIndexing);

        System.out.println(p2_dfs.dfsOfGraph(10, p2_dfs.adjList, 1));
    }

    // Add bidirectional edge
    public void addEdge(int u, int v, GraphDirection graphDirection) {
        switch (graphDirection) {
            case Directional: {
                this.adjList.get(u).add(v);
            }
            break;
            case BiDirectional: {
                this.adjList.get(u).add(v);
                this.adjList.get(v).add(u);
            }
        }
    }

    public void printAllEdges(GraphType graphType) {
        switch (graphType) {
            case ZeroBasedIndexing: {
                for (int i = 0; i < this.capacity; i++) {
                    System.out.print(i + " -> ");
                    for (int j = 0; j < this.adjList.get(i).size(); j++) {
                        System.out.print(this.adjList.get(i).get(j) + " ");
                    }
                    System.out.println();
                }
            }
            break;
            case OneBasedIndexing: {
                for (int i = 1; i <= this.capacity; i++) {
                    System.out.print(i + " -> ");
                    for (int j = 0; j < this.adjList.get(i).size(); j++) {
                        System.out.print(this.adjList.get(i).get(j) + " ");
                    }
                    System.out.println();
                }
            }
        }
    }

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj, int startNode) {
        boolean[] visited = new boolean[V + 1];
        visited[startNode] = true;
        ArrayList<Integer> dfsList = new ArrayList<>();
        dfs_recur(startNode, visited, adj, dfsList);

        return dfsList;
    }

    public void dfs_recur(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> dfsList) {

        // mark the node as visited true
        visited[node] = true;
        dfsList.add(node);

        // traverse all its neighbours
        for (Integer it : adj.get(node)) {
            if (!visited[it]) {
                dfs_recur(it, visited, adj, dfsList);
            }
        }
    }

    public enum GraphType {
        ZeroBasedIndexing,
        OneBasedIndexing
    }

    public enum GraphDirection {
        Directional,
        BiDirectional
    }
}

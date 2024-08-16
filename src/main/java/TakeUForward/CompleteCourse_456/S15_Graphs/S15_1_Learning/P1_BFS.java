package TakeUForward.CompleteCourse_456.S15_Graphs.S15_1_Learning;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S15_Graphs.S15_1_Learning
 * <p>
 * User: piyushbajaj
 * Date: 09/10/22
 * Time: 4:53 pm
 * <p>
 * <p>
 * TC: O(N + 2*E)
 * SC: O(N)
 */
public class P1_BFS {
    public final ArrayList<ArrayList<Integer>> adjList;
    public final int capacity;

    public P1_BFS(final int capacity) {
        this.adjList = new ArrayList<>();
        this.capacity = capacity;

        for (int i = 0; i <= capacity; i++) {
            this.adjList.add(new ArrayList<>());
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

    public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj, int startNode) {

        ArrayList<Integer> bfsList = new ArrayList<>();
        boolean[] visited = new boolean[V];

        Queue<Integer> queueBFS = new LinkedList<>();

        queueBFS.add(startNode);
        visited[startNode] = true;

        while (!queueBFS.isEmpty()) {
            Integer nodeVal = queueBFS.poll();
            bfsList.add(nodeVal);

            // Runs for all degrees for the node
            for (Integer it : adj.get(nodeVal)) {
                if (!visited[it]) {
                    visited[it] = true;
                    queueBFS.add(it);
                }
            }
        }

        return bfsList;
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
            break;
        }
    }

    public static void main(String[] args) {
        P1_BFS p1_bfs = new P1_BFS(9);

        p1_bfs.addEdge(1, 2, GraphDirection.BiDirectional);
        p1_bfs.addEdge(1, 6, GraphDirection.BiDirectional);
        p1_bfs.addEdge(2, 3, GraphDirection.BiDirectional);
        p1_bfs.addEdge(2, 4, GraphDirection.BiDirectional);
        p1_bfs.addEdge(4, 5, GraphDirection.BiDirectional);
        p1_bfs.addEdge(6, 7, GraphDirection.BiDirectional);
        p1_bfs.addEdge(6, 9, GraphDirection.BiDirectional);
        p1_bfs.addEdge(7, 8, GraphDirection.BiDirectional);

        p1_bfs.printAllEdges(GraphType.OneBasedIndexing);

        System.out.println(bfsOfGraph(10, p1_bfs.adjList, 1));
    }
}

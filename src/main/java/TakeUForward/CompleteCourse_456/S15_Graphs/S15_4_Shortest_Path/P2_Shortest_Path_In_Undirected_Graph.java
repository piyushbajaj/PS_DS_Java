package TakeUForward.CompleteCourse_456.S15_Graphs.S15_4_Shortest_Path;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S15_Graphs.S15_4_Shortest_Path
 * <p>
 * User: piyushbajaj
 * Date: 31/10/22
 * Time: 1:11 pm
 * <p>
 * Link g4g: <a href="https://practice.geeksforgeeks.org/problems/shortest-path-in-weighted-undirected-graph/1">...</a>
 */
public class P2_Shortest_Path_In_Undirected_Graph {

    public static void main(String[] args) {
        P2_Shortest_Path_In_Undirected_Graph p2_shortest_path_in_undirected_graph =
            new P2_Shortest_Path_In_Undirected_Graph();
        int[][] edges = {{0, 1}, {0, 3}, {3, 4}, {4, 5}
            , {5, 6}, {1, 2}, {2, 6}, {6, 7}, {7, 8}, {6, 8}};

        System.out.println(Arrays.toString(p2_shortest_path_in_undirected_graph
            .shortestPath(edges, 9, 10, 0)));
    }

    /**
     * Approach:
     * 1. Follow BFS, start with source 0. Always store
     * 2. Maintain distance array, and keep updating distance as move further
     * TC: O(V+ 2E)
     * SC: O(N)
     *
     * @param edges
     * @param n
     * @param m
     * @return
     */
    public int[] shortestPath(int[][] edges, int n, int m, int src) {
        List<List<Pair>> adj = new ArrayList<>();
        int[] distanceArray = new int[n];

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            distanceArray[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], 1));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], 1));
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(src, 0));
        distanceArray[src] = 0;

        while (!queue.isEmpty()) {
            int currElement = queue.peek().toNode;
            int currDistance = queue.peek().distance;
            queue.poll();

            for (Pair adjNode : adj.get(currElement)) {
                int adjElement = adjNode.toNode;
                int adjDistance = adjNode.distance;

                if (currDistance + adjDistance < distanceArray[adjElement]) {
                    distanceArray[adjElement] = currDistance + adjDistance;
                    queue.add(new Pair(adjElement, distanceArray[adjElement]));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (distanceArray[i] == Integer.MAX_VALUE) {
                distanceArray[i] = -1;
            }
        }

        return distanceArray;
    }

    static class Pair {
        int toNode;
        int distance;

        Pair(int toNode, int distance) {
            this.toNode = toNode;
            this.distance = distance;
        }
    }
}

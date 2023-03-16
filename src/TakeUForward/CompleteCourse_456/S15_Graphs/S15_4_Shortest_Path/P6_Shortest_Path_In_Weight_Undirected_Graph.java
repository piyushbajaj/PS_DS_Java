package TakeUForward.CompleteCourse_456.S15_Graphs.S15_4_Shortest_Path;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S15_Graphs.S15_4_Shortest_Path
 * <p>
 * User: piyushbajaj
 * Date: 01/11/22
 * Time: 10:19 pm
 * <p>
 * Link: https://practice.geeksforgeeks.org/problems/shortest-path-in-weighted-undirected-graph/1
 */
public class P6_Shortest_Path_In_Weight_Undirected_Graph {
    static class Pair {
        int distance, toNode;

        Pair(int toNode, int distance) {
            this.toNode = toNode;
            this.distance = distance;
        }
    }

    /**
     * Steps:
     * 1. Create the minimum priority queue to store distance along-with node's element
     * 2. Create the parent array, to store the last visited
     * 3. Do the BFS fashion
     * 4. Check the parent array from end, and keep storing in the result
     * TC: O(E*logV)
     *
     * @param n
     * @param m
     * @param edges
     * @return
     */
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        List<Integer> result = new ArrayList<>();

        int[] distance = new int[n + 1];
        int[] parent = new int[n + 1];
        List<List<Pair>> adjList = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
            distance[i] = Integer.MAX_VALUE;
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            adjList.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adjList.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }

        minHeap.add(new Pair(1, 0));
        distance[1] = 0;

        while (!minHeap.isEmpty()) {
            int currDistance = minHeap.peek().distance;
            int currNode = minHeap.peek().toNode;
            minHeap.poll();

            for (Pair adjNode : adjList.get(currNode)) {
                int adjDistance = adjNode.distance;
                int adjNodeVal = adjNode.toNode;

                if (currDistance + adjDistance < distance[adjNodeVal]) {
                    distance[adjNodeVal] = currDistance + adjDistance;
                    minHeap.add(new Pair(adjNodeVal, distance[adjNodeVal]));
                    parent[adjNodeVal] = currNode;
                }
            }
        }

        // If it hasnt reached the final distance, then return -1
        if (distance[n] == Integer.MAX_VALUE) {
            result.add(-1);
            return result;
        }

        int node = n;
        while (parent[node] != node) {
            result.add(node);
            node = parent[node];
        }

        result.add(1);

        Collections.reverse(result);

        return result;
    }

    public static void main(String[] args) {
        P6_Shortest_Path_In_Weight_Undirected_Graph p6_shortest_path_in_weight_undirected_graph =
            new P6_Shortest_Path_In_Weight_Undirected_Graph();

        int[][] edges = {{1, 2, 2}, {2, 5, 5}, {2, 3, 4}, {1, 4, 1}, {4, 3, 3}, {3, 5, 1}};

        System.out.println(p6_shortest_path_in_weight_undirected_graph.shortestPath(5, 6, edges));
    }
}

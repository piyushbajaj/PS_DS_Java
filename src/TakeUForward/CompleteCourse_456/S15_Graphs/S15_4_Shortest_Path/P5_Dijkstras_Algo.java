package TakeUForward.CompleteCourse_456.S15_Graphs.S15_4_Shortest_Path;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S15_Graphs.S15_4_Shortest_Path
 * <p>
 * User: piyushbajaj
 * Date: 01/11/22
 * Time: 5:22 pm
 * <p>
 * Link g4g: <a href="https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1">...</a>
 */
public class P5_Dijkstras_Algo {

    public static void main(String[] args) {
        P5_Dijkstras_Algo p5_dijkstras_algo = new P5_Dijkstras_Algo();

        List<List<List<Integer>>> adjList = Arrays.asList(
            Arrays.asList(
                Arrays.asList(1, 4),
                Arrays.asList(2, 4)
            ),
            Arrays.asList(
                Arrays.asList(0, 4),
                Arrays.asList(2, 2)
            ),
            Arrays.asList(
                Arrays.asList(0, 4),
                Arrays.asList(1, 2),
                Arrays.asList(3, 3),
                Arrays.asList(4, 1),
                Arrays.asList(5, 6)
            ),
            Arrays.asList(
                Arrays.asList(2, 3),
                Arrays.asList(5, 2)
            ),
            Arrays.asList(
                Arrays.asList(2, 1),
                Arrays.asList(5, 3)
            ),
            Arrays.asList(
                Arrays.asList(2, 6),
                Arrays.asList(3, 2),
                Arrays.asList(4, 3)
            )
        );

        System.out.println(Arrays.toString(p5_dijkstras_algo.dijkstra(6, adjList, 0)));
    }

    /**
     * Approach using Priority Queue using BFS
     * 1. Create Min Priority Queue, and keep updating distance along with adjacent Nodes. Reason for using Min
     * Priority Queue is that we want to keep minimum distance in the top.
     * 2. Keep storing the minimum weight to reach any node from the source node
     * TC: O(E*logV)
     *
     * @param V
     * @param adj
     * @param S
     * @return
     */
    public int[] dijkstra(int V, List<List<List<Integer>>> adj, int S) {
        // Min heap in the increasing order of distance
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        int[] distance = new int[V];

        for (int i = 0; i < V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        distance[S] = 0;

        minHeap.add(new Pair(distance[S], S));

        while (!minHeap.isEmpty()) {
            int currDist = minHeap.peek().distance;
            int currToNode = minHeap.peek().toNode;
            minHeap.remove();

            for (int i = 0; i < adj.get(currToNode).size(); i++) {
                int adjNode = adj.get(currToNode).get(i).get(0);
                int adjDist = adj.get(currToNode).get(i).get(1);

                if (currDist + adjDist < distance[adjNode]) {
                    distance[adjNode] = currDist + adjDist;
                    minHeap.add(new Pair(distance[adjNode], adjNode));
                }
            }
        }

        return distance;
    }

    static class Pair {
        int distance;
        int toNode;

        Pair(int distance, int toNode) {
            this.distance = distance;
            this.toNode = toNode;
        }
    }
}

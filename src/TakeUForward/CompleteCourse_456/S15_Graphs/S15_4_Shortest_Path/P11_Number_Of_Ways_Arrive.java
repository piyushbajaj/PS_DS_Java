package TakeUForward.CompleteCourse_456.S15_Graphs.S15_4_Shortest_Path;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S15_Graphs.S15_4_Shortest_Path
 * <p>
 * User: piyushbajaj
 * Date: 03/11/22
 * Time: 6:17 pm
 * <p>
 * Link g4g: <a href="https://practice.geeksforgeeks.org/problems/minimum-multiplications-to-reach-end/1">...</a>
 */
public class P11_Number_Of_Ways_Arrive {

    static class Pair {
        int distance, node;

        Pair(int distance, int node) {
            this.distance = distance;
            this.node = node;
        }
    }

    /**
     * Dijkstras Algo question
     * TC: ElogV
     *
     * @param n
     * @param roads
     * @return
     */
    public int countPaths(int n, List<List<Integer>> roads) {
        PriorityQueue<Pair> minPQ = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        List<List<Pair>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < roads.size(); i++) {
            adjList.get(roads.get(i).get(0)).add(new Pair(roads.get(i).get(2), roads.get(i).get(1)));
            adjList.get(roads.get(i).get(1)).add(new Pair(roads.get(i).get(2), roads.get(i).get(0)));
        }

        int[] ways = new int[n];
        int[] distance = new int[n];

        for (int i = 0; i < n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        distance[0] = 0;
        ways[0] = 1;

        minPQ.add(new Pair(0, 0));

        int mod = (int) 1e9 + 7;

        while (!minPQ.isEmpty()) {
            int currDistance = minPQ.peek().distance;
            int currNode = minPQ.peek().node;
            minPQ.poll();

            for (Pair adjPair : adjList.get(currNode)) {
                int adjNode = adjPair.node;
                int adjDistance = adjPair.distance;

                if (adjDistance + currDistance < distance[adjNode]) {
                    distance[adjNode] = adjDistance + currDistance;
                    minPQ.add(new Pair(distance[adjNode], adjNode));
                    ways[adjNode] = ways[currNode];
                } else if (adjDistance + currDistance == distance[adjNode]) {
                    ways[adjNode] = ways[adjNode] + ways[currNode] % mod;
                }
            }
        }

        return ways[n - 1] % mod;
    }

    public static void main(String[] args) {
        List<List<Integer>> edges =
            Arrays.asList(Arrays.asList(0, 6, 7), Arrays.asList(0, 1, 2), Arrays.asList(1, 2, 3), Arrays.asList(1, 3,
                    3), Arrays.asList(6, 3, 3), Arrays.asList(3, 5, 1), Arrays.asList(6, 5, 1), Arrays.asList(2, 5, 1),
                Arrays.asList(0, 4, 5), Arrays.asList(4, 6, 2));

        P11_Number_Of_Ways_Arrive p11_number_of_ways_arrive = new P11_Number_Of_Ways_Arrive();
        System.out.println(p11_number_of_ways_arrive.countPaths(7, edges));
    }
}

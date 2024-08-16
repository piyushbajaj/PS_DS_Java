package TakeUForward.CompleteCourse_456.S15_Graphs.S15_4_Shortest_Path;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S15_Graphs.S15_4_Shortest_Path
 * <p>
 * User: piyushbajaj
 * Date: 03/11/22
 * Time: 11:54 am
 * <p>
 * Link lc: <a href="https://leetcode.com/problems/cheapest-flights-within-k-stops/">...</a>
 * Link g4g: <a href="https://practice.geeksforgeeks.org/problems/cheapest-flights-within-k-stops/1">...</a>
 */
public class P9_CheapestFlight {
    public static void main(String[] args) {
        P9_CheapestFlight p9_cheapestFlight = new P9_CheapestFlight();

        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};

        System.out.println(p9_cheapestFlight.CheapestFLight(4, flights, 0, 3, 1));
    }

    /**
     * This is a variation of Dijkstras Algo, but there is some customization:
     * 1. Here we will consider Queue instead, because we are considering stops as the parameter in increasing order,
     * which will only get increment by 1.
     * 2. We will use distance array, which will store the cost for each path
     * TC: O(N) + O (flights.size)
     *
     * @param n
     * @param flights
     * @param src
     * @param dst
     * @param k
     * @return
     */
    public int CheapestFLight(int n, int flights[][], int src, int dst, int k) {
        Queue<Tuple> queue = new LinkedList<>();
        List<List<Tuple>> adjList = new ArrayList<>();

        int[] distance = new int[n];
        int rowLen = flights.length;

        // Creating Adjacent List from the flights matrix
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < rowLen; i++) {
            adjList.get(flights[i][0]).add(new Tuple(-1, flights[i][1], flights[i][2]));
        }

        distance[src] = 0;
        queue.add(new Tuple(0, src, 0));

        while (!queue.isEmpty()) {
            int currStops = queue.peek().stops;
            int currNode = queue.peek().node;
            int currDistance = queue.peek().distance;
            queue.poll();

            if (currStops > k) {
                continue;
            }

            for (Tuple adjTuple : adjList.get(currNode)) {
                int adjStops = adjTuple.stops;
                int adjNode = adjTuple.node;
                int adjDistance = adjTuple.distance;

                if (currDistance + adjDistance < distance[adjNode]) {
                    distance[adjNode] = currDistance + adjDistance;
                    queue.add(new Tuple(currStops + 1, adjNode, distance[adjNode]));
                }
            }
        }

        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }

    static class Tuple {
        int stops, node, distance;

        Tuple(int stops, int node, int distance) {
            this.stops = stops;
            this.node = node;
            this.distance = distance;
        }
    }
}

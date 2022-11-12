package TakeUForward.S15_Graphs.S15_5_MST_DisjointSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S15_Graphs.S15_5_Minimum_Spanning_Tree
 * <p>
 * User: piyushbajaj
 * Date: 04/11/22
 * Time: 8:02 pm
 * <p>
 * Link: <a href="https://practice.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1">...</a>
 */
public class P1_Prim_Algo_MST {

    static class Pair {
        int weight, node;

        Pair(int weight, int node) {
            this.weight = weight;
            this.node = node;
        }
    }

    /**
     * Approach:
     * 1. Create Minimum priority queue to store Weight, Node, and Parent
     * 2. Create visited array
     * 3. Return the sum of the weights
     * <p>
     * TC: ElogE
     * SC: V^2
     *
     * @param V
     * @param adj
     * @return
     */
    public int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        PriorityQueue<Pair> minimumPQ = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        boolean[] isVisited = new boolean[V];

        minimumPQ.add(new Pair(0, 0));
        int sum = 0;

        while (!minimumPQ.isEmpty()) {
            int currWeight = minimumPQ.peek().weight;
            int currNode = minimumPQ.peek().node;

            minimumPQ.poll();

            if (isVisited[currNode]) {
                continue;
            }

            // Add it to the MST
            isVisited[currNode] = true;
            sum += currWeight;

            for (int i = 0; i < adj.get(currNode).size(); i++) {
                int adjNode = adj.get(currNode).get(i).get(0);
                int adjWeight = adj.get(currNode).get(i).get(1);

                if (!isVisited[adjNode]) {
                    minimumPQ.add(new Pair(adjWeight, adjNode));
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        P1_Prim_Algo_MST p1_prim_algo_mst = new P1_Prim_Algo_MST();

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);

            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }

            int i = 0;
            while (i++ < E) {
                String S[] = read.readLine().trim().split(" ");

                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);

                ArrayList<Integer> t1 = new ArrayList<>();
                ArrayList<Integer> t2 = new ArrayList<>();

                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }

            System.out.println(p1_prim_algo_mst.spanningTree(V, adj));
        }
    }
}

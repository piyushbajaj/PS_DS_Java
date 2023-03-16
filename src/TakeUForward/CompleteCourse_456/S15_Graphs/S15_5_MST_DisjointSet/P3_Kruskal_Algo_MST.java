package TakeUForward.CompleteCourse_456.S15_Graphs.S15_5_MST_DisjointSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S15_Graphs.S15_5_Minimum_Spanning_Tree
 * <p>
 * User: piyushbajaj
 * Date: 08/11/22
 * Time: 7:34 pm
 *
 * Link: <a href="https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1">...</a>
 */
public class P3_Kruskal_Algo_MST {

    static class Tuple implements Comparable<Tuple> {
        int weight, u, v;

        Tuple(int weight, int u, int v) {
            this.weight = weight;
            this.u = u;
            this.v = v;
        }

        @Override
        public int compareTo(Tuple o) {
            return this.weight - o.weight;
        }
    }

    /**
     * Approach:
     * <p>
     * TC: O(M*logN + M*4*alpha*2)
     *
     * @param V
     * @param adj
     * @return
     */
    public int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        List<Tuple> tuples = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                int adjNode = adj.get(i).get(j).get(0);
                int adjWt = adj.get(i).get(j).get(1);
                int node = i;

                Tuple temp = new Tuple(adjWt, node, adjNode);
                tuples.add(temp);
            }
        }

        P2_Disjoint_Set disjoint_set = new P2_Disjoint_Set(V);
        Collections.sort(tuples);
        int mstWt = 0;

        for (int i = 0; i < tuples.size(); i++) {
            int currWt = tuples.get(i).weight;
            int currU = tuples.get(i).u;
            int currV = tuples.get(i).v;

            if (disjoint_set.findUParent(currU) != disjoint_set.findUParent(currV)) {
                disjoint_set.unionByRank(currU, currV);
                mstWt += currWt;
            }
        }

        return mstWt;
    }

    public static void main(String[] args) throws IOException {
        P3_Kruskal_Algo_MST p3_kruskal_algo_mst = new P3_Kruskal_Algo_MST();

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

            System.out.println(p3_kruskal_algo_mst.spanningTree(V, adj));
        }
    }
}

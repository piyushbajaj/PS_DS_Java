package TakeUForward.S15_Graphs.S15_5_MST_DisjointSet;

import java.util.ArrayList;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S15_Graphs.S15_5_MST_DisjointSet
 * <p>
 * User: piyushbajaj
 * Date: 09/11/22
 * Time: 9:46 am
 */
public class P4_Number_Of_Province {

    /**
     * TC: O(N^2)
     *
     * @param adjList
     * @param n
     * @return
     */
    public int numProvinces(ArrayList<ArrayList<Integer>> adjList, int n) {
        P2_Disjoint_Set disjoint_set = new P2_Disjoint_Set(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < adjList.get(i).size(); j++) {
                if (adjList.get(i).get(j) == 1) {
                    disjoint_set.unionBySize(i, j);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i == disjoint_set.parent.get(i)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

    }
}

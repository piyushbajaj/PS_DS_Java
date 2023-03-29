package TakeUForward.CompleteCourse_456.S15_Graphs.S15_2_BFS_DFS;

import java.util.ArrayList;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S15_Graphs.S15_2_BFS_DFS
 * <p>
 * User: piyushbajaj
 * Date: 09/10/22
 * Time: 9:59 pm
 * <p>
 * <p>
 * Link: <a href="https://leetcode.com/problems/number-of-provinces/">...</a>
 * TC: O(N) + O(V + 2 * E)
 */
public class P1_No_Of_Provinces {

    public static void main(String[] args) {
        P1_No_Of_Provinces p1_no_of_provinces = new P1_No_Of_Provinces();
        int[][] isConnected = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(p1_no_of_provinces.findCircleNum(isConnected));
    }

    /**
     * Approach:
     * TC: O(N) + O(V + 2 * E)
     *
     * @param isConnected
     * @return
     */
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        int n = isConnected.length;

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    adjList.get(i).add(j);
                }
            }
        }

        // visited boolean flag
        boolean[] visited = new boolean[n + 1];

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs_recur(i, adjList, visited);
            }
        }

        return count;
    }

    public void dfs_recur(int node, ArrayList<ArrayList<Integer>> adjList, boolean[] visited) {

        visited[node] = true;

        for (Integer it : adjList.get(node)) {
            if (!visited[it]) {
                dfs_recur(it, adjList, visited);
            }
        }
    }
}

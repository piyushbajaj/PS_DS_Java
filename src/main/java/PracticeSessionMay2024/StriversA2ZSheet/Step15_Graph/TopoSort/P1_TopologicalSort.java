package PracticeSessionMay2024.StriversA2ZSheet.Step15_Graph.TopoSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Project: DSAlgo
 * Package: PracticeSessionMay2024.StriversA2ZSheet.Step15_Graph.TopoSort
 * <p>
 * User: piyushbajaj
 * Date: 26/07/24
 * Time: 3:58 pm
 * <p>
 * Link: <a href="https://takeuforward.org/data-structure/topological-sort-algorithm-dfs-g-21/">...</a>
 * <p>
 * Steps:
 * 1. Instantiate:
 * 1.1 All adjacency list, which will hold the edges with empty array list
 * 1.2 Add edges into this list, means node and their edges
 * 1.3 isVisited[] array with the same size of vertices
 * 1.4 Stack(Integer) which will store vertex, where is no more unvisited nodes
 * 1.5 Pop the Stack and store into the ArrayList
 * 2. Start visiting nodes from 0 to V, also the one which is unvisited
 * 3. As the nodes gets visited, mark it 1
 * 4. Then for that node, go through each edges
 * 5. Once you reach the node when there is no more outdegree nodes or unvisited, loop is over
 * 6. Add that into stack
 * <p>
 * TC: O(V + E)
 * SC: O(2V)
 */
public class P1_TopologicalSort {

    ArrayList<ArrayList<Integer>> adjList;

    P1_TopologicalSort(int V) {
        adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    private void addEdge(int i, int j) {
        adjList.get(i).add(j);
    }

    public int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] isVisited = new int[V];
        Stack<Integer> stackOutput = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (isVisited[i] == 0) {
                dfs(adj, isVisited, i, stackOutput);
            }
        }

        while (!stackOutput.isEmpty()) {
            result.add(stackOutput.pop());
        }

        return result.stream().mapToInt(i -> i).toArray();
    }


    private void dfs(ArrayList<ArrayList<Integer>> adj, int[] isVisited, int currNode, Stack<Integer> stackOutput) {
        isVisited[currNode] = 1;
        for (Integer adjacentNode : adj.get(currNode)) {
            if (isVisited[adjacentNode] == 0) {
                dfs(adj, isVisited, adjacentNode, stackOutput);
            }
        }

        stackOutput.push(currNode);
    }


    public static void main(String[] args) {
        P1_TopologicalSort p1TopoSort = new P1_TopologicalSort(6);

        p1TopoSort.addEdge(5, 0);
        p1TopoSort.addEdge(4, 0);
        p1TopoSort.addEdge(5, 2);
        p1TopoSort.addEdge(4, 1);
        p1TopoSort.addEdge(2, 3);
        p1TopoSort.addEdge(3, 1);

        System.out.println(Arrays.toString(p1TopoSort.topoSort(6, p1TopoSort.adjList)));

    }
}

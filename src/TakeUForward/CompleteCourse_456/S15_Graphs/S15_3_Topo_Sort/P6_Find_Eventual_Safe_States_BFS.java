package TakeUForward.CompleteCourse_456.S15_Graphs.S15_3_Topo_Sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import TakeUForward.CompleteCourse_456.S15_Graphs.S15_1_Learning.P1_BFS;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S15_Graphs.S15_3_Topo_Sort
 * <p>
 * User: piyushbajaj
 * Date: 26/10/22
 * Time: 8:26 pm
 * <p>
 */
public class P6_Find_Eventual_Safe_States_BFS {
    public static void main(String[] args) {
        P6_Find_Eventual_Safe_States_BFS p6_find_eventual_safe_states_bfs = new P6_Find_Eventual_Safe_States_BFS();

        P1_BFS p1_bfs = new P1_BFS(7);
        p1_bfs.addEdge(0, 1, P1_BFS.GraphDirection.Directional);
        p1_bfs.addEdge(0, 2, P1_BFS.GraphDirection.Directional);
        p1_bfs.addEdge(1, 2, P1_BFS.GraphDirection.Directional);
        p1_bfs.addEdge(1, 3, P1_BFS.GraphDirection.Directional);
        p1_bfs.addEdge(2, 5, P1_BFS.GraphDirection.Directional);
        p1_bfs.addEdge(3, 0, P1_BFS.GraphDirection.Directional);
        p1_bfs.addEdge(4, 5, P1_BFS.GraphDirection.Directional);

        System.out.println(p6_find_eventual_safe_states_bfs.eventualSafeNodes(7, p1_bfs.adjList));

        int[][] graph = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};

        System.out.println(p6_find_eventual_safe_states_bfs.eventualSafeNodes(graph));
    }

    public List<Integer> eventualSafeNodes(int V, ArrayList<ArrayList<Integer>> adj) {
        List<List<Integer>> adjReverse = new ArrayList<>();
        List<Integer> safeNodes = new ArrayList<>();

        Queue<Integer> queueElements = new LinkedList<>();
        int[] indeqree = new int[V];

        //Reverse the adjacent nodes
        for (int i = 0; i < V; i++) {
            adjReverse.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            for (Integer adjNode : adj.get(i)) {
                adjReverse.get(adjNode).add(i);
                indeqree[i]++;
            }
        }

        for (int i = 0; i < V; i++) {
            if (indeqree[i] == 0) {
                queueElements.add(i);
            }
        }

        while (!queueElements.isEmpty()) {
            int currElement = queueElements.poll();
            safeNodes.add(currElement);

            for (Integer adjNode : adjReverse.get(currElement)) {
                if (indeqree[adjNode] > 0) {
                    indeqree[adjNode]--;
                }

                if (indeqree[adjNode] == 0) {
                    queueElements.add(adjNode);
                }
            }
        }

        Collections.sort(safeNodes);
        return safeNodes;
    }

    // Leetcode: https://leetcode.com/problems/find-eventual-safe-states/
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                adj.get(i).add(graph[i][j]);
            }
        }

        List<List<Integer>> adjReverse = new ArrayList<>();
        List<Integer> safeNodes = new ArrayList<>();

        Queue<Integer> queueElements = new LinkedList<>();
        int[] indeqree = new int[V];

        //Reverse the adjacent nodes
        for (int i = 0; i < V; i++) {
            adjReverse.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            for (Integer adjNode : adj.get(i)) {
                adjReverse.get(adjNode).add(i);
                indeqree[i]++;
            }
        }

        for (int i = 0; i < V; i++) {
            if (indeqree[i] == 0) {
                queueElements.add(i);
            }
        }

        while (!queueElements.isEmpty()) {
            int currElement = queueElements.poll();
            safeNodes.add(currElement);

            for (Integer adjNode : adjReverse.get(currElement)) {
                if (indeqree[adjNode] > 0) {
                    indeqree[adjNode]--;
                }

                if (indeqree[adjNode] == 0) {
                    queueElements.add(adjNode);
                }
            }
        }

        Collections.sort(safeNodes);
        return safeNodes;

    }
}

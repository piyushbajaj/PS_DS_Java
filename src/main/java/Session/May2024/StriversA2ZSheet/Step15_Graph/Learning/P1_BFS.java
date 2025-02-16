package Session.May2024.StriversA2ZSheet.Step15_Graph.Learning;

import java.util.ArrayList;

/**
 * Project: DSAlgo
 * Package: PracticeSessionMay2024.StriversA2ZSheet.Step15_Graph.BFS_DFS
 * <p>
 * User: piyushbajaj
 * Date: 25/07/24
 * Time: 9:06 pm
 * <p>
 * Link: <a href="https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1">...</a>
 */
public class P1_BFS {

    ArrayList<ArrayList<Integer>> adj;

    P1_BFS(int capacity) {
        this.adj = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            this.adj.add(new ArrayList<>());
        }

    }

    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result = new ArrayList<>();

        return result;
    }

    public enum Direction {
        DIRECTIONAL,
        BI_DIRECTIONAL
    }

    public void addEdge(Direction direction, int i, int j) {
        switch (direction) {
            case DIRECTIONAL: {
                adj.get(i).add(j);
            }

            case BI_DIRECTIONAL: {
                adj.get(i).add(j);
                adj.get(j).add(i);
            }
        }
    }

    public static void main(String[] args) {

        P1_BFS p1_bfs = new P1_BFS(5);
        p1_bfs.addEdge(Direction.DIRECTIONAL, 0, 1);
        p1_bfs.addEdge(Direction.DIRECTIONAL, 0, 2);
        p1_bfs.addEdge(Direction.DIRECTIONAL, 0, 3);
        p1_bfs.addEdge(Direction.DIRECTIONAL, 2, 4);

        System.out.println(p1_bfs.adj);
    }
}

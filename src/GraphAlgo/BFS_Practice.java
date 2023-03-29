package GraphAlgo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by piyush.bajaj on 27/03/17.
 */
public class BFS_Practice {
    private int vertexCount;
    private int V;//Total no of vertex count
    private LinkedList<Integer> adjList[];
    private Vertex vertexList[];
    private Queue<Integer> queue = new LinkedList<Integer>();
    public BFS_Practice(int V) {
        this.V = V;
        this.vertexCount = 0;
        adjList = new LinkedList[V];
        vertexList = new Vertex[V];

        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public static void main(String[] args) {
        BFS_Practice g = new BFS_Practice(8);

        g.addVertices('A');
        g.addVertices('B');
        g.addVertices('F');
        g.addVertices('H');
        g.addVertices('G');


        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 6);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(4, 5);
        g.addEdge(4, 6);
        g.addEdge(4, 7);

        System.out.println("Following is Breadth First Traversal");

        g.BFS_Function();
    }

    public void addVertices(char verLabel) {
        vertexList[vertexCount++] = new Vertex(verLabel);
    }

    public void addEdge(int i, int j) {
        adjList[i].add(j);
    }

    public void BFS_Function() {
        for (int i = 0; i < this.V; i++) {
            if (vertexList[i].visited == false) {
                BFS_Util(i);
            }
        }

    }

    public void BFS_Util(int value) {
        vertexList[value].visited = true;
        System.out.print(vertexList[value].label + " ");

        queue.add(value);
        int temp1 = 0;

        while (!queue.isEmpty()) {
            int temp = queue.remove();
            while ((temp1 = checkNextVal(temp)) != -1) {
                vertexList[temp1].visited = true;
                System.out.print(vertexList[temp1].label + " ");
                queue.add(temp1);
            }
        }

    }

    public int checkNextVal(int val) {
        for (int i = 0; i < this.V; i++) {
            if (adjList[val].contains(i) && vertexList[i].visited == false) {
                return i;
            }
        }
        return -1;
    }

    public class Vertex {
        char label;
        boolean visited;

        Vertex(char label) {
            this.label = label;
            this.visited = false;
        }
    }


}

package GraphAlgo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by piyush.bajaj on 10/01/17.
 */
public class TopologicalSorting {
    Stack<Integer> stk = new Stack<>();
    //For adding random vertices
    private Vertex vertexList[];
    private int V; //Number of vertices
    //Array of lists for Adjacency list representation
    private LinkedList<Integer> adjList[];
    private int vertexCount;

    public TopologicalSorting(int v) {
        this.V = v;
        vertexCount = 0;
        adjList = new LinkedList[V];
        vertexList = new Vertex[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public static void main(String[] args) {
        TopologicalSorting TS = new TopologicalSorting(8);

        TS.addVertex(2);
        TS.addVertex(3);
        TS.addVertex(5);
        TS.addVertex(7);
        TS.addVertex(8);
        TS.addVertex(9);
        TS.addVertex(10);
        TS.addVertex(11);

//        TS.addVertex(0);
//        TS.addVertex(1);
//        TS.addVertex(2);
//        TS.addVertex(3);
//        TS.addVertex(4);
//        TS.addVertex(5);


        TS.addEdge(3, 7);
        TS.addEdge(3, 4);
        TS.addEdge(2, 7);
        TS.addEdge(1, 4);
        TS.addEdge(1, 6);
        TS.addEdge(7, 0);
        TS.addEdge(7, 6);
        TS.addEdge(4, 5);
        //TS.addEdge(4, 7);

//        TS.addEdge(5, 2);
//        TS.addEdge(5, 0);
//        TS.addEdge(4, 0);
//        TS.addEdge(4, 1);
//        TS.addEdge(2, 3);
//        TS.addEdge(3, 1);

//        TS.addEdge(0, 1);
//        TS.addEdge(0, 5);
//        TS.addEdge(4, 5);
//        TS.addEdge(4, 3);
//        TS.addEdge(1, 2);
//        TS.addEdge(2, 3);


//        TS.addEdge(3, 7);
//        TS.addEdge(4, 6);
//        TS.addEdge(4, 7);

        TS.topologicalSort();

    }

    public void addVertex(int ver) {
        vertexList[vertexCount++] = new Vertex(ver);
    }

    public void addEdge(int u, int v) {
        adjList[u].add(v);
    }

    public void topologicalSort_Util(int ver) {
        vertexList[ver].visited = true;

        Iterator<Integer> itr = adjList[ver].iterator();
        while (itr.hasNext()) {
            int i = itr.next();
            if (!vertexList[i].visited) {
                topologicalSort_Util(i);
            }
        }
        stk.push(ver);

    }

    public void topologicalSort() {

        for (int i = 0; i < V; i++) {
            if (!vertexList[i].visited) {
                topologicalSort_Util(i);
            }
        }

        while (!stk.isEmpty()) {
            System.out.print(vertexList[stk.pop()].label + " ");
        }

        for (int i = 0; i < V; i++) {
            vertexList[i].visited = false;
        }
    }

    public class Vertex {
        private int label;
        private boolean visited;

        public Vertex(int lab) {
            label = lab;
            visited = false;
        }
    }

}

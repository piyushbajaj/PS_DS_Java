package GraphAlgo;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by piyush.bajaj on 08/01/17.
 */
public class DFS {

    //For adding random vertices
    public Vertex vertexList[];
    private int V; //Number of vertices
    //Array of lists for Adjacency list representation
    private LinkedList<Integer> adjList[];
    private int vertexCount;


    public DFS(int vertices) {
        V = vertices;
        adjList = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList();
        }

        vertexList = new Vertex[V];
        vertexCount = 0;
    }

    public static class Vertex {
        public int label;
        public boolean visited;

        public Vertex(int lab) {
            label = lab;
            visited = false;
        }
    }

    //static boolean[] visited;

    public void addEdge(int i, int j) {
        adjList[i].add(j);
        adjList[j].add(i);
    }

    public void addVertices(int v) {
        vertexList[vertexCount++] = new Vertex(v);
    }

    public void DFS_fun() {
        //mark all the vertex as FALSE


        for (int i = 0; i < V; i++) {
            if (vertexList[i].visited == false)
                DFS_Utility(i, vertexList[i].visited);
        }

        //reset flags
        for (int i = 0; i < V; i++) {
            vertexList[i].visited = false;
        }
    }

    public void DFS_Utility(int v, boolean visited) {

        //mark the first node as visited
        vertexList[v].visited = true;
        System.out.print(vertexList[v].label + " ");
        Stack<Integer> stk = new Stack<Integer>();
        stk.push(v);

        while (!stk.isEmpty()) {
            int temp = nextElement(stk.pop());
            //if()
            if (temp != -1) {
//                stk.pop();
//            else
                vertexList[temp].visited = true;
                System.out.print(vertexList[temp].label + " ");
                stk.push(temp);

            }

        }
    }

    public int nextElement(int v) {
        for (int i = 0; i < V; i++)
            if (adjList[v].contains(i) && vertexList[i].visited == false)
                return i;
        return -1;
    }

    public static void main(String[] args) {
        //DFS g = new DFS(4);
        DFS g = new DFS(8);


//        g.addVertices(0);
//        g.addVertices(1);
//        g.addVertices(2);
//        g.addVertices(3);
//        //g.addVertices(4);
//
//        g.addEdge(0, 1);
//        g.addEdge(0, 2);
//        g.addEdge(1, 2);
//        g.addEdge(2, 0);
//        g.addEdge(2, 3);
//        g.addEdge(3, 3);


        g.addVertices(10);
        g.addVertices(20);
        g.addVertices(30);
        g.addVertices(40);
        g.addVertices(50);
        g.addVertices(60);

        g.addVertices(70);
        g.addVertices(80);

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 6);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(4, 5);
        g.addEdge(4, 6);
        g.addEdge(4, 7);

        System.out.println("Following is Depth First Traversal");

        g.DFS_fun();

    }


}

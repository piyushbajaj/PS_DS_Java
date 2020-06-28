package GraphAlgo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by piyush.bajaj on 11/01/17.
 * Algorithm for Calculating SHortest Path in UnWeighted Graph:
 * 1. Create Vertex class.
 * 2. Create addEdge and addVertex function.
 * 3. Create a function ShotestPath(int s){
 *     a. Initialize every distance to be -1, and the source to be 0
 *     b. Initialize every path to be -.
 *     c. This will be done using Queue, where first will add that element in queue
 *
 *     queue.add(s)
 *     while(!queue.isEmpty){
 *         int v = queue.remove;
 *
 *         for(int i: adjList[v]){
 *             if(Distance[i] == -1){
 *                 Distance[i] = Distance[v] + 1;
 *                 Path[i] = vertexList[i].label;
 *                 queue.add(i);
 *             }
 *         }
 *     }
 * }
 */
public class ShortestPathUnweight {
    public class Vertex{
        public char label;
        public boolean visited;

        public Vertex(char lab){
            label = lab;
            visited = false;
        }
    }

    //For adding random vertices
    public Vertex vertexList[];
    private int V; //Number of vertices
    //Array of lists for Adjacency list representation
    private LinkedList<Integer> adjList[];
    private int vertexCount;
    static int[] Distance;
    static char[] Path;



    public ShortestPathUnweight(int v){
        this.V = v;
        vertexCount = 0;
        adjList = new LinkedList[V];
        vertexList = new Vertex[V];

        Distance = new int[V];
        Path = new char[V];

        for(int i = 0; i < V; i++){
            adjList[i] = new LinkedList<>();
        }
    }

    public void addVertex(char ver){
        vertexList[vertexCount++] = new Vertex(ver);
    }

    public void addEdge(int u, int v){
        adjList[u].add(v);
    }


    public void UnweightedShortest(int s){
        Queue<Integer> queue = new LinkedList<>();
        int v, w;
        queue.add(s);

        for(int i = 0; i < V; i++){
            Distance[i] = -1;
        }
        Distance[s] = 0;

        for(int i = 0; i < V; i++){
            Path[i] = '-';
        }

        while (!queue.isEmpty()){
            v = queue.remove();

            for(int i: adjList[v]){
                if(Distance[i] == -1){
                    Distance[i] = Distance[v] + 1;
                    Path[i] = vertexList[v].label;
                    queue.add(i);
                }
            }
        }
    }

    public void printGraph(){
        for(int i=0; i < V; i++){
            System.out.println("Vertex: " + vertexList[i].label + "  Distance from source: " + Distance[i] + "  Previous vertex which gave the distance: " +
                    Path[i]);
        }
    }

    public static void main(String[] args) {
        ShortestPathUnweight SW = new ShortestPathUnweight(7);
        SW.addVertex('A');
        SW.addVertex('B');
        SW.addVertex('C');
        SW.addVertex('D');
        SW.addVertex('E');
        SW.addVertex('F');
        SW.addVertex('G');

        SW.addEdge(0, 1);
        SW.addEdge(0, 3);
        SW.addEdge(1, 3);
        SW.addEdge(1, 4);
        SW.addEdge(2, 0);
        SW.addEdge(2, 5);
        SW.addEdge(3, 5);
        SW.addEdge(3, 6);
        SW.addEdge(4, 6);
        SW.addEdge(6, 5);

        SW.UnweightedShortest(0);

        SW.printGraph();
    }
}

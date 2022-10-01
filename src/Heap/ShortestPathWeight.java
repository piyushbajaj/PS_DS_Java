package Heap;

import java.util.LinkedList;

/**
 * Created by piyush.bajaj on 12/01/17.
 */
public class ShortestPathWeight {
//    public class Edge
//    {
//        public int dest;
//        public int weight;
//        public Edge(int dest,int weight)
//        {
//            this.dest=dest;
//            this.weight=weight;
//        }
//    }

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
    private int wtList[][];
    private int vertexCount;
    static int[] Distance;
    static char[] Path;

    private int weight;





    public ShortestPathWeight(int v){
        this.V = v;
        vertexCount = 0;
        adjList = new LinkedList[V];
        wtList = new int[V][V];
        vertexList = new Vertex[V];

        Distance = new int[V];
        Path = new char[V];

        for(int i = 0; i < V; i++){
            adjList[i] = new LinkedList<>();
            //wtList[i] = new LinkedList.LinkedList<>();
        }
    }

    public void addVertex(char ver){
        vertexList[vertexCount++] = new Vertex(ver);
    }

    public void addEdge(int u, int v, int weight){
        //Edge e1=new Edge(v,weight);
        //Edge e2=new Edge(u,weight);

        adjList[u].add(v);
        adjList[v].add(u);
        wtList[u][v] = weight;
        wtList[v][u] = weight;
    }


    public void weightedShortest(int s){
        //Queue<Integer> queue = new LinkedList.LinkedList<>();
        //PriorityQueue<Integer> Pqueue = new PriorityQueue<>();



        MinHeap queue = new MinHeap(V);

        //BinaryMinHeap<Integer> BH = new BinaryMinHeap<>();

        int v, d, k;
        queue.insert(s);
        //BH.add;

        for(int i = 0; i < V; i++){
            Distance[i] = Integer.MAX_VALUE;
            //queue.add(i);
          //  queue.insert(Distance[i]);
            //Pqueue.add(i);
        }
        Distance[s] = 0;

        queue.decreaseKey(s, 0);


        for(int i = 0; i < V; i++){
            Path[i] = '-';
        }

        //Path[s] = 'null';

        while (!queue.isEmpty()){
            v = queue.extractMin();

            //MinHeap

            //v = queue.extractMin();
            //queue.delete(queue.extractMin());

//            Distance[v] =
           vertexList[v].visited = true;

            for(int i: adjList[v]){
                d = Distance[v] + wtList[i][v];
                if(!vertexList[i].visited && (wtList[i][v] != 0|| wtList[v][i]!=0)
                        && Distance[v] != Integer.MAX_VALUE && d < Distance[i]){

                    Distance[i] = d;
                    queue.decreaseKey(i, d);
                    Path[i] = vertexList[v].label;

                    //queue.add(i);
                }
            }
        }
    }

    public void printGraph(){
        for(int i=0; i < V; i++){
            System.out.println("Vertex: " + vertexList[i].label + "  Distance from source: " + Distance[i]
                    + "  Previous vertex which gave the distance: " +
                    Path[i]);
        }
    }

    public static void main(String[] args) {
        ShortestPathWeight SW = new ShortestPathWeight(6);
        SW.addVertex('A');
        SW.addVertex('B');
        SW.addVertex('C');
        SW.addVertex('D');
        SW.addVertex('E');
        SW.addVertex('F');


        SW.addEdge(0, 1, 5);
        SW.addEdge(0, 4, 2);
        SW.addEdge(0, 3, 9);
        SW.addEdge(1, 2, 2);
        SW.addEdge(2, 3, 3);
        SW.addEdge(3, 5, 2);
        SW.addEdge(4, 5, 3);

        SW.weightedShortest(0);

        SW.printGraph();
    }
}

package GraphAlgo;

/**
 * Created by piyush.bajaj on 13/01/17.
 */
public class BellmanFord {
//    public static class Vertex {
//        public int label;
//        public boolean visited;
//
//        public Vertex(int lab) {
//            label = lab;
//            visited = false;
//        }
//    }

    public class Edge{
        int src, dest, weight;
        public Edge(){
            src = dest = weight = 0;
        }
    }

    int V, E;
    Edge edge[];

//    public Vertex vertexList[];
//    int flag = 0; // to detect cycle
//    private int V; //Number of vertices
//    //Array of lists for Adjacency list representation
//    private LinkedList.LinkedList<Integer> adjList[];
//    private int vertexCount;

    public BellmanFord(int v, int e) {
//        V = vertices;
//        adjList = new LinkedList.LinkedList[V];
//
//        for (int i = 0; i < V; i++) {
//            adjList[i] = new LinkedList.LinkedList();
//        }
//
//        vertexList = new Vertex[V];
//        vertexCount = 0;
        V = v;
        E = e;
        edge = new Edge[e];

        for(int i = 0; i < e; i++){
            edge[i] = new Edge();
        }


    }

//    public void addEdge(int i, int j) {
//        adjList[i].add(j);
//        adjList[j].add(i); ///Add this in case of Undirected graph
//    }
//
//    public void addVertices(int v) {
//        vertexList[vertexCount++] = new Vertex(v);
//    }

    public void BellmanFord_Algo(BellmanFord g, int s){
        V = g.V;
        E = g.E;

        int[] dist = new int[V];
        //Intialize all the vertices to max from source to dest
        for(int i = 0; i < V; i++ ){
            dist[i] = Integer.MAX_VALUE;
        }

        dist[s] = 0;

        //Relax all edges V-1 times. A simple shortest path from source to any other vertex can have atmost V-1 edges
        for(int i = 0; i < V-1; i++){
            for(int j = 0; j < E; j++){
                int u = g.edge[j].src;
                int v = g.edge[j].dest;
                int weight = g.edge[j].weight;
                if(dist[u]!= Integer.MAX_VALUE && dist[v] > dist[u] + weight){
                    dist[v] = dist[u] + weight;
                }
            }
        }
        printArr(dist, V);

        System.out.println();

        //To check negative weight cycle, just iterate one more time
        for(int j = 0; j < E; j++){
            int u = g.edge[j].src;
            int v = g.edge[j].dest;
            int weight = g.edge[j].weight;
            if(dist[u]!= Integer.MAX_VALUE && dist[v] > dist[u] + weight){
                System.out.print("Graph contains negative weight cycle");
            }
        }

        printArr(dist, V);


    }

    void printArr(int dist[], int V)
    {
        System.out.println("Vertex     Distance from Source");
        for (int i=0; i<V; ++i)
            System.out.println(i+"\t\t\t"+dist[i]);
    }




    public static void main(String[] args) {
        BellmanFord g = new BellmanFord(4, 4);

        g.edge[0].src = 0;
        g.edge[0].dest = 1;
        g.edge[0].weight = 1;

        g.edge[1].src = 1;
        g.edge[1].dest = 2;
        g.edge[1].weight = 3;

        g.edge[2].src = 2;
        g.edge[2].dest = 3;
        g.edge[2].weight = 2;

        g.edge[3].src = 3;
        g.edge[3].dest = 1;
        g.edge[3].weight = -6;



        g.BellmanFord_Algo(g, 0);
    }


}

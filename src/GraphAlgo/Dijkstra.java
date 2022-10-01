//package GraphAlgo;
//
//import Heap.MinHeap;
//import java.util.LinkedList;
//import java.util.Queue;
//
////
////import java.util.ArrayList;
////import java.util.Collections;
////import java.util.List;
////import java.util.PriorityQueue;
////
/////**
//// * Created by piyush.bajaj on 12/01/17.
//// */
////class Vertex implements Comparable<Vertex>
////{
////    public final String name;
////    public Edge[] adjacencies;
////    public double minDistance = Double.POSITIVE_INFINITY;
////    public Vertex previous;
////    public Vertex(String argName) { name = argName; }
////    @Override
////    public String toString() { return name; }
////    @Override
////    public int compareTo(Vertex other)
////    {
////        return Double.compare(minDistance, other.minDistance);
////    }
////}
////
////class Edge
////{
////    public final Vertex target;
////    public final double weight;
////    public Edge(Vertex argTarget, double argWeight)
////    {
////        target = argTarget;
////        weight = argWeight;
////    }
////}
////
////
////public class Dijkstra {
////    public static void computePaths(Vertex source)
////    {
////        source.minDistance = 0;
////        //PriorityQueue   <Vertex> vertexQueue = new PriorityQueue<>();
////        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
////        vertexQueue.add(source);
////
////        while (!vertexQueue.isEmpty())
////        {
////            Vertex u = vertexQueue.poll();
////
////            // Visit each edge exiting u
////            for (Edge e : u.adjacencies)
////            {
////                Vertex v = e.target;
////                double weight = e.weight;
////                double distanceThroughU = u.minDistance + weight;
////                if (distanceThroughU < v.minDistance) {
////                    vertexQueue.remove(v);
////                    v.minDistance = distanceThroughU ;
////                    v.previous = u;
////                    vertexQueue.add(v);
////                }
////            }
////        }
////    }
////
////    public static List<Vertex> getShortestPathTo(Vertex target)
////    {
////        // List<Vertex> path = new ArrayList<>();
////        List<Vertex> path = new ArrayList<Vertex>();
////
////        for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
////            path.add(vertex);
////
////        Collections.reverse(path);
////        return path;
////    }
////
////    public static void main(String[] args)
////    {
////        Vertex v1 = new Vertex("A");
////        Vertex v2 = new Vertex("B");
////        Vertex v3 = new Vertex("C");
////        Vertex v4 = new Vertex("D");
////        Vertex v5 = new Vertex("E");
////        Vertex v6 = new Vertex("F");
////
////        v1.adjacencies = new Edge[]{ new Edge(v1, 5), new Edge(v5, 2)};
////        v2.adjacencies = new Edge[]{ new Edge(v0, 5), new Edge(v2, 3),  new Edge(v4, 7) };
////        v2.adjacencies = new Edge[]{ new Edge(v0, 10), new Edge(v1, 3) };
////        v3.adjacencies = new Edge[]{ new Edge(v0, 8), new Edge(v4, 2) };
////        v4.adjacencies = new Edge[]{ new Edge(v1, 7), new Edge(v3, 2) };
////
////        Vertex[] vertices = { v0, v1, v2, v3, v4 };
////
////        computePaths(v0);
////
////        for (Vertex v : vertices)
////        {
////            System.out.println("Distance to " + v + ": " + v.minDistance);
////            List<Vertex> path = getShortestPathTo(v);
////            System.out.println("Path: " + path);
////        }
////    }
////}
//public class Dijkstra {
//
//	private int V; //Actual number of vertex
//	private int vertexCount; //Will keep incrementing as vertex gets added
//	private LinkedList<Integer> adjList[]; //To keep list of connections
//	private Vertex vertexList[]; //To keep vertex as a list of array
//	private Queue<Integer> queue = new LinkedList<>();
//
//	public class Vertex{
//		public char label;
//		public boolean visited;
//
//		public Vertex(char lab){
//			label = lab;
//			visited = false;
//		}
//	}
//
//	public void addVertices(char v){
//		vertexList[vertexCount++] = new Vertex(v);
//	}
//
//	public void addEdge(int i, int j){
//		adjList[i].add(j);
//	}
//
//	public Dijkstra(int vertex){
//		V = vertex;
//		vertexCount = 0;
//		vertexList = new Vertex[V];
//		adjList = new LinkedList[V];
//		queue = new LinkedList<Integer>();
//
//		for(int i = 0; i < V; i++)
//			adjList[i] = new LinkedList<>();
//	}
//
//	int minDistance(int dist[], Boolean sptSet[])
//	{
//		// Initialize min value
//		int min = Integer.MAX_VALUE, min_index = -1;
//
//		for (int v = 0; v < V; v++)
//			if (sptSet[v] == false && dist[v] <= min) {
//				min = dist[v];
//				min_index = v;
//			}
//
//		return min_index;
//	}
//
//	void printSolution(int dist[])
//	{
//		System.out.println("Vertex \t\t Distance from Source");
//		for (int i = 0; i < V; i++)
//			System.out.println(i + " \t\t " + dist[i]);
//	}
//
//	public void dijkstraAlgo(int graph[][], int src) {
//		int dist[] = new int[V]; // The output array. dist[i] will hold
//		// the shortest distance from src to i
//
//		// sptSet[i] will true if vertex i is included in shortest
//		// path tree or shortest distance from src to i is finalized
//		Boolean sptSet[] = new Boolean[V];
//
//		// Initialize all distances as INFINITE and stpSet[] as false
//		for (int i = 0; i < V; i++) {
//			dist[i] = Integer.MAX_VALUE;
//			sptSet[i] = false;
//		}
//
//		// Distance of source vertex from itself is always 0
//		dist[src] = 0;
//
//		// Find shortest path for all vertices
//		for (int count = 0; count < V - 1; count++) {
//			// Pick the minimum distance vertex from the set of vertices
//			// not yet processed. u is always equal to src in first
//			// iteration.
//			int u = minDistance(dist, sptSet);
//
//			// Mark the picked vertex as processed
//			sptSet[u] = true;
//
//			// Update dist value of the adjacent vertices of the
//			// picked vertex.
//			for (int v = 0; v < V; v++)
//
//				// Update dist[v] only if is not in sptSet, there is an
//				// edge from u to v, and total weight of path from src to
//				// v through u is smaller than current value of dist[v]
//				if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
//					dist[v] = dist[u] + graph[u][v];
//		}
//
//		// print the constructed distance array
//		printSolution(dist);
//	}
//
//	static int[] dist = new int[4];
//
//	public void dijkstraAlgo1(int graph[][], int src) {
//		MinHeap minHeap = new MinHeap(4);
//		minHeap.insert(src);
//		dist[src] = 0;
//		for(int i = 1; i < 4; i++) {
//			minHeap.insert(Integer.MAX_VALUE);
//			dist[i] = Integer.MAX_VALUE;
//		}
//
//		while (!minHeap.isEmpty()) {
//			int curr = minHeap.extractMin();
//			for()
//		}
//
//
//
//	}
//
//	public static void main(String[] args) {
////		int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
////			{ 4, 0, 8, 0, 0, 0, 0, 11, 0 },
////			{ 0, 8, 0, 7, 0, 4, 0, 0, 2 },
////			{ 0, 0, 7, 0, 9, 14, 0, 0, 0 },
////			{ 0, 0, 0, 9, 0, 10, 0, 0, 0 },
////			{ 0, 0, 4, 14, 10, 0, 2, 0, 0 },
////			{ 0, 0, 0, 0, 0, 2, 0, 1, 6 },
////			{ 8, 11, 0, 0, 0, 0, 1, 0, 7 },
////			{ 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
//
//		Dijkstra g = new Dijkstra(4);
//
//		g.addVertices('A');
//		g.addVertices('B');
//		g.addVertices('C');
//		g.addVertices('D');
//
//		g.addEdge(0, 1);
//		g.addEdge(1, 2);
//		g.addEdge(1, 6);
//		g.addEdge(2, 3);
//		g.addEdge(2, 4);
//		g.addEdge(4, 5);
//		g.addEdge(4, 6);
//		g.addEdge(4, 7);
//
//		int graph[][] = new int[][] {
//			{0, 10, 15, 0},
//			{10, 0, 5, 16},
//			{20, 5, 0, 20},
//			{0, 16, 20, 0}
//		};
//		Dijkstra t = new Dijkstra();
//		t.dijkstraAlgo(graph, 0);
//	}
//}
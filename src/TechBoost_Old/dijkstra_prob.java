package TechBoost_Old;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Created by piyush.bajaj on 08/04/18.
 */
public class dijkstra_prob {
    int V;
    LinkedList<Integer> adjList[];
    Vertex vertexList[];
    int[][] weightList;
    int vertexCount = 0;
    int[] distanceArr;

    MinHeap minHeap;

    class Vertex{
        public char label;
        public boolean visited;

        Vertex(char label){
            this.label = label;
            this.visited = false;
        }
    }

    class Weight{
        public int weight;
    }

    dijkstra_prob(int V){
        this.V = V;
        adjList = new LinkedList[V];
        vertexList = new Vertex[V];
        weightList = new int[V][V];

        distanceArr = new int[V];
        minHeap = new MinHeap(V);

        for(int i = 0; i < V; i++){
            adjList[i] = new LinkedList<Integer>();
        }

        distanceArr[0] = 0;
        minHeap.insert(0);
        for(int i = 1; i < V; i++){
            distanceArr[i] = Integer.MAX_VALUE;
            minHeap.insert(Integer.MAX_VALUE);
        }

    }

    //Single direction Graph
    public void addEdge(int i, int j, int weight){
        adjList[i].add(j);
        weightList[i][j] = weight;
    }

    public void addVertex(char ver){
        vertexList[vertexCount++] = new Vertex(ver);
    }

    PriorityQueue<Integer> pq = new PriorityQueue<>();

    public int getIndex(int val){
        for(int i = 0; i < V; i++){
            if(distanceArr[i] == val && vertexList[i].visited == false) {
                vertexList[i].visited = true;
                return i;
            }
        }
        return -1;
    }

    public void calculate(){
        //minHeap.insert(distanceArr[0]);

        int curr = 0;

        while (minHeap.size > 0){
            curr = minHeap.extractMin();
            int index = getIndex(curr);
            if(index == -1) break;
            Iterator<Integer> iterator = adjList[index].listIterator();

            while (iterator.hasNext()){
                int temp = iterator.next();
                if(distanceArr[temp] > distanceArr[index] + weightList[index][temp]){
                    distanceArr[temp] = distanceArr[index] + weightList[index][temp];
                }
                minHeap.arr[temp] = distanceArr[temp];
                minHeap.fixDownwards(temp);
            }
        }
    }

    public void print(){
        for(int i = 0; i < V; i++){
            System.out.println(vertexList[i].label + ": " + distanceArr[i]);
        }
    }

    public static void main(String[] args) {
        dijkstra_prob dp = new dijkstra_prob(5);
        dp.addVertex('A');
        dp.addVertex('B');
        dp.addVertex('C');
        dp.addVertex('D');
        dp.addVertex('E');

        dp.addEdge(0, 1, 4);
        dp.addEdge(0, 2, 1);
        dp.addEdge(1, 4, 4);
        dp.addEdge(2, 1, 2);
        dp.addEdge(2, 3, 4);
        dp.addEdge(3, 4, 4);

        dp.calculate();

        dp.print();
    }
}

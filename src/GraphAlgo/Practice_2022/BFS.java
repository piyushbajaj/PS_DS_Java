package GraphAlgo.Practice_2022;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

/**
 * Created by bajajp on 18 May, 2022
 */
public class BFS extends BaseGraphAdjacencyList {
    /**
     * 1. Vertex Array List
     * 2. Each Vertex has their own Linked List
     * 3. Vertex Stores char and index
     * 4. Maintain maximum capacity
     * 5. Maintain vertex count
     * <p>
     * TC: O(V+E) if we use Adjacency List for storing all the graphs, while O(V^2) if we use Adjacency Matrix
     * SC: O(V+E)
     * <p>
     * Algo:
     * 1. Create a static vertex class, which will store vertex label and bool isVisited flag for each vertex
     * 2. Define all these member variables:
     * 2.1 Total number of vertices
     * 2.2 Incremental vertex count
     * 2.3 Queue for storing indexes of BFS traversal
     * 2.4 LinkedList Array for storing edges from each vertex
     * 2.5 VertexList Array for storing max vertices
     * 3. Initialize LinkedList Array for all the vertex.
     * <p>
     * TC: O(V+E) if we use Adjacency List for storing all the graphs, while O(V^2) if we use Adjacency Matrix
     * SC: O(V+E)
     **/

    @SuppressWarnings("unchecked")
    BFS(int capacity) {
        super(capacity);
    }

    public static void main(String[] args) {
        BFS bfs = new BFS(8);
        bfs.addVertex("A");
        bfs.addVertex("B");
        bfs.addVertex("C");
        bfs.addVertex("D");
        bfs.addVertex("E");
        bfs.addVertex("F");
        bfs.addVertex("H");
        bfs.addVertex("G");

        bfs.addEdge_biDirectional(0, 1);
        bfs.addEdge_biDirectional(1, 2);
        bfs.addEdge_biDirectional(1, 6);
        bfs.addEdge_biDirectional(2, 3);
        bfs.addEdge_biDirectional(2, 4);
        bfs.addEdge_biDirectional(4, 5);
        bfs.addEdge_biDirectional(4, 7);

        System.out.println(bfs.BFSTraversal());

    }

    public ArrayList<String> BFSTraversal() {
        ArrayList<String> bfsList = new ArrayList<>();

        for (int i = 0; i < totalVertices; i++) {
            if (!vertexList[i].isVisited) {
                BFSTraversal_Util(i, bfsList);
            }
        }

        for (int i = 0; i < totalVertices; i++) {
            vertexList[i].isVisited = false;
        }

        return bfsList;
    }

    private ArrayList<String> BFSTraversal_Util(int source, ArrayList<String> bfsList) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(source);

        while (!queue.isEmpty()) {
            int temp = queue.remove();
            if (!vertexList[temp].isVisited) {
                vertexList[temp].isVisited = true;
                bfsList.add(vertexList[temp].label);
            }

            ListIterator<Integer> adjacentVertices = adjList[temp].listIterator();

            while (adjacentVertices.hasNext()) {
                int adjacentVertex = adjacentVertices.next();

                if (!vertexList[adjacentVertex].isVisited) {
                    queue.add(adjacentVertex);
                }
            }
        }
        return bfsList;
    }


}

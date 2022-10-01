package GraphAlgo.Practice_2022;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Stack;

/**
 * Created by bajajp on 20 May, 2022
 */
public class DFS extends BaseGraphAdjacencyList {
    DFS(int capacity) {
        super(capacity);
    }

    public ArrayList<String> DFSTraversal() {
        ArrayList<String> dfsList = new ArrayList<>();

        for (int i = 0; i < totalVertices; i++) {
            if (!vertexList[i].isVisited) {
                DFSTraversal_Util(i, dfsList);
            }
        }

        for (int i = 0; i < totalVertices; i++) {
            vertexList[i].isVisited = false;
        }

        return dfsList;
    }

    private ArrayList<String> DFSTraversal_Util(int source, ArrayList<String> dfsList) {
        Stack<Integer> stack = new Stack<>();
        stack.push(source);

        while (!stack.isEmpty()) {
            int temp = stack.peek();
            if (!vertexList[temp].isVisited) {
                vertexList[temp].isVisited = true;
                dfsList.add(vertexList[temp].label);
            }

            stack.pop();

            ListIterator<Integer> adjacentVertices = adjList[temp].listIterator();

            while (adjacentVertices.hasPrevious()) {
                int adjacentVertex = adjacentVertices.previous();

                if (!vertexList[adjacentVertex].isVisited) {
                    stack.push(adjacentVertex);
                }
            }

        }
        return dfsList;
    }

    public static void main(String[] args) {
//        DFS dfs = new DFS(8);
//
//        dfs.addVertex("A");
//        dfs.addVertex("B");
//        dfs.addVertex("C");
//        dfs.addVertex("D");
//        dfs.addVertex("E");
//        dfs.addVertex("F");
//        dfs.addVertex("H");
//        dfs.addVertex("G");
//
//        dfs.addEdge_biDirectional(0, 1);
//        dfs.addEdge_biDirectional(1, 2);
//        dfs.addEdge_biDirectional(1, 6);
//        dfs.addEdge_biDirectional(2, 3);
//        dfs.addEdge_biDirectional(2, 4);
//        dfs.addEdge_biDirectional(4, 5);
//        dfs.addEdge_biDirectional(4, 6);
//        dfs.addEdge_biDirectional(4, 7);
//
//        System.out.println(dfs.DFSTraversal());

        DFS dfs1 = new DFS(12);

//        dfs1.addVertex("0");
        dfs1.addVertex("1");
        dfs1.addVertex("2");
        dfs1.addVertex("3");
        dfs1.addVertex("4");
        dfs1.addVertex("5");
        dfs1.addVertex("6");
        dfs1.addVertex("7");
        dfs1.addVertex("8");
        dfs1.addVertex("9");
        dfs1.addVertex("10");
        dfs1.addVertex("11");
        dfs1.addVertex("12");
//        dfs1.addVertex("4");

        dfs1.addEdge_singleDirectional(1, 2);
        dfs1.addEdge_singleDirectional(1, 7);
        dfs1.addEdge_singleDirectional(1, 8);
        dfs1.addEdge_singleDirectional(2, 3);
        dfs1.addEdge_singleDirectional(2, 6);
        dfs1.addEdge_singleDirectional(3, 4);
        dfs1.addEdge_singleDirectional(3, 5);
        dfs1.addEdge_singleDirectional(8, 9);
        dfs1.addEdge_singleDirectional(8, 12);
        dfs1.addEdge_singleDirectional(9, 10);
        dfs1.addEdge_singleDirectional(9, 11);

        System.out.println(dfs1.DFSTraversal());
    }

}

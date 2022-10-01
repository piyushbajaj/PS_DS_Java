package GraphAlgo.Practice_2022;

import lombok.Data;

import java.util.LinkedList;

/**
 * Created by bajajp on 20 May, 2022
 */
@Data
public class BaseGraphAdjacencyList {
    public int vertexCount;
    public final int totalVertices;
    public final Vertex[] vertexList;
    public final LinkedList<Integer>[] adjList;

    @SuppressWarnings("unchecked")
    BaseGraphAdjacencyList(int capacity) {
        totalVertices = capacity;
        vertexCount = 0;
        adjList = new LinkedList[totalVertices];
        vertexList = new Vertex[totalVertices];

        for (int i = 0; i < totalVertices; i++) {
            adjList[i] = new LinkedList<Integer>();
        }
    }

    public static class Vertex {
        String label;
        boolean isVisited;

        Vertex(String label) {
            this.label = label;
            this.isVisited = false;
        }
    }

    public void addVertex(String c) {
        if (vertexCount <= totalVertices) {
            vertexList[vertexCount++] = new Vertex(c);
        }
    }

    public void addEdge_singleDirectional(int i, int j) {
        if (i < vertexCount && j < vertexCount && adjList[i] != null) {
            adjList[i].add(j);
        }
    }

    public void addEdge_biDirectional(int i, int j) {
        if (i < vertexCount && j < vertexCount && adjList[i] != null) {
            adjList[i].add(j);
            adjList[j].add(i);
        }
    }
}

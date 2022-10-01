package GraphAlgo.Practice_2022;

/**
 * Created by bajajp on 18 May, 2022
 * TC: Matrix requires O(V^2) bits of storage, and initialization is O(V^2)
 */
public class BaseGraphAdjacencyMatrix {
    private int vertexCount;
    private boolean[][] adjacencyMatrix;

    BaseGraphAdjacencyMatrix(int vertexCount, boolean[][] adjacencyMatrix) {
        this.vertexCount = vertexCount;
        this.adjacencyMatrix = new boolean[vertexCount][vertexCount];
    }

    public void addEdge(int i, int j) {
        if (i >= 0 && i < this.vertexCount && j >= 0 && j < this.vertexCount) {
            this.adjacencyMatrix[i][j] = true;
        }
    }

    public void removeEdge(int i, int j) {
        if (i >= 0 && i < this.vertexCount && j >= 0 && j < this.vertexCount) {
            this.adjacencyMatrix[i][j] = false;
        }
    }

    public boolean isEdge(int i, int j) {
        if (i >= 0 && i < this.vertexCount && j >= 0 && j < this.vertexCount) {
            return this.adjacencyMatrix[i][j];
        }

        return false;
    }

}

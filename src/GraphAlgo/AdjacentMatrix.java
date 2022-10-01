package GraphAlgo;

/**
 * Created by piyush.bajaj on 08/01/17.
 */
public class AdjacentMatrix {
    private boolean adjMatrix[][];
    private int vertexCount;

    public AdjacentMatrix(int vertexCount){
        this.vertexCount = vertexCount;
        this.adjMatrix = new boolean[this.vertexCount][this.vertexCount];
    }

    public void addEdge(int i, int j){
        if(i >= 0 && i < vertexCount && j >=0 && j < vertexCount ){
            adjMatrix[i][j] = true;
            adjMatrix[j][i] = true;
        }
    }

    public void removeEdge(int i, int j){
        if(i >= 0 && i < vertexCount && j >=0 && j < vertexCount ){
            adjMatrix[i][j] = false;
            adjMatrix[j][i] = false;
        }
    }

    public boolean isEdge(int i, int j){
        if(i >= 0 && i < vertexCount && j >=0 && j < vertexCount ){
            return adjMatrix[i][j];
        }
        else
            return false;
    }

    public void printGraph(){
        for(int i = 0; i < this.vertexCount; i++){
            for(int j = 0; j < this.vertexCount; j++){
                System.out.print(i + "->" + j + ":" + this.adjMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int V = 5;
        AdjacentMatrix g = new AdjacentMatrix(V);

        g.addEdge(0, 1);
        //g.printGraph();
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        System.out.println("Graph:");
        g.printGraph();
    }
}

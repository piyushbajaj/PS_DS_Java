package GraphAlgo;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by piyush.bajaj on 05/02/17.
 * This is done using DFS
 */
public class IsPathExist {
    public static class Vertex{
        boolean visited;
        int label;

        public Vertex(int label){
            this.label = label;
            visited = false;
        }
    }

    //For adding random vertices
    public Vertex vertexList[];

    //No of vertices
    public int V;

    //Adjacency list of vertices
    public LinkedList<Integer> adjList[];

    //Counting no. of vertices
    public int vertexCount = 0;

    public IsPathExist(int vertices){
        V = vertices;
        adjList = new LinkedList[V];
        for(int i = 0; i < V; i++){
            adjList[i] = new LinkedList();
        }

        vertexCount = 0;
        vertexList = new Vertex[V];
    }

    public void addVertex(int ver){
        vertexList[vertexCount++] = new Vertex(ver);
    }

    public void addEdge(int u, int v){
        adjList[u].add(v);
    }

    public void DFS_fun(){
        for(int i = 0; i < V; i++){
            if(vertexList[i].visited==false)
                DFS_Util(i, vertexList[i].visited);
        }


        for(int i = 0; i < V; i++){
            vertexList[i].visited=false;
        }
    }

    public void DFS_Util(int v, boolean visited){

        vertexList[v].visited = true;
        Stack<Integer> stk = new Stack<>();
        System.out.print(vertexList[v].label + " ");
        stk.push(v);
        while (!stk.isEmpty()){
            int temp = nextElement(stk.pop());

            if(temp!=-1) {
                vertexList[temp].visited = true;
                System.out.print(vertexList[temp].label + " ");
                stk.push(temp);
            }
        }
    }

    public int nextElement(int k){
        for(int i = 0; i < V; i++){
            if(adjList[k].contains(i) && vertexList[i].visited==false)
                return i;
        }
        return -1;
    }

    public boolean isPathFound(int u, int v){
        vertexList[u].visited = true;
        Stack<Integer> stk = new Stack<>();
        //System.out.print(vertexList[u].label + " ");
        stk.push(u);
        int temp2 = 0;
        while (!stk.isEmpty()){
            int temp1 = stk.pop();

            while((temp2 = nextElement(temp1))!=-1) {
                vertexList[temp2].visited = true;
                //System.out.print(vertexList[temp].label + " ");
                stk.push(temp2);
                if(temp2 == v) {
                    System.out.println("\nYes path exist from " + vertexList[u].label + " to " + vertexList[v].label);
                    return true;
                }

            }
        }
        return false;
    }

    public static void main(String[] args) {
        IsPathExist g = new IsPathExist(4);
        //DFS g = new DFS(8);


        g.addVertex(10);
        g.addVertex(11);
        g.addVertex(12);
        g.addVertex(13);
        //g.addVertices(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        //g.DFS_fun();
        //System.out.println();

        System.out.println(g.isPathFound(1, 3));
    }


}

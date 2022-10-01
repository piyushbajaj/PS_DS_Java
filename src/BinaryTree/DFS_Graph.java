package BinaryTree;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by piyush.bajaj on 07/12/16.
 */
public class DFS_Graph {
    private int V;
    private LinkedList<Integer> adj[];

    public DFS_Graph(int v){
        V = v;

        adj = new LinkedList[V];
        for(int i = 0; i < V; i++){
            adj[i] = new LinkedList();
        }
    }

    public void addEdge(int v, int w){
        adj[v].add(w);
    }

    public void DFS_Recur(int s, boolean[] visited){

        //All the values are kept false by default

        visited[s] = true;
        System.out.println(s+ " ");

        Iterator<Integer> i = adj[s].listIterator();
        while (i.hasNext()){
            int n = i.next();
            if(!visited[n]){
                DFS_Recur(n, visited);
            }
        }
    }

    public void DFS(int s){
        boolean visited[] = new boolean[V];

        DFS_Recur(s, visited);
    }

    public static void main(String[] args) {
        DFS_Graph DG = new DFS_Graph(4);

        DG.addEdge(0, 1);
        DG.addEdge(0, 2);
        DG.addEdge(1, 2);
        DG.addEdge(2, 0);
        DG.addEdge(2, 3);
        DG.addEdge(3, 3);

        DG.DFS(2);
    }


}

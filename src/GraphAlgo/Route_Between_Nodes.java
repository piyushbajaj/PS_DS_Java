package GraphAlgo;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by piyush.bajaj on 08/12/16.
 */
public class Route_Between_Nodes {
    public int V; //Vertex
    private LinkedList<Integer> adj[];

    public Route_Between_Nodes(int v){
        V = v;
        adj = new LinkedList[V];

        for(int i =0; i < V; i++){
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int u, int v){
        adj[u].add(v);
    }

    public void DFS_Route_Bet_Nodes(int x, int y, boolean[] visited){
        visited[x] = true;

        Iterator<Integer> i = adj[x].listIterator();

        while (i.hasNext()){
            int n = i.next();
            if(n==y) {
                System.out.println("There is a connection between Nodes");
                System.exit(1);
            }
            else if(!visited[n]){
                DFS_Route_Bet_Nodes(n, y, visited);
            }
            //else break;
        }

       // System.exit(1);
    }

    public void DFS(int x, int y){
        boolean[] visited = new boolean[V];

        DFS_Route_Bet_Nodes(x, y, visited);

        System.out.println("There is NO connection between Nodes");
    }

    //here we will use depth first search for this
    public static void main(String[] args) {
        Route_Between_Nodes RB = new Route_Between_Nodes(4);

        RB.addEdge(0, 1);
        RB.addEdge(0, 2);
        RB.addEdge(1, 2);
        RB.addEdge(2, 0);
        RB.addEdge(2, 3);
        RB.addEdge(3, 3);

        int x = 5, y = 3;


        System.out.println("Is there a route between " + x + " and " + y + ": " );
        RB.DFS(x, y);
    }
}

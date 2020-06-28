package OnlineTest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by piyush.bajaj on 29/03/17.
 */
public class lendingKart_graph {
    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency Lists

    static int[] Distance;

    lendingKart_graph(int v)
    {
        V = v;
        adj = new LinkedList[v];
        Distance = new int[V];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v,int w)
    {
        adj[v].add(w);
        adj[w].add(v);
    }

    public int UnweightedShortest(int distance){
        Queue<Integer> queue = new LinkedList<>();
        int v, w;
        queue.add(0);

        for(int i = 0; i < V; i++){
            Distance[i] = -1;
        }
        Distance[0] = 0;

        while (!queue.isEmpty()){
            v = queue.remove();

            for(int i: adj[v]){
                if(Distance[i] == -1){
                    Distance[i] = Distance[v] + 1;
                    queue.add(i);
                }
            }
        }

        int count = 0;
        for(int i = 0 ; i < V; i++){
            if(Distance[i] == distance)
                count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        lendingKart_graph lk = new lendingKart_graph(n);

        int d = s.nextInt();

        for(int i = 1; i < n; i++){
            lk.addEdge(s.nextInt()-1, s.nextInt()-1);
        }

        System.out.println(lk.UnweightedShortest(d));


    }
}

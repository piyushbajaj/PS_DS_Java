package TechBoost_Old;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by piyush.bajaj on 25/03/18.
 */
public class Graph_Prob {
    int V;
    LinkedList<Integer> adjList[];
    Vertex vertexList[];
    int vertexCount= 0;

    public class Vertex{
        public char label;
        public boolean visited;

        public Vertex(char lab){
            label = lab;
            visited = false;
        }
    }

    Graph_Prob(int v){
        this.V = v;
        adjList = new LinkedList[V];
        vertexList = new Vertex[V];

        for(int i = 0; i < V; i++){
            adjList[i] = new LinkedList();
        }
    }

    public void addEdge(int i, int j){
        adjList[i].add(j);
        adjList[j].add(i);
    }

    public void addVertex(char i){
        vertexList[vertexCount++] = new Vertex(i);
    }

    public void BFS(){

        for(int i = 0; i < V; i++){
            if(vertexList[i].visited == false)
                BFS_util(i, vertexList[i].visited);
        }

        for(int i = 0; i < V; i++){
            vertexList[i].visited = false;
        }
    }

    public void BFS_util(int ver, boolean visited){

        Queue<Integer> queue = new LinkedList<>();
        queue.add(ver);
        vertexList[ver].visited = true;

        while (!queue.isEmpty()){
            int temp = queue.remove();
            System.out.print(vertexList[temp].label + " ");

            Iterator<Integer> integerIterator = adjList[temp].listIterator();

            while (integerIterator.hasNext()){
                int n = integerIterator.next();
                if(!vertexList[n].visited){
                    vertexList[n].visited = true;
                    queue.add(n);
                }
            }
        }
    }

    public void DFS(){
        for(int i = 0; i < V; i++){
            if(vertexList[i].visited == false){
                DFS_Util(i, vertexList[i].visited);
            }
        }

        for(int i = 0; i < V; i++){
            vertexList[i].visited = false;
        }
    }

    public void DFS_Util(int ver, boolean visited){
        Stack<Integer> stack = new Stack<>();
        stack.push(ver);
        vertexList[ver].visited = true;
        System.out.print(vertexList[ver].label + " ");

        while (!stack.isEmpty()){
            int temp = stack.pop();

            temp = nextElement(temp);

            if(temp != -1){
                System.out.print(vertexList[temp].label + " ");
                vertexList[temp].visited = true;
                stack.push(temp);
            }
        }
    }

    public int nextElement(int v){
        for(int i = 0; i < V; i++){
            if(adjList[v].contains(i) && vertexList[i].visited == false)
                return i;
        }
        return -1;
    }



    public static void main(String[] args) {
        Graph_Prob gp = new Graph_Prob(8);
        gp.addVertex('A');
        gp.addVertex('B');
        gp.addVertex('C');
        gp.addVertex('D');
        gp.addVertex('E');
        gp.addVertex('F');
        gp.addVertex('H');
        gp.addVertex('G');

        gp.addEdge(0, 1);
        gp.addEdge(1, 2);
        gp.addEdge(1, 6);
        gp.addEdge(2, 3);
        gp.addEdge(2, 4);
        gp.addEdge(4, 5);
        gp.addEdge(4, 6);
        gp.addEdge(4, 7);

        gp.BFS();

        System.out.println();
        gp.DFS();
    }
}

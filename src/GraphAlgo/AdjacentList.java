package GraphAlgo;

import java.util.ArrayList;

/**
 * Created by piyush.bajaj on 08/01/17.
 */
public class AdjacentList {
    Node head;
    public static class Node{
        int data;
        Node next;


        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public AdjacentList(){
        this.head = null;
    }

    private ArrayList<Integer> vertices;
    private AdjacentList[] edges;
    private int vertexCount = 0;

    public AdjacentList(int vertexCount){
        this.vertexCount = vertexCount;
        this.vertices = new ArrayList<Integer>();
        this.edges = new AdjacentList[vertexCount];

        for(int i = 0; i < this.vertexCount; i++){
            this.vertices.add(i);
            this.edges[i] = new AdjacentList();
        }
    }

    public void addAtBeginning(Node key){
        if(key == null)
            head = key;
        else {
            key.next = head;
            head = key;
        }
    }

    public void printList() {
        Node node= head;

        while(node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }

        System.out.println();
    }

    public void print(){
        int i=0;
        for(AdjacentList l: this.edges){
            System.out.print(this.vertices.get(i++) + ": ");
            l.printList();
        }
    }

    public void addEdge(int source, int dest){
        int i = this.vertices.get(source);
        int j = this.vertices.get(dest);

        edges[i].addAtBeginning(new Node(j));
        edges[j].addAtBeginning(new Node(i));
    }

    public static void main(String[] args) {
        int V = 5;
        AdjacentList g = new AdjacentList(V);

        g.addEdge(0, 1);
        //g.printGraph();
        g.addEdge(0, 4);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        System.out.println("Graph:");
        g.print();
    }
}

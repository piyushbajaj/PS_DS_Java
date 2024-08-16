package GraphAlgo;

/**
 * Created by piyush.bajaj on 06/12/16.
 */
public class GraphStructure {

    public static void main(String[] args) {
        int V = 5;
        Graph g = new Graph(V);

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

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class AdjacencyList {
        Node head;

        public AdjacencyList() {
            this.head = null;
        }

        public void addAtBeginning(Node node) {
            node.next = head;
            head = node;
        }

        public void printList() {
            Node node = head;

            while (node != null) {
                System.out.print(node.data + " ");
                node = node.next;
            }

            System.out.println();
        }
    }

    public static class Graph {
        int V;
        AdjacencyList[] lists;

        public Graph(int V) {
            this.V = V;
            this.lists = new AdjacencyList[V];

            for (int i = 0; i < V; i++) {
                lists[i] = new AdjacencyList();
            }

        }

        public void addEdge(int u, int v) {
            lists[u].addAtBeginning(new Node(v));
            lists[v].addAtBeginning(new Node(u));
        }

        public void printGraph() {
            int i = 0;
            for (AdjacencyList l : lists) {
                System.out.print(i++ + " : ");
                l.printList();
            }
        }

    }
}

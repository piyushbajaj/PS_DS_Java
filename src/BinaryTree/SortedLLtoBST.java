package BinaryTree;

/**
 * Created by piyush.bajaj on 25/12/16.
 */
public class SortedLLtoBST {
    Node head; //head of the list


    /* Linked List Node*/
    static class Node
    {
        int data;
        Node next;

        //Constructor to create a new node
        //Next is by default initialized as null

        Node(int d){
            data = d;
            next = null;
        }
    }

    //This is for Binary Tree
    static class TNode
    {
        int data;
        TNode left, right;

        //Constructor to create a new node
        //Next is by default initialized as null

        TNode(int d){
            data = d;
            left = right = null;
        }
    }

    public void push(int new_data){
        //Declare a new node & assign a value
        Node new_node = new Node(new_data);
        //Now point next of new_node to Head
        new_node.next = head;
        //Now store the address of new node on Head, since the new_node is Head now
        head = new_node;
    }

    public void printAllNodes(Node key){
        if(key==null)
            System.out.println("There are no nodes to print!");
        while (key.next!=null){
            System.out.print(key.data + " -> ");
            key = key.next;
        }
        System.out.print(key.data);
        System.out.println();
    }

    public int countNodes(Node key){
        int count=0;
        while (key!=null){
            count++;
            key = key.next;
        }
        return count;
    }

    public TNode sortedLLtoBSTlist(){
        if(head==null)
            return null;
        int n = countNodes(head);

        return sortedLLtoBSTlist_Recur(n);
    }
    public TNode sortedLLtoBSTlist_Recur(int n){
        if(n<=0)
            return null;

        //Construct left subtree
        TNode left = sortedLLtoBSTlist_Recur(n/2);

        /* head_ref now refers to middle node,
           make middle node as root of BST*/
        TNode root = new TNode(head.data);

        // Set pointer to left subtree
        root.left = left;

        //move head pointer

        head = head.next;

        //constuct right subtree
        /* Recursively construct the right subtree and link it
           with root. The number of nodes in right subtree  is
           total nodes - nodes in left subtree - 1 (for root) */
        root.right = sortedLLtoBSTlist_Recur(n-n/2-1);

        return root;

    }

    public static void main(String[] args) {
        SortedLLtoBST ll = new SortedLLtoBST();

        ll.push(7);
        ll.push(6);
        ll.push(5);
        ll.push(4);
        ll.push(3);
        ll.push(2);
        ll.push(1);

        ll.printAllNodes(ll.head);

        TNode root = ll.sortedLLtoBSTlist();

        System.out.println("Root: " + root.data);
        System.out.println("Root (" + root.data + ") -> Left: " + root.left.data);
        System.out.println("Root (" + root.data + ") -> Right: " + root.right.data);
        System.out.println("Root (" + root.data + ") -> Left (" + root.left.data + ") -> Left: " + root.left.left.data);
        System.out.println("Root (" + root.data + ") -> Left (" + root.left.data + ") -> Right: " + root.left.right.data);
        System.out.println("Root (" + root.data + ") -> Right (" + root.right.data + ")-> Left: " + root.right.left.data);
        System.out.println("Root (" + root.data + ") -> Right (" + root.right.data + ") -> Right: " + root.right.right.data);

    }


}

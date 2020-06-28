package BinaryTreeExample;

/**
 * Created by piyush.bajaj on 25/12/16.
 *
 * In Doubly linked list, it will use the algorithm of InOrder

 1. public Node sortedLLtoBST(int n){
    if(n <= 0) return null;
    Node left = sortedLLtoBST(n/2);
    Node root = head;
    root.prev = left;
    head = head.next;
    Node right = sortedLLtoBST(n-n/2-1);

 return root;
    }
 */
public class SortedDLLtoBST {
    Node head;

    static class Node{
        int data;
        Node next;
        Node prev;

        Node(int d){
            data = d;
            next = null;
            prev = null;
        }
    }

    public void push(int data){
        Node new_node = new Node(data);

        new_node.next = head;
        new_node.prev = null;

        if(head!=null)
            head.prev = new_node;

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

    //This function counts the number of nodes in Linked List and then calls sortedListtoBSTRecur() to construct BST


    public Node sortedListTOBST(Node key){
        int n = countNodes(key);

        return prac_sortedListTOBST(n);
    }

    public Node sortedListTOBST_Recur(int n){
        if(n<=0)
            return null;

        //Construct left subtree
        Node left = sortedListTOBST_Recur(n/2);

        //make middle node as root of the BST
        Node root = head;

        //Set pointer to left Subtree
        root.prev = left;

        //move head ahead
        head = head.next;

        //now construct right subtree

        root.next = sortedListTOBST_Recur(n - (n/2) -1);

        return root;



        //Time Complexity is O(n)
    }

    public static void main(String[] args) {
        SortedDLLtoBST ll = new SortedDLLtoBST();

        ll.push(7);
        ll.push(6);
        ll.push(5);
        ll.push(4);
        ll.push(3);
        ll.push(2);
        ll.push(1);

        ll.printAllNodes(ll.head);

        Node root = ll.sortedListTOBST(ll.head);

        System.out.println("Root: " + root.data);
        System.out.println("Root ("+ root.data +") -> Left: " + root.prev.data);
        System.out.println("Root ("+ root.data +") -> Right: " + root.next.data);
        System.out.println("Root ("+ root.data +") -> Left ("+ root.prev.data + ") -> Left: " + root.prev.prev.data);
        System.out.println("Root ("+ root.data +") -> Left ("+ root.prev.data + ") -> Right: " + root.prev.next.data);
        System.out.println("Root ("+ root.data +") -> Right ("+ root.next.data + ")-> Left: " + root.next.prev.data);
        System.out.println("Root ("+ root.data +") -> Right ("+ root.next.data + ") -> Right: " + root.next.next.data);


    }


    //Inorder types
    public Node prac_sortedListTOBST(int n){
        if(n<=0)
            return null;

        Node left = prac_sortedListTOBST(n/2);

        Node root = head;

        root.prev = left;

        head = head.next;

        root.next = prac_sortedListTOBST(n - n/2 -1);

        return root;
    }

}

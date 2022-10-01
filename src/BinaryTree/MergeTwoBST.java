package BinaryTree;

import java.util.Stack;

/**
 * Created by piyush.bajaj on 27/12/16.
 * O(m+n) where m is the number of nodes in first tree and n is the number of nodes in second tree
 * This i have merged using just limited space of O(height of first tree + 2nd)
 */
public class MergeTwoBST {

    Node root;
    public static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    public MergeTwoBST(){
        root = null;
    }

    public MergeTwoBST(int key){
        root = new Node(key);
    }

    public void InOrderTraversal(Node key){
        if(key == null)
            return;
        else {

            InOrderTraversal(key.left);
            System.out.print(key.data + " ");
            InOrderTraversal(key.right);
        }
        return;

    }

    public void mergeBST(Node Nd1, Node Nd2){

        Node c1 = Nd1;
        Node c2 = Nd2;

        Stack<Node> s1 = new Stack<>();

        Stack<Node> s2 = new Stack<>();

        // If first BST is empty, then output is inorder
        // traversal of second BST
        if(c1==null){
            InOrderTraversal(c2);
            return;
        }

        // If second BST is empty, then output is inorder
        // traversal of first BST
        if(c2==null){
            InOrderTraversal(c1);
            return;
        }

        // Run the loop while there are nodes not yet printed.
        // The nodes may be in stack(explored, but not printed)
        // or may be not yet explored
        while (c1!=null || c2!=null || !s1.empty() || !s2.empty()){
            // Following steps follow iterative Inorder Traversal
            if(c1!=null || c2!=null){
                // Reach the leftmost node of both BSTs and push ancestors of
                // leftmost nodes to stack s1 and s2 respectively
                if(c1!=null){
                    s1.push(c1);
                    c1 = c1.left;
                }

                if(c2!=null){
                    s2.push(c2);
                    c2 = c2.left;
                }
            }
            else {
                // If we reach a NULL node and either of the stacks is empty,
                // then one tree is exhausted, ptint the other tree
                if(s1.empty()){
                    while(!s2.empty()){
                        c2 = s2.pop();
                        c2.left = null;
                        InOrderTraversal(c2);
                    }
                    return;
                }
                if(s2.empty()){
                    while(!s1.empty()){
                        c1 = s1.pop();
                        c1.left = null;
                        InOrderTraversal(c1);
                    }
                    return;
                }
                c1 = s1.pop();
                c2 = s2.pop();


                // If element of first tree is smaller, then print it
                // and push the right subtree. If the element is larger,
                // then we push it back to the corresponding stack.
                if(c1.data < c2.data){
                    System.out.print(c1.data + " ");
                    c1 = c1.right;
                    s2.push(c2);
                    c2 = null;
                }
                else {
                    System.out.print(c2.data + " ");
                    c2 = c2.right;
                    s1.push(c1);
                    c1 = null;
                }
            }

        }

    }

    public static void main(String[] args) {
        MergeTwoBST BT1 = new MergeTwoBST(3);
        BT1.root.left = new Node(1);
        BT1.root.right = new Node(5);
        BT1.InOrderTraversal(BT1.root);
        System.out.println();

        MergeTwoBST BT2 = new MergeTwoBST(4);
        BT2.root.left = new Node(2);
        BT2.root.right = new Node(6);
        BT2.InOrderTraversal(BT2.root);
        System.out.println();

        BT1.mergeBST(BT1.root, BT2.root);
    }

}

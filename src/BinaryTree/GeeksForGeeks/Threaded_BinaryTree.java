package BinaryTree.GeeksForGeeks;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by piyush.bajaj on 22/09/17.
 */
public class Threaded_BinaryTree {
    Node root;

    static class Node{
        Node left, right;
        int data;
        boolean isThreaded;

        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    Threaded_BinaryTree(){
        root = null;
    }

    Threaded_BinaryTree(int data){
        if(root == null)
            root = new Node(data);
        else
            new Node(data);
    }

    /*
    Convert a Binary Tree to Threaded binary tree - Using Queue
    This is three step process:
    1. Create a queue which will store all the values in an Inorder manner.
    2. Then go through each item one by one, and then remove it, and display the correct value.
     */

    public void populateQueue(Node key, Queue<Node> queue){
        if(key == null)
            return;


        populateQueue(key.left, queue);
        queue.add(key);
        populateQueue(key.right, queue);
    }

    public void createTree(Node key){
        if(key == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        populateQueue(key, queue);

        createTree_Util(key, queue);

        printTree(key);

    }

    public void createTree_Util(Node key, Queue<Node> queue){
        if(key == null)
            return;

        if(key.left!=null)
            createTree_Util(key.left, queue);
        queue.remove();

        if(key.right!=null)
            createTree_Util(key.right, queue);

        else {
            key.right = queue.peek();
            key.isThreaded = true;
        }
    }

    public Node leftMost(Node key){
        if(key == null)
            return null;

        while (key!=null && key.left!=null)
            key = key.left;

        return key;
    }

    public void printTree(Node key){
        if(key == null)
            return;

        key = leftMost(key);

        while (key!=null) {
            System.out.print(key.data + " ");
            if (key.isThreaded == true) {
                key = key.right;
            } else {
                key = leftMost(key.right);
            }
        }
    }


    //Another approach without Stack
    public void inOrder_threaded(Node key){
        if(key == null)
            return;

        Node curr = key;
        Node pred = null;

        while (curr!=null){
            if(curr.left ==null){
                System.out.print(curr.data + " ");
                curr = curr.right;
            }
            else {
                pred = curr.left;


                //Finding the predecessor
                while (pred.right!=null && pred.right != curr){
                    pred = pred.right;
                }


                //Linking the predecessor
                if(pred.right == null){
                    pred.right = curr;
                    curr = curr.left;
                }

                //We need to remove the threaded BT, once its printed
                else {
                    System.out.print(curr.data + " ");
                    pred.right = null;
                    curr = curr.right;
                }

            }
        }
    }

    public static void main(String[] args) {
        Threaded_BinaryTree BT = new Threaded_BinaryTree();
        BT.root = new Node(4);

        BT.root.left = new Node(2);
        BT.root.left.left = new Node(1);
        BT.root.left.right = new Node(3);
        BT.root.right = new Node(6);
        BT.root.right.left = new Node(5);
        BT.root.right.right = new Node(7);

        //BT.createTree(BT.root);

        BT.inOrder_threaded(BT.root);

    }

}

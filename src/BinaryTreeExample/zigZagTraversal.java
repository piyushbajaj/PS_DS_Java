package BinaryTreeExample;

import java.util.Stack;

/**
 * Created by piyush.bajaj on 21/12/16.
 */
public class zigZagTraversal {
    Node root;
    public static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    public zigZagTraversal(){
        root = null;
    }

    public zigZagTraversal(int key){
        root = new Node(key);
    }

    void printSpiral(Node key)
    {
        if (key == null)
            return;   // NULL check

        Stack<Node> currentLevel = new Stack<Node>(); //This is for printing from left to right
        Stack<Node> nextLevel = new Stack<Node>(); //This is for printing from right to left

        currentLevel.push(key);

        while (!currentLevel.empty() || !nextLevel.empty()){
            while(!currentLevel.empty()){
                Node temp = currentLevel.pop();
                System.out.print(temp.data + " ");
                if(temp.left!=null)
                    nextLevel.push(temp.left);
                if(temp.right!=null)
                    nextLevel.push(temp.right);
            }

            while(!nextLevel.empty()){
                Node temp = nextLevel.pop();
                System.out.print(temp.data + " ");
                if(temp.right!=null)
                    currentLevel.push(temp.right);
                if(temp.left!=null)
                    currentLevel.push(temp.left);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        zigZagTraversal BT = new zigZagTraversal(1);
        System.out.println("Root: " + BT.root.data);
        BT.root.left = new Node(2);
        System.out.println("Root ("+ BT.root.data +") -> Left: " + BT.root.left.data);
        BT.root.right = new Node(3);
        System.out.println("Root ("+ BT.root.data +") -> Right: " + BT.root.right.data);
        BT.root.left.left = new Node(4);
        System.out.println("Root ("+ BT.root.data +") -> Left ("+ BT.root.left.data + ") -> Left: " + BT.root.left.left.data);
        BT.root.left.right = new Node(5);
        System.out.println("Root ("+ BT.root.data +") -> Left ("+ BT.root.left.data + ") -> Right: " + BT.root.left.right.data);
        BT.root.right.left = new Node(6);
        System.out.println("Root ("+ BT.root.data +") -> Right ("+ BT.root.right.data + ")-> Left: " + BT.root.right.left.data);
        BT.root.right.right = new Node(7);
        System.out.println("Root ("+ BT.root.data +") -> Right ("+ BT.root.right.data + ") -> Right: " + BT.root.right.right.data);
        BT.printSpiral(BT.root);

    }
}

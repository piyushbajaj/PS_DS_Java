package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by piyush.bajaj on 15/12/16.
 */
public class MaxBinaryTree {
    Node root;
    public static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    public MaxBinaryTree(){
        root = null;
    }

    public MaxBinaryTree(int key){
        root = new Node(key);
    }

    public int maxInBinaryTree(Node key){
        int maxValue = Integer.MIN_VALUE;
        if(key!=null){
            int leftMax = maxInBinaryTree(key.left);
            int rightMax = maxInBinaryTree(key.right);

            if(leftMax > rightMax)
                maxValue = leftMax;
            else
                maxValue = rightMax;

            if(key.data > maxValue)
                maxValue = key.data;
        }
        return maxValue;
    }

    public int maxInBinaryTree_Iteration(Node key){
        if(key == null)
            return Integer.MIN_VALUE;
        int maxValue = Integer.MIN_VALUE;
        Queue<Node> queue = new LinkedList<Node>();

        queue.add(key);

        Node temp = null;

        while (!queue.isEmpty()){
            temp = queue.remove();
            if(temp.data > maxValue)
                maxValue = temp.data;
            if(temp!=null){
                if(temp.left!=null)
                    queue.add(temp.left);
                if (temp.right!=null)
                    queue.add(temp.right);
            }
        }
        return maxValue;
    }


    public static void main(String[] args) {
        MaxBinaryTree BT = new MaxBinaryTree(1);
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
        System.out.println("Maximum value in the Binary Tree is: " + BT.maxInBinaryTree(BT.root));

        System.out.println("Maximum value in the Binary Tree using Iterative approach is: " + BT.maxInBinaryTree_Iteration(BT.root));
    }
}

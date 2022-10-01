package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by piyush.bajaj on 18/12/16.
 */
public class deepestNode {
    Node root;
    public static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    public deepestNode(){
        root = null;
    }

    public deepestNode(int key){
        root = new Node(key);
    }

    public Node findingMaxDepth(Node key){
        if(root == null)
            return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(key);
        //int count =0;

        Node temp = null;

        while (!queue.isEmpty()){
            Node curr = queue.remove();
            if(curr!=null){
                if(curr.left!=null)
                    queue.add(curr.left);
                if(curr.right!=null)
                    queue.add(curr.right);
                //count++;
            }
            temp = curr;
        }
        return temp;
    }

    public static void main(String[] args) {
        deepestNode BT = new deepestNode(1);
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
        BT.root.right.right.right = new Node(8);

        System.out.println("So the Deepest node of this Binary Tree is: " + BT.findingMaxDepth(BT.root).data);
    }
}

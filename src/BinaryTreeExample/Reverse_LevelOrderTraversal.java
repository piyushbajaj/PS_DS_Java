package BinaryTreeExample;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by piyush.bajaj on 17/12/16.
 */
public class Reverse_LevelOrderTraversal {
    Node root;
    public static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    public Reverse_LevelOrderTraversal(){
        root = null;
    }

    public Reverse_LevelOrderTraversal(int key){
        root = new Node(key);
    }

    public void levelOrderTraverse_Reverse(Node key){
        Queue<Node> queue = new LinkedList<Node>();

        Stack<Integer> s = new Stack<>();

        queue.add(key);
        while (!queue.isEmpty()){
            Node temp = queue.remove();
            s.push(temp.data);
            if(temp.right!=null)
                queue.add(temp.right);
            if(temp.left!=null)
                    queue.add(temp.left);
        }

        while(!s.empty()){
            System.out.print(s.pop() + " ");
        }
    }

    public static void main(String[] args) {
        Reverse_LevelOrderTraversal BT = new Reverse_LevelOrderTraversal(1);
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

        System.out.println("Level Order Traversal in Reverse Order: ");
        BT.levelOrderTraverse_Reverse(BT.root);
    }
}

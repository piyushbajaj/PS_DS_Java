package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by piyush.bajaj on 17/12/16.
 */
public class insertingAnElement {
    Node root;
    public static class Node{
        int data;
        Node left, right;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    public insertingAnElement(){
        root = null;
    }

    public insertingAnElement(int key){
        root = new Node(key);
    }


    //Using Level Order Traversal
    public Node insertElement(Node key, int data){
        Queue<Node> queue = new LinkedList<Node>();
        if(key == null) {
            key = new Node(data);
            return key;
        }
        queue.add(key);

        while (!queue.isEmpty()){
            Node temp = queue.remove();
            if(temp!=null){
                if(temp.left!=null)
                    queue.add(temp.left);
                else {
                    temp.left = new Node(data);
                    return key;
                }
                if(temp.right!=null)
                    queue.add(temp.right);
                else {
                    temp.right = new Node(data);
                    return key;
                }
            }
        }
        return key;
    }


    public ArrayList<ArrayList<Integer>> levelOrderTraverse(Node key){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();

        if(key==null)
            return res;

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(key);
        queue.add(null);

        while (!queue.isEmpty()){
            Node tmp = queue.poll();
            if(tmp!=null){
                current.add(tmp.data);
                if(tmp.left!=null)
                    queue.add(tmp.left);
                if(tmp.right!=null)
                    queue.add(tmp.right);
            }
            else {
                ArrayList<Integer> c_curr = new ArrayList<Integer>(current);
                res.add(c_curr);
                current.clear();
                if(!queue.isEmpty())
                    queue.add(null);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        insertingAnElement BT = new insertingAnElement(1);
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
        System.out.println("After insertion Traversing all the nodes now: " + BT.levelOrderTraverse(BT.insertElement(BT.root, 10)));


    }
}

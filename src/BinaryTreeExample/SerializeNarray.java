package BinaryTreeExample;

import java.util.ArrayList;

/**
 * Created by piyush.bajaj on 28/07/17.
 */
public class SerializeNarray {
    Node root;

    static class Node{
        Node left, right;
        int data;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    SerializeNarray(int data){
        if(root == null)
            root = new Node(data);
    }

    public ArrayList<Integer> serialize(Node key, ArrayList<Integer> arr){
        if(key == null) {
            arr.add(-1);
            return arr;
        }

        arr.add(key.data);
        serialize(key.left, arr);
        serialize(key.right, arr);

        return arr;
    }

    public static void main(String[] args) {
        SerializeNarray BT = new SerializeNarray(7);
        System.out.println("Root: " + BT.root.data);
        BT.root.left = new Node(2);
        System.out.println("Root ("+ BT.root.data +") -> Left: " + BT.root.left.data);
        BT.root.right = new Node(5);
        System.out.println("Root ("+ BT.root.data +") -> Right: " + BT.root.right.data);
        BT.root.left.left = new Node(1);
        System.out.println("Root ("+ BT.root.data +") -> Left ("+ BT.root.left.data + ") -> Left: " + BT.root.left.left.data);
        //BT.root.left.right = new Node(5);
        //System.out.println("Root ("+ BT.root.data +") -> Left ("+ BT.root.left.data + ") -> Right: " + BT.root.left.right.data);
        BT.root.right.left = new Node(3);
        System.out.println("Root (" + BT.root.data + ") -> Right (" + BT.root.right.data + ")-> Left: " + BT.root.right.left.data);
        BT.root.right.right = new Node(8);
        System.out.println("Root (" + BT.root.data + ") -> Right ("+ BT.root.right.data + ") -> Right: " + BT.root.right.right.data);

        ArrayList<Integer> arr = new ArrayList<>();
        System.out.println(BT.serialize(BT.root, arr));
    }
}

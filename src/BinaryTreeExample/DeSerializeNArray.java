package BinaryTreeExample;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by piyush.bajaj on 28/07/17.
 */
public class DeSerializeNArray {
    Node root;

    static class Node{
        Node left, right;
        int data;

        Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    DeSerializeNArray(int data){
        if(root == null)
            root = new Node(data);
    }

    DeSerializeNArray(){};

    int index = 0;
    public Node deSerialize(ArrayList<Integer> arr){
        if(arr.get(index) == -1 || index == arr.size()){
            index++;
            return null;
        }
        Node key = new Node(arr.get(index));
        index++;
//        if(root == null){
//            root = key;
//        }

        key.left = deSerialize(arr);
        key.right = deSerialize(arr);

        return key;
    }

    public static void main(String[] args) {
        DeSerializeNArray BT = new DeSerializeNArray();
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(7, 2, 1, -1, -1, -1, 5, 3, -1, -1, 8, -1, -1));
        BT.root = BT.deSerialize(arr);


        System.out.println("Root ("+ BT.root.data +") -> Left: " + BT.root.left.data);
        //BT.root.right = new Node(5);
        System.out.println("Root ("+ BT.root.data +") -> Right: " + BT.root.right.data);
        //BT.root.left.left = new Node(1);
        System.out.println("Root ("+ BT.root.data +") -> Left ("+ BT.root.left.data + ") -> Left: " + BT.root.left.left.data);
        //BT.root.left.right = new Node(5);
        //System.out.println("Root ("+ BT.root.data +") -> Left ("+ BT.root.left.data + ") -> Right: " + BT.root.left.right.data);
        //BT.root.right.left = new Node(3);
        System.out.println("Root (" + BT.root.data + ") -> Right (" + BT.root.right.data + ")-> Left: " + BT.root.right.left.data);
        //BT.root.right.right = new Node(8);
        System.out.println("Root (" + BT.root.data + ") -> Right ("+ BT.root.right.data + ") -> Right: " + BT.root.right.right.data);


    }


}

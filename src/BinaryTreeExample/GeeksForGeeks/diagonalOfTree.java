package BinaryTreeExample.GeeksForGeeks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by piyush.bajaj on 03/09/17.
 */
public class diagonalOfTree {
    Node root;

    static class Node{
        Node left, right;
        int data;
        Node(int data){
            this.data = data;
            this.left = this.right = null;
        }
    }

    diagonalOfTree(){
        root = null;
    }



    diagonalOfTree(int data){
        if(root == null)
            root = new Node(data);
        else
            new Node(data);
    }


    ArrayList<Node> inArr = new ArrayList<>();
    //int n = 1;

    public void printDiagonal(Node key){
        if(key == null)
            return;

        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
        printDiagonal_util(hashMap, key, 0);

        for (Map.Entry entry: hashMap.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }



    }
    public HashMap<Integer, ArrayList<Integer>> printDiagonal_util(HashMap<Integer, ArrayList<Integer>> hashMap, Node key, int n){
        if(key == null)
            return null;

        ArrayList<Integer> arr = hashMap.get(n);

        if(arr == null){
            arr = new ArrayList<>();
            arr.add(key.data);
        }
        else {
            arr.add(key.data);
        }

        hashMap.put(n, arr);

        printDiagonal_util(hashMap, key.left, n + 1);

        printDiagonal_util(hashMap, key.right, n);


        return hashMap;

    }

    public static void main(String[] args) {
        diagonalOfTree dt = new diagonalOfTree(8);
        dt.root.left = new Node(3);
        dt.root.right = new Node(10);
        dt.root.left.left = new Node(1);
        dt.root.left.right = new Node(6);
        dt.root.left.right.left = new Node(4);
        dt.root.left.right.right = new Node(7);
        dt.root.right.right = new Node(14);
        dt.root.right.right.left = new Node(13);

        dt.printDiagonal(dt.root);

    }
}

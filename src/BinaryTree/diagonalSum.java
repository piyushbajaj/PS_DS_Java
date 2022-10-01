package BinaryTree;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by piyush.bajaj on 02/08/17.
 */
public class diagonalSum {
    Node root;

    private ArrayList<Node> arr[];

    static class Node{
        Node left, right;
        int data;
        int level;

        Node(int data){
            this.data = data;
            this.left = this.right = null;
            this.level = 0;
        }

    }

    diagonalSum(int data){
        if(root == null)
            root = new Node(data);

        arr = new ArrayList[3];

        for(int i = 0; i < 3; i++)
            arr[i] = new ArrayList<Node>();
    }

    static TreeMap<Integer, ArrayList<Node>> tree = new TreeMap<>();

    //static int[] arr = new int[100];
    //int i = 0;
    //ArrayList<Integer> arr = new ArrayList<>();



    public Node getLeft(Node key){
        if(key == null || key.left == null)
            return null;
        key.left.level += key.level;
        return key.left;
    }

    public Node getRight(Node key){
        if(key == null || key.right == null)
            return null;
        key.right.level += key.level;
        return key.right;
    }

    Node temp = null;
    public void cal_diagonal_Sum(Node key, int i){
        if(key == null)
            return;


        //arr.add(key.data);
        for(int j = 0; j < i; j++){
            if(key.level <= arr[j].get(0).level){
                temp = arr[j].get(0);
                arr[j].add(key);
                arr[j++].add(temp);
            }
        }

        if(arr[i].isEmpty() || key.level > arr[i].get(0).level){
            arr[i].add(key);
        }

        tree.put(i, arr[i]);

//        if(key.level <= arr[i].get(0).level){
//            temp = arr[i].get(0);
//            arr[0].add(key);
//            arr[i].add(temp);
//        }

//        arr[i].add(key);
//        tree.put(i, arr[i]);

        cal_diagonal_Sum(getRight(key), i);
        //arr.clear();
        i++;
        cal_diagonal_Sum(getLeft(key), i);


//        if(key.left!=null){
//            arr.clear();
//            arr.add(key.left.data);
//            tree.put(i + 1, arr);
//            while (key.right!=null){
//                arr.add(key.right.data);
//                key = key.right;
//                tree.put(i + 1, arr);
//            }
//
//        }



    }

    public String toString(){
        return " ";
    }

    public static void main(String[] args) {
        diagonalSum BT = new diagonalSum(40);
        System.out.println("Root: " + BT.root.data);
        BT.root.left = new Node(20);
        System.out.println("Root ("+ BT.root.data +") -> Left: " + BT.root.left.data);
        BT.root.right = new Node(60);
        System.out.println("Root ("+ BT.root.data +") -> Right: " + BT.root.right.data);
        BT.root.left.left = new Node(10);
        System.out.println("Root ("+ BT.root.data +") -> Left ("+ BT.root.left.data + ") -> Left: " + BT.root.left.left.data);
        BT.root.left.right = new Node(30);
        System.out.println("Root ("+ BT.root.data +") -> Left ("+ BT.root.left.data + ") -> Right: " + BT.root.left.right.data);
        BT.root.right.left = new Node(50);
        System.out.println("Root ("+ BT.root.data +") -> Right ("+ BT.root.right.data + ")-> Left: " + BT.root.right.left.data);
        BT.root.right.right = new Node(70);
        System.out.println("Root (" + BT.root.data + ") -> Right (" + BT.root.right.data + ") -> Right: " + BT.root.right.right.data);



        BT.cal_diagonal_Sum(BT.root, 0);



        for(Map.Entry entry: tree.entrySet()){
            //Node temp = ((Node) entry.getValue());
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }



}

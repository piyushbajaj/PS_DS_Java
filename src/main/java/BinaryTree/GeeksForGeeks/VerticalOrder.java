package BinaryTree.GeeksForGeeks;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by piyush.bajaj on 04/09/17.
 */
public class VerticalOrder {
    Node root;

    VerticalOrder() {
        root = null;
    }

    VerticalOrder(int data) {
        if (root == null) {
            root = new Node(data);
        } else {
            new Node(data);
        }
    }

    public static void main(String[] args) {
        VerticalOrder BT = new VerticalOrder(1);
//        BT.root.left = new Node(4);
//        BT.root.left.left = new Node(6);
//        BT.root.left.left.right = new Node(10);
//        BT.root.left.left.right.right = new Node(11);
//        BT.root.left.right = new Node(7);
//        BT.root.left.right.right = new Node(1);
//        BT.root.right = new Node(5);
//        BT.root.right.left = new Node(8);
//        BT.root.right.right = new Node(9);


        BT.root.left = new Node(2);
        BT.root.right = new Node(3);
        BT.root.left.left = new Node(4);
        BT.root.left.right = new Node(5);
        BT.root.right.left = new Node(6);
        BT.root.right.right = new Node(7);
        BT.root.right.left.right = new Node(8);
        BT.root.right.right.right = new Node(9);


        BT.printVerticalNodes(BT.root);


    }

    public void printVerticalNodes(Node key) {
        TreeMap<Integer, ArrayList<Integer>> hashMap = new TreeMap<>();
        printVerticalNodes_util(key, hashMap, 0);

        for (Map.Entry entry : hashMap.entrySet()) {
            System.out.println(entry.getValue());
        }


    }

    public TreeMap<Integer, ArrayList<Integer>> printVerticalNodes_util(Node key,
                                                                        TreeMap<Integer, ArrayList<Integer>> hashMap,
                                                                        int n) {
        if (key == null) {
            return null;
        }

        ArrayList<Integer> arr = hashMap.get(n);

        if (arr == null) {
            arr = new ArrayList<Integer>();
            arr.add(key.data);
        } else {
            arr.add(key.data);
        }

        hashMap.put(n, arr);

        printVerticalNodes_util(key.left, hashMap, n - 1);

        printVerticalNodes_util(key.right, hashMap, n + 1);

        return hashMap;


    }

    static class Node {
        Node left, right;
        int data;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }
}

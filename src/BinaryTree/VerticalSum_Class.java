package BinaryTree;

import java.util.HashMap;

/**
 * Created by piyush.bajaj on 21/12/16.
 */
public class VerticalSum_Class {
    Node root;

    public VerticalSum_Class() {
        root = null;
    }

    public VerticalSum_Class(int key) {
        root = new Node(key);
    }

    public static void vSum(HashMap<Integer, Integer> hash, Node key, int c) {
        if (key.left != null) {
            vSum(hash, key.left, c - 1);
        }
        if (key.right != null) {
            vSum(hash, key.right, c + 1);
        }
        int data = 0;
        if (hash.containsKey(c)) {
            data = hash.get(c);
        }
        hash.put(c, key.data + data);
    }

    public static void verticalSum(Node key) {
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        vSum(hash, key, 0);

        System.out.println();

        for (int k : hash.keySet()) {
            System.out.println("key: " + k + "sum: " + hash.get(k) + " ");
        }
    }

    public static void main(String[] args) {
        VerticalSum_Class BT = new VerticalSum_Class(1);
        System.out.println("Root: " + BT.root.data);
        BT.root.left = new Node(2);
        System.out.println("Root (" + BT.root.data + ") -> Left: " + BT.root.left.data);
        BT.root.right = new Node(3);
        System.out.println("Root (" + BT.root.data + ") -> Right: " + BT.root.right.data);
        BT.root.left.left = new Node(4);
        System.out.println(
            "Root (" + BT.root.data + ") -> Left (" + BT.root.left.data + ") -> Left: " + BT.root.left.left.data);
        BT.root.left.right = new Node(5);
        System.out.println(
            "Root (" + BT.root.data + ") -> Left (" + BT.root.left.data + ") -> Right: " + BT.root.left.right.data);
        BT.root.right.left = new Node(6);
        System.out.println(
            "Root (" + BT.root.data + ") -> Right (" + BT.root.right.data + ")-> Left: " + BT.root.right.left.data);
        BT.root.right.right = new Node(7);
        System.out.println(
            "Root (" + BT.root.data + ") -> Right (" + BT.root.right.data + ") -> Right: " + BT.root.right.right.data);
        verticalSum(BT.root);
    }

    public static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
}

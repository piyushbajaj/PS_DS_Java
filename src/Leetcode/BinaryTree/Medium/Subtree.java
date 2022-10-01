package Leetcode.BinaryTree.Medium;

import java.util.ArrayList;

public class Subtree {
    TreeNode root;

    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int data;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    Subtree(int data) {
        this.root = new TreeNode(data);
    }

    /*
    First Approach-
    1. To convert the tree to InOrder from the root and for another node
    2. Just match is its part of substring
     */

    static ArrayList<Integer> arrayLstInOrder = new ArrayList<>();

    public void inOrderTraversal(TreeNode key) {
        if (key == null) return;

        inOrderTraversal(key.left);
        arrayLstInOrder.add(key.data);
        inOrderTraversal(key.right);
    }

    public boolean isSubTree(TreeNode key, TreeNode child) {
        inOrderTraversal(key);
        ArrayList<Integer> biggerTree = arrayLstInOrder;
        arrayLstInOrder.clear();

        inOrderTraversal(child);
        ArrayList<Integer> subTree = arrayLstInOrder;

        return biggerTree.containsAll(subTree);
    }

    public static void main(String[] args) {
        Subtree BT = new Subtree(1);
        System.out.println("Root: " + BT.root.data);
        BT.root.left = new TreeNode(2);
        System.out.println("Root (" + BT.root.data + ") -> Left: " + BT.root.left.data);
        BT.root.right = new TreeNode(3);
        System.out.println("Root (" + BT.root.data + ") -> Right: " + BT.root.right.data);
        BT.root.left.left = new TreeNode(4);
        System.out.println("Root (" + BT.root.data + ") -> Left (" + BT.root.left.data + ") -> Left: " + BT.root.left.left.data);
        BT.root.left.right = new TreeNode(5);
        System.out.println("Root (" + BT.root.data + ") -> Left (" + BT.root.left.data + ") -> Right: " + BT.root.left.right.data);
        BT.root.right.left = new TreeNode(6);
        System.out.println("Root (" + BT.root.data + ") -> Right (" + BT.root.right.data + ")-> Left: " + BT.root.right.left.data);
        BT.root.right.right = new TreeNode(7);
        System.out.println("Root (" + BT.root.data + ") -> Right (" + BT.root.right.data + ") -> Right: " + BT.root.right.right.data);


        System.out.println(BT.isSubTree(BT.root, BT.root.left.left));
    }

}

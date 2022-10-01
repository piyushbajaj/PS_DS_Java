package Leetcode.BinaryTree.Easy;

import java.util.ArrayList;
import java.util.Stack;

public class ZigZagTraversal {
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

    ZigZagTraversal(int data) {
        root = new TreeNode(data);
    }

    public int getHeight(TreeNode key) {
        if (key == null) return 0;

        int lHeight = getHeight(key.left);
        int rHeight = getHeight(key.right);

        return Math.max(lHeight, rHeight) + 1;
    }

    public void zigzag(TreeNode key) {
        if (key == null) {
            return;
        }

        Stack<TreeNode> currentLevel = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();
        ArrayList<TreeNode> arr = new ArrayList<>();

        currentLevel.push(key);

        while (!currentLevel.isEmpty() || !nextLevel.isEmpty()) {
            while (!currentLevel.isEmpty()) {
                TreeNode temp = currentLevel.pop();
                System.out.print(temp.data + " ");
                if(temp.left != null) {
                    nextLevel.push(temp.left);
                }
                if(temp.right != null) {
                    nextLevel.push(temp.right);
                }
            }

            while (!nextLevel.isEmpty()) {
                TreeNode temp = nextLevel.pop();
                System.out.print(temp.data + " ");
                if(temp.right != null) {
                    currentLevel.push(temp.right);
                }
                if(temp.left != null) {
                    currentLevel.push(temp.left);
                }
            }
        }
    }

    public static void main(String[] args) {
        ZigZagTraversal BT = new ZigZagTraversal(1);
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

        BT.zigzag(BT.root);
    }


}

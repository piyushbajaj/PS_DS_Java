package Leetcode.BinaryTree.Easy;

import java.util.Date;

public class MaximumDepth {
    TreeNode root;

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    MaximumDepth(int data) {
        this.root = new TreeNode(data);
    }

    private int answer; // don't forget to initialize answer before call maximum_depth
    private void maximum_depth(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            answer = Math.max(answer, depth);
        }
        maximum_depth(root.left, depth + 1);
        maximum_depth(root.right, depth + 1);
    }

    public static void main(String[] args) {
        MaximumDepth maximumDepth = new MaximumDepth(4);
        maximumDepth.root.left = new TreeNode(2);
        maximumDepth.root.left.left = new TreeNode(1);
        maximumDepth.root.left.right = new TreeNode(3);
        maximumDepth.root.right = new TreeNode(6);
        maximumDepth.root.right.left = new TreeNode(5);
        maximumDepth.root.right.right = new TreeNode(7);
        maximumDepth.maximum_depth(maximumDepth.root, 1);

        System.out.println(maximumDepth.answer);

        System.out.println(new Date());

    }
}

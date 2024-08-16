package BinaryTree.Practice_2022;

public class BaseTreeNode {
    TreeNode root;

    static class TreeNode {
        TreeNode left, right;
        int data;

        TreeNode(int data) {
            this.left = this.right = null;
            this.data = data;
        }
    }
}

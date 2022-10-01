package Leetcode.BinaryTree.Easy;

public class BasicBST {
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

    public boolean isBST(TreeNode key) {
        return isBST_Util(key, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isBST_Util(TreeNode key, int min, int max) {
        if (key == null)
            return true;

        if (key.data < min)
            return false;

        if (key.data > max)
            return false;

        return isBST_Util(key.left, min, key.data) && isBST_Util(key.right, key.data, max);
    }

    public static void main(String[] args) {
        BasicBST basicBinaryTree = new BasicBST();
        basicBinaryTree.root = new TreeNode(4);
        basicBinaryTree.root.left = new TreeNode(2);
        basicBinaryTree.root.left.left = new TreeNode(1);
        basicBinaryTree.root.left.right = new TreeNode(3);
        basicBinaryTree.root.right = new TreeNode(6);
        basicBinaryTree.root.right.left = new TreeNode(5);
        basicBinaryTree.root.right.right = new TreeNode(7);
        basicBinaryTree.root.right.right.right = new TreeNode(0);

        System.out.println(basicBinaryTree.isBST(basicBinaryTree.root));
    }
}

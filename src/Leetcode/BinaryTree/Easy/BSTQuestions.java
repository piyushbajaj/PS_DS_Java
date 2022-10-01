package Leetcode.BinaryTree.Easy;

public class BSTQuestions {
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

    public TreeNode LCA_BST(TreeNode key, TreeNode a, TreeNode b) {
        if (key == null) return null;

        if (a.data < key.data && b.data < key.data) {
            LCA_BST(key.left, a, b);
        } else if (a.data > key.data && b.data > key.data) {
            LCA_BST(key.right, a, b);
        }

        return key;
    }

    public static void main(String[] args) {
        BSTQuestions basicBinaryTree = new BSTQuestions();
        basicBinaryTree.root = new TreeNode(4);
        basicBinaryTree.root.left = new TreeNode(2);
        basicBinaryTree.root.left.left = new TreeNode(1);
        basicBinaryTree.root.left.right = new TreeNode(3);
        basicBinaryTree.root.right = new TreeNode(6);
        basicBinaryTree.root.right.left = new TreeNode(5);
        basicBinaryTree.root.right.right = new TreeNode(7);
        basicBinaryTree.root.right.right.right = new TreeNode(8);

        System.out.println(basicBinaryTree.LCA_BST(basicBinaryTree.root, basicBinaryTree.root.left,
            basicBinaryTree.root.right.right.right).data);
    }
}

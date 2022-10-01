package Leetcode.BinaryTree.Easy;

public class BTreeQuestions {
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

    public TreeNode LCA(TreeNode key, TreeNode a, TreeNode b) {
        if (key == null) return null;

        if (key == a || key == b) return key;

        TreeNode leftLCA = LCA(key.left, a, b);
        TreeNode rightLCA = LCA(key.right, a, b);

        if (leftLCA != null && rightLCA != null) return key;

        if (leftLCA != null)
            return leftLCA;
        else
            return rightLCA;
    }

    public static void main(String[] args) {
        BTreeQuestions basicBinaryTree = new BTreeQuestions();
        basicBinaryTree.root = new TreeNode(-1);
        basicBinaryTree.root.left = new TreeNode(2);
        basicBinaryTree.root.left.left = new TreeNode(1);
        basicBinaryTree.root.left.right = new TreeNode(3);
        basicBinaryTree.root.right = new TreeNode(6);
        basicBinaryTree.root.right.left = new TreeNode(5);
        basicBinaryTree.root.right.right = new TreeNode(7);
        basicBinaryTree.root.right.right.right = new TreeNode(0);

        System.out.println(basicBinaryTree.LCA(basicBinaryTree.root, basicBinaryTree.root.left.left,
            basicBinaryTree.root.right.right.right).data);
    }
}

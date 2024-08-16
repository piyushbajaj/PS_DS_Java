package Leetcode.BinaryTree.Easy;

public class BalancedTree {
    TreeNode root;

    BalancedTree(int data) {
        this.root = new TreeNode(data);
    }

    public static void main(String[] args) {
        BalancedTree BT = new BalancedTree(1);
        System.out.println("Root: " + BT.root.data);
        BT.root.left = new TreeNode(2);
        System.out.println("Root (" + BT.root.data + ") -> Left: " + BT.root.left.data);
        BT.root.right = new TreeNode(3);
        System.out.println("Root (" + BT.root.data + ") -> Right: " + BT.root.right.data);
        BT.root.left.left = new TreeNode(4);
        System.out.println(
            "Root (" + BT.root.data + ") -> Left (" + BT.root.left.data + ") -> Left: " + BT.root.left.left.data);
        BT.root.left.right = new TreeNode(5);
        System.out.println(
            "Root (" + BT.root.data + ") -> Left (" + BT.root.left.data + ") -> Right: " + BT.root.left.right.data);
        BT.root.right.left = new TreeNode(6);
        System.out.println(
            "Root (" + BT.root.data + ") -> Right (" + BT.root.right.data + ")-> Left: " + BT.root.right.left.data);
        BT.root.right.right = new TreeNode(7);
        System.out.println(
            "Root (" + BT.root.data + ") -> Right (" + BT.root.right.data + ") -> Right: " + BT.root.right.right.data);
        BT.root.right.right.right = new TreeNode(8);
//        BT.root.right.right.right.left = new TreeNode(8);

        System.out.println(BT.isBalanced(BT.root));
    }

    public boolean isBalanced(TreeNode key) {
        if (validateHeight(key) == -1) {
            return false;
        }
        return true;
    }

    public int validateHeight(TreeNode key) {
        if (key == null) {
            return 0;
        }

        int leftHeight = validateHeight(key.left);
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = validateHeight(key.right);
        if (rightHeight == -1) {
            return -1;
        }

        int diff = leftHeight - rightHeight;
        if (Math.abs(diff) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

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
}

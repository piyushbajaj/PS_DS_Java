package Leetcode.BinaryTree.Easy;

public class MinimumDepth {
    TreeNode root;

    MinimumDepth(int data) {
        this.root = new TreeNode(data);
    }

    public static void main(String[] args) {
        MinimumDepth BT = new MinimumDepth(1);
        System.out.println("Root: " + BT.root.data);
        BT.root.left = new TreeNode(2);
        System.out.println("Root (" + BT.root.data + ") -> Left: " + BT.root.left.data);
        BT.root.right = new TreeNode(2);
        System.out.println("Root (" + BT.root.data + ") -> Right: " + BT.root.right.data);
        BT.root.left.left = new TreeNode(3);
        System.out.println(
            "Root (" + BT.root.data + ") -> Left (" + BT.root.left.data + ") -> Left: " + BT.root.left.left.data);
        BT.root.left.right = new TreeNode(4);
        System.out.println(
            "Root (" + BT.root.data + ") -> Left (" + BT.root.left.data + ") -> Right: " + BT.root.left.right.data);
        BT.root.right.left = new TreeNode(4);
        System.out.println(
            "Root (" + BT.root.data + ") -> Right (" + BT.root.right.data + ")-> Left: " + BT.root.right.left.data);
        BT.root.right.right = new TreeNode(3);
        System.out.println(
            "Root (" + BT.root.data + ") -> Right (" + BT.root.right.data + ") -> Right: " + BT.root.right.right.data);
        BT.root.right.right.left = new TreeNode(3);

        System.out.println(BT.minDepth(BT.root));
    }

    /*
    1. This will follow Pre-Order Traversal (Modified version)
    2.
     */
    public int minDepth(TreeNode key) {
        if (key == null) {
            return 0;
        }

        if (key.left == null && key.right == null) {
            return 1;
        }

        if (key.left == null) {
            return minDepth(key.right) + 1;
        }

        if (key.right == null) {
            return minDepth(key.left) + 1;
        }

        return Math.min(minDepth(key.left), minDepth(key.right)) + 1;
    }

    static class TreeNode {
        int data;
        TreeNode left, right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}

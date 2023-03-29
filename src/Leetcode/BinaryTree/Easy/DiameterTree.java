package Leetcode.BinaryTree.Easy;

public class DiameterTree {
    TreeNode root;

    DiameterTree(int data) {
        this.root = new TreeNode(data);
    }

    public static void main(String[] args) {
        DiameterTree BT = new DiameterTree(1);
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

        System.out.println(BT.diameterOfTree(BT.root, new Height()));
    }

    public int diameterOfTree(TreeNode key, Height height) {
        if (key == null) {
            height.height = 0;
            return 0;
        }

        Height lHeight = new Height();
        Height rHeight = new Height();

        int lDiameter = diameterOfTree(key.left, lHeight);
        int rDiameter = diameterOfTree(key.right, rHeight);

        if (lHeight.height > rHeight.height) {
            height.height = lHeight.height + 1;
        } else {
            height.height = rHeight.height + 1;
        }

        return Math.max(lHeight.height + rHeight.height + 1, Math.max(lDiameter, rDiameter));
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

    static class Height {
        int height = 0;
    }
}

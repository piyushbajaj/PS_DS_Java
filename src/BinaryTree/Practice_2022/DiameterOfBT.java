package BinaryTree.Practice_2022;

public class DiameterOfBT extends CommonUtils {
    public static void main(String[] args) {
        DiameterOfBT diameterOfBT = new DiameterOfBT();
        diameterOfBT.root = new TreeNode(1);
        diameterOfBT.root.left = new TreeNode(2);
        diameterOfBT.root.right = new TreeNode(3);
        diameterOfBT.root.left.left = new TreeNode(4);
        diameterOfBT.root.left.left.left = new TreeNode(8);
        diameterOfBT.root.left.left.left.left = new TreeNode(10);
        diameterOfBT.root.left.right = new TreeNode(5);
        diameterOfBT.root.left.right.left = new TreeNode(9);
        diameterOfBT.root.left.right.left.left = new TreeNode(11);


        System.out.println(diameterOfBT.printBinaryTree_levelOrder(diameterOfBT.root));
        System.out.println();
        System.out.println(diameterOfBT.diameter(diameterOfBT.root, new Height()));
    }

    /*
    1. Diameter of left subtree
    2. Diameter of right subtree
    3. Longest path going via root (Height of left subtree + Height of right subtree + 1)

    Link: https://www.geeksforgeeks.org/diameter-of-a-binary-tree/
    TC: O(N)
    SC: O(N)
     */
    public int diameter(TreeNode node, Height height) {
        Height lh = new Height();
        Height rh = new Height();

        if (node == null) {
            height.height = 0;
            return 0;
        }

        int leftDiameter = diameter(node.left, lh);
        int rightDiameter = diameter(node.right, rh);

        height.height = Math.max(lh.height, rh.height) + 1;

        return Math.max(lh.height + rh.height + 1, Math.max(leftDiameter, rightDiameter));
    }

    static class Height {
        int height;
    }
}

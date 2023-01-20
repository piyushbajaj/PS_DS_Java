package TakeUForward.S13_BinaryTrees.S13_2_Medium;

import TakeUForward.S13_BinaryTrees.S13_1_Traversals.TreeNode;

/**
 * Created by bajajp on 29 Sep, 2022
 * <p>
 * lc: <a href="https://leetcode.com/problems/diameter-of-binary-tree/description/">...</a>
 * g4g: <a href="https://practice.geeksforgeeks.org/problems/diameter-of-binary-tree/1">...</a>
 */
public class P3_DiameterOfBT {

    /**
     * Approach:
     * 1. Start traversing the tree recursively, and do work in Post Order
     * 2. In the post order of every node, calculate diameter and height of the current node
     * 3. If current diameter is maximum then update the variable used to store the maximum diameter.
     * 4. Return height of current node to the previous recursive call.
     * <p>
     * TC: O(N)
     * SC: O(h)
     *
     * @param curr
     * @return
     */
    public int diameterOfTree(TreeNode curr) {
        int[] diameter = new int[1];
        diameterOfTree_util(curr, diameter);

        return diameter[0];
    }

    public int diameterOfTree_util(TreeNode curr, int[] diameter) {
        if (curr == null) {
            return 0;
        }

        int lHeight = diameterOfTree_util(curr.left, diameter);
        int rHeight = diameterOfTree_util(curr.right, diameter);

        diameter[0] = Math.max(diameter[0], lHeight + rHeight + 1);

        return Math.max(lHeight, rHeight) + 1;
    }

    public static void main(String[] args) {
        P3_DiameterOfBT p3_diameterOfBT = new P3_DiameterOfBT();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(10);
        root.left.left.left.left = new TreeNode(11);

        System.out.println(p3_diameterOfBT.diameterOfTree(root));
    }
}

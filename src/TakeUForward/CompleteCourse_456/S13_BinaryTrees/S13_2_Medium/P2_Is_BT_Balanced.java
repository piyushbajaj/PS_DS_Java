package TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_2_Medium;

import TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_1_Traversals.TreeNode;

/**
 * Created by bajajp on 29 Sep, 2022
 * <p>
 * lc: <a href="https://leetcode.com/problems/balanced-binary-tree/description/">...</a>
 * g4g: <a href="https://practice.geeksforgeeks.org/problems/check-for-balanced-tree/1">...</a>
 */
public class P2_Is_BT_Balanced {

    /**
     * Approach:
     * 1. Start traversing the tree recursively and do work in Post Order
     * 2. For each call, return the height of the current node, and return to the previous node
     * 3. Keep calculating the difference in the height of each node, and if it becomes more than 1, then return -1,
     * or else return the height of the node
     * 4. If it is balanced , simply return height of current node and if not then return -1.
     * 5. Whenever the subtree result is -1 , simply keep on returning -1.
     * <p>
     * TC: O(N)
     * SC: O(H)
     *
     * @param curr
     * @return
     */
    public boolean isBTBalanced(TreeNode curr) {
        if (curr == null) {
            return false;
        }

        return isBTBalanced_util(curr) != -1;
    }

    public int isBTBalanced_util(TreeNode curr) {
        if (curr == null) {
            return 0;
        }

        int lHeight = isBTBalanced_util(curr.left);
        if (lHeight == -1) {
            return -1;
        }

        int rHeight = isBTBalanced_util(curr.right);
        if (rHeight == -1) {
            return -1;
        }

        int diff = Math.abs(lHeight - rHeight);
        if (diff > 1) {
            return -1;
        }

        return Math.max(lHeight, rHeight) + 1;
    }

    public static void main(String[] args) {
        P2_Is_BT_Balanced p2_is_bt_balanced = new P2_Is_BT_Balanced();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(10);
        root.left.left.left.left = new TreeNode(11);

        System.out.println(p2_is_bt_balanced.isBTBalanced(root));
    }
}

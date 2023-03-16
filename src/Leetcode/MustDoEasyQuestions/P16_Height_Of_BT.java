package Leetcode.MustDoEasyQuestions;

import TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_1_Traversals.TreeNode;

/**
 * Project: DS_Algo
 * Package: Leetcode.MustDoEasyQuestions
 * <p>
 * User: piyushbajaj
 * Date: 14/01/23
 * Time: 12:24 pm
 */
public class P16_Height_Of_BT {

    /**
     * Calculating Height recursively
     * TC: O(N)
     * SC: O(N)
     *
     * @param curr
     * @return
     */
    public int height_recur(TreeNode curr) {
        if (curr == null) {
            return 0;
        }

        int lHeight = height_recur(curr.left);
        int rHeight = height_recur(curr.right);

        return Math.max(lHeight, rHeight) + 1;
    }

    public static void main(String[] args) {
        P16_Height_Of_BT p16_height_of_bt = new P16_Height_Of_BT();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(p16_height_of_bt.height_recur(root));
    }
}

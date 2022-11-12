package TakeUForward.S14_BST.S14_2;

import TakeUForward.S13_BinaryTrees.S13_1_Traversals.TreeNode;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S14_BST.S14_2
 * <p>
 * User: piyushbajaj
 * Date: 06/10/22
 * Time: 5:23 pm
 * <p>
 */
public class P5_Tree_BST {

    /**
     * This also covers BST with duplicates
     * <p>
     * Using long to make sure max and min are the biggest in long format
     * TC: O(logN)
     * SC: O(logN)
     *
     * @param root
     * @return
     */
    public boolean checkIsBST(TreeNode root) {
        return checkIsBST_util(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean checkIsBST_util(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        if (root.data <= min || root.data >= max) {
            return false;
        }

        return checkIsBST_util(root.left, min, root.data) && checkIsBST_util(root.right, root.data, max);
    }

    public static void main(String[] args) {
        P5_Tree_BST p5_tree_bst = new P5_Tree_BST();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        System.out.println(p5_tree_bst.checkIsBST(root));
    }
}

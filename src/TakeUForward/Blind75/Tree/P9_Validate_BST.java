package TakeUForward.Blind75.Tree;

import TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_1_Traversals.TreeNode;

/**
 * Project: DS_Algo
 * Package: TakeUForward.Blind75.Tree
 * <p>
 * User: piyushbajaj
 * Date: 24/01/23
 * Time: 1:06 pm
 * <p>
 * lc: <a href="https://leetcode.com/problems/validate-binary-search-tree/">...</a>
 */
public class P9_Validate_BST {

    public static void main(String[] args) {
        P9_Validate_BST p9_validate_bst = new P9_Validate_BST();

        // Inserting into tree
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        System.out.println(p9_validate_bst.isValidBST(root));
    }

    /**
     * TC: O(N)
     * SC: O(N)
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isValidBST_util(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST_util(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }

        if (root.data < min || root.data > max) {
            return false;
        }

        return isValidBST_util(root.left, min, root.data) && isValidBST_util(root.right, root.data, max);
    }
}

package TakeUForward.S14_BST.S14_2;

import TakeUForward.S13_BinaryTrees.S13_1_Traversals.TreeNode;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S14_BST.S14_2
 * <p>
 * User: piyushbajaj
 * Date: 08/10/22
 * Time: 1:43 pm
 * <p>
 * <p>
 * Approach 1:
 * 1. Sort Inorder, then compare element based on the target
 * TC: O(N) + O(N)
 * SC: O(N)
 * <p>
 * Approach 2:
 * 1. Use BST Iterator to get low and high value
 * 2. Store this in stack and keep comparing
 * TC: O(N)
 * SC: O(H)*2
 */
public class P10_TwoSumInBST {

    public boolean findTarget(TreeNode root, int k) {
        P9_BST_Iterator p9_bst_iterator = new P9_BST_Iterator(root);

        int low = p9_bst_iterator.next();
        int high = p9_bst_iterator.before();

        while (low <= high) {
            int sum = low + high;
            if (k == sum) {
                return true;
            } else if (k < sum) {
                high = p9_bst_iterator.before();
            } else {
                low = p9_bst_iterator.next();
            }
        }

        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        P10_TwoSumInBST p10_twoSumInBST = new P10_TwoSumInBST();
        System.out.println(p10_twoSumInBST.findTarget(root, 3));
    }
}

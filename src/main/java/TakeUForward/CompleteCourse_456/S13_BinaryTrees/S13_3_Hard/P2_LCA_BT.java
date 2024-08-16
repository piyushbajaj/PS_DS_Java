package TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_3_Hard;

import TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_1_Traversals.TreeNode;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S13_BinaryTrees.S13_3_Hard
 * <p>
 * User: piyushbajaj
 * Date: 02/10/22
 * Time: 8:45 am
 * <p>
 * lc: <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/">...</a>
 * g4g: <a href="https://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-binary-tree/1">...</a>
 */
public class P2_LCA_BT {

    public static void main(String[] args) {
        P2_LCA_BT p2_lca_bt = new P2_LCA_BT();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        System.out.println(p2_lca_bt.getLCA(root, root.left.left, root.right.right) == null ? null :
            p2_lca_bt.getLCA(root, root.left.left, root.right.right).data);
    }

    /**
     * We followed approach of Post Order here:
     * <p>
     * 1. We are using Post Order traversal
     * 2. First will check if there is node matching on the left side
     * 3. Will check if the node is matching on right side
     * 3. Will return root node if both matches.
     * 4. If left is null then right, if right is null then left
     * <p>
     * TC: O(N)
     * SC: O(N)
     *
     * @param curr
     * @param a
     * @param b
     * @return
     */
    public TreeNode getLCA(TreeNode curr, TreeNode a, TreeNode b) {
        if (curr == null) {
            return null;
        }

        if (curr == a || curr == b) {
            return curr;
        }

        TreeNode leftLCA = getLCA(curr.left, a, b);
        TreeNode rightLCA = getLCA(curr.right, a, b);

        if (leftLCA != null && rightLCA != null) {
            return curr;
        }

        return leftLCA != null ? leftLCA : rightLCA;
    }
}

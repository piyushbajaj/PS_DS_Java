package TakeUForward.CompleteCourse_456.S14_BST.S14_2;

import TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_1_Traversals.TreeNode;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S14_BST.S14_2
 * <p>
 * User: piyushbajaj
 * Date: 06/10/22
 * Time: 6:15 pm
 * <p>
 */
public class P6_Left_LCA {

    public static void main(String[] args) {
        P6_Left_LCA p6_left_lca = new P6_Left_LCA();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        System.out.println(p6_left_lca.lowestCommonAncestor(root, root.left.left, root.left.right).data);
    }

    /**
     * Approach:
     * 1. If node a and node b is less than root, then check on the left side of tree, or else check on the right
     * side of tree.
     * 2. Return root
     * <p>
     * TC: O(logN)
     * SC: O(logN)
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root.data < p.data && root.data < q.data) {
            return lowestCommonAncestor(root.right, p, q);
        } else if (root.data > p.data && root.data > q.data) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }
}

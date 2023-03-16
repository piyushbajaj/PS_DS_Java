package TakeUForward.Blind75.Tree;

import TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_1_Traversals.TreeNode;

/**
 * Project: DS_Algo
 * Package: TakeUForward.Blind75.Tree
 * <p>
 * User: piyushbajaj
 * Date: 24/01/23
 * Time: 1:24 pm
 * <p>
 * lc: <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/">...</a>
 */
public class P11_LCA {

    /**
     * If p and q is less than root, then look left side or else right side
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

        if (p.data < root.data && q.data < root.data) {
            lowestCommonAncestor(root.left, p, q);
        } else if (p.data > root.data && q.data > root.data) {
            lowestCommonAncestor(root.right, p, q);
        }

        return root;
    }

    public static void main(String[] args) {
        P11_LCA p11_lca = new P11_LCA();

        // Inserting into tree
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        TreeNode result = p11_lca.lowestCommonAncestor(root, root.left.left, root.right.right);

        System.out.println(result == null ? null : result.data);
    }
}

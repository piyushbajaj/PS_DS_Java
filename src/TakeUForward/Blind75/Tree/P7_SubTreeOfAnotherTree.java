package TakeUForward.Blind75.Tree;

import TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_1_Traversals.TreeNode;

/**
 * Project: DS_Algo
 * Package: TakeUForward.Blind75.Tree
 * <p>
 * User: piyushbajaj
 * Date: 23/01/23
 * Time: 7:30 pm
 * <p>
 * lc: <a href="https://leetcode.com/problems/subtree-of-another-tree/description/">...</a>
 */
public class P7_SubTreeOfAnotherTree {
    public static void main(String[] args) {
        P7_SubTreeOfAnotherTree p7_subTreeOfAnotherTree = new P7_SubTreeOfAnotherTree();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);

        System.out.println(p7_subTreeOfAnotherTree.isSubtree(root, subRoot));

    }

    /**
     * TC: O(N*M)
     * SC: O(N+M)
     *
     * @param root
     * @param subRoot
     * @return
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }

        if (subRoot == null) {
            return true;
        }

        if (isIdentical(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isIdentical(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 == null || node2 == null) {
            return false;
        }

        if (node1.data != node2.data) {
            return false;
        }

        return isIdentical(node1.left, node2.left) && isIdentical(node1.right, node2.right);
    }
}

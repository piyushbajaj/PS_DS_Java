package TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_2_Medium;

import TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_1_Traversals.TreeNode;

/**
 * Project: DS_Algo
 * Package: TakeUForward.S13_BinaryTrees.S13_2_Medium
 * <p>
 * User: piyushbajaj
 * Date: 22/01/23
 * Time: 1:55 pm
 * <p>
 * lc: <a href="https://leetcode.com/problems/symmetric-tree/">...</a>
 * g4g: <a href="https://practice.geeksforgeeks.org/problems/symmetric-tree/1">...</a>
 */
public class P13_SymmetricBT {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode rootA, TreeNode rootB) {
        if (rootA == null && rootB == null) {
            return true;
        }

        if (rootA == null || rootB == null) {
            return false;
        }

        if (rootA.data != rootB.data) {
            return false;
        }

        return isSymmetric(rootA.left, rootB.right) && isSymmetric(rootA.right, rootB.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(2);
        root.right.right = new TreeNode(2);
        P13_SymmetricBT p13_symmetricBT = new P13_SymmetricBT();
        System.out.println(p13_symmetricBT.isSymmetric(root));

    }
}

package TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_2_Medium;

import TakeUForward.CompleteCourse_456.S13_BinaryTrees.S13_1_Traversals.TreeNode;

/**
 * Created by bajajp on 29 Sep, 2022
 * <p>
 * g4g: <a href="https://practice.geeksforgeeks.org/problems/determine-if-two-trees-are-identical/1">...</a>
 * lc: <a href="https://leetcode.com/problems/same-tree/">...</a>
 */
public class P5_CheckTwoTreesIdentical {

    public static void main(String[] args) {
        P5_CheckTwoTreesIdentical p5_checkTwoTreesIdentical = new P5_CheckTwoTreesIdentical();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(10);
        root.left.left.left.left = new TreeNode(11);

        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(0);
        root1.right = new TreeNode(6);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);
        root1.right.left = new TreeNode(5);
        root1.right.right = new TreeNode(7);
        root1.left.left.left = new TreeNode(10);
        root1.left.left.left.left = new TreeNode(11);

        System.out.println(p5_checkTwoTreesIdentical.checkTwoTrees(root, root1));
    }

    /**
     * TC: O(N)
     * SC: O(H)
     *
     * @param node1
     * @param node2
     * @return
     */
    public boolean checkTwoTrees(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 == null || node2 == null) {
            return false;
        }

        if (node1.data != node2.data) {
            return false;
        }

        return checkTwoTrees(node1.left, node2.left) && checkTwoTrees(node1.right, node2.right);
    }
}
